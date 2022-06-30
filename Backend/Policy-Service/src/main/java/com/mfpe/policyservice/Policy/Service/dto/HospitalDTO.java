package com.mfpe.policyservice.Policy.Service.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfpe.policyservice.Policy.Service.model.Hospital;

public class HospitalDTO {
	public HospitalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonProperty
	private Set<Hospital> hospitals;
		@JsonIgnore
		public HospitalDTO(Set<Hospital> hospitals) {
			this.hospitals=hospitals;
		}
		@JsonIgnore
		public Set<Hospital> getHospitals() {
			return hospitals;
		}
		@JsonIgnore
		public void setHospitals(Set<Hospital> hospitals) {
			this.hospitals = hospitals;
		}
		
		
}
