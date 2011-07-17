package org.eclipse.twig.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.core.index2.search.ISearchEngine;
import org.eclipse.dltk.core.index2.search.ISearchEngine.MatchRule;
import org.eclipse.dltk.core.index2.search.ISearchEngine.SearchFor;
import org.eclipse.dltk.core.index2.search.ISearchRequestor;
import org.eclipse.dltk.core.index2.search.ModelAccess;
import org.eclipse.dltk.core.search.IDLTKSearchScope;
import org.eclipse.dltk.core.search.SearchEngine;
import org.eclipse.dltk.internal.core.util.LRUCache;
import org.eclipse.php.internal.core.PHPLanguageToolkit;
import org.eclipse.php.internal.core.model.PhpModelAccess;
import org.eclipse.twig.core.TwigCoreConstants;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigModelAccess extends PhpModelAccess {

	private static TwigModelAccess instance = null;	
	private List<Template> templates = new ArrayList<Template>();

	private IType filterType = null;
	private IType functionType = null;
	
	private LRUCache tagCache = new LRUCache();


	private TwigModelAccess() {


	}	
	
	public static TwigModelAccess getDefault() {
		if (instance == null) {
			instance = new TwigModelAccess();
		}
		
		return instance;
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


	/**
	 * 
	 * Get all Functions defined in the {@link IScriptProject}.
	 * 
	 * 
	 * @param scriptProject
	 * @return
	 */
	public Function[] getFunctions(IScriptProject scriptProject) {

		IDLTKSearchScope scope = SearchEngine.createSearchScope(scriptProject);
		ISearchEngine engine = ModelAccess.getSearchEngine(PHPLanguageToolkit.getDefault());		 

		final List<Function> functions = new ArrayList<Function>();

		engine.search(ITwigModelElement.FUNCTION, null, null, 0, 0, 100, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				Function filter = new Function(elementName);
				functions.add(filter);				

			}
		}, null);

		return (Function[]) functions.toArray(new Function[functions.size()]);

	}


	/**
	 * 
	 * Get all Filters defined in the {@link IScriptProject}.
	 * 
	 * 
	 * @param scriptProject
	 * @return
	 */
	public Filter[] getFilters(IScriptProject scriptProject) {

		IDLTKSearchScope scope = SearchEngine.createSearchScope(scriptProject);
		ISearchEngine engine = ModelAccess.getSearchEngine(PHPLanguageToolkit.getDefault());		 

		final List<Filter> filters = new ArrayList<Filter>();

		engine.search(ITwigModelElement.FILTER, null, null, 0, 0, 100, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				Filter filter = new Filter(elementName);
				filters.add(filter);				

			}
		}, null);

		return (Filter[]) filters.toArray(new Filter[filters.size()]);		

	}

	
	/**
	 * 
	 * Check for a valid startTag in the given {@link IScriptProject}.
	 * 
	 * 
	 * 
	 * @param scriptProject
	 * @param text
	 * @return
	 */
	public boolean isStartTag(IScriptProject scriptProject, String text) {

		return isTag(scriptProject, text, ITwigModelElement.START_TAG);
	}

	/**
	 * 
	 * Check for a valid endTag in the {@link IScriptProject}.
	 * 
	 * @param scriptProject
	 * @param text
	 * @return
	 */
	public boolean isEndTag(IScriptProject scriptProject, String text) {

		return isTag(scriptProject, text, ITwigModelElement.END_TAG);
	}
	

	/**
	 * 
	 * Check if the given tag is valid for the {@link IScriptProject}.
	 * 
	 * 
	 * @param scriptProject
	 * @param text
	 * @param type
	 * @return
	 */
	private boolean isTag(IScriptProject scriptProject, String text, int type) {

		IDLTKSearchScope scope = null;

		if (scriptProject != null)
			scope = SearchEngine.createSearchScope(scriptProject);
		else SearchEngine.createWorkspaceScope(PHPLanguageToolkit.getDefault());
		
		if (scope == null)
			return false;		
		
		String cacheKey = scriptProject.getElementName() + text + type;
		
		if( tagCache.get(cacheKey) != null) {
			return true;		
		}
		
		ISearchEngine engine = ModelAccess.getSearchEngine(PHPLanguageToolkit.getDefault());
		
		final List<String> tags = new ArrayList<String>();

		engine.search(type, null, text, 0, 0, 1, SearchFor.REFERENCES, MatchRule.EXACT, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				tags.add(elementName);				

			}
		}, null);
		
	
		if (tags.size() == 1) {			
			String tagName= tags.get(0);
			cacheKey = scriptProject.getElementName() + tagName;
			tagCache.put(cacheKey, text);
			return true;
		}
		
		return false;

		
		
	}

	public boolean isTwigTag(IScriptProject scriptProject, String nodeName) {

		boolean isTag = isStartTag(scriptProject, nodeName);
		
		if (isTag == true)
			return true;
		
		return isEndTag(scriptProject, nodeName);
	}
	
	public void clearTagCache() {

		tagCache.flush();
		
		
	}
	
	public void clearCache() {

		
		clearTagCache();
		
		
	}
}