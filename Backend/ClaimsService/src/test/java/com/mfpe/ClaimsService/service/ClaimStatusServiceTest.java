package com.mfpe.ClaimsService.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mfpe.ClaimsService.dto.ClaimStatusDTO;
import com.mfpe.ClaimsService.exception.InvalidClaimIdException;
import com.mfpe.ClaimsService.repository.ClaimRepository;

@SpringBootTest
class ClaimStatusServiceTest {

	@Autowired
	ClaimStatusService claimStatusService;
	@MockBean
	ClaimRepository claimRepo;
	@Test
	@DisplayName("Checking if ClaimStatusService class is loading or not")
	void claimStatusServiceIsLoadedOrNot() {
		assertThat(claimStatusService).isNotNull();
	}
	
	@Test
	@DisplayName("Checking if getClaimStatus method is working or not with valid Id")
	void getClaimStatusTestWithValidId() {
		ClaimStatusDTO claimStatusDTO=new ClaimStatusDTO();
		claimStatusDTO.setClaimId("C101");
		claimStatusDTO.setClaimStatus("Pending");
		claimStatusDTO.setClaimDescription("Verified");
		
		
		when(claimRepo.getStatus("C101")).thenReturn("Pending");
		when(claimRepo.getDescription("C101")).thenReturn("Verified");
		
		
		assertEquals(claimStatusDTO.getClaimId(), claimStatusService.getClaimStatus("C101").getBody().getClaimId()); 
		assertEquals(claimStatusDTO.getClaimStatus(), claimStatusService.getClaimStatus("C101").getBody().getClaimStatus()); 
		assertEquals(claimStatusDTO.getClaimDescription(), claimStatusService.getClaimStatus("C101").getBody().getClaimDescription()); 
	}
	
	@Test
	@DisplayName("Checking if getClaimStatus method is working or not with Invalid Id")
	void testGetClaimStatusWithInvalidValidId() {
		
		assertThrows(InvalidClaimIdException.class, () ->
         claimStatusService.getClaimStatus("C1561"));
	}
	
	
}