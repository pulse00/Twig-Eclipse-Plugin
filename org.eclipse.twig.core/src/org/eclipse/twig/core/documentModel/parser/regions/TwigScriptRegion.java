package org.eclipse.twig.core.documentModel.parser.regions;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.php.internal.core.documentModel.parser.regions.IPhpScriptRegion;
import org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer;
import org.eclipse.wst.sse.core.internal.parser.ForeignRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

@SuppressWarnings("restriction")
public class TwigScriptRegion extends ForeignRegion implements ITwigScriptRegion {

	private static final String TWIG_SCRIPT = "Twig Script";

//	private int ST_PHP_LINE_COMMENT = -1;
	private int ST_TWIG_CONTENT = -1;

	private IProject project;

	private boolean isFullReparsed;
	
	private final TwigTokenContainer tokensContainer = new TwigTokenContainer();	
	
	public TwigScriptRegion(String newContext, int startOffset,
			IProject project, AbstractTwigLexer twigLexer) {
		
		super(newContext, startOffset, 0, 0, TwigScriptRegion.TWIG_SCRIPT);
		
		this.project = project;

		try {
			// we use reflection here since we don't know the constant value of
			// of this state in specific PHP version lexer
//			ST_PHP_LINE_COMMENT = twigLexer.getClass()
//					.getField("ST_PHP_LINE_COMMENT").getInt(twigLexer);
			
			
			ST_TWIG_CONTENT = twigLexer.getClass()
					.getField("ST_TWIG_CONTENT").getInt(twigLexer);
		} catch (Exception e) {
			
			e.printStackTrace();
//			Logger.logException(e);
		}
		completeReparse(twigLexer);
		
		
	}
	
	public int getTokenCount() {
		
		return tokensContainer.size();
		
	}
	
	

	private void completeReparse(AbstractTwigLexer twigLexer) {
		setTwigtokens(twigLexer);
		
	}



	private void setTwigtokens(AbstractTwigLexer lexer) {
		setLength(0);
		setTextLength(0);

		isFullReparsed = true;
		assert lexer != null;
		
		int s = 0;

		int start = 0;
		this.tokensContainer.getModelForCreation();
		this.tokensContainer.reset();
		try {
			Object state = lexer.createLexicalStateMemento();
			String yylex = lexer.getNextToken();
			int yylength = 0;
			while (yylex != null && (yylex != TwigRegionTypes.TWIG_CLOSE && yylex != TwigRegionTypes.TWIG_STMT_CLOSE)) {
				yylength = lexer.getLength();
				this.tokensContainer.addLast(yylex, start, yylength, yylength, state);
				start += yylength;
				state = lexer.createLexicalStateMemento();
				yylex = lexer.getNextToken();
//				System.err.println("size: " + ++s);

			}
			
			adjustLength(start);
			adjustTextLength(start);


		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {

			this.tokensContainer.releaseModelFromCreation();
		}
	}



	@Override
	public ITextRegion getTwigToken(int offset) throws BadLocationException {
 
		return tokensContainer.getToken(offset);

	}
	
	/**
	 * @see IPhpScriptRegion#getPhpTokens(int, int)
	 */
	public final ITextRegion[] getTwigTokens(int offset, int length)
			throws BadLocationException {
		return tokensContainer.getTokens(offset, length);
	}
	
}