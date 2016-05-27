package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;

public interface ICompletionProposalInfo {
	String getInfo(IProgressMonitor monitor);
}
