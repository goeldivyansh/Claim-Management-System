package com.mfpe.ClaimsService.feign;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthClientTest {

	AuthClient authClient;
	
	@Test
	@DisplayName("Checking AuthClient Loading")
	void AuthClientLoading() {
		assertThat(authClient).isNull();
	}

}
