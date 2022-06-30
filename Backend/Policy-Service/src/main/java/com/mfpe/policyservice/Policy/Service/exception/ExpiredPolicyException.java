package com.mfpe.policyservice.Policy.Service.exception;

public class ExpiredPolicyException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public ExpiredPolicyException(String msg)
	{
		super(msg);
	}

}