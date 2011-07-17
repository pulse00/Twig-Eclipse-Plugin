package org.eclipse.twig.core.builder;

import java.util.Stack;

import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.references.SimpleReference;
import org.eclipse.dltk.core.builder.IBuildContext;
import org.eclipse.php.internal.core.compiler.ast.nodes.ArrayCreation;
import org.eclipse.php.internal.core.compiler.ast.nodes.ArrayElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.ArrayVariableReference;
import org.eclipse.php.internal.core.compiler.ast.nodes.Assignment;
import org.eclipse.php.internal.core.compiler.ast.nodes.ClassDeclaration;
import org.eclipse.php.internal.core.compiler.ast.nodes.ClassInstanceCreation;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPCallArgumentsList;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPCallExpression;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPMethodDeclaration;
import org.eclipse.php.internal.core.compiler.ast.nodes.ReturnStatement;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;
import org.eclipse.php.internal.core.compiler.ast.visitor.PHPASTVisitor;
import org.eclipse.twig.core.TwigCoreConstants;
import org.eclipse.twig.core.model.Filter;
import org.eclipse.twig.core.model.Function;


/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class TwigVisitor extends PHPASTVisitor {

	private IBuildContext context;
	
	private boolean inTwigExtension;	
	private boolean inFilterCreation;
	private boolean inTokenParser;
		
	private boolean inTagParseMethod;
	
	
	final Stack<Filter> filters = new Stack<Filter>();
	private Stack<Function> functions = new Stack<Function>();


	
	public Stack<Filter> getFilters() {
		return filters;
	}
	
	public Stack<Function> getFunctions() {
		
		return functions;
	}

	public TwigVisitor(IBuildContext context) {

		this.context = context;
		
	}

	@Override
	public boolean visit(ClassDeclaration s) throws Exception {
		
		inTwigExtension = false;
		
		for (String superclass : s.getSuperClassNames()) {			
			if (superclass.equals(TwigCoreConstants.TWIG_EXTENSION)) {				
				inTwigExtension = true;			
			} else if (superclass.equals(TwigCoreConstants.TWIG_TOKEN_PARSER)) {				
				inTokenParser = true;				
			}
		}
	
		return true;
	}
	
	@Override
	public boolean endvisit(ClassDeclaration s) throws Exception {

		inTwigExtension = false;
		inTokenParser = false;
		return true;
	}
	
	
	@Override
	public boolean visit(Assignment s) throws Exception {

		if (inFilterCreation && inTwigExtension) {
			
			if (s.getVariable().getClass() == ArrayVariableReference.class) {

			}
		}
		
		return true;
	
	}
	
	@Override
	public boolean endvisit(Assignment s) throws Exception {

		return true;
	}
	
	@Override
	public boolean visit(ArrayCreation array) throws Exception {

		if (inFilterCreation && inTwigExtension) {	
			
		
		}
		
		return true;
	
	}
	
	@Override
	public boolean visit(ClassInstanceCreation s) throws Exception {

		if (inFilterCreation && inTwigExtension) {
			
		}
		return true;
	}
	
	
	@Override
	public boolean endvisit(ClassInstanceCreation s) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean endvisit(ArrayCreation s) throws Exception {

		
		return true;
	}
	
	@Override
	public boolean visit(PHPCallExpression s) throws Exception {
	
		
		if (inTagParseMethod) {
			
			SimpleReference ref = s.getCallName();
			
			if (ref != null && "subparse".equals(ref.getName())) {
				
				System.err.println("subparse");
				s.traverse(new PHPASTVisitor() {
					
					@Override
					public boolean visit(ArrayCreation array) throws Exception {
						
						for (ArrayElement elem : array.getElements()) {
							
							Expression key = elem.getKey();
							Expression value = elem.getValue();
							
							if (key == null || value == null)
								continue;
							
							System.err.println(elem.getKey().toString() + " => " + elem.getValue().toString());
							
						}
						

						return false;
					}
					
					
				});
				
				
			}
			
		}
		

		return true;
	}
	
	@Override
	public boolean visit(PHPCallArgumentsList s) throws Exception {

		return true;
	}
	
	@Override
	public boolean visit(PHPMethodDeclaration s) throws Exception {
		
		if (inTwigExtension && s.getName().equals(TwigCoreConstants.GET_FILTERS)) {
			
			inFilterCreation = true;			
			s.traverse(new PHPASTVisitor() {
				
				@Override
				public boolean visit(ArrayElement s) throws Exception {

					Expression key = s.getKey();
					Expression value = s.getValue();
					
					if (key == null | value == null)
						return false;
					
					if (key.getClass() == Scalar.class && value.getClass() == ClassInstanceCreation.class) {
						
						Scalar name = (Scalar) key;
						ClassInstanceCreation filterClass = (ClassInstanceCreation) value;
						
						if (filterClass.getClassName().toString().equals(TwigCoreConstants.TWIG_FILTER_FUNCTION)) {
							filters.push(new Filter(context.getFile(), name));
						}
					}
					return true;
				}
			});
		} else if (inTwigExtension && TwigCoreConstants.GET_FUNCTIONS.equals(s.getName())) {
			
			inFilterCreation = true;			
			s.traverse(new PHPASTVisitor() {
				
				@Override
				public boolean visit(ArrayElement s) throws Exception {

					Expression key = s.getKey();
					Expression value = s.getValue();
					
					if (key == null | value == null)
						return false;
					
					if (key.getClass() == Scalar.class && value.getClass() == ClassInstanceCreation.class) {
						
						Scalar name = (Scalar) key;
						ClassInstanceCreation filterClass = (ClassInstanceCreation) value;
						
						if (filterClass.getClassName().toString().equals(TwigCoreConstants.TWIG_FUNCTION_METHOD)) {							
							functions.push(new Function(context.getFile(), name));
						}
					}
					return true;
				}
			});			
			
		} else if (inTokenParser && TwigCoreConstants.PARSE_TOKEN_METHOD.equals(s.getName())) {
			
//			System.err.println("in token parser " + s.getDeclaringTypeName() + " " + s.getName());
			inTagParseMethod = true;
			
		} else if (inTokenParser && TwigCoreConstants.PARSE_GET_TAG_METHOD.equals(s.getName())) {
		

			
			s.traverse(new PHPASTVisitor() {
				
				@Override
				public boolean visit(ReturnStatement s) throws Exception {

					
					if (s.getExpr().getClass() == Scalar.class) {

						Scalar scalar = (Scalar) s.getExpr();						
//						System.err.println(scalar.getValue().replaceAll("['\"]", ""));
						
					}

					return false;
				}
			});
			
		}
		
		return true;
	}
	
	@Override
	public boolean endvisit(PHPMethodDeclaration s) throws Exception {
	
		inFilterCreation = false;
		inTagParseMethod = false;
		return true;
	
	}
	
	@Override
	public boolean visit(ReturnStatement s) throws Exception {
	
		if (inTwigExtension && inFilterCreation) {
			
		}
		return true;
	}
	
	@Override
	public boolean endvisit(ReturnStatement s) throws Exception {

		
		return true;

	}

}
