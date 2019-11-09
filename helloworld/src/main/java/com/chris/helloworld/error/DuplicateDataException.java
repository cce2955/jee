package com.chris.helloworld.error;

public class DuplicateDataException extends RuntimeException{
	//This page will check for duplicate data entered into the database and reject it
	//Only relevant info to be rejected is account # and email address, name is irrelevant
	public DuplicateDataException(long account, long email)
	{
		super("Either email address " + email + " or account number " + account +" is alread in the system, try again");
	}
}
