package com.mfpe.policyservice.Policy.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfpe.policyservice.Policy.Service.model.Policy;

@Repository
public interface PolicyRepository  extends JpaRepository<Policy,String>{

}
