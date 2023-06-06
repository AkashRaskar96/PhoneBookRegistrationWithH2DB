package com.adt.exception;

public class ContactNotFound extends RuntimeException {

	public ContactNotFound() {
		
	}
	public ContactNotFound(String msg){
		super(msg);
	}
}
