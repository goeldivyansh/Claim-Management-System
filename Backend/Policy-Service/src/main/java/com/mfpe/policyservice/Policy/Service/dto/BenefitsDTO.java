package com.mfpe.policyservice.Policy.Service.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfpe.policyservice.Policy.Service.model.Benefits;

public class BenefitsDTO {
	public BenefitsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
	 private Set<Benefits> benefits;

	@JsonIgnore
	public Set<Benefits> getBenefits() {
		return benefits;
	}

	@JsonIgnore
	public void setBenefits(Set<Benefits> benefits) {
		this.benefits = benefits;
	}

	@JsonIgnore
	public BenefitsDTO(Set<Benefits> benefits) {
		super();
		this.benefits = benefits;
	}
}
