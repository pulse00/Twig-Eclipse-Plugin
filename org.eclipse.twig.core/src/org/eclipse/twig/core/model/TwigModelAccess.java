package org.eclipse.twig.core.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.core.index2.search.ISearchEngine.MatchRule;
import org.eclipse.dltk.core.search.IDLTKSearchScope;
import org.eclipse.dltk.core.search.SearchEngine;
import org.eclipse.php.internal.core.model.PhpModelAccess;
import org.eclipse.twig.core.TwigCoreConstants;

@SuppressWarnings("restriction")
public class TwigModelAccess {
		
	private static TwigModelAccess instance = null;	
	private Stack<Filter> filters = new Stack<Filter>();
	private Stack<Function> functions = new Stack<Function>();
	
	private List<Template> templates = new ArrayList<Template>();
	
	private IType filterType = null;
	private IType functionType = null;
	
	
	public Stack<Filter> getFilters() {
		return filters;
	}
	
	public Stack<Function> getFunctions() {
	
		return functions;
		
	}

	private TwigModelAccess() {
		
		
	}	
	

	public static TwigModelAccess getInstance() {
		
		if (instance == null) {
			instance = new TwigModelAccess();
		}
		
		return instance;
	}
	
	public void addFilters(Stack<Filter> newFilters) {

		for(Filter filter : newFilters) {
			
			if (filters.contains(filter))
				continue;
			
			filters.add(filter);
		}
	}
	

	public IType getFilterType(ISourceModule sourceModule) {
		
		if (filterType != null)
			return filterType;
		
		IScriptProject scriptProject = sourceModule.getScriptProject();
		
		if (scriptProject == null) {
			return null;			
		}
		
		IDLTKSearchScope scope = SearchEngine.createSearchScope(scriptProject);
		IType[] types = PhpModelAccess.getDefault().findTypes(null, TwigCoreConstants.TWIG_FILTER_FUNCTION,
				MatchRule.EXACT, 0, 0, scope, null);

		if (types.length == 1) {
			filterType = types[0];
			return filterType;
		}
		
		return null;
		
	}
	
	public IType getFunctionType(ISourceModule sourceModule) {
		
		if (functionType != null)
			return functionType;
		
		IScriptProject scriptProject = sourceModule.getScriptProject();
		
		if (scriptProject == null) {
			return null;			
		}
		
		IDLTKSearchScope scope = SearchEngine.createSearchScope(scriptProject);
		IType[] types = PhpModelAccess.getDefault().findTypes(null, TwigCoreConstants.TWIG_FUNCTION_METHOD,
				MatchRule.EXACT, 0, 0, scope, null);

		if (types.length == 1) {
			functionType = types[0];
			return functionType;
		}
		
		return null;		
		
	}



	public Template getTemplate(ISourceModule sourceModule) {
		
		for (Template template : templates) {			
			if(template.getSourceModule().equals(sourceModule))
				return template;			
		}

		return null;
	}



	public void addTemplate(Template twigTemplate) {

		if (templates.contains(twigTemplate))
			templates.remove(twigTemplate);

		templates.add(twigTemplate);		
		
	}


	public void addFunctions(Stack<Function> newFunctions) {

		for(Function function : newFunctions) {
			
			if (functions.contains(function))
				continue;
			
			functions.add(function);
		}
		
	}
}
