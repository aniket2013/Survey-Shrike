package com.sg.exception;

public class DuplicateKeyException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateKeyException(String str) {
		super(str);
	}

}
