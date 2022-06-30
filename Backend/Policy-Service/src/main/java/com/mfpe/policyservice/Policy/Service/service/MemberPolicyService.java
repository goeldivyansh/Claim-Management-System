package com.mfpe.policyservice.Policy.Service.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.policyservice.Policy.Service.model.MemberPolicy;
import com.mfpe.policyservice.Policy.Service.repository.MemberPolicyRepository;

@Service
public class MemberPolicyService {
	

	private static final Logger log=LoggerFactory.getLogger(MemberPolicyService.class);
	@Autowired
	private MemberPolicyRepository memberPolicyRepository;
	
	public boolean ValidateMember(String memberId) {
		log.info("Inside get member policy service...");
		
		Optional<MemberPolicy> memPolicy=memberPolicyRepository.findById(memberId);
		return memPolicy.isPresent();
	}
	
	public boolean isPremiumPaid(String memberId)
	{
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Optional<MemberPolicy> member = memberPolicyRepository.findById(memberId);
		
		LocalDate today = LocalDate.now();
		
		if(member.isPresent())
		{
			LocalDate lastDate = LocalDate.parse(member.get().getPremiumLastDate(),df);
	
			if(lastDate.plusYears(1).compareTo(today) >= 0)
				return true;
		}
		
		return false;
	}
	
	
}
