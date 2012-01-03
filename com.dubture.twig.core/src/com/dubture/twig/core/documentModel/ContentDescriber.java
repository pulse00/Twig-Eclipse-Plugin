package com.dubture.twig.core.documentModel;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;

public class ContentDescriber implements ITextContentDescriber
{

    @Override
    public int describe(InputStream contents, IContentDescription description)
            throws IOException
    {

        System.err.println("descript content");
        BufferedInputStream bis = new BufferedInputStream(contents);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        int result = bis.read();
        while(result != -1) {
          byte b = (byte)result;
          buf.write(b);
          result = bis.read();
        }        
        
        if ( buf.toString().indexOf("{{") >= 0) {
            
            return VALID;
        }

        return INDETERMINATE;
        
    }

    @Override
    public QualifiedName[] getSupportedOptions()
    {
        System.err.println("getsupportedoptions");
        return null;
    }

    @Override
    public int describe(Reader contents, IContentDescription description)
            throws IOException
    {

        System.err.println("describe 2");
        return 0;
    }

}
