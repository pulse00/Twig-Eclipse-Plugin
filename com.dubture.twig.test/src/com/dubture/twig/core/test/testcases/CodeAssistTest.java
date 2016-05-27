package com.dubture.twig.core.test.testcases;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.php.core.tests.PHPCoreTests;
import org.eclipse.php.core.tests.PdttFile;
import org.eclipse.php.core.tests.runner.AbstractPDTTRunner.Context;
import org.eclipse.php.core.tests.runner.PDTTList;
import org.eclipse.php.core.tests.runner.PDTTList.AfterList;
import org.eclipse.php.core.tests.runner.PDTTList.BeforeList;
import org.eclipse.php.core.tests.runner.PDTTList.Parameters;
import org.eclipse.php.internal.core.project.PHPNature;
import org.eclipse.wst.sse.core.internal.FileBufferModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.framework.Bundle;

import com.dubture.twig.core.TwigNature;
import com.dubture.twig.core.codeassist.CompletionProposal;
import com.dubture.twig.core.codeassist.CompletionRequestor;
import com.dubture.twig.core.codeassist.TwigCompletionEngine;
import com.dubture.twig.core.test.TwigCoreTestPlugin;

@RunWith(PDTTList.class)
public class CodeAssistTest {

	@Parameters
	public static final String[] TEST_DIRS = { "/workspace/codeassist" };
	private static final String OFFSET_CHAR = "|";

	@Context
	public static Bundle getBundle() {
		return TwigCoreTestPlugin.getDefault().getBundle();
	}

	protected Map<String, IFile> files = new HashMap<String, IFile>();
	protected Map<String, PdttFile> pdttFiles = new HashMap<String, PdttFile>();
	private int count = 0;

	private String[] fileNames;
	private IProject project;

	public CodeAssistTest(String fileNames[]) {
		this.fileNames = fileNames;
	}

	@BeforeList
	public void beforeList() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject("TwigCodeAssist");
		if (project.exists()) {
			return;
		}
		project.create(null);
		project.open(null);

		IProjectDescription desc = project.getDescription();
		desc.setNatureIds(new String[] { PHPNature.ID, TwigNature.NATURE_ID });
		project.setDescription(desc, null);

		for (final String fileName : fileNames) {
			PdttFile pdttFile = new PdttFile(fileName);
			pdttFiles.put(fileName, pdttFile);
			files.put(fileName, createFile(pdttFile.getFile().trim()));
		}

		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		PHPCoreTests.getDefault().waitForIndexer();
	}

	private IFile createFile(String data) throws CoreException {
		IFile testFile = project.getFile("test" + (++count) + ".html.twig");
		testFile.create(new ByteArrayInputStream(data.getBytes()), true, null);
		return testFile;
	}

	@AfterList
	public void afterList() throws CoreException {
		if (project != null && project.isAccessible()) {
			project.delete(true, null);
			project = null;
		}
	}

	@Test
	public void assist(String fileName) throws CoreException {
		IStructuredModel model = FileBufferModelManager.getInstance().getModel(files.get(fileName));

		TwigCompletionEngine engine = new TwigCompletionEngine();
		engine.setMonitor(new NullProgressMonitor());
		engine.setProject(project);
		engine.setSourceRange(new SourceRange(pdttFiles.get(fileName).getFile().trim().lastIndexOf(OFFSET_CHAR), 0));
		final List<CompletionProposal> proposals = new LinkedList<CompletionProposal>();
		engine.setRequestor(new CompletionRequestor() {

			@Override
			public void acceptProposal(CompletionProposal proposal) {
				proposals.add(proposal);
				System.out.println(proposal);
			}
		});
		engine.complete(model.getStructuredDocument());
	}
}
