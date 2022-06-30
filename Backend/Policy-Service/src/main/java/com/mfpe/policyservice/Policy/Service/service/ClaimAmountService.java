package com.mfpe.policyservice.Policy.Service.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.policyservice.Policy.Service.dto.ClaimAmountDTO;
import com.mfpe.policyservice.Policy.Service.exception.ExpiredPolicyException;
import com.mfpe.policyservice.Policy.Service.exception.InvalidMemberIdException;
import com.mfpe.policyservice.Policy.Service.exception.InvalidPolicyId;
import com.mfpe.policyservice.Policy.Service.model.Policy;
import com.mfpe.policyservice.Policy.Service.repository.PolicyRepository;

@Service
public class ClaimAmountService {

	
	private static final Logger log=LoggerFactory.getLogger(ClaimAmountService.class);
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private MemberPolicyService memberPolicyService;
	
	public ClaimAmountDTO getClaimAmount(String policyId, String memberId) throws InvalidPolicyId{
		log.info("Inside get claim amount method in claim amount service...");
		
		Optional<Policy> policy = policyRepository.findById(policyId);
		
		if(!policy.isPresent() )
		{
			throw new InvalidPolicyId("Invalid Policy Id...");
		}
		if(!memberPolicyService.ValidateMember(memberId))
		{
			throw new InvalidMemberIdException("Invalid Member Id...");
		}
		
		if(!memberPolicyService.isPremiumPaid(memberId))
		{
			throw new ExpiredPolicyException("Premium is not paid...");
		}
		
		log.info("Exiting get claim amount method in claim amount service...");
		return new ClaimAmountDTO(policy.get().getSumInsured());
	}
}
