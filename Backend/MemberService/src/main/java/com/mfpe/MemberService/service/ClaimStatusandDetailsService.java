package com.mfpe.MemberService.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.MemberService.dto.ClaimDTO;
import com.mfpe.MemberService.dto.ClaimStatusDTO;
import com.mfpe.MemberService.exceptions.InvalidClaimIdException;
import com.mfpe.MemberService.exceptions.InvalidMemberIdException;
import com.mfpe.MemberService.feign.ClaimsClient;
import com.mfpe.MemberService.model.Bills;
import com.mfpe.MemberService.repository.BillsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimStatusandDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(ClaimStatusandDetailsService.class);
	int var = 103;
	@Autowired
	private BillsRepository billsRepository;
	
	@Autowired
	private ClaimsClient claimsClient;
	
	public Bills fetchBills(String memberId) {
		log.info("Inside fetchBill Function: Begins");
		
		Optional<Bills> bill = billsRepository.findById(memberId);
		
		if(!bill.isPresent()) {
			throw new InvalidMemberIdException("The Member id is invalid");
		}
		
		return bill.get();
	}
	
	public ClaimStatusDTO fetchClaimStatus(String claimId, String token) {
		log.info("Inside fetch Claim Status: Begin");
		
		ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
		
		try {
			claimStatusDTO = claimsClient.getClaimStatus(claimId, token).getBody();
		}catch (Exception e) {
			// TODO: handle exception
			throw new InvalidClaimIdException("Claim Id is Invalid");
		}
		
		log.info("Inside fetch Claim Status: End");
		return claimStatusDTO;
	}
	
	public String produceClaimId() {
		String claimId = "C" + var;
		var++;
		return claimId;
	}
	
	public ClaimStatusDTO fetchClaimStatusDetails(ClaimDTO claimDetails, String token) {
		log.info("Inside fetch Claim Status Details: Begin");
		
		ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
		
		claimDetails.setClaimId(produceClaimId());
		
		try {
			claimStatusDTO = claimsClient.submitClaim(claimDetails, token).getBody();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return claimStatusDTO;
	}
}