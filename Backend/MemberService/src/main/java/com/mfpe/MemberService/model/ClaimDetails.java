package com.mfpe.MemberService.model;

import java.util.Objects;

public class ClaimDetails {
	private String claimId;
	
	private String status;

	private String description;
    

	private String remarks;
	
	private double claimAmount;


    private String hospitalId;
    

    private String benefitId;
    

    private String policyId;
    

    private String memberId;


	public ClaimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClaimDetails(String claimId, String status, String description, String remarks, double claimAmount,
			String hospitalId, String benefitId, String policyId, String memberId) {
		super();
		this.claimId = claimId;
		this.status = status;
		this.description = description;
		this.remarks = remarks;
		this.claimAmount = claimAmount;
		this.hospitalId = hospitalId;
		this.benefitId = benefitId;
		this.policyId = policyId;
		this.memberId = memberId;
	}


	public String getClaimId() {
		return claimId;
	}


	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public double getClaimAmount() {
		return claimAmount;
	}


	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}


	public String getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}


	public String getBenefitId() {
		return benefitId;
	}


	public void setBenefitId(String benefitId) {
		this.benefitId = benefitId;
	}


	public String getPolicyId() {
		return policyId;
	}


	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "ClaimDetails [claimId=" + claimId + ", status=" + status + ", description=" + description + ", remarks="
				+ remarks + ", claimAmount=" + claimAmount + ", hospitalId=" + hospitalId + ", benefitId=" + benefitId
				+ ", policyId=" + policyId + ", memberId=" + memberId + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(benefitId, claimAmount, claimId, description, hospitalId, memberId, policyId, remarks,
				status);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaimDetails other = (ClaimDetails) obj;
		return Objects.equals(benefitId, other.benefitId)
				&& Double.doubleToLongBits(claimAmount) == Double.doubleToLongBits(other.claimAmount)
				&& Objects.equals(claimId, other.claimId) && Objects.equals(description, other.description)
				&& Objects.equals(hospitalId, other.hospitalId) && Objects.equals(memberId, other.memberId)
				&& Objects.equals(policyId, other.policyId) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(status, other.status);
	}
    
    
}