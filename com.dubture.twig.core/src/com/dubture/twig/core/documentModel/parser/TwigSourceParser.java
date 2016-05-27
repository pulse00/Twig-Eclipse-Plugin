/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;

import java.io.Reader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.php.internal.core.documentModel.parser.PHPRegionContext;
import org.eclipse.wst.sse.core.internal.ltk.parser.BlockTokenizer;
import org.eclipse.wst.sse.core.internal.ltk.parser.RegionParser;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;
import org.eclipse.wst.xml.core.internal.parser.XMLSourceParser;
import org.eclipse.wst.xml.core.internal.regions.DOMRegionContext;

/**
 * @see http ://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.
 *      smarty
 *      .core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/
 *      SmartySourceParser.java
 * 
 */
@SuppressWarnings("restriction")
public class TwigSourceParser extends XMLSourceParser {

	@SuppressWarnings("rawtypes")
	public static ThreadLocal editFile = new ThreadLocal();

	public TwigSourceParser() {
		super();
		IResource resource = (IResource) editFile.get();
		if (resource instanceof IProject) {
		} else if (resource instanceof IFile) {
			((IFile) resource).getProject();
		}
	}

	@Override
	public IStructuredDocumentRegion getDocumentRegions() {

		return super.getDocumentRegions();
	}

	/*
	 * Change the Tokenizer used by the XMLSourceParser to make it Twig aware
	 */
	@Override
	public BlockTokenizer getTokenizer() {
		if (fTokenizer == null) {
			TwigTokenizer twigTokenizer = new TwigTokenizer();
			// twigTokenizer.setProject(project);
			fTokenizer = twigTokenizer;
		}
		return fTokenizer;
	}

	@Override
	public RegionParser newInstance() {
		TwigSourceParser newInstance = new TwigSourceParser();
		TwigTokenizer tokenizer = (TwigTokenizer) getTokenizer().newInstance();
		// tokenizer.setProject(project);
		newInstance.setTokenizer(tokenizer);
		return newInstance;
	}

	private IStructuredDocumentRegion headNode = null;

	private IStructuredDocumentRegion lastNode = null;

	private IStructuredDocumentRegion currentNode = null;

