package com.mfpe.policyservice.Policy.Service.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
@Entity
@Table(name="benefits")
public class Benefits {

	@Id
	@Column(name="BID")
	private String benefitId;
	
	@Column(name="Name")
	private String benefitName;

	public Benefits(String benefitId, String benefitName) {
		super();
		this.benefitId = benefitId;
		this.benefitName = benefitName;
	}
	
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy = "benefits")
	private Set<Policy> policyBenefits = new HashSet<>();

	public Benefits() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}

	public String getBenefitName() {
		return benefitName;
	}

	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}

	public Set<Policy> getPolicyBenefits() {
		return policyBenefits;
	}

	public void setPolicyBenefits(Set<Policy> policyBenefits) {
		this.policyBenefits = policyBenefits;
	}

	public Benefits(String benefitId, String benefitName, Set<Policy> policyBenefits) {
		super();
		this.benefitId = benefitId;
		this.benefitName = benefitName;
		this.policyBenefits = policyBenefits;
	}
	
	
}