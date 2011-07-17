package org.eclipse.twig.core.model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
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
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

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

	
	private LRUCache tagCache = new LRUCache();


	private TwigModelAccess() {


	}	
	
	public static TwigModelAccess getDefault() {
		if (instance == null) {
			instance = new TwigModelAccess();
		}
		
		return instance;
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
		
		final JSONParser parser = new JSONParser();
		final List<Function> functions = new ArrayList<Function>();

		engine.search(ITwigModelElement.FUNCTION, null, null, 0, 0, 100, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				try {
					
					Function function = new Function(elementName);
					
					if (metadata != null) {
						
						JSONArray mdata = (JSONArray) parser.parse(new StringReader(metadata));
						
						if (mdata != null && mdata.size() > 0) {
							function.setPhpClass((String)mdata.get(0));
						}
						
					}				
					functions.add(function);
					
				} catch (Exception e) {
					e.printStackTrace();
				}			

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
		
		final JSONParser parser = new JSONParser();

		final List<Filter> filters = new ArrayList<Filter>();

		engine.search(ITwigModelElement.FILTER, null, null, 0, 0, 100, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				try {
					Filter filter = new Filter(elementName);
					if (metadata != null) {
						
						JSONArray mdata = (JSONArray) parser.parse(new StringReader(metadata));
						
						if (mdata != null && mdata.size() > 0) {
							filter.setPHPClass((String)mdata.get(0));
						}
						
					}
					
					filters.add(filter);				
					
				} catch (Exception e) {
					e.printStackTrace();
				}

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


	/**
	 * 
	 * 
	 * 
	 * 
	 * @param scriptProject
	 * @return
	 */
	public Tag[] findTags(IScriptProject scriptProject) {

		IDLTKSearchScope scope = SearchEngine.createSearchScope(scriptProject);
		ISearchEngine engine = ModelAccess.getSearchEngine(PHPLanguageToolkit.getDefault());
		
		final List<Tag> tags = new ArrayList<Tag>();		
		final JSONParser parser = new JSONParser();

		engine.search(ITwigModelElement.START_TAG, null, null, 0, 0, 200, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				try {
					
					Tag tag = new Tag(elementName);
					
					if(metadata != null) {
						
						JSONArray data = (JSONArray) parser.parse(new StringReader(metadata));
						if (data.size() > 0)
							tag.setPHPClass((String) data.get(0));
						
						if (data.size() > 1)
							tag.setDescription((String) data.get(1));
						
					}
					tags.add(tag);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
								

			}
		}, null);
		
		engine.search(ITwigModelElement.END_TAG, null, null, 0, 0, 200, SearchFor.REFERENCES, MatchRule.PREFIX, scope, new ISearchRequestor() {

			@Override
			public void match(int elementType, int flags, int offset, int length,
					int nameOffset, int nameLength, String elementName,
					String metadata, String doc, String qualifier, String parent,
					ISourceModule sourceModule, boolean isReference) {

				try {
					
					Tag tag = new Tag(elementName);						
					
					if(metadata != null) {
						
						JSONArray data = (JSONArray) parser.parse(new StringReader(metadata));

						if (data.size() > 0)
							tag.setPHPClass((String) data.get(0));
						
						if (data.size() > 1)
							tag.setDescription((String) data.get(1));
						
					}
					tags.add(tag);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			}
		}, null);
				
		return (Tag[]) tags.toArray(new Tag[tags.size()]);
		
	}
}