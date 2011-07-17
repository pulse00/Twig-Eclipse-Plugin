package org.eclipse.twig.core.index;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.declarations.MethodDeclaration;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.declarations.TypeDeclaration;
import org.eclipse.dltk.ast.expressions.CallArgumentsList;
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
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPDocBlock;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPMethodDeclaration;
import org.eclipse.php.internal.core.compiler.ast.nodes.ReturnStatement;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;
import org.eclipse.php.internal.core.compiler.ast.visitor.PHPASTVisitor;
import org.eclipse.twig.core.TwigCoreConstants;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.model.Filter;
import org.eclipse.twig.core.model.Function;
import org.eclipse.twig.core.model.ITwigModelElement;
import org.eclipse.twig.core.model.Tag;
import org.eclipse.twig.core.model.Test;
import org.eclipse.twig.core.model.TwigType;
import org.eclipse.twig.core.util.TwigModelUtils;
import org.json.simple.JSONObject;

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
	
	private Tag tag;
	
	private List<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	
	private List<Function> functions = new ArrayList<Function>();
	private List<Filter> filters = new ArrayList<Filter>();
	private List<Test> tests= new ArrayList<Test>();	
	
	public TwigIndexingVisitorExtension() {

	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean visit(MethodDeclaration s) throws Exception {


		
		if (!methods.contains(s))
			methods.add(s);
		
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
							
							Scalar internal = (Scalar) filterClass.getCtorParams().getChilds().get(0);
							
							if (internal == null)
								return true;
							
							if (filterClass.getClassName().toString().equals(TwigCoreConstants.TWIG_FILTER_FUNCTION)) {
								
								String elemName = name.getValue().replaceAll("['\"]", "");
								
								Filter filter = new Filter(elemName);
								filter.setInternalFunction(internal.getValue().replaceAll("['\"]", ""));
								filter.setPhpClass(currentClass.getName());
								
								filters.add(filter);
								
							}
						}
						return true;
					}
				});
				
			} else if (inTwigExtension && TwigCoreConstants.GET_TESTS.equals(s.getName())) {
				
				
				phpMethod.traverse(new PHPASTVisitor() {
					
					@Override
					public boolean visit(ArrayElement s) throws Exception {

						Expression key = s.getKey();
						Expression value = s.getValue();
						
						if (key == null || value == null)
							return false;
						
						if (key.getClass() == Scalar.class && value.getClass() == ClassInstanceCreation.class) {
							
							Scalar name = (Scalar) key;
							ClassInstanceCreation functionClass = (ClassInstanceCreation) value;
							
							CallArgumentsList args = functionClass.getCtorParams();
							Scalar internalFunction = (Scalar) args.getChilds().get(0);
						
							if (internalFunction == null)
								return true;
							
							if (functionClass.getClassName().toString().equals(TwigCoreConstants.TWIG_TEST_FUNCTION)) {
								
								String elemName = name.getValue().replaceAll("['\"]", "");
								
								JSONObject metadata = new JSONObject();
								metadata.put(TwigType.PHPCLASS, currentClass.getName());
								
								Test test = new Test(elemName);
								test.setPhpClass(currentClass.getName());
								test.setInternalFunction(internalFunction.getValue().replaceAll("['\"]", ""));
								tests.add(test);
								
								
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
						
						if (key == null || value == null)
							return false;
						
						if (key.getClass() == Scalar.class && value.getClass() == ClassInstanceCreation.class) {
							
							Scalar name = (Scalar) key;
							ClassInstanceCreation functionClass = (ClassInstanceCreation) value;
							
							CallArgumentsList args = functionClass.getCtorParams();
							Scalar internalFunction = (Scalar) args.getChilds().get(0);
						
							if (internalFunction == null)
								return true;
							
							if (functionClass.getClassName().toString().equals(TwigCoreConstants.TWIG_FUNCTION_METHOD)) {
								
								String elemName = name.getValue().replaceAll("['\"]", "");
								
								JSONObject metadata = new JSONObject();
								metadata.put(TwigType.PHPCLASS, currentClass.getName());
								
								Function function = new Function(elemName);
								function.setPhpClass(currentClass.getName());
								function.setInternalFunction(internalFunction.getValue().replaceAll("['\"]", ""));
								functions.add(function);
								
								
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
							tag.setStartTag(scalar.getValue().replaceAll("['\"]", ""));
							
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
					
					tag = new Tag();
					
					inTokenParser = true;
				}
			}
		
			return true;			
			
		}

		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean endvisit(TypeDeclaration s) throws Exception {

		
		if (s instanceof ClassDeclaration) {
		
			
			if (inTwigExtension) {
			
			}
			
			
			
			if (tag != null) {
				
				if (tag.getStartTag() != null && tag.getEndTag() != null) {
					
					int length = currentClass.sourceEnd() - currentClass.sourceStart();					
					PHPDocBlock block = currentClass.getPHPDoc();

					String desc = "";
					if (block != null) {
						String shortDesc = block.getShortDescription() != null ? block.getShortDescription() : "";
						String longDesc = block.getLongDescription() != null ? block.getLongDescription() : "";
						desc =  longDesc + shortDesc;						
					}
					
					JSONObject metadata = new JSONObject();
					metadata.put(TwigType.PHPCLASS, currentClass.getName());
					metadata.put(TwigType.DOC, desc);					

					Logger.debugMSG("indexing twig tag: " + tag.getStartTag() + " : " + tag.getEndTag() + " with metadata: " + metadata.toString());
					
					ReferenceInfo info = new ReferenceInfo(ITwigModelElement.START_TAG, currentClass.sourceStart(), length, tag.getStartTag(), metadata.toString(), null);
					requestor.addReference(info);
					
					ReferenceInfo endIinfo = new ReferenceInfo(ITwigModelElement.END_TAG, currentClass.sourceStart(), length, tag.getEndTag(), metadata.toString(), null);
					requestor.addReference(endIinfo);
					
														
				}			
				tag = null;
			}
			
			
			inTwigExtension = false;
			inTokenParser = false;
			currentClass = null;		
			
		}
		
		return false;

	}
	
	
	@Override
	public boolean visit(Statement s) throws Exception {

		if (!inTagParseMethod)
			return false;
		
		s.traverse(new PHPASTVisitor() {
			
			@Override
			public boolean visit(PHPCallExpression callExpr) throws Exception {

				SimpleReference ref = callExpr.getCallName();
				
				if (ref != null && TwigCoreConstants.PARSE_SUB.equals(ref.getName())) {
					
					callExpr.traverse(new PHPASTVisitor() {
						
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
													tag.setEndTag(stmt);
													return false;
												}
												
											}
											
										}
									}								
								}
							}
							return true;
						}
					});
				}								
				return true;
			}
		});
		
		return true;
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
	
	
	@Override
	public boolean endvisit(ModuleDeclaration s) throws Exception {

		for (Test test : tests) {

			for (MethodDeclaration method : methods) {
				
				if (method.getName().equals(test.getInternalFunction())) {
					
					PHPMethodDeclaration phpMethod = (PHPMethodDeclaration) method;
					PHPDocBlock doc = phpMethod.getPHPDoc();
					
					if (doc != null) {
						test.addDoc(doc);
					}
					
					
					ReferenceInfo info = new ReferenceInfo(ITwigModelElement.TEST, 0, 0, test.getElementName(), test.getMetadata(), null);
					requestor.addReference(info);
					
				}			
			}			
		}
		
		
		for (Function function : functions) {

			System.err.println("function: " + function.getElementName());
			
			for (MethodDeclaration method : methods) {
				
				if (method.getName().equals(function.getInternalFunction())) {
					
					PHPMethodDeclaration phpMethod = (PHPMethodDeclaration) method;
					PHPDocBlock doc = phpMethod.getPHPDoc();
					
					if (doc != null) {
						function.addDoc(doc);
					}
					
					function.addArgs(method.getArguments());
					ReferenceInfo info = new ReferenceInfo(ITwigModelElement.FUNCTION, 0, 0, function.getElementName(), function.getMetadata(), null);
					requestor.addReference(info);
					
				}			
			}			
		}
		
				
		for (Filter filter : filters) {		
			
			for (MethodDeclaration method : methods) {
				
				if (method.getName().equals(filter.getInternalFunction())) {
					
					PHPMethodDeclaration phpMethod = (PHPMethodDeclaration) method;
					PHPDocBlock doc = phpMethod.getPHPDoc();
					
					if (doc != null) {
						filter.addDoc(doc);
					}
					
					filter.addArgs(method.getArguments());
					ReferenceInfo info = new ReferenceInfo(ITwigModelElement.FILTER, 0, 0, filter.getElementName(), filter.getMetadata(), null);
					requestor.addReference(info);
					
				}				
			}
		}
		
		
		return true;
	
	}

}