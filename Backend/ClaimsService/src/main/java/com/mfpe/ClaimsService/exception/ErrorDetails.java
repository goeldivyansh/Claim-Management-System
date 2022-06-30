package com.mfpe.ClaimsService.exception;

import java.util.Date;

public class ErrorDetails {
	private Date date;
	private String message;
	private String requestURL;
	public ErrorDetails(Date date, String message, String requestURL) {
		super();
		this.date = date;
		this.message = message;
		this.requestURL = requestURL;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	
	
}
