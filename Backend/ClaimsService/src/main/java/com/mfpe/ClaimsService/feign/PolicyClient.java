package com.mfpe.ClaimsService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.ClaimsService.dto.BenefitsDTO;
import com.mfpe.ClaimsService.dto.ClaimAmountDTO;
import com.mfpe.ClaimsService.dto.HospitalDTO;

@FeignClient(value="policy-client",url= "${Policy.url}")
public interface PolicyClient {
	@GetMapping(path="/getChainOfProviders/{policyId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HospitalDTO> getProviders(@PathVariable String policyId, @RequestHeader(name = "Authorization", required = true)String token);
	
	@GetMapping(path="/getEligibleBenefits/{policyId}/{memberId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BenefitsDTO> getEligibleBenefits(@PathVariable String policyId,@PathVariable String memberId,@RequestHeader(name = "Authorization", required = true)String token);
	
	@GetMapping(path="/getEligibleClaimAmount/{policyId}/{memberId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClaimAmountDTO> getEligibleAmount(@PathVariable String policyId, @PathVariable String memberId, @RequestHeader(name = "Authorization", required = true)String token);
}
