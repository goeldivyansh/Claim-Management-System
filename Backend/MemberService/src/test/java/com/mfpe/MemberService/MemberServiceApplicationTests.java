package com.mfpe.MemberService;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceApplicationTests {

	MemberServiceApplication memberServiceApplication;
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testMemberServiceApplication() {
		assertThat(memberServiceApplication).isNull();
	}
}