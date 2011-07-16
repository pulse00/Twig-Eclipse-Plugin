package org.eclipse.twig.core.search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.parser.ITwigNodeVisitor;
import org.eclipse.twig.core.parser.TwigCommonTree;
import org.eclipse.twig.core.parser.TwigCommonTreeAdaptor;
import org.eclipse.twig.core.parser.TwigLexer;
import org.eclipse.twig.core.parser.TwigNode;
import org.eclipse.twig.core.parser.TwigNodeVisitor;
import org.eclipse.twig.core.parser.TwigParser;
import org.eclipse.twig.core.parser.TwigSourceParser;


abstract public class AbstractOccurrencesFinder extends TwigNodeVisitor implements IOccurrencesFinder {


	protected int offset;
	protected int currentPosition;
	protected int endOffset;
	protected int length;
	protected TwigNode twigNode;	
	protected List<OccurrenceLocation> locations = new ArrayList<OccurrenceLocation>();

	@Override
	public String initialize(String source, TwigNode node) {

		try {

			offset = node.getSourceStart();						
			endOffset = node.getSourceEnd();

			BufferedReader br = new BufferedReader(new StringReader(source));

			String line;

			twigNode = node;
			
			currentPosition = 0;
			int lineNumber = 0;

			while( (line = br.readLine()) != null) {

				lineNumber++;


				if (line.contains(TwigSourceParser.TWIG_OPEN)) {
					parsePrint(line, TwigSourceParser.TWIG_OPEN, TwigSourceParser.TWIG_CLOSE, lineNumber, currentPosition);				
				} else if (line.contains(TwigSourceParser.STMT_OPEN)) {
					parseStatement(line, TwigSourceParser.STMT_OPEN, TwigSourceParser.STMT_CLOSE, lineNumber, currentPosition);								
				}

				// +1 for the line break which apparently doesn't count in .length();
				currentPosition += line.length() + 1;

			}

		} catch (IOException e) { 
			e.printStackTrace();
		}

		return null;
	}

	private void parsePrint(String line, String twigOpen, String twigClose,
			int lineNumber, int current) {


	}
	
	

	private void parseStatement(String line, String open, String close,
			int lineNumber, int current) {

		int start = 0;
		int end = 0;

		while( (start = line.indexOf(open)) >= 0) {

			end = line.indexOf(close);

			if (end == -1) {
				//TODO: report error
				break;
			}


			String twig = line.substring(start, end+2);
			parseTwig(twig, (current + start), lineNumber);

			if (line.length() > end +1) {						
				//TODO: report error
				break;
			}

			line = line.substring(end + 2);

		}		


	}

	private void parseTwig(String source, int offset, int line) {

		try {

			CharStream content = new ANTLRStringStream(source);
			TwigLexer lexer = new TwigLexer(content);

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_source_return root;

			root = parser.twig_source();
			TwigCommonTree tree = (TwigCommonTree) root.getTree();
			ITwigNodeVisitor visitor = getVisitor(offset);
			tree.accept(visitor);


		} catch (Exception e) {
			Logger.logException(e);
		}
	}	


	abstract protected ITwigNodeVisitor getVisitor(int offset);
	
	@Override
	public OccurrenceLocation[] getOccurrences() {
		
		return (OccurrenceLocation[]) locations.toArray(new OccurrenceLocation[locations.size()]);
		
	}

	@Override
	public String getJobLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedPluralLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedSingularLabel() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TwigCommonTree getRoot() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getSearchKind() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
}