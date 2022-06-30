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
@Entity
//@NoArgsConstructor
@Table(name="hospital")
public class Hospital {
	
	@Id
	@Column(name="HID")
	private String hospitalId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Location")
	private String location;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="hospitals")
	private Set<Policy> policies = new HashSet<>();

	public Hospital(String hospitalId, String name, String location) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(String hospitalId, String name, String location, Set<Policy> policies) {
		super();
		this.hospitalId = hospitalId;
		this.name = name;
		this.location = location;
		this.policies = policies;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(Set<Policy> policies) {
		this.policies = policies;
	}
	
}