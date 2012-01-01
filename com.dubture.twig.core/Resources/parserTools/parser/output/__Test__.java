import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import com.dubture.twig.core.parser.ast.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        TwigLexer lex = new TwigLexer(new ANTLRFileStream("/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/output/__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        TwigParser g = new TwigParser(tokens, 49100, null);
        try {
            g.template();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}