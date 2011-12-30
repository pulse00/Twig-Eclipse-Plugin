/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;

import org.eclipse.wst.sse.core.internal.provisional.events.RegionChangedEvent;
import org.eclipse.wst.sse.core.internal.provisional.events.StructuredDocumentEvent;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredTextReParser;
import org.eclipse.wst.xml.core.internal.parser.XMLStructuredDocumentReParser;
import org.eclipse.wst.xml.core.internal.regions.DOMRegionContext;

import com.dubture.twig.core.util.Debug;

@SuppressWarnings("restriction")
public class TwigStructuredDocumentReParser extends
        XMLStructuredDocumentReParser
{

    // @Override
    // protected boolean isLoneOpenFollowedByContent(
    // IStructuredDocumentRegion flatNode) {
    //
    // boolean result = false;
    //
    // if (flatNode == null)
    // return false;
    //
    // String type = flatNode.getType();
    // if (type == DOMRegionContext.XML_CONTENT) {
    // IStructuredDocumentRegion previous = flatNode.getPrevious();
    // String previousType = null;
    // if (previous != null) {
    // previousType = previous.getType();
    // }
    // if (previousType != null) {
    // result = (previousType == DOMRegionContext.XML_TAG_OPEN);
    // }
    // }
    // return result;
    // }

    @Override
    protected void findDirtyStart(int start)
    {

        IStructuredDocumentRegion result = fStructuredDocument
                .getRegionAtCharacterOffset(start);
        // heuristic: if the postion is exactly equal to the start, then
        // go back one more, if it exists. This prevents problems with
        // insertions
        // of text that should be merged with the previous node instead of
        // simply hung
        // off of it as a separate node (ex.: XML content inserted right
        // before an open
        // bracket should become part of the previous content node)

        if (result != null) {

            IStructuredDocumentRegion previous = result.getPrevious();
            if ((previous != null)
                    && ((!(previous.isEnded())) || (start == result.getStart()))) {
                result = previous;
            }
            // If we are now at the end of a "tag dependent" content area (or
            // JSP area)
            // then we need to back up all the way to the beginning of that.
            IStructuredDocumentRegion potential = result;
            while (isPartOfBlockRegion(potential)) {
                potential = potential.getPrevious();
            }
            if (potential != null) {
                result = potential;
                fStructuredDocument.setCachedDocumentRegion(result);
            }
        }

        dirtyStart = result;

    }

    @Override
    protected IStructuredDocumentRegion findDirtyEnd(int end)
    {

        // Caution: here's one place we have to cast
        IStructuredDocumentRegion result = fStructuredDocument
                .getRegionAtCharacterOffset(end);
        // if not well formed, get one past, if there is something there

        if ((result != null) && (!result.isEnded())) {
            if (result.getNext() != null) {
                result = result.getNext();
            }
        }
        // also, get one past if exactly equal to the end (this was needed
        // as a simple fix to when a whole exact region is deleted.
        // there's probably a better way.
        if ((result != null) && (end == result.getEnd())) {
            if (result.getNext() != null) {
                result = result.getNext();
            }
        }

        // 12/6/2001 - Since we've changed the parser/scanner to allow a lone
        // '<' without
        // always interpretting it as start of a tag name, we need to be a
        // little fancier, in order
        // to "skip" over any plain 'ol content between the lone '<' and any
        // potential meating
        // regions past plain 'ol content.
        if (isLoneOpenFollowedByContent(result) && (result.getNext() != null)) {
            result = result.getNext();
        }

        if (result != null)
            fStructuredDocument.setCachedDocumentRegion(result);
        dirtyEnd = result;

        return dirtyEnd;
    }

    protected StructuredDocumentEvent regionCheck(
            IStructuredDocumentRegion oldNode, IStructuredDocumentRegion newNode)
    {
        final StructuredDocumentEvent event = super.regionCheck(oldNode,
                newNode);

        if (event instanceof RegionChangedEvent) {
            RegionChangedEvent changedEvent = (RegionChangedEvent) event;

            if (changedEvent.getRegion().getType() == TwigRegionContext.TWIG_CONTENT
                    || changedEvent.getRegion().getType() == TwigRegionContext.TWIG_COMMENT) {
                oldNode.setRegions(newNode.getRegions());
            }
        }
        return event;
    }

    @Override
    public IStructuredTextReParser newInstance()
    {

        return new TwigStructuredDocumentReParser();

    }

    protected StructuredDocumentEvent checkForComments()
    {

        StructuredDocumentEvent result = checkForCriticalKey("{#"); //$NON-NLS-1$
        if (result == null) {
            result = checkForCriticalKey("#}"); //$NON-NLS-1$
        }
        return result != null ? result : super.checkForComments();
    }

    public StructuredDocumentEvent reparse()
    {

        final StructuredDocumentEvent event = super.reparse();
        return event;

    }
}
