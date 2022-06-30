package com.mfpe.ClaimsService.model;

public class Benefits {
	private String benefitId;
	private String benefitName;
	public Benefits() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Benefits(String benefitId, String benefitName) {
		super();
		this.benefitId = benefitId;
		this.benefitName = benefitName;
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
	
	
}
