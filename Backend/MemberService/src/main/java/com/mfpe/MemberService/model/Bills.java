package com.mfpe.MemberService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bills")
public class Bills {
	@Id
    @Column(name="MID")
	private String memberId;
	
    @Column(name="PID")	
	private String policyId;
    
    @Column(name="LastPaidDate")	
	private String  lastPaidDate;
    
    @Column(name="DueAmount")	
	private int dueAmount;
    
    @Column(name="LateCharge")	
	private int  lateCharge;
    
    @Column(name="DueDate")	
	private String  dueDate;

	public Bills() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bills(String memberId, String policyId, String lastPaidDate, int dueAmount, int lateCharge, String dueDate) {
		super();
		this.memberId = memberId;
		this.policyId = policyId;
		this.lastPaidDate = lastPaidDate;
		this.dueAmount = dueAmount;
		this.lateCharge = lateCharge;
		this.dueDate = dueDate;
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

	public String getLastPaidDate() {
		return lastPaidDate;
	}

	public void setLastPaidDate(String lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}

	public int getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(int dueAmount) {
		this.dueAmount = dueAmount;
	}

	public int getLateCharge() {
		return lateCharge;
	}

	public void setLateCharge(int lateCharge) {
		this.lateCharge = lateCharge;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	    
}
