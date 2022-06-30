package com.mfpe.ClaimsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.mfpe.ClaimsService.model.Claim;
import com.mfpe.ClaimsService.repository.ClaimRepository;



@SpringBootApplication
@EnableFeignClients

public class ClaimsServiceApplication implements CommandLineRunner {
	@Autowired
	private ClaimRepository claimRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClaimsServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Claim claim1=new Claim("C101","Pending Action","All fields are succesfully verified.","remarks",10000.0,"H1","B101","P1002","M101");
		claimRepository.save(claim1);
		
		Claim claim2=new Claim("C102","Claim Rejected","Providers Details are not valid","remarks",15000.0,"H8","B101","P1003","M102");
		claimRepository.save(claim2);
	}

}
