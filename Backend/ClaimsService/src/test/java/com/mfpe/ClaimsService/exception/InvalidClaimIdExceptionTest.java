package com.mfpe.ClaimsService.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvalidClaimIdExceptionTest {

	InvalidClaimIdException invalidClaimIdException = new InvalidClaimIdException("Exception");
	
	@Test
	@DisplayName("Checking InvalidClaimIdException is Loading")
	void invalidClaimIdExceptionIsLoading() {
		assertThat(invalidClaimIdException).isNotNull();
	}

}
