package org.eclipse.twig.core.documentModel.parser;

import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

@SuppressWarnings("restriction")
public class TwigSourceElementRequestorExtension extends
		PHPSourceElementRequestorExtension {

		
	public TwigSourceElementRequestorExtension() {
		
	}
	
	
	@Override
	public void setSourceModule(IModuleSource sourceModule) {
			
		char[] contentx = sourceModule.getContentsAsCharArray();
		
		String source = sourceModule.getSourceContents();
		TwigTokenizer tokenizer = new TwigTokenizer(contentx);
		IElementRequestor requestor = getRequestor();
		requestor.enterModule();
		
		try {
		
			while(!tokenizer.isEOF()) {
				
				ITextRegion region = tokenizer.getNextToken();
				
				if (region instanceof ContextRegion) {
					
					if (region.getType() == TwigRegionContext.TWIG_LABEL) {

						FieldInfo info = new FieldInfo();
						info.name = source.substring(region.getStart(), region.getEnd());
						info.nameSourceStart = region.getStart();
						info.nameSourceEnd = region.getTextEnd();
						info.modifiers = Modifiers.AccPublic;
						info.declarationStart = region.getStart();
						
						requestor.enterField(info);
						requestor.exitField(region.getTextEnd());					
						
					}
					
				}
				
			}
			
			requestor.exitModule(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.setSourceModule(sourceModule);
	}
}
