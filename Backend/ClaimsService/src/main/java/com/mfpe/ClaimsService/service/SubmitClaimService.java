package com.mfpe.ClaimsService.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mfpe.ClaimsService.dto.BenefitsDTO;
import com.mfpe.ClaimsService.dto.ClaimAmountDTO;
import com.mfpe.ClaimsService.dto.ClaimDTO;
import com.mfpe.ClaimsService.dto.ClaimStatusDTO;
import com.mfpe.ClaimsService.dto.HospitalDTO;
import com.mfpe.ClaimsService.exception.PolicyException;
import com.mfpe.ClaimsService.feign.PolicyClient;
import com.mfpe.ClaimsService.model.Benefits;
import com.mfpe.ClaimsService.model.Claim;
import com.mfpe.ClaimsService.model.Hospital;
import com.mfpe.ClaimsService.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubmitClaimService {
	private static final Logger log=LoggerFactory.getLogger(SubmitClaimService.class);
	
	@Autowired
	private ClaimRepository claimRepo;
	@Autowired
	private PolicyClient policyClient;
	
	
	private boolean checkProvider(ClaimDTO claimDTO, String token) {
		System.out.println(policyClient.getProviders(claimDTO.getPolicyId(), token).getBody());
		
		HospitalDTO hospitalDTO= (HospitalDTO) policyClient.getProviders(claimDTO.getPolicyId(), token).getBody();
		
		
		
		if (hospitalDTO !=null && hospitalDTO.getHospitals()!=null) {
			for(Hospital hospitalDetails:hospitalDTO.getHospitals()) {
				if(claimDTO.getHospitalId().equalsIgnoreCase(hospitalDetails.getHospitalId())) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	private boolean checkBenefit(ClaimDTO claimDTO, String token) {
		BenefitsDTO benefitsDTO=(BenefitsDTO) policyClient.getEligibleBenefits(claimDTO.getPolicyId(), claimDTO.getMemberId(), token).getBody();
		
		if(benefitsDTO!=null && benefitsDTO.getBenefits()!=null) {
			for (Benefits benefits : benefitsDTO.getBenefits()) {
				if (claimDTO.getBenefitId().equalsIgnoreCase(benefits.getBenefitId())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean checkAmount(ClaimDTO claimDTO, String token) {
			ClaimAmountDTO claimAmountDTO=(ClaimAmountDTO) policyClient.getEligibleAmount(claimDTO.getPolicyId(),claimDTO.getMemberId(), token).getBody();
			if (claimAmountDTO != null) {
				return (claimDTO.getClaimAmount()<=claimAmountDTO.getEligibleAmount());
			}
			
			return false;
	}
	
	public ResponseEntity<ClaimStatusDTO> submitClaim(ClaimDTO claimDTO, String token) throws NullPointerException{
		boolean hospitalFlag = false;
		boolean benefitFlag = false;
		boolean amountFlag = false;
		
		try {
			log.info("inside the submit claim service method : BEGIN");
			log.info("checking the Hospital : BEGIN");
			hospitalFlag = checkProvider(claimDTO, token);
			
			log.info("checking of provider : ENDED");

			log.info("checking the Benefit : BEGIN");
			
			benefitFlag = checkBenefit(claimDTO, token);
			log.info("checking of Benefit : ENDED");
			
			log.info("checking the Amount : BEGIN");
			amountFlag = checkAmount(claimDTO, token);
			log.info("checking of provider : ENDED");
		}catch(PolicyException pe) {
			throw new PolicyException("Policy Serivce is Not working Properly");
		}
		log.info("creating claim and setting the status : BEGIN");
		
		Claim newClaim = new Claim();
		newClaim.setClaimId(claimDTO.getClaimId());
		
		newClaim.setBenefitId(claimDTO.getBenefitId());
		newClaim.setClaimAmount(claimDTO.getClaimAmount());
		newClaim.setHospitalId(claimDTO.getHospitalId());
		newClaim.setMemberId(claimDTO.getMemberId());
		newClaim.setPolicyId(claimDTO.getPolicyId());
		newClaim.setRemarks(claimDTO.getRemarks());
		
		if (hospitalFlag && benefitFlag && amountFlag) {
			newClaim.setStatus("Pending Action");
			newClaim.setDescription("All fields are succesfully verified.");
		}else {
			newClaim.setStatus("Claim Rejected");
			if (!hospitalFlag) {
				newClaim.setDescription("Providers Details are not valid.");
			} else if (!benefitFlag) {
				newClaim.setDescription("Benefits Details are not valid.");
			} else {
				newClaim.setDescription("Claim amount is not valid.");
			}
		}
		log.info("setting the status : ENDED");
		if (hospitalFlag && benefitFlag && amountFlag) {
			claimRepo.save(newClaim);
		}
		
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimStatus(newClaim.getStatus());
		claimStatusDTO.setClaimDescription(newClaim.getDescription());
		claimStatusDTO.setClaimId(newClaim.getClaimId());
		
		return new ResponseEntity<>(claimStatusDTO,HttpStatus.OK);

		
		
		
	}
}
