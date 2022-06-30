package com.mfpe.ClaimsService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.ClaimsService.dto.ClaimStatusDTO;
import com.mfpe.ClaimsService.exception.InvalidClaimIdException;
import com.mfpe.ClaimsService.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClaimStatusService {
	@Autowired
	private ClaimRepository claimRepository;
	
	private static final Logger log=LoggerFactory.getLogger(ClaimStatusService.class);
	
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(String claim_id) throws InvalidClaimIdException{
		log.info("inside getClaimStatus in service ");
		ClaimStatusDTO claimStatusDTO = new ClaimStatusDTO();
		String status = claimRepository.getStatus(claim_id);
		String desc = claimRepository.getDescription(claim_id);
		
		if (status == null) {
			throw new InvalidClaimIdException("Invalid Claim ID");
		}
		
		claimStatusDTO.setClaimStatus(status);
		claimStatusDTO.setClaimDescription(desc);
		claimStatusDTO.setClaimId(claim_id);
		
		
		log.info("inside the get Claim Status : ENDED");
		return new ResponseEntity<>(claimStatusDTO, HttpStatus.OK);
		
		
		
		
		
	}
}
