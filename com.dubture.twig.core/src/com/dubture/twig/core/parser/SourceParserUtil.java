package com.dubture.twig.core.parser;

import java.io.IOException;

import java.io.Reader;
import java.io.StringReader;

import org.eclipse.core.runtime.Assert;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceModule;

import com.dubture.twig.core.parser.ast.CompilerAstLexer;
import com.dubture.twig.core.parser.ast.TwigAstParser;

@SuppressWarnings("restriction")
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

    /**
     * @param module
     * @return 
     * @throws IOException 
     * @throws ModelException 
     */
    public static ModuleDeclaration parseSourceModule(SourceModule module) throws ModelException, IOException
    {
        Assert.isNotNull(module);
        return parseSourceModule(new StringReader(module.getSource()));
        
    }
}
