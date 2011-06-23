package org.eclipse.twig.ui.editor;

import java.util.Collection;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.php.internal.ui.Logger;
import org.eclipse.php.internal.ui.editor.highlighter.LineStyleProviderForPhp;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import org.eclipse.twig.core.util.Debug;
import org.eclipse.twig.ui.preferences.PreferenceConstants;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionList;

/**
 * 
 * {@link LineStyleProviderForTwig} adds TwigColors
 * to the colorTypes of the {@link LineStyleProviderForPhp}.
 *  
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class LineStyleProviderForTwig extends LineStyleProviderForPhp {


	static {
		fColorTypes.put(TwigRegionContext.TWIG_OPEN, PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CLOSE, PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CLOSETAG, PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);

		fColorTypes.put(TwigRegionContext.TWIG_STMT_OPEN, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_STMT_CLOSE, PreferenceConstants.EDITOR_STRING_COLOR);

		fColorTypes.put(TwigRegionContext.TWIG_CONTENT, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_COMMENT, PreferenceConstants.EDITOR_COMMENT_COLOR);

		fColorTypes.put(TwigRegionContext.TWIG_COMMENT_OPEN, PreferenceConstants.EDITOR_COMMENT_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_COMMENT_TEXT, PreferenceConstants.EDITOR_COMMENT_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_COMMENT_CLOSE, PreferenceConstants.EDITOR_COMMENT_COLOR);		



		fColorTypes.put(TwigRegionContext.TWIG_VARIABLE, PreferenceConstants.EDITOR_VARIABLE_COLOR);		
		fColorTypes.put(TwigRegionContext.TWIG_KEYWORD, PreferenceConstants.EDITOR_DOUBLE_QUOTED_COLOR);
		
		fColorTypes.put(TwigRegionContext.TWIG_JSON_START, PreferenceConstants.EDITOR_DOUBLE_QUOTED_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_JSON_END, PreferenceConstants.EDITOR_DOUBLE_QUOTED_COLOR);

		fColorTypes.put(TwigRegionContext.TWIG_DELIMITER, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_WHITESPACE, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_NUMBER, PreferenceConstants.EDITOR_NUMBER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_LABEL, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_START, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_END, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_BACKTICK_END, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_BACKTICK_START, PreferenceConstants.EDITOR_LABEL_COLOR);
	}	

	@Override
	public TextAttribute getAttributeFor(ITextRegion region) {
		
		final String type = region.getType();
		

		
		if (type != null && type.startsWith("TWIG_")) {
			return getAttributeFor(type);
		}

		return super.getAttributeFor(region);
	}


	@Override
	protected TextAttribute getAttributeFor(String type) {

		return super.getAttributeFor(type);
	}
	
	

	public boolean prepareTextRegion(ITextRegionCollection blockedRegion,
			int partitionStartOffset, int partitionLength,
			Collection<StyleRange> holdResults) {

		boolean handled = false;
		final int partitionEndOffset = partitionStartOffset + partitionLength
				- 1;
		ITextRegion region = null;
		ITextRegionList regions = blockedRegion.getRegions();
		int nRegions = regions.size();
		StyleRange styleRange = null;
		for (int i = 0; i < nRegions; i++) {
			region = regions.get(i);
			TextAttribute attr = null;
			TextAttribute previousAttr = null;
			final int startOffset = blockedRegion.getStartOffset(region);
			if (startOffset > partitionEndOffset)
				break;
			if (blockedRegion.getEndOffset(region) <= partitionStartOffset)
				continue;

			if (region instanceof ITextRegionCollection) {
				handled = prepareTextRegion((ITextRegionCollection) region,
						partitionStartOffset, partitionLength, holdResults);
			} else {

				if (region.getType() == TwigRegionContext.TWIG_CONTENT || region.getType() == TwigRegionContext.TWIG_COMMENT) {
					handled = prepareTwigRegions(holdResults,
							(ITwigScriptRegion) region, startOffset,
							partitionStartOffset, partitionLength);
				} else {
					

					attr = getAttributeFor(region);
					if (attr != null) {
						handled = true;
						// if this region's attr is the same as previous one,
						// then
						// just adjust the previous style range
						// instead of creating a new instance of one
						// note: to use 'equals' in this case is important,
						// since
						// sometimes
						// different instances of attributes are associated with
						// a
						// region, even the
						// the attribute has the same values.
						// TODO: this needs to be improved to handle readonly
						// regions correctly
						if ((styleRange != null) && (previousAttr != null)
								&& (previousAttr.equals(attr))) {
							styleRange.length += region.getLength();
						} else {
							styleRange = createStyleRange(blockedRegion,
									region, attr, partitionStartOffset,
									partitionLength);
							holdResults.add(styleRange);
							// technically speaking, we don't need to update
							// previousAttr
							// in the other case, because the other case is when
							// it hasn't changed
							previousAttr = attr;
						}
					} else {
						previousAttr = null;
					}
				}
			}
		}
		return handled;
	}

	private boolean prepareTwigRegions(Collection<StyleRange> holdResults,
			ITwigScriptRegion region, int regionStart, int partitionStartOffset,
			int partitionLength) {

		

		assert (region.getType() == TwigRegionContext.TWIG_CONTENT || region.getType() == TwigRegionContext.TWIG_COMMENT);

		StyleRange styleRange = null;
		TextAttribute attr;
		TextAttribute previousAttr = null;

		ITextRegion[] twigTokens = null;
		try {

			int from;
			int length;
			if (partitionStartOffset < regionStart) {
				from = 0;
				length = partitionLength - (regionStart - partitionStartOffset);
			} else {
				from = partitionStartOffset - regionStart;
				length = partitionLength;
			}
			twigTokens = region.getTwigTokens(from,
					Math.min(length, region.getLength()));
			ITextRegion prevElement = null;
			for (int i = 0; i < twigTokens.length; i++) {
				ITextRegion element = twigTokens[i];
				attr = getAttributeFor(element);
				// Check that the elements are different - otherwise the
				// coloring is not valid
				if (prevElement == element) {
					continue;
				}
				if ((styleRange != null) && (previousAttr != null)
						&& (previousAttr.equals(attr)) && prevElement != null
						&& prevElement.getLength() == prevElement.getLength()) {
					// extends the prev styleRange with the current element
					// length
					styleRange.length += element.getLength();
					if (styleRange.start + styleRange.length > partitionStartOffset
							+ partitionLength) {
						styleRange.length -= (styleRange.start + styleRange.length)
								- (partitionStartOffset + partitionLength);
					}
				} else {
					// create new styleRange
					int styleStart = regionStart + element.getStart();
					int styleLength = element.getLength();
					if (styleStart + styleLength < partitionStartOffset) { // if
						// the
						// range
						// ends
						// before
						// the
						// requested
						// starting
						// position
						// -
						// ignoring
						// it
						continue;
					}
					if (styleStart < partitionStartOffset) { // if the region
						// starts before
						// the requested
						// starting
						// position -
						// adjusting the
						// style start
						// position
						styleLength -= (partitionStartOffset - styleStart);
						styleStart = partitionStartOffset;
					}
					if (styleStart > partitionStartOffset + partitionLength) {
						// if the region ends after the requested end position -
						// making it shorter
						styleLength -= styleStart
								- (partitionStartOffset + partitionLength);
					}
					if (attr.getBackground() != null
							&& element.getTextEnd() != element.getEnd()) {// in
						// case
						// of
						// background
						// color
						// make
						// sure
						// the
						// highlighting
						// will
						// not
						// paint
						// the
						// whitespaces
						// applying style to the region w/o the whitespace
						styleRange = new StyleRange(styleStart, styleLength
								- (element.getEnd() - element.getTextEnd()),
								attr.getForeground(), attr.getBackground(),
								attr.getStyle());
						if ((attr.getStyle() & TextAttribute.UNDERLINE) != 0) {
							styleRange.underline = true;
							styleRange.fontStyle &= ~TextAttribute.UNDERLINE;
						}
						if ((attr.getStyle() & TextAttribute.STRIKETHROUGH) != 0) {
							styleRange.strikeout = true;
							styleRange.fontStyle &= ~TextAttribute.STRIKETHROUGH;
						}
						holdResults.add(styleRange);
						// applying style to the whitespace (important for the
						// refresh of the specific range
						styleRange = new StyleRange(regionStart
								+ element.getTextEnd(), element.getEnd()
								- element.getTextEnd(), attr.getForeground(),
								null, attr.getStyle());
						holdResults.add(styleRange);
						previousAttr = null;
					} else {
						styleRange = new StyleRange(styleStart, styleLength,
								attr.getForeground(), attr.getBackground(),
								attr.getStyle());
						if ((attr.getStyle() & TextAttribute.UNDERLINE) != 0) {
							styleRange.underline = true;
							styleRange.fontStyle &= ~TextAttribute.UNDERLINE;
						}
						if ((attr.getStyle() & TextAttribute.STRIKETHROUGH) != 0) {
							styleRange.strikeout = true;
							styleRange.fontStyle &= ~TextAttribute.STRIKETHROUGH;
						}
						holdResults.add(styleRange);
						// technically speaking, we don't need to update
						// previousAttr
						// in the other case, because the other case is when
						// it hasn't changed
						previousAttr = attr;
					}
				}
				prevElement = element;
			}
			return true;
		} catch (BadLocationException e) {
			Logger.logException(e);
			return false;
		}		
	}


	@Override
	public boolean prepareTextRegions(
			IStructuredDocumentRegion structuredDocumentRegion,
			int partitionStartOffset, int partitionLength,
			Collection<StyleRange> holdResults) {



		boolean handled = false;
		final int partitionEndOffset = partitionStartOffset + partitionLength
				- 1;
		while (structuredDocumentRegion != null
				&& structuredDocumentRegion.getStartOffset() <= partitionEndOffset) {
			ITextRegion region = null;
			ITextRegionList regions = structuredDocumentRegion.getRegions();
			int nRegions = regions.size();
			StyleRange styleRange = null;
			
			for (int i = 0; i < nRegions; i++) {
				region = regions.get(i);
				
				TextAttribute attr = null;
				TextAttribute previousAttr = null;
				final int startOffset = structuredDocumentRegion
						.getStartOffset(region);
				
				if (startOffset > partitionEndOffset)
					break;
				if (structuredDocumentRegion.getEndOffset(region) <= partitionStartOffset)
					continue;

				if (region instanceof ITextRegionCollection) {
					handled = prepareTextRegion((ITextRegionCollection) region,
							partitionStartOffset, partitionLength, holdResults);
				} else {

					
					if (region.getType() == TwigRegionContext.TWIG_CONTENT || region.getType() == TwigRegionContext.TWIG_COMMENT) {
						handled = prepareTwigRegions(holdResults,
								(ITwigScriptRegion) region, startOffset,
								partitionStartOffset, partitionLength);
					} else {

						attr = getAttributeFor(region);
						if (attr != null) {
							handled = true;
							// if this region's attr is the same as previous
							// one,
							// then just adjust the previous style range
							// instead of creating a new instance of one
							// note: to use 'equals' in this case is important,
							// since sometimes
							// different instances of attributes are associated
							// with a region, even the
							// the attribute has the same values.
							// TODO: this needs to be improved to handle
							// readonly
							// regions correctly
							if ((styleRange != null) && (previousAttr != null)
									&& (previousAttr.equals(attr))) {
								styleRange.length += region.getLength();
							} else {
								styleRange = createStyleRange(
										structuredDocumentRegion, region, attr,
										partitionStartOffset, partitionLength);
								holdResults.add(styleRange);
								// technically speaking, we don't need to update
								// previousAttr
								// in the other case, because the other case is
								// when it hasn't changed
								previousAttr = attr;
							}
						} else {
							previousAttr = null;
						}
					}
				}

				if (Debug.syntaxHighlighting) {
					if (!handled) {
						System.out.println("not handled in prepareRegions"); //$NON-NLS-1$
					}
				}
			}
			structuredDocumentRegion = structuredDocumentRegion.getNext();
		}
		return handled;		
	}
}