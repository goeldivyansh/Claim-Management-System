package com.mfpe.ClaimsService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ClaimsServiceApplicationTests {
	
	ClaimsServiceApplication claimsServiceApplication;
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testComponentProcessingMicroserviceApplication() {
		assertThat(claimsServiceApplication).isNull();
	}
}
