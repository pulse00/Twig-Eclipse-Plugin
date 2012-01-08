package com.dubture.twig.core.parser.ast.node;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.statements.Statement;

public class TwigModuleDeclaration extends ModuleDeclaration
{

    public TwigModuleDeclaration(int length, List<Statement> statements)
    {
        super(length);
        
        for (Statement statement : statements) {
            System.err.println("--- adding statement " + statement.getClass());
            addStatement(statement);
        }
    }
    
    public List<BlockStatement> getBlocks()
    {        
        List<BlockStatement> blocks = new LinkedList<BlockStatement>();
        
        for (Object o : getStatements()) {            
            if (o instanceof BlockStatement) {                
                blocks.add((BlockStatement) o);
            }
        }
        return blocks;
        
    }
}
