package com.mfpe.policyservice.Policy.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfpe.policyservice.Policy.Service.model.MemberPolicy;

@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy,String>{

}
