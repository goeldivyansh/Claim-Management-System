package com.mfpe.MemberService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfpe.MemberService.model.Bills;

@Repository
public interface BillsRepository extends JpaRepository<Bills, String>{
	
}