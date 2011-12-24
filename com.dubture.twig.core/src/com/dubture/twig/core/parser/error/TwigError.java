/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.error;

import org.eclipse.dltk.compiler.problem.CategorizedProblem;
import org.eclipse.dltk.compiler.problem.IProblemIdentifier;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;

public class TwigError extends CategorizedProblem {

	@Override
	public String[] getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProblemIdentifier getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOriginatingFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSourceEnd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSourceLineNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSourceStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarning() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTask() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSourceEnd(int sourceEnd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSourceLineNumber(int lineNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSourceStart(int sourceStart) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCategoryID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMarkerType() {
		// TODO Auto-generated method stub
		return null;
	}

    /* (non-Javadoc)
     * @see org.eclipse.dltk.compiler.problem.IProblem#setSeverity(org.eclipse.dltk.compiler.problem.ProblemSeverity)
     */
    @Override
    public void setSeverity(ProblemSeverity severity) {
        // TODO Auto-generated method stub
        
    }

}
