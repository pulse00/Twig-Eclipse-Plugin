package com.dubture.twig.core.parser;

import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import com.dubture.twig.core.parser.ast.TwigLexer;
import com.dubture.twig.core.parser.ast.TwigParser;
import com.dubture.twig.core.parser.ast.TwigParser.template_return;
import com.dubture.twig.core.parser.ast.TwigTreeWalker;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

public class SourceParserUtil
{
    public static TwigModuleDeclaration parseSourceModule(Reader in) throws IOException,
            RecognitionException
    {

        CharStream content = new ANTLRReaderStream(in);
        TwigLexer lexer = new TwigLexer(content);
        TwigParser parser = new TwigParser(new CommonTokenStream(lexer));

        template_return template = parser.template();

        CommonTree tree = (CommonTree) template.getTree();
        CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(tree);
        TwigTreeWalker walker = new TwigTreeWalker(nodeStream);

        return walker.module();

    }

}
