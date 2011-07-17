package org.eclipse.twig.core.index;

import org.eclipse.dltk.ast.declarations.MethodDeclaration;
import org.eclipse.dltk.ast.declarations.TypeDeclaration;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.references.SimpleReference;
import org.eclipse.dltk.ast.statements.Statement;
import org.eclipse.dltk.core.index2.IIndexingRequestor.ReferenceInfo;
import org.eclipse.php.core.index.PhpIndexingVisitorExtension;
import org.eclipse.php.internal.core.compiler.ast.nodes.ArrayCreation;
import org.eclipse.php.internal.core.compiler.ast.nodes.ArrayElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.ClassDeclaration;
import org.eclipse.php.internal.core.compiler.ast.nodes.ClassInstanceCreation;
import org.eclipse.php.internal.core.compiler.ast.nodes.ExpressionStatement;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPCallExpression;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPMethodDeclaration;
import org.eclipse.php.internal.core.compiler.ast.nodes.ReturnStatement;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;
import org.eclipse.php.internal.core.compiler.ast.visitor.PHPASTVisitor;
import org.eclipse.twig.core.TwigCoreConstants;
import org.eclipse.twig.core.model.Tag;
import org.eclipse.twig.core.model.ITwigModelElement;
import org.eclipse.twig.core.util.TwigModelUtils;

/**
 * 
 * {@link TwigIndexingVisitorExtension} indexes:
 * 
 * - Filters
 * - Functions
 * - TokenParsers (used to detect start/end tags like if/endif, block/endblock etc
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigIndexingVisitorExtension extends PhpIndexingVisitorExtension {

	
	private boolean inTwigExtension;	
	private boolean inTokenParser;
	private boolean inTagParseMethod;
	private ClassDeclaration currentClass;
	
	private Tag blockTag;
	
	public TwigIndexingVisitorExtension() {

	}
	
	
	@Override
	public boolean visit(MethodDeclaration s) throws Exception {


		if (s instanceof PHPMethodDeclaration) {
			
			PHPMethodDeclaration phpMethod = (PHPMethodDeclaration) s;
			
			if (inTwigExtension && phpMethod.getName().equals(TwigCoreConstants.GET_FILTERS)) {
				
				phpMethod.traverse(new PHPASTVisitor() {
					
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
								
								int length = currentClass.sourceEnd() - currentClass.sourceStart();
								String elemName = name.getValue().replaceAll("['\"]", "");
								
								ReferenceInfo info = new ReferenceInfo(ITwigModelElement.FILTER, currentClass.sourceStart(), length, elemName, null, null);
								requestor.addReference(info);
								
							}
						}
						return true;
					}
				});
			} else if (inTwigExtension && TwigCoreConstants.GET_FUNCTIONS.equals(s.getName())) {
				
				phpMethod.traverse(new PHPASTVisitor() {
					
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
								
								int length = currentClass.sourceEnd() - currentClass.sourceStart();
								String elemName = name.getValue().replaceAll("['\"]", "");
								
								ReferenceInfo info = new ReferenceInfo(ITwigModelElement.FUNCTION, currentClass.sourceStart(), length, elemName, null, null);
								requestor.addReference(info);
								
							}
						}
						return true;
					}
				});			
				
			} else if (inTokenParser && TwigCoreConstants.PARSE_TOKEN_METHOD.equals(s.getName())) {
				
				inTagParseMethod = true;
				
			} else if (inTokenParser && TwigCoreConstants.PARSE_GET_TAG_METHOD.equals(s.getName())) {
			
				phpMethod.traverse(new PHPASTVisitor() {
					
					@Override
					public boolean visit(ReturnStatement s) throws Exception {
						
						if (s.getExpr().getClass() == Scalar.class) {
							Scalar scalar = (Scalar) s.getExpr();												
							blockTag.setStartTag(scalar.getValue().replaceAll("['\"]", ""));
							
						}

						return false;
					}
				});			
			}			
			
			
		}
					
		return false;
	}
	
	
	@Override
	public boolean endvisit(MethodDeclaration s) throws Exception {

		inTagParseMethod = false;
		return true;
	}
	
	
	@Override
	public boolean visit(TypeDeclaration s) throws Exception {

		if (s instanceof ClassDeclaration) {
			
			inTwigExtension = false;
			currentClass = (ClassDeclaration) s;
			
			for (String superclass : currentClass.getSuperClassNames()) {
				if (superclass.equals(TwigCoreConstants.TWIG_EXTENSION)) {				
					inTwigExtension = true;			
				} else if (superclass.equals(TwigCoreConstants.TWIG_TOKEN_PARSER)) {				
					
					blockTag = new Tag();
					inTokenParser = true;
				}
			}
		
			return true;			
			
		}

		return false;
	}
	
	
	@Override
	public boolean endvisit(TypeDeclaration s) throws Exception {

		if (s instanceof ClassDeclaration) {
			
			if (blockTag != null) {			
				if (blockTag.getStartTag() != null && blockTag.getEndTag() != null) {
					
					int length = currentClass.sourceEnd() - currentClass.sourceStart();
					ReferenceInfo info = new ReferenceInfo(ITwigModelElement.TAG, currentClass.sourceStart(), length, blockTag.getStartTag(), null, null);
					requestor.addReference(info);
														
				}			
			}
			
			blockTag = null;
			inTwigExtension = false;
			inTokenParser = false;
			currentClass = null;		
			
		}
		
		return false;

	}
	
	
	@Override
	public boolean visit(Statement s) throws Exception {

		if (s instanceof ExpressionStatement) {
			
			ExpressionStatement stmt = (ExpressionStatement) s;
			
			if (stmt.getExpr() instanceof PHPCallExpression) {
				
				PHPCallExpression callExpr = (PHPCallExpression) stmt.getExpr();
				
				if (inTagParseMethod) {
					
					SimpleReference ref = callExpr.getCallName();
					
					if (ref != null && TwigCoreConstants.PARSE_SUB.equals(ref.getName())) {
						
						s.traverse(new PHPASTVisitor() {
							
							@Override
							public boolean visit(ArrayCreation array) throws Exception {
								
								for (ArrayElement elem : array.getElements()) {
									
									Expression value = elem.getValue();
									
									if (value == null)
										continue;
									
									if (value.getClass() == Scalar.class) {
										
										Scalar scalar = (Scalar) value;
										String subParseMethod = scalar.getValue().replaceAll("['\"]", "");
										
										for (MethodDeclaration method : currentClass.getMethods()) {
											
											if (subParseMethod.equals(method.getName())) {
												
												String[] endStatements = TwigModelUtils.getEndStatements((PHPMethodDeclaration) method);
												
												for (String stmt : endStatements) {
																								
													if (stmt.startsWith("end")) {												
														blockTag.setEndTag(stmt);
														break;
													}
													
												}
												
											}
										}								
									}
								}
								return false;
							}
						});
					}
				}

				return true;
			}
		}
		
		return false;
	}
	
	
	@Override
	public boolean endvisit(Statement s) throws Exception {
		
		if (s instanceof ExpressionStatement) {
			
			ExpressionStatement stmt = (ExpressionStatement) s;
			
			if (stmt.getExpr() instanceof PHPCallExpression) {

				return true;
			}
		}
		
		return false;
		
		
	}

}