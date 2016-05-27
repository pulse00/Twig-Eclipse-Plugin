/*******************************************************************************
 * Copyright (c) 2004, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 
 *******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ICodeAssist;

import com.dubture.twig.core.model.ITwigModelElement;

/**
 * Completion proposal.
 * <p>
 * In typical usage, the user working in a code editor issues a code assist
 * command. This command results in a call to
 * <code>ICodeAssist.codeComplete(position, completionRequestor)</code> passing
 * the current position in the source code. The code assist engine analyzes the
 * code in the buffer, determines what kind of language construct is at that
 * position, and proposes ways to complete that construct. These proposals are
 * instances of the class <code>CompletionProposal</code>. These proposals,
 * perhaps after sorting and filtering, are presented to the user to make a
 * choice.
 * </p>
 * <p>
 * The proposal is as follows: insert the {@linkplain #getCompletion()
 * completion string} into the source file buffer, replacing the characters
 * between {@linkplain #getReplaceStart() the start} and
 * {@linkplain #getReplaceEnd() end}. The string can be arbitrary; for example,
 * it might include not only the name of a method but a set of parentheses.
 * Moreover, the source range may include source positions before or after the
 * source position where <code>ICodeAssist.codeComplete</code> was invoked. The
 * rest of the information associated with the proposal is to provide context
 * that may help a user to choose from among competing proposals.
 * </p>
 * <p>
 * The completion engine creates instances of this class; it is not intended to
 * be instantiated or subclassed by clients.
 * </p>
 * 
 * @see ICodeAssist#codeComplete(int, CompletionRequestor)
 * 
 */
public class CompletionProposal implements Cloneable {
	/**
	 * Completion is a reference to a field. This kind of completion might occur
	 * in a context like <code>"this.ref^ = 0;"</code> and complete it to
	 * <code>"this.refcount = 0;"</code>.
	 * 
	 */
	public static final int FIELD_REF = 1;

	/**
	 * Completion is a keyword. This kind of completion might occur in a context
	 * like <code>"public cl^ Foo {}"</code> and complete it to
	 * <code>"public class Foo {}"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int KEYWORD = 2;

	/**
	 * Completion is a reference to a label. This kind of completion might occur
	 * in a context like <code>"break lo^;"</code> and complete it to
	 * <code>"break loop;"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int TEST_REF = 3;

	/**
	 * Completion is a reference to a local variable. This kind of completion
	 * might occur in a context like <code>"ke^ = 4;"</code> and complete it to
	 * <code>"keys = 4;"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int LOCAL_VARIABLE_REF = 4;

	/**
	 * Completion is a reference to a method. This kind of completion might
	 * occur in a context like <code>"System.out.pr^();"</code> and complete it
	 * to <code>""System.out.println();"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int METHOD_REF = 5;

	/**
	 * Completion is a reference to IResource (mostly IFile). This kind of
	 * completion might occur in context like <code>{{ asset('my^') }}</code>
	 * and complet it to <code> {{ asset('myImage.png') }}</code>
	 * 
	 * @see #getKind()
	 */
	public static final int RESOURCE_REF = 6;

	/**
	 * Completion is a reference to a filter. Any kind of type is allowed,
	 * including primitive types, reference types, array types, parameterized
	 * types, and type variables. This kind of completion might occur in a
	 * context like <code>"{{ Str|cou^ }}"</code> and complete it to
	 * <code>"{{ Str|count }}"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int FILTER_REF = 7;

	/**
	 * Completion is a reference to a tag. Any kind of type is allowed,
	 * including primitive types, reference types, array types, parameterized
	 * types, and type variables. This kind of completion might occur in a
	 * context like <code>"{% fo^ %}"</code> and complete it to
	 * <code>"{% for %}"</code>.
	 * 
	 * @see #getKind()
	 */
	public static final int TAG_REF = 8;

	/**
	 * Completion is a declaration of a variable (locals, parameters, fields,
	 * etc.).
	 * 
	 * @see #getKind()
	 */
	public static final int VARIABLE_DECLARATION = 9;

	public static final int USER = 15;

	/**
	 * First valid completion kind.
	 */
	protected static final int FIRST_KIND = FIELD_REF;

	/**
	 * Last valid completion kind.
	 */
	protected static final int LAST_KIND = 22;

	private boolean updateCompletion = false;

	/**
	 * Kind of completion request.
	 */
	private int completionKind;

	/**
	 * Completion string; defaults to empty string.
	 */
	private String completion = Util.EMPTY_STRING;

