package com.mfpe.ClaimsService.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PolicyExceptionTest {

	PolicyException policyException = new PolicyException("Exception");
	
	@Test
	@DisplayName("Checking if PolicyException class is loading")
	void policyExceptionIsLoading() {
		assertThat(policyException).isNotNull();
	}

}