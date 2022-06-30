package com.mfpe.policyservice.Policy.Service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.policyservice.Policy.Service.dto.BenefitsDTO;
import com.mfpe.policyservice.Policy.Service.exception.ExpiredPolicyException;
import com.mfpe.policyservice.Policy.Service.exception.InvalidMemberIdException;
import com.mfpe.policyservice.Policy.Service.exception.InvalidPolicyId;
import com.mfpe.policyservice.Policy.Service.model.Policy;
import com.mfpe.policyservice.Policy.Service.repository.PolicyRepository;

@Service
public class BenefitsService {
	
	private static final Logger log=LoggerFactory.getLogger(BenefitsService.class);
	@Autowired
	private PolicyRepository policyRepository;
	@Autowired
	private MemberPolicyService memberPolicyService;
	
	public BenefitsDTO getBenefits(String policyId,String memberId) throws InvalidPolicyId,InvalidMemberIdException{
		log.info("Inside get benefits method in benefits service...");
		
		Optional<Policy> policies=policyRepository.findById(policyId);
		
		if(!policies.isPresent()) {
			throw new InvalidPolicyId("Invalid Policy ID");
		}
		
		if(!memberPolicyService.ValidateMember(memberId)) {
			throw new InvalidMemberIdException("Invalid Member");
		}
		
		if(!memberPolicyService.isPremiumPaid(memberId)) {
			throw new ExpiredPolicyException("Premium not paid");
		}
		
		return new BenefitsDTO(policies.get().getBenefits());
	}
	
}