	/**
	 * Start position (inclusive) of source range in original buffer to be
	 * replaced by completion string; defaults to empty subrange at [0,0).
	 */
	private int replaceStart = 0;

	/**
	 * End position (exclusive) of source range in original buffer to be
	 * replaced by completion string; defaults to empty subrange at [0,0).
	 */
	private int replaceEnd = 0;

	/**
	 * Relevance rating; positive; higher means better; defaults to minimum
	 * rating.
	 */
	private int relevance = 1;

	/**
	 * Simple name of the method, field, member, or variable relevant in the
	 * context, or <code>null</code> if none. Defaults to null.
	 */
	private String name = null;

	/**
	 * Related TwigModelElement
	 */
	private ITwigModelElement modelElement;

	/**
	 * Parameter names (for method completions), or <code>null</code> if none.
	 * Lazily computed. Defaults to <code>null</code>.
	 */
	private String[] parameterNames = null;

	private Map<Object, Object> attributes;

	/**
	 * Creates a basic completion proposal. All instance field have plausible
	 * default values unless otherwise noted.
	 * <p>
	 * Note that the constructors for this class are internal to the model
	 * implementation. Clients cannot directly create CompletionProposal
	 * objects.
	 * </p>
	 * 
	 * @param kind
	 *            one of the kind constants declared on this class
	 * @param completionLocation
	 *            original offset of code completion request
	 */
	protected CompletionProposal(int kind) {
		assert kind > 0;

		this.completionKind = kind;
	}

	/**
	 * Returns the kind of completion being proposed.
	 * <p>
	 * The set of different kinds of completion proposals is expected to change
	 * over time. It is strongly recommended that clients do <b>not</b> assume
	 * that the kind is one of the ones they know about, and code defensively
	 * for the possibility of unexpected future growth.
	 * </p>
	 * 
	 * @return the kind; one of the kind constants declared on this class, or
	 *         possibly a kind unknown to the caller
	 */
	public int getKind() {
		return this.completionKind;
	}

	/**
	 * Returns the proposed sequence of characters to insert into the source
	 * file buffer, replacing the characters at the specified source range. The
	 * string can be arbitrary; for example, it might include not only the name
	 * of a method but a set of parentheses.
	 * <p>
	 * The client must not modify the array returned.
	 * </p>
	 * 
	 * @return the completion string
	 */
	public String getCompletion() {
		if (this.completionKind == METHOD_REF || this.completionKind == FILTER_REF) {
			this.findParameterNames(null);
			if (this.updateCompletion) {
				this.updateCompletion = false;

				if (this.parameterNames != null) {
					int length = this.parameterNames.length;
					StringBuffer completionBuffer = new StringBuffer(this.completion.length());

					int start = 0;
					int end = this.completion.indexOf('%');

					completionBuffer.append(this.completion, start, end - start);

					for (int i = 0; i < length; i++) {
						completionBuffer.append(this.parameterNames[i]);
						start = end + 1;
						end = this.completion.indexOf('%', start);
						if (end > -1) {
							completionBuffer.append(this.completion, start, end - start);
						} else {
							completionBuffer.append(this.completion, start, this.completion.length() - start);
						}
					}
					this.completion = completionBuffer.toString();
				}
			}
		}
		return this.completion;
	}

	/**
	 * Sets the proposed sequence of characters to insert into the source file
	 * buffer, replacing the characters at the specified source range. The
	 * string can be arbitrary; for example, it might include not only the name
	 * of a method but a set of parentheses.
	 * <p>
	 * If not set, defaults to an empty character array.
	 * </p>
	 * <p>
	 * The completion engine creates instances of this class and sets its
	 * properties; this method is not intended to be used by other clients.
	 * </p>
	 * 
	 * @param completion
	 *            the completion string
	 */
	public void setCompletion(String completion) {
		this.completion = completion;
	}

	/**
	 * Returns the character index of the start of the subrange in the source
	 * file buffer to be replaced by the completion string. If the subrange is
	 * empty (<code>getReplaceEnd() == getReplaceStart()</code>), the completion
	 * string is to be inserted at this index.
	 * <p>
	 * Note that while the token subrange is precisely specified, the
	 * replacement range is loosely constrained and may not bear any direct
	 * relation to the original request offset. For example, it would be
	 * possible for a type completion to propose inserting an import declaration
	 * at the top of the compilation unit; or the completion might include
	 * trailing parentheses and punctuation for a method completion.
	 * </p>
	 * 
	 * @return replacement start position (inclusive)
	 */
	public int getReplaceStart() {
		return this.replaceStart;
	}

