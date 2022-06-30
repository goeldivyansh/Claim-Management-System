package com.mfpe.MemberService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.MemberService.dto.ClaimDTO;
//import com.mfpe.MemberService.dto.ClaimDTO;
import com.mfpe.MemberService.dto.ClaimStatusDTO;


@FeignClient(name = "claim-service", url ="${Claims.url}")
public interface ClaimsClient {
	
	@GetMapping(path="/getClaimStatus/{claim_id}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable("claim_id") String claim_id,@RequestHeader(name = "Authorization", required = true) String token);
	//public ClaimStatusDTO getClaimStatus(@PathVariable("claim_id") String claim_id,@RequestHeader(name = "Authorization", required = true) String token);
	
	@PostMapping(path ="/submitClaim")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@RequestBody ClaimDTO claimDTO, @RequestHeader(name = "Authorization", required = true) String token);
	//public ClaimStatusDTO submitClaim(@RequestBody ClaimDetails claimDetails, @RequestHeader(name = "Authorization", required = true) String token);
}