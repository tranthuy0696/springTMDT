package com.tmdt.exception;

public class TmdtException extends Exception{
	 private static final long serialVersionUID = 1L;

	    public TmdtException( String message ) {
		super( message );
	    }

	    public TmdtException( String message, Exception exception ) {
		super( message, exception );
	    }
}