	/**
	 * Returns the character index of the end of the subrange in the source file
	 * buffer to be replaced by the completion string. If the subrange is empty
	 * (<code>getReplaceEnd() == getReplaceStart()</code>), the completion
	 * string is to be inserted at this index.
	 * 
	 * @return replacement end position (exclusive)
	 */
	public int getReplaceEnd() {
		return this.replaceEnd;
	}

	/**
	 * Sets the character indices of the subrange in the source file buffer to
	 * be replaced by the completion string. If the subrange is empty (
	 * <code>startIndex == endIndex</code>), the completion string is to be
	 * inserted at this index.
	 * <p>
	 * If not set, defaults to empty subrange at [0,0).
	 * </p>
	 * <p>
	 * The completion engine creates instances of this class and sets its
	 * properties; this method is not intended to be used by other clients.
	 * </p>
	 * 
	 * @param startIndex
	 *            character index of replacement start position (inclusive)
	 * @param endIndex
	 *            character index of replacement end position (exclusive)
	 */
	public void setReplaceRange(int startIndex, int endIndex) {
		if (startIndex < 0 || endIndex < startIndex) {
			throw new IllegalArgumentException();
		}

		this.replaceStart = startIndex;
		this.replaceEnd = endIndex;
	}

	/**
	 * Returns the relative relevance rating of this proposal.
	 * 
	 * @return relevance rating of this proposal; ratings are positive; higher
	 *         means better
	 */
	public int getRelevance() {
		return this.relevance;
	}

	/**
	 * Sets the relative relevance rating of this proposal.
	 * <p>
	 * If not set, defaults to the lowest possible rating (1).
	 * </p>
	 * <p>
	 * The completion engine creates instances of this class and sets its
	 * properties; this method is not intended to be used by other clients.
	 * </p>
	 * 
	 * @param rating
	 *            relevance rating of this proposal; ratings are positive;
	 *            higher means better
	 */
	public void setRelevance(int rating) {
		if (rating <= 0) {
			throw new IllegalArgumentException();
		}

		this.relevance = rating;
	}

	/**
	 * Returns the simple name of the method, field, member, or variable
	 * relevant in the context, or <code>null</code> if none.
	 * <p>
	 * This field is available for the following kinds of completion proposals:
	 * <ul>
	 * <li><code>ANNOTATION_ATTRIBUT_REF</code> - the name of the attribute</li>
	 * <li><code>FIELD_REF</code> - the name of the field</li>
	 * <li><code>KEYWORD</code> - the keyword</li>
	 * <li><code>LABEL_REF</code> - the name of the label</li>
	 * <li><code>LOCAL_VARIABLE_REF</code> - the name of the local variable</li>
	 * <li><code>METHOD_REF</code> - the name of the method (the type simple
	 * name for constructor)</li>
	 * <li><code>METHOD_DECLARATION</code> - the name of the method (the type
	 * simple name for constructor)</li>
	 * <li><code>VARIABLE_DECLARATION</code> - the name of the variable</li>
	 * <li><code>POTENTIAL_METHOD_DECLARATION</code> - the name of the method
	 * </li>
	 * </ul>
	 * For kinds of completion proposals, this method returns <code>null</code>.
	 * Clients must not modify the array returned.
	 * </p>
	 * 
	 * @return the keyword, field, method, local variable, or member name, or
	 *         <code>null</code> if none
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the simple name of the method (type simple name for constructor),
	 * field, member, or variable relevant in the context, or <code>null</code>
	 * if none.
	 * <p>
	 * If not set, defaults to none.
	 * </p>
	 * <p>
	 * The completion engine creates instances of this class and sets its
	 * properties; this method is not intended to be used by other clients.
	 * </p>
	 * 
	 * @param name
	 *            the keyword, field, method, local variable, or member name, or
	 *            <code>null</code> if none
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Finds the method parameter names. This information is relevant to method
	 * reference (and method declaration proposals). Returns <code>null</code>
	 * if not available or not relevant.
	 * <p>
	 * The client must not modify the array returned.
	 * </p>
	 * <p>
	 * <b>Note that this is an expensive thing to compute, which may require
	 * parsing source files, etc. Use sparingly.</b>
	 * </p>
	 * 
	 * @param monitor
	 *            the progress monitor, or <code>null</code> if none
	 * @return the parameter names, or <code>null</code> if none or not
	 *         available or not relevant
	 */
	public String[] findParameterNames(IProgressMonitor monitor) {
		return this.parameterNames;
	}

