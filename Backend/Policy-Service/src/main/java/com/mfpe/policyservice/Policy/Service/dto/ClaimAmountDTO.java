package com.mfpe.policyservice.Policy.Service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimAmountDTO {
	@JsonProperty
	private double eligibleAmount;

	@JsonIgnore 
	public double getEligibleAmount() {
		return eligibleAmount;
	}
	
	public ClaimAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	public void setEligibleAmount(double eligibleAmount) {
		this.eligibleAmount = eligibleAmount;
	}
	
	@JsonIgnore
	public ClaimAmountDTO(double eligibleAmount) {
		super();
		this.eligibleAmount = eligibleAmount;
	}
}