	@Override
	protected IStructuredDocumentRegion parseNodes() {
		// regions are initially reported as complete offsets within the
		// scanned input
		// they are adjusted here to be indexes from the currentNode's start
		// offset

		// reset the state
		headNode = lastNode = currentNode = null;

		ITextRegion region = null;
		String type = null;

		while ((region = getNextRegion()) != null) {
			type = region.getType();

			// these types (might) demand a IStructuredDocumentRegion for each
			// of them
			if (type == DOMRegionContext.BLOCK_TEXT) {
				if (currentNode != null && currentNode.getLastRegion().getType() == DOMRegionContext.BLOCK_TEXT) {
					// multiple block texts indicated embedded containers; no
					// new IStructuredDocumentRegion
					currentNode.addRegion(region);
					currentNode.setLength(region.getStart() + region.getLength() - currentNode.getStart());
					region.adjustStart(-currentNode.getStart());
					// DW 4/16/2003 regions no longer have parents
					// region.setParent(currentNode);
					if (region instanceof ITextRegionContainer) {
						((ITextRegionContainer) region).setParent(currentNode);
					}
				} else {
					// not continuing a IStructuredDocumentRegion

					if (currentNode != null) {
						// ensure that any existing node is at least
						// terminated
						if (!currentNode.isEnded()) {
							currentNode.setLength(region.getStart() - currentNode.getStart());
							// fCurrentNode.setTextLength(region.getStart() -
							// fCurrentNode.getStart());
						}
						lastNode = currentNode;
					}
					fireNodeParsed(currentNode);
					currentNode = createStructuredDocumentRegion(type);
					if (lastNode != null) {
						lastNode.setNext(currentNode);
					}
					currentNode.setPrevious(lastNode);
					currentNode.setStart(region.getStart());
					currentNode.setLength(region.getLength());
					// currentNode.setLength(region.getStart() +
					// region.getLength() - currentNode.getStart());
					currentNode.setEnded(true);
					region.adjustStart(-currentNode.getStart());
					currentNode.addRegion(region);
					// DW 4/16/2003 regions no longer have parents
					// region.setParent(currentNode);
					if (region instanceof ITextRegionContainer) {
						((ITextRegionContainer) region).setParent(currentNode);
					}
				}
			}
			// the following contexts OPEN new StructuredDocumentRegions
			else if ((currentNode != null && currentNode.isEnded()) || (type == PHPRegionContext.PHP_OPEN)
					|| (type == TwigRegionContext.TWIG_OPEN) || (type == TwigRegionContext.TWIG_STMT_OPEN)
					|| (type == TwigRegionContext.TWIG_COMMENT_OPEN) || (type == DOMRegionContext.XML_CONTENT)
					|| (type == DOMRegionContext.XML_CHAR_REFERENCE) || (type == DOMRegionContext.XML_ENTITY_REFERENCE)
					|| (type == DOMRegionContext.XML_TAG_OPEN) || (type == DOMRegionContext.XML_END_TAG_OPEN)
					|| (type == DOMRegionContext.XML_COMMENT_OPEN) || (type == DOMRegionContext.XML_CDATA_OPEN)
					|| (type == DOMRegionContext.XML_DECLARATION_OPEN)) {

				if (currentNode != null) {
					// ensure that any existing node is at least terminated
					if (!currentNode.isEnded()) {
						currentNode.setLength(region.getStart() - currentNode.getStart());
						// fCurrentNode.setTextLength(region.getStart() -
						// fCurrentNode.getStart());
					}
					lastNode = currentNode;
				}
				fireNodeParsed(currentNode);
				currentNode = createStructuredDocumentRegion(type);
				if (lastNode != null) {
					lastNode.setNext(currentNode);
				}
				currentNode.setPrevious(lastNode);
				currentNode.setStart(region.getStart());
				currentNode.addRegion(region);
				currentNode.setLength(region.getStart() + region.getLength() - currentNode.getStart());
				region.adjustStart(-currentNode.getStart());
				// DW 4/16/2003 regions no longer have parents
				// region.setParent(currentNode);
				if (region instanceof ITextRegionContainer) {
					((ITextRegionContainer) region).setParent(currentNode);
				}
			}
			// the following contexts neither open nor close
			// StructuredDocumentRegions; just add to them
			else if ((type == DOMRegionContext.XML_TAG_NAME) || (type == DOMRegionContext.XML_TAG_ATTRIBUTE_NAME)
					|| (type == DOMRegionContext.XML_TAG_ATTRIBUTE_EQUALS)
					|| (type == DOMRegionContext.XML_TAG_ATTRIBUTE_VALUE) || (type == DOMRegionContext.XML_COMMENT_TEXT)
					|| (type == DOMRegionContext.XML_PI_CONTENT)
					|| (type == DOMRegionContext.XML_DOCTYPE_INTERNAL_SUBSET) || (type == PHPRegionContext.PHP_CONTENT)
					|| (type == TwigRegionContext.TWIG_CONTENT) || (type == TwigRegionContext.TWIG_COMMENT)) {

				currentNode.addRegion(region);
				currentNode.setLength(region.getStart() + region.getLength() - currentNode.getStart());
				region.adjustStart(-currentNode.getStart());
				// DW 4/16/2003 regions no longer have parents
				// region.setParent(currentNode);
				if (region instanceof ITextRegionContainer) {
					((ITextRegionContainer) region).setParent(currentNode);
				}
			}
			// the following contexts close off StructuredDocumentRegions
			// cleanly
			else if ((type == PHPRegionContext.PHP_CLOSE) || (type == TwigRegionContext.TWIG_CLOSE)
					|| (type == TwigRegionContext.TWIG_STMT_CLOSE) || (type == TwigRegionContext.TWIG_COMMENT_CLOSE)
					|| (type == DOMRegionContext.XML_PI_CLOSE) || (type == DOMRegionContext.XML_TAG_CLOSE)
					|| (type == DOMRegionContext.XML_EMPTY_TAG_CLOSE) || (type == DOMRegionContext.XML_COMMENT_CLOSE)
					|| (type == DOMRegionContext.XML_DECLARATION_CLOSE) || (type == DOMRegionContext.XML_CDATA_CLOSE)) {

				int l = region.getStart() + region.getLength() - currentNode.getStart();

				currentNode.setEnded(true);
				currentNode.setLength(l);
				currentNode.addRegion(region);
				region.adjustStart(-currentNode.getStart());
				// DW 4/16/2003 regions no longer have parents
				// region.setParent(currentNode);
				if (region instanceof ITextRegionContainer) {
					((ITextRegionContainer) region).setParent(currentNode);
				}
			}
			// this is extremely rare, but valid
			else if (type == DOMRegionContext.WHITE_SPACE) {
				ITextRegion lastRegion = currentNode.getLastRegion();
				// pack the embedded container with this region
				if (lastRegion instanceof ITextRegionContainer) {
					ITextRegionContainer container = (ITextRegionContainer) lastRegion;
					container.getRegions().add(region);
					// containers must have parent set ...
					// setting for EACH subregion is redundent, but not sure
					// where else to do, so will do here for now.
					container.setParent(currentNode);
					// DW 4/16/2003 regions no longer have parents
					// region.setParent(container);
					if (region instanceof ITextRegionContainer) {
						((ITextRegionContainer) region).setParent(currentNode);
					}
					region.adjustStart(container.getLength() - region.getStart());
				}
				currentNode.getLastRegion().adjustLength(region.getLength());
				currentNode.adjustLength(region.getLength());
			} else if (type == DOMRegionContext.UNDEFINED && currentNode != null) {
				// skip on a very-first region situation as the default
				// behavior is good enough
				// combine with previous if also undefined
				if (currentNode.getLastRegion() != null
						&& currentNode.getLastRegion().getType() == DOMRegionContext.UNDEFINED) {
					currentNode.getLastRegion().adjustLength(region.getLength());
					currentNode.adjustLength(region.getLength());
				}
				// previous wasn't undefined
				else {
					currentNode.addRegion(region);
					currentNode.setLength(region.getStart() + region.getLength() - currentNode.getStart());
					region.adjustStart(-currentNode.getStart());
				}
			} else {
				// if an unknown type is the first region in the document,
				// ensure that a node exists
				if (currentNode == null) {
					currentNode = createStructuredDocumentRegion(type);
					currentNode.setStart(region.getStart());
				}
				currentNode.addRegion(region);
				currentNode.setLength(region.getStart() + region.getLength() - currentNode.getStart());
				region.adjustStart(-currentNode.getStart());
				// DW 4/16/2003 regions no longer have parents
				// region.setParent(currentNode);
				if (region instanceof ITextRegionContainer) {
					((ITextRegionContainer) region).setParent(currentNode);
				}

				// $NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
			}

			// these regions also get their own node, so close them cleanly
			// NOTE: these regions have new StructuredDocumentRegions created
			// for them above; it may
			// be more readable if that is handled here as well, but the
			// current layout
			// ensures that they open StructuredDocumentRegions the same way
			if ((type == DOMRegionContext.XML_CONTENT) || (type == DOMRegionContext.XML_CHAR_REFERENCE)
					|| (type == DOMRegionContext.XML_ENTITY_REFERENCE) || (type == PHPRegionContext.PHP_CLOSE)
					|| (type == TwigRegionContext.TWIG_CLOSE) || (type == TwigRegionContext.TWIG_STMT_CLOSE)
					|| (type == TwigRegionContext.TWIG_COMMENT_CLOSE)) {
				currentNode.setEnded(true);
			}

			if (headNode == null && currentNode != null) {
				headNode = currentNode;
			}
		}
		if (currentNode != null) {
			fireNodeParsed(currentNode);
			currentNode.setPrevious(lastNode);
		}
		// fStringInput = null;
		primReset();

		return headNode;
	}

	@Override
	public void reset(Reader reader, int position) {

		super.reset(reader, position);
	}

}
