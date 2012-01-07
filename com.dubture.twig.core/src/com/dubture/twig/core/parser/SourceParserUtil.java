package com.dubture.twig.core.parser;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;

import com.dubture.twig.core.parser.ast.CompilerAstLexer;
import com.dubture.twig.core.parser.ast.TwigAstParser;

public class SourceParserUtil
{
    public static ModuleDeclaration parseSourceModule(Reader in)
            throws IOException
    {

        CompilerAstLexer lexer = new CompilerAstLexer(in);
        TwigAstParser parser = new TwigAstParser(lexer);

        // parser.setFileName(fileName);
        try {
            parser.parse();
        } catch (Exception e) {
            // TODO: add recovery
            e.printStackTrace();
            return new ModuleDeclaration(0);
        }
        
        return parser.getModuleDeclaration();

    }
}
