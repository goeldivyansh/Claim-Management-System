package com.mfpe.ClaimsService.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimAmountDTO {
	public ClaimAmountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
	private double eligibleAmount;

	@JsonIgnore
	public double getEligibleAmount() {
		return eligibleAmount;
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
