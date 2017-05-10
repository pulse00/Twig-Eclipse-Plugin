/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.index2.search.ISearchEngine.MatchRule;
import org.eclipse.dltk.core.search.IDLTKSearchScope;
import org.eclipse.dltk.core.search.SearchEngine;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.php.internal.core.model.PHPModelAccess;
import org.eclipse.php.internal.ui.documentation.PHPDocumentationContentAccess;
import org.eclipse.swt.graphics.FontData;
import org.osgi.framework.Bundle;

import com.dubture.twig.core.model.IFilter;
import com.dubture.twig.core.model.ITag;
import com.dubture.twig.core.model.ITest;
import com.dubture.twig.ui.TwigPluginImages;
import com.dubture.twig.ui.TwigUICorePlugin;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class HTMLUtils {

	private static String fgStyleSheet;

	public static String tag2Html(ITag tag) {
		StringBuffer info = new StringBuffer();
		String styles = getStyleSheet();
		HTMLPrinter.insertPageProlog(info, 0, styles);

		URL imageUrl = TwigUICorePlugin.getDefault().getImagesOnFSRegistry()
				.getImageURL(TwigPluginImages.DESC_OBJS_TAG);
		String body = null;

		if (imageUrl != null) {

			StringBuffer header = new StringBuffer();
			String imageName = imageUrl.toExternalForm();
			String name = tag.getElementName() + " (" + tag.getPhpClass() + ")";

			body = tag.getDescription();
			addImageAndLabel(header, imageName, 16, 16, 2, 2, name, 20, 2, true);
			HTMLPrinter.addSmallHeader(info, header.toString());

		}

		StringBuffer content = new StringBuffer();

		if (body != null)
			content.append(body);

		HTMLPrinter.addParagraph(info, new StringReader(content.toString()));
		HTMLPrinter.addPageEpilog(info);

		return info.toString();

	}

	public static String test2Html(ITest test) {

		StringBuffer info = new StringBuffer();
		String styles = getStyleSheet();
		HTMLPrinter.insertPageProlog(info, 0, styles);

		URL imageUrl = TwigUICorePlugin.getDefault().getImagesOnFSRegistry()
				.getImageURL(TwigPluginImages.DESC_OBJS_TEST);
		String body = null;

		if (imageUrl != null) {

			StringBuffer header = new StringBuffer();
			String imageName = imageUrl.toExternalForm();
			String name = test.getElementName() + " (" + test.getPhpClass() + ")";

			body = test.getDescription();
			addImageAndLabel(header, imageName, 16, 16, 2, 2, name, 20, 2, true);
			HTMLPrinter.addSmallHeader(info, header.toString());

		}

		StringBuffer content = new StringBuffer();

		if (body != null)
			content.append(body);

		HTMLPrinter.addParagraph(info, new StringReader(content.toString()));
		HTMLPrinter.addPageEpilog(info);

		return info.toString();
	}

	public static String filter2Html(IFilter filter) {

		StringBuffer info = new StringBuffer();
		String styles = getStyleSheet();
		HTMLPrinter.insertPageProlog(info, 0, styles);

		URL imageUrl = TwigUICorePlugin.getDefault().getImagesOnFSRegistry()
				.getImageURL(TwigPluginImages.DESC_OBJS_FILTER);
		String body = null;

		if (imageUrl != null) {

			StringBuffer header = new StringBuffer();
			String imageName = imageUrl.toExternalForm();

			IScriptProject project = filter.getScriptProject();
			String name = filter.getElementName() + " (" + filter.getPhpClass() + ")";

			IDLTKSearchScope scope = SearchEngine.createSearchScope(project);
			IMethod[] methods = PHPModelAccess.getDefault().findMethods(filter.getInternalFunction(), MatchRule.EXACT,
					0, 0, scope, null);

			if (methods.length > 0 && filter.getInternalFunction().length() > 0) {
				IMethod method = methods[0];
				try {
					body = PHPDocumentationContentAccess.getHTMLContent(method);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			addImageAndLabel(header, imageName, 16, 16, 2, 2, name, 20, 2, true);
			HTMLPrinter.addSmallHeader(info, header.toString());

		}

		StringBuffer content = new StringBuffer();

		if (body != null)
			content.append(body);

		HTMLPrinter.addParagraph(info, new StringReader(content.toString()));
		HTMLPrinter.addPageEpilog(info);

		return info.toString();

	}

	private static String getStyleSheet() {

		if (fgStyleSheet == null)
			fgStyleSheet = loadStylesheet();
		String css = fgStyleSheet;
		if (css != null) {
			FontData fontData = JFaceResources.getFontRegistry()
					.getFontData(PreferenceConstants.APPEARANCE_DOCUMENTATION_FONT)[0];
			css = HTMLPrinter.convertTopLevelFont(css, fontData);
		}

		return css;
	}

	private static String loadStylesheet() {

		Bundle bundle = Platform.getBundle(TwigUICorePlugin.PLUGIN_ID);

		URL styleSheetURL = bundle.getEntry("/TwigDocumentationStylesheet.css"); //$NON-NLS-1$
		if (styleSheetURL != null) {
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new InputStreamReader(styleSheetURL.openStream()));
				StringBuffer buffer = new StringBuffer(1500);
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				return buffer.toString();
			} catch (IOException ex) {
				ex.printStackTrace();
				return ""; //$NON-NLS-1$
			} finally {
				try {
					if (reader != null)
						reader.close();
				} catch (IOException e) {
				}
			}
		}
		return null;

	}

	private static void addImageAndLabel(StringBuffer buf, String imageName, int imageWidth, int imageHeight,
			int imageLeft, int imageTop, String label, int labelLeft, int labelTop, boolean isFirstElement) {

		// workaround to make the window wide enough

		label = label + "&nbsp";
		if (imageName != null) {
			StringBuffer imageStyle = new StringBuffer("position: absolute; "); //$NON-NLS-1$
			imageStyle.append("width: ").append(imageWidth).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			imageStyle.append("height: ").append(imageHeight).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			if (isFirstElement) {
				imageStyle.append("top: ").append(imageTop).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
				imageStyle.append("left: ").append(imageLeft).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				imageStyle.append("margin-top: ").append(imageTop).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
				imageStyle.append("margin-left: ").append(-imageLeft).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			}

			buf.append("<img style='").append(imageStyle).append("' src='").append(imageName).append("'/>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		buf.append("<div style='word-wrap:break-word;"); //$NON-NLS-1$
		if (imageName != null) {
			buf.append("margin-left: ").append(labelLeft).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
			buf.append("margin-top: ").append(labelTop).append("px; "); //$NON-NLS-1$ //$NON-NLS-2$
		}
		buf.append("'>"); //$NON-NLS-1$
		buf.append(label);
		buf.append("</div>"); //$NON-NLS-1$
	}

}
