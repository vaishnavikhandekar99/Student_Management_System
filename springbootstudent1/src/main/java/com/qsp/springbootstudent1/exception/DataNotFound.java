package com.qsp.springbootstudent1.exception;

public class DataNotFound extends RuntimeException
{
	private String message;

	public DataNotFound(String message) 
	{
		super();
		this.message = message;
	}
	@Override
	public String getMessage() 
	{
		return message;
	}


}
