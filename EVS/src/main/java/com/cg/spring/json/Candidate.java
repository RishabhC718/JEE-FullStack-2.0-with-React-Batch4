package com.cg.spring.json;

public class Candidate
{
	private int candidateId;
	private String candidateName;
	private String address;
	private int age;
	private long contactNo;
	private Party party;
	
	public Candidate() {
		super();
	}
	
	public Candidate(String candidate_name, String address, int age, long contact_no) {
		super();
		this.candidateName = candidate_name;
		this.address = address;
		this.age = age;
		this.contactNo = contact_no;
	}
	
	public Candidate(String candidate_name, String address, int age, long contact_no, Party party) {
		super();
		this.candidateName = candidate_name;
		this.address = address;
		this.age = age;
		this.contactNo = contact_no;
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contact_no) {
		this.contactNo = contact_no;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", candidate_name=" + candidateName + ", address=" + address
				+ ", age=" + age + ", contact_no=" + contactNo + ", party=" + party + "]";
	}
}
