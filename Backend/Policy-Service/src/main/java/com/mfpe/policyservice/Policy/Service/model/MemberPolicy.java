package com.mfpe.policyservice.Policy.Service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="member_policy")
public class MemberPolicy {
	
	@Override
	public String toString() {
		return "MemberPolicy [memberId=" + memberId + ", policyId=" + policyId + ", tenure=" + tenure
				+ ", premiumLastDate=" + premiumLastDate + ", subscriptionDate=" + subscriptionDate + "]";
	}

	public MemberPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberPolicy(String memberId, String policyId, int tenure, String premiumLastDate, String subscriptionDate) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.tenure = tenure;
		this.premiumLastDate = premiumLastDate;
		this.subscriptionDate = subscriptionDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public String getPremiumLastDate() {
		return premiumLastDate;
	}

	public void setPremiumLastDate(String premiumLastDate) {
		this.premiumLastDate = premiumLastDate;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	@Id
	@Column(name="MID")
	private String memberId;
	
	@Column(name="PID")
	private String policyId;
	
	@Column(name="tenure")
	private int tenure;
	
	@Column(name="premium_last_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String premiumLastDate;
	
	@Column(name="subscription_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String subscriptionDate;
}
