package com.mfpe.policyservice.Policy.Service.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.policyservice.Policy.Service.dto.HospitalDTO;
import com.mfpe.policyservice.Policy.Service.exception.InvalidPolicyId;
import com.mfpe.policyservice.Policy.Service.model.Policy;
import com.mfpe.policyservice.Policy.Service.repository.PolicyRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HospitalService {
	@Autowired
	private PolicyRepository policyRepository;
	
	private static final Logger log=LoggerFactory.getLogger(HospitalService.class);
//	private HospitalDTO getHospitals(String policyId) throws InvalidPolicyId{
//		log.info("Inside get providers method in provider service...");
//		
//		Optional<Policy> policies=policyRepository.findById(policyId);
//		if(!policies.isPresent()) {
//			throw new InvalidPolicyId("Invalid PolicyId");
//		}
//		
//		return new HospitalDTO(policies.get().getHospitals());
//		
//		
//	}
	
	public HospitalDTO getHospitals(String policyId) throws InvalidPolicyId{
		log.info("Inside get providers method in provider service...");
		Optional<Policy> policies=policyRepository.findById(policyId);
		if(!policies.isPresent()) {
			throw new InvalidPolicyId("Invalid PolicyId");
		}
		
		return new HospitalDTO(policies.get().getHospitals());
	}
	
	
}
