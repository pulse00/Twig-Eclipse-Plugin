package org.eclipse.twig.core;

import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;

public class TwigCorePreferences {
	
	
	/**
	 * Get the severity level for annotation problems.
	 * 
	 * 
	 * @return {@link ProblemSeverity}
	 */
	public static ProblemSeverity getSyntaxErrorSeverity() {
		
		// see https://github.com/pulse00/Twig-Eclipse-Plugin/issues/8
//		try {
//			
//			//TODO: check if there's a cleaner way to get the preferences from the ui
//			// plugin than hardcoding the ID
//			String severity = Platform.getPreferencesService().getString("org.eclipse.twig.ui", 
//					TwigCoreConstants.SYNTAX_PROBLEM_SEVERITY, TwigCoreConstants.SYNTAX_WARNING, null);
//			
//			if (severity == null) {						
//				severity = TwigCoreConstants.SYNTAX_WARNING;
//			}		
//			
//			if (severity.equals(TwigCoreConstants.SYNTAX_ERROR)) 
//			{	
//				return ProblemSeverity.ERROR;
//				
//			} else if(severity.equals(TwigCoreConstants.SYNTAX_WARNING))
//			{				
//				return ProblemSeverity.WARNING;
//			}
//			
//			return ProblemSeverity.IGNORE;
//			
//		} catch (Exception e) {
//
//		}		
		
		return null;		
	}	

}
