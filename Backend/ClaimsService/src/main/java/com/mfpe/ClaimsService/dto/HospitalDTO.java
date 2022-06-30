package com.mfpe.ClaimsService.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfpe.ClaimsService.model.Hospital;

public class HospitalDTO {
	public HospitalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonProperty
	private List<Hospital> hospitals;
		@JsonIgnore
		public HospitalDTO(List<Hospital> hospitals) {
			this.hospitals=hospitals;
		}
		@JsonIgnore
		public List<Hospital> getHospitals() {
			return hospitals;
		}
		@JsonIgnore
		public void setHospitals(List<Hospital> hospitals) {
			this.hospitals = hospitals;
		}
}
