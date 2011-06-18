package org.eclipse.twig.core.documentModel.parser;

import org.eclipse.wst.sse.core.internal.provisional.events.RegionChangedEvent;
import org.eclipse.wst.sse.core.internal.provisional.events.StructuredDocumentEvent;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredTextReParser;
import org.eclipse.wst.xml.core.internal.parser.XMLStructuredDocumentReParser;
import org.eclipse.wst.xml.core.internal.regions.DOMRegionContext;

@SuppressWarnings("restriction")
public class TwigStructuredDocumentReParser extends
	XMLStructuredDocumentReParser {
	
	
	@Override
	protected boolean isLoneOpenFollowedByContent(
			IStructuredDocumentRegion flatNode) {
		
        boolean result = false;
        
        if (flatNode == null)
        	return false;
        
        String type = flatNode.getType();
        if (type == DOMRegionContext.XML_CONTENT) {
            IStructuredDocumentRegion previous = flatNode.getPrevious();
            String previousType = null;
            if (previous != null) {
                previousType = previous.getType();
            }
            if (previousType != null) {
                result = (previousType == DOMRegionContext.XML_TAG_OPEN);
            }
        }
        return result;		
	}
	
	
	@Override
	protected void findDirtyStart(int start) {
		
		
		System.err.println("search dirty start at " + start);
	    IStructuredDocumentRegion result = fStructuredDocument.getRegionAtCharacterOffset(start);
        // heuristic: if the postion is exactly equal to the start, then
        // go back one more, if it exists. This prevents problems with
        // insertions
        // of text that should be merged with the previous node instead of
        // simply hung
        // off of it as a separate node (ex.: XML content inserted right
        // before an open
        // bracket should become part of the previous content node)
	    
	    
        if (result != null) {
        	
        	System.err.println("found region to be " + result.getClass() + " " +  result.getType() + " " + result.getStart() + " " + result.getEnd());
            IStructuredDocumentRegion previous = result.getPrevious();
            if ((previous != null) && ((!(previous.isEnded())) || (start == result.getStart()))) {
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
        
        if (dirtyStart != null)
        	System.err.println("dirty start: " + dirtyStart.getStart() + " " + dirtyStart.getEnd());
        else System.err.println("no dirty start");
        
	}
	
	@Override
	protected IStructuredDocumentRegion findDirtyEnd(int end) {
	
		System.err.println();
		System.err.println("search dirty end at " + end);
		  // Caution: here's one place we have to cast
        IStructuredDocumentRegion result = fStructuredDocument.getRegionAtCharacterOffset(end);
        // if not well formed, get one past, if there is something there
        
        if (result != null)
        	System.err.println("got dirty region " + result.getClass() + " " + result.getType() + " " + result.getStart() + " " + result.getEnd());
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

        
        if (dirtyEnd != null)
        	System.err.println("dirty end " + dirtyEnd.getStart() + " " + dirtyEnd.getEnd());
        else System.err.println("no dirty end");
        return dirtyEnd;	
     }
	
	
	protected StructuredDocumentEvent regionCheck(
			IStructuredDocumentRegion oldNode, IStructuredDocumentRegion newNode) {
		final StructuredDocumentEvent event = super.regionCheck(oldNode,
				newNode);

		
		System.err.println("region chek");
		if (event instanceof RegionChangedEvent) {
			RegionChangedEvent changedEvent = (RegionChangedEvent) event;

			if (changedEvent.getRegion().getType() == TwigRegionContext.TWIG_CONTENT) {
				oldNode.setRegions(newNode.getRegions());
			}
		}
		return event;
	}
	
	
	
	@Override
	public IStructuredTextReParser newInstance() {

		return new TwigStructuredDocumentReParser();

	}
	
	public StructuredDocumentEvent reparse() {
		
		
		
//		return super.reparse();
		
//TODO: find out why this reparse() logic does not work
// (only when deleting characters the regions are detected as dirty
		
//		StructuredDocumentEvent result = null;
//		// if we do not have a cachedNode, then the document
//		// must be empty, so simply use 'null' as the dirtyStart and dirtyEnd
//		// otherwise, find them.
//		if (fStructuredDocument.getCachedDocumentRegion() != null) {
//			findDirtyStart(fStart);
//			int end = fStart + fLengthToReplace;
//			findDirtyEnd(end);
//		}
//		if (fStructuredDocument.getCachedDocumentRegion() != null) {
//			result = checkHeuristics();
//		}
//		if (result == null) {
//			result = reparse(dirtyStart, dirtyEnd);
//		}
//		endReParse();
//		return result;
		
		
		findDirtyStart(fStart);
		int end = fStart + fLengthToReplace;
		findDirtyEnd(end);
		StructuredDocumentEvent event = reparse(dirtyStart, dirtyEnd);
		return event;		
		
	}
}
