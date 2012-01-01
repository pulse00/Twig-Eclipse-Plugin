package com.dubture.twig.core.parser.ast.node;

public interface ASTNodeKinds
{

    public static final int PRINT_STATEMENT = 100;
    public static final int BLOCK_STATEMENT = 101;    
    public static final int CALL_EXPRESSION = 102;
    public static final int IDENT           = 103;
    public static final int HASH            = 104;
    public static final int HASH_ENTRY      = 105;
    public static final int ARRAY           = 106;
    public static final int VARIABLE_ACCESS = 107;
    public static final int STRING_LITERAL  = 106;

}
