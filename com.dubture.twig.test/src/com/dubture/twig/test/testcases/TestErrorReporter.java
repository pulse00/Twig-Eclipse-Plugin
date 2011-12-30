/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.test.testcases;

import org.antlr.runtime.RecognitionException;

import com.dubture.twig.core.parser.error.IErrorReporter;

public class TestErrorReporter implements IErrorReporter
{

    private int errorCount = 0;

    @Override
    public void reportError(String header, String message,
            RecognitionException e)
    {

        errorCount++;

    }

    public int getErrors()
    {

        return errorCount;

    }

    public boolean hasErrors()
    {

        return errorCount > 0;
    }

}
