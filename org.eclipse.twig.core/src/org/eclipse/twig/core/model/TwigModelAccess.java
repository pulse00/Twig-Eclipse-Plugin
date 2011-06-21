package org.eclipse.twig.core.model;

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
	
	private IType filterType = null;
	
	public Stack<Filter> getFilters() {
		return filters;
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
}
