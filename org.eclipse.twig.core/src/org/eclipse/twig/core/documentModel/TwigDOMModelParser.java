package org.eclipse.twig.core.documentModel;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.regions.TwigRegionTypes;
import org.eclipse.twig.core.parser.TwigCommonTree;
import org.eclipse.twig.core.parser.TwigCommonTreeAdaptor;
import org.eclipse.twig.core.parser.TwigLexer;
import org.eclipse.twig.core.parser.TwigParser;
import org.eclipse.twig.core.parser.TwigStatementVisitor;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.document.DOMModelImpl;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigDOMModelParser extends XMLModelParser {

	public static final String TWIG_PRINT_TAG = "PRINT"; //$NON-NLS-1$	
	public static final String TWIG_STMT_TAG = "STMT"; //$NON-NLS-1$
	
	public static final String TWIG_BLOCK_START = "BLOCK";
	public static final String TWIG_BLOCK_END = "ENDBLOCK";
	
	public static final String TWIG_FOR_START = "FOR";
	public static final String TWIG_FOR_END = "ENDFOR";
	
	public static final String TWIG_IF_START = "IF";
	public static final String TWIG_IF_END = "ENDIF";
	
	public static final String TWIG_MACRO_START = "MACRO";
	public static final String TWIG_MACRO_END = "ENDMACRO";
	
	
	
	//private static final Pattern blockPattern = Pattern.compile("{% ) 
	

	public TwigDOMModelParser(DOMModelImpl model) {
		super(model);
	}

	protected boolean isNestedContent(String regionType) {
		return regionType == TwigRegionContext.TWIG_CONTENT;
	}

	protected boolean isNestedTag(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN
				|| regionType == TwigRegionContext.TWIG_OPEN
				|| regionType == TwigRegionContext.TWIG_CLOSE
				|| regionType == TwigRegionContext.TWIG_STMT_CLOSE;
	}

	protected boolean isNestedTagOpen(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN
				|| regionType == TwigRegionContext.TWIG_OPEN;
	}

	protected String computeNestedTag(String regionType, String tagName,
			IStructuredDocumentRegion structuredDocumentRegion,
			ITextRegion region) {
		
		if (regionType.equals(TwigRegionTypes.TWIG_STMT_OPEN)) {
			
			try {
				
				String text =  structuredDocumentRegion.getText();
				
				CharStream content = new ANTLRStringStream(text);
				TwigLexer lexer = new TwigLexer(content);

				TwigParser parser = new TwigParser(new CommonTokenStream(lexer));

				parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
				TwigParser.twig_source_return root;
				
				root = parser.twig_source();
				TwigCommonTree tree = (TwigCommonTree) root.getTree();
				TwigStatementVisitor visitor = new TwigStatementVisitor();
				tree.accept(visitor);
				
				if (visitor.getStatementType() == TwigParser.BLOCK) {
					return TWIG_BLOCK_START;
				} else if (visitor.getStatementType() == TwigParser.ENDBLOCK) {					
					return TWIG_BLOCK_END;
				} else if (visitor.getStatementType() == TwigParser.IF) {
					return TWIG_IF_START;
				} else if (visitor.getStatementType() == TwigParser.ENDIF) {					
					return TWIG_IF_END;
				} else if (visitor.getStatementType() == TwigParser.FOR) {
					return TWIG_FOR_START;
				} else if (visitor.getStatementType() == TwigParser.ENDFOR) {					
					return TWIG_FOR_END;					
				} else if (visitor.getStatementType() == TwigParser.MACRO) {
					return TWIG_MACRO_START;
				} else if (visitor.getStatementType() == TwigParser.ENDMACRO) {
					return TWIG_MACRO_END;					
				}				

				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return TWIG_STMT_TAG;
			
			
		} else if (regionType.equals(TwigRegionTypes.TWIG_OPEN)) {
			
			return TWIG_PRINT_TAG;
		}
		
		
		return TWIG_STMT_TAG;
	}

	protected boolean isNestedTagClose(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_CLOSE
				|| regionType == TwigRegionContext.TWIG_CLOSE;
	}
}
