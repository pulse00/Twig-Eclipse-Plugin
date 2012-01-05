/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.TwigNode;
import com.dubture.twig.core.parser.TwigSourceParser;

/**
 * 
 * Finds a {@link TwigNode} in a twig template at a given position.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class NodeFinder
{

    private int offset;
    private int currentPosition;
    public TwigNode node = null;

    public TwigNode find(String source, int offset)
    {

        try {

            this.offset = offset;
            BufferedReader br = new BufferedReader(new StringReader(source));

            String line;

            currentPosition = 0;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {

                lineNumber++;

                if (line.contains(TwigSourceParser.TWIG_OPEN)) {
                    parsePrint(line, TwigSourceParser.TWIG_OPEN,
                            TwigSourceParser.TWIG_CLOSE, lineNumber,
                            currentPosition);

                } else if (line.contains(TwigSourceParser.STMT_OPEN)) {
                    parseStatement(line, TwigSourceParser.STMT_OPEN,
                            TwigSourceParser.STMT_CLOSE, lineNumber,
                            currentPosition);
                }

                // +1 for the line break which apparently doesn't count in
                // .length();
                currentPosition += line.length() + 1;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (node != null)
            Logger.debugMSG("found node " + node);

        return node;
    }

    private void parsePrint(String line, String twigOpen, String twigClose,
            int lineNumber, int current)
    {

    }

    private void parseStatement(String line, String open, String close,
            int lineNumber, int current)
    {

        int start = 0;
        int end = 0;

        while ((start = line.indexOf(open)) >= 0) {

            end = line.indexOf(close);

            if (end == -1) {
                // TODO: report error
                break;
            }

            String twig = line.substring(start, end + 2);
            parseTwig(twig, (current + start), lineNumber);

            if (line.length() > end + 1) {
                // TODO: report error
                break;
            }

            line = line.substring(end + 2);

        }

    }

    private void parseTwig(String source, int offset, int line)
    {

        try {
            // TODO: REWRITE AFTER PARSER IMPLEMENTATION
            // CharStream content = new ANTLRStringStream(source);
            // TwigLexer lexer = new TwigLexer(content);
            //
            // TwigParser parser = new TwigParser(new CommonTokenStream(lexer));
            //
            // parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
            // TwigParser.twig_source_return root;
            //
            // root = parser.twig_source();
            // TwigCommonTree tree = (TwigCommonTree) root.getTree();
            // NodeVisitor visitor = new NodeVisitor(offset);
            //
            // if (tree != null)
            // tree.accept(visitor);

        } catch (Exception e) {
            Logger.logException(e);
        }
    }
}
