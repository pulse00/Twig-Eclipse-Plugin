/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;

import com.dubture.twig.core.model.Test;
import com.dubture.twig.ui.utils.HTMLUtils;

public class TestProposalInfo extends MemberProposalInfo
{

    public TestProposalInfo(IScriptProject project, CompletionProposal proposal)
    {
        super(project, proposal);

    }

    @Override
    public String getInfo(IProgressMonitor monitor)
    {

        try {
            Test test = (Test) getModelElement();
            if (test != null)
                return HTMLUtils.test2Html(test);

        } catch (ModelException e) {

            e.printStackTrace();
        }

        return "";
    }

}
