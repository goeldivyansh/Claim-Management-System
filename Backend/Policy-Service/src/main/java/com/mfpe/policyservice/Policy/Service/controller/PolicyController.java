package com.mfpe.policyservice.Policy.Service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.policyservice.Policy.Service.dto.BenefitsDTO;
import com.mfpe.policyservice.Policy.Service.dto.ClaimAmountDTO;
import com.mfpe.policyservice.Policy.Service.dto.HospitalDTO;
import com.mfpe.policyservice.Policy.Service.exception.InvalidTokenException;
import com.mfpe.policyservice.Policy.Service.feign.AuthClient;
import com.mfpe.policyservice.Policy.Service.service.BenefitsService;
import com.mfpe.policyservice.Policy.Service.service.ClaimAmountService;
import com.mfpe.policyservice.Policy.Service.service.HospitalService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j


public class PolicyController {
	
	private static final Logger log=LoggerFactory.getLogger(PolicyController.class);
	@Autowired
	private AuthClient authClient;
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private BenefitsService benefitsService;
	
	@Autowired
	private ClaimAmountService claimAmountService;

	@GetMapping(path="/getChainOfProviders/{policyId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HospitalDTO> getProviders(@PathVariable String policyId, @RequestHeader(name = "Authorization", required = true)String token)throws InvalidTokenException{ 
		
		log.info("Inside get chain of providers...");
		
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		log.info("Exiting get chain of providers...");
		
		return new ResponseEntity<>(hospitalService.getHospitals(policyId),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/getEligibleBenefits/{policyId}/{memberId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BenefitsDTO> getEligibleBenefits(@PathVariable String policyId,@PathVariable String memberId,@RequestHeader(name = "Authorization", required = true)String token)throws InvalidTokenException{
		log.info("Inside eligible benefites...");
		if(!authClient.authorizeTheRequest(token)) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		log.info("Exiting eligible benefites...");
		return new ResponseEntity<>(benefitsService.getBenefits(policyId, memberId),HttpStatus.OK);
	}
	
	@GetMapping(path="/getEligibleClaimAmount/{policyId}/{memberId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimAmountDTO> getEligibleAmount(@PathVariable String policyId, @PathVariable String memberId, @RequestHeader(name = "Authorization", required = true)String token) throws InvalidTokenException{
		log.info("Inside get eligible benefits");
		if (!authClient.authorizeTheRequest(token)) {										
			throw new InvalidTokenException("Token is either expired or invalid ");
		}	 
		log.info("Exiting get elibile amount");
		
		return new ResponseEntity<>(claimAmountService.getClaimAmount(policyId, memberId),HttpStatus.OK);		
		
	}
}
