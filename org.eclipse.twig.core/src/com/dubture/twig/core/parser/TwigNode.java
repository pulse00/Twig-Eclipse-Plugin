package org.eclipse.twig.core.parser;

public class TwigNode {

	
	private int sourceStart;
	private int sourceEnd;
	private String name;
	private int type;
	
	public TwigNode(String name, int start, int end, int type) {
	
		this.name = name;
		sourceStart = start;
		sourceEnd = end;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int getSourceStart() {
		return sourceStart;
	}

	public int getSourceEnd() {
		return sourceEnd;
	}

	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {


		return name + ", start: " + sourceStart + ", end: " + sourceEnd ;
	}


}
