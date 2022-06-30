package com.mfpe.policyservice.Policy.Service.exception;


import java.util.Date;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.mfpe.policyservice.Policy.Service.model.ErrorMessage;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {
	private static final Logger log=org.slf4j.LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@ExceptionHandler(value=InvalidPolicyId.class)
	public ResponseEntity<ErrorMessage> invalidPolicyId(InvalidPolicyId e, WebRequest request){
		
		log.info("Inside invalid policy id exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
		
		log.info("Exiting invalid policy id exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(value=InvalidMemberIdException.class)
	public ResponseEntity<ErrorMessage> invalidMemberId(InvalidMemberIdException e, WebRequest request){
		
		log.info("Inside invalid member id exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
		
		log.info("Exiting invalid member id exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(value=ExpiredPolicyException.class)
	public ResponseEntity<ErrorMessage> expiredPremium(ExpiredPolicyException e, WebRequest request){
		
		log.info("Inside expired policy exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
		
		log.info("Exiting expired policy exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
		
	}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorMessage> InvalidTokenExceptionHandling(InvalidTokenException e, WebRequest request){
		
		log.info("Inside Invalid token exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(), "Token is either expired or invalid...", request.getDescription(false));
		
		log.info("Exiting Invalid token exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorMessage> feignExceptionHandling(FeignException e, WebRequest request){
		
		log.info("Inside Invalid token exception handler");
		
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(),new Date(), "Token is either expired or invalid...", request.getDescription(false));
		
		log.info("Exiting Invalid token exception handler");
		
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}
}