	/**
	 * Returns the method parameter names. This information is relevant to
	 * method reference (and method declaration proposals). Returns
	 * <code>null</code> if not available or not relevant.
	 * <p>
	 * The client must not modify the array returned.
	 * </p>
	 * 
	 * @return the parameter names, or <code>null</code> if none or not
	 *         available or not relevant
	 */
	public String[] getParameterNames() {
		return this.parameterNames;
	}

	/**
	 * Sets the method parameter names. This information is relevant to method
	 * reference (and method declaration proposals).
	 * <p>
	 * The completion engine creates instances of this class and sets its
	 * properties; this method is not intended to be used by other clients.
	 * </p>
	 * 
	 * @param parameterNames
	 *            the parameter names, or <code>null</code> if none
	 */
	public void setParameterNames(String[] parameterNames) {
		this.parameterNames = parameterNames;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append('[');
		switch (this.completionKind) {
		case CompletionProposal.FIELD_REF:
			buffer.append("FIELD_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.KEYWORD:
			buffer.append("KEYWORD"); //$NON-NLS-1$
			break;
		case CompletionProposal.TEST_REF:
			buffer.append("TEST_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.LOCAL_VARIABLE_REF:
			buffer.append("LOCAL_VARIABLE_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.METHOD_REF:
			buffer.append("METHOD_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.FILTER_REF:
			buffer.append("FILTER_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.TAG_REF:
			buffer.append("TAG_REF"); //$NON-NLS-1$
			break;
		case CompletionProposal.VARIABLE_DECLARATION:
			buffer.append("VARIABLE_DECLARATION"); //$NON-NLS-1$
			break;
		case CompletionProposal.RESOURCE_REF:
			buffer.append("RESOURCE_REF"); //$NON-NLS-1$
			break;
		default:
			buffer.append("PROPOSAL"); //$NON-NLS-1$
			break;

		}
		buffer.append("]{completion:"); //$NON-NLS-1$
		if (this.completion != null)
			buffer.append(this.completion);
		buffer.append(", name:"); //$NON-NLS-1$
		if (this.name != null)
			buffer.append(this.name);
		buffer.append(", ["); //$NON-NLS-1$
		buffer.append(this.replaceStart);
		buffer.append(',');
		buffer.append(this.replaceEnd);
		buffer.append("], relevance="); //$NON-NLS-1$
		buffer.append(this.relevance);
		buffer.append('}');
		return buffer.toString();
	}

	public void setAttribute(String key, Object value) {
		internalSetAttribute(key, value);
	}

	private void internalSetAttribute(Object key, Object value) {
		if (value != null) {
			if (attributes == null) {
				attributes = new HashMap<Object, Object>(4);
			}
			attributes.put(key, value);
		} else if (attributes != null) {
			attributes.remove(key);
		}
	}

	public Object getAttribute(String key) {
		return attributes != null ? attributes.get(key) : null;
	}

	/**
	 * Sets the specified flag.
	 */
	public void setFlag(ICompletionProposalFlag flag) {
		internalSetAttribute(flag, Boolean.TRUE);
	}

	/**
	 * Clears the specified flag.
	 */
	public void clearFlag(ICompletionProposalFlag flag) {
		internalSetAttribute(flag, null);
	}

	/**
	 * Tests if the specified flag is set.
	 */
	public boolean hasFlag(ICompletionProposalFlag flag) {
		return attributes != null && attributes.containsKey(flag);
	}

	/**
	 * Used TwigModElement
	 * 
	 * @return
	 */
	public ITwigModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * TwigModelElement
	 * 
	 * @param modelElement
	 */
	public void setModelElement(ITwigModelElement modelElement) {
		this.modelElement = modelElement;
	}

	@Override
	public CompletionProposal clone() {
		try {
			final CompletionProposal copy = (CompletionProposal) super.clone();
			// parameterNames array is shared, don't want to copy it.
			if (attributes != null) {
				copy.attributes = new HashMap<Object, Object>(attributes);
			}
			return copy;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Allow bulk flags set
	 * 
	 * @param flags
	 * @see setFlag()
	 */
	public void setFlags(ICompletionProposalFlag[] flags) {
		assert flags != null;
		for (ICompletionProposalFlag flag : flags) {
			this.setFlag(flag);
		}
	}
}
