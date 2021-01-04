package com.cg.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class CandidateEntity 
{
	@Id
	@GeneratedValue
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="candidate_name")
	private String candidateName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private int age;
	
	@Column(name="contact_number")
	private long contact_number;
	
	@Column(name="email")
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="party_name")
	private PartyEntity party;

	public CandidateEntity() {
		super();
	}

	public CandidateEntity(String candidate_name, String address, int age, long contactNo, String email) {
		super();
		this.candidateName = candidate_name;
		this.address = address;
		this.age = age;
		this.contact_number = contactNo;
	}

	public CandidateEntity(String candidate_name, String address, int age, long contactNo, String email, PartyEntity party) {
		super();
		this.candidateName = candidate_name;
		this.address = address;
		this.age = age;
		this.contact_number = contactNo;
		this.party = party;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidate_name) {
		this.candidateName = candidate_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contactNo) {
		this.contact_number = contactNo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PartyEntity getParty() {
		return party;
	}

	public void setParty(PartyEntity party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "CandidateEntity [candidateId=" + candidateId + ", candidateName=" + candidateName + ", address="
				+ address + ", age=" + age + ", contactNo=" + contact_number + ", party=" + party + "]";
	}
	
}
