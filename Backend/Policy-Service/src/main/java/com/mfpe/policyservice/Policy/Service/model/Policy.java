package com.mfpe.policyservice.Policy.Service.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policy")
//@Getter
//@Setter
//@NoArgsConstructor
public class Policy{
	
	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public Set<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(Set<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public Set<Benefits> getBenefits() {
		return benefits;
	}

	public void setBenefits(Set<Benefits> benefits) {
		this.benefits = benefits;
	}

	public Policy(String policyId, String policyType, double sumInsured, double premium, Set<Hospital> hospitals,
			Set<Benefits> benefits) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.sumInsured = sumInsured;
		this.premium = premium;
		this.hospitals = hospitals;
		this.benefits = benefits;
	}

	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="PID")
	private String policyId;
	
	@Column(name="Policy_Type")
	private String policyType;
	
	@Column(name="Cap_Amount")
	private double sumInsured;
	
	@Column(name="Premium")
	private double premium;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="provider_policy", joinColumns= @JoinColumn(name="policyId"),
								  inverseJoinColumns= @JoinColumn(name="hospitalId"))
	private Set<Hospital> hospitals = new HashSet<>();
	
	@JsonIgnore	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="policy_benefits", joinColumns= @JoinColumn(name="policyId"),
					  inverseJoinColumns= @JoinColumn(name="benefitID"))
	private Set<Benefits> benefits = new HashSet<>();
	
	public Policy(String policyId, String policyType, double sumInsured, double premium) {
		super();
		this.policyId = policyId;
		this.policyType = policyType;
		this.sumInsured = sumInsured;
		this.premium = premium;
	}
}