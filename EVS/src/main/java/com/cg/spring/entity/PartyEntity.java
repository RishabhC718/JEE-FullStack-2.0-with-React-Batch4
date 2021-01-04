package com.cg.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="party")
public class PartyEntity 
{
	@Id
	@Column(name="party_name")
	private String partyName;
	
	@Column(name="leader")
	private String leader;
	
	@Column(name="symbol")
	private String symbol;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy="party")
	private Set<CandidateEntity> candidate;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="election_party", joinColumns = {@JoinColumn(name="party_name")}, inverseJoinColumns = {@JoinColumn(name="election_id")})
	private Set<ElectionEntity> election = new HashSet<ElectionEntity>();

	public PartyEntity() {
		super();
	}

	public PartyEntity(String party_name, String leader, String symbol) {
		super();
		this.partyName = party_name;
		this.leader = leader;
		this.symbol = symbol;
	}

	public PartyEntity(String party_name, String leader, String symbol, Set<CandidateEntity> candidate) {
		super();
		this.partyName = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.candidate = candidate;
	}

	public PartyEntity(String party_name, String leader, String symbol, Set<CandidateEntity> candidate,
			Set<ElectionEntity> election) {
		super();
		this.partyName = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.candidate = candidate;
		this.election = election;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String party_name) {
		this.partyName = party_name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Set<CandidateEntity> getCandidate() {
		return candidate;
	}

	public void setCandidate(Set<CandidateEntity> candidate) {
		this.candidate = candidate;
	}

	public Set<ElectionEntity> getElection() {
		return election;
	}

	public void setElection(Set<ElectionEntity> election) {
		this.election = election;
	}

	@Override
	public String toString() {
		return "PartyEntity [party_name=" + partyName + ", leader=" + leader + ", symbol=" + symbol + ", candidate="
				+ candidate + ", election=" + election + "]";
	}
	
}
