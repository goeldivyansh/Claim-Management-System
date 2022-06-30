package com.mfpe.MemberService;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.mfpe.MemberService.model.Bills;
import com.mfpe.MemberService.repository.BillsRepository;

@SpringBootApplication
@EnableFeignClients
public class MemberServiceApplication implements CommandLineRunner {

	@Autowired
	private BillsRepository billsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Bills bill1=new Bills("M101","P1001","2020-01-02",10000,800,"2021-02-01");
		billsRepository.save(bill1);
		

		Bills bill2=new Bills("M102","P1003","2019-12-10",50000,6500,"2020-12-10");
		billsRepository.save(bill2);

		Bills bill3=new Bills("M103","P1004","2021-07-20",12000,0,"2022-12-10");
		billsRepository.save(bill3);

		Bills bill4=new Bills("M104","P1002","2021-08-14",40000,700,"2022-06-15");
		billsRepository.save(bill4);

		Bills bill5=new Bills("M105","P1003","2021-12-16",35000,1000,"2022-06-01");
		billsRepository.save(bill5);
		
		
		
		
		
	}

}
