package com.mfpe.ClaimsService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.ClaimsService.dto.ClaimDTO;
import com.mfpe.ClaimsService.dto.ClaimStatusDTO;
import com.mfpe.ClaimsService.exception.InvalidClaimIdException;
import com.mfpe.ClaimsService.exception.InvalidTokenException;
import com.mfpe.ClaimsService.feign.AuthClient;
import com.mfpe.ClaimsService.service.ClaimStatusService;
import com.mfpe.ClaimsService.service.SubmitClaimService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@Api(value = "For dealing with claim ")
public class ClaimsController {
	
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private ClaimStatusService claimStatusService;
	
	@Autowired
	private SubmitClaimService submitClaimService;
	
	private static final Logger log=LoggerFactory.getLogger(ClaimsController.class);
	
	@GetMapping(path="/getClaimStatus/{claim_id}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable("claim_id") String claim_id,@RequestHeader(name = "Authorization", required = true) String token)throws InvalidTokenException,InvalidClaimIdException{
		System.out.println(claim_id);
		
		log.info("Inside getClaims Status Method");
		
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token Is Either Invalid or Expired");
		}
		
		//return new ResponseEntity<>(claimStatusService.getClaimStatus(claim_id),HttpStatus.OK);
		return claimStatusService.getClaimStatus(claim_id);
	}
	
	
	@PostMapping(path ="/submitClaim")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@RequestBody ClaimDTO claimDTO, @RequestHeader(name = "Authorization", required = true) String token)throws InvalidTokenException,NullPointerException {
		
		System.out.println(token);
		System.out.println(claimDTO);
		log.info(token);
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token Is Either Invalid or Expired");
		}
		
		log.info("inside the submit Claim : BEGIN");
		
		return submitClaimService.submitClaim(claimDTO, token);
		
	}
}
