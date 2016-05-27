package com.dubture.twig.core.codeassist;

abstract public class CompletionRequestor {
	public boolean isContextInformationMode() {
		return false;
	}

	private String fError;

	public void beginSession() {
		// do nothing
	}

	public abstract void acceptProposal(CompletionProposal proposal);

	public String getErrorMessage() {
		return fError;
	}

	public void setErrorMessage(String err) {
		this.fError = err;
	}

	public void endSession() {
		// no notihing
	}
}
