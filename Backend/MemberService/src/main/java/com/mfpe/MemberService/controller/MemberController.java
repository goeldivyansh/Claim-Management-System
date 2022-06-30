package com.mfpe.MemberService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.MemberService.dto.ClaimDTO;
import com.mfpe.MemberService.dto.ClaimStatusDTO;
import com.mfpe.MemberService.exceptions.InvalidMemberIdException;
import com.mfpe.MemberService.exceptions.InvalidTokenException;
import com.mfpe.MemberService.feign.AuthClient;
import com.mfpe.MemberService.model.Bills;
import com.mfpe.MemberService.model.ClaimDetails;
import com.mfpe.MemberService.service.ClaimStatusandDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private ClaimStatusandDetailsService claimStatusandDetailsService;
	
	@GetMapping(path = "/viewBills/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bills> getBills(@PathVariable("memberId") String memberId,@RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException, InvalidMemberIdException{
		
		log.info("Inside the getBills: Begins");
		
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token Is Either Invalid or Expired");
		}
		
		log.info("inside the getBills: End");
		
		return new ResponseEntity<>(claimStatusandDetailsService.fetchBills(memberId),HttpStatus.OK);
	}
	
	@GetMapping(path = "/getClaimStatus/{claimId}", produces = "application/json")
	public ResponseEntity<ClaimStatusDTO> returnClaimStatus(@PathVariable("claimId") String claimId,@RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException{
		
		log.info("Inside the returnClaimStatus: Begin");
		
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token Is Either Invalid or Expired");
		}
		
		log.info("Inside the returnClaimStatus: Ended");
		
		return new ResponseEntity<>(claimStatusandDetailsService.fetchClaimStatus(claimId, token), HttpStatus.OK);
	}
	
	@PostMapping(path = "/submitClaim", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimStatusDTO> returnClaimStatusOnUpdate(@RequestBody ClaimDTO claimDetails, @RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException{
		log.info("Inside return Claim status on update: Begin");
		
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token Is Either Invalid or Expired");
		}
		
		log.info("Inside return Claim status on update: Ended");
		
		return new ResponseEntity<>(claimStatusandDetailsService.fetchClaimStatusDetails(claimDetails, token), HttpStatus.OK);
	}
}