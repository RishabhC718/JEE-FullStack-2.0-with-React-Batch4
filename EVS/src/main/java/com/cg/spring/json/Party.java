package com.cg.spring.json;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Party
{
	private String partyName;
	private String leader;
	private String symbol;
	private Set<Candidate> candidate;
	private Set<Election> election;
	
	public Party() {
		super();
	}
	
	public Party(String party_name, String leader, String symbol) {
		super();
		this.partyName = party_name;
		this.leader = leader;
		this.symbol = symbol;
	}

	public Party(String party_name, String leader, String symbol, Set<Candidate> candidate) {
		super();
		this.partyName = party_name;
		this.leader = leader;
		this.symbol = symbol;
		this.candidate = candidate;
	}

	public Party(String party_name, String leader, String symbol, Set<Candidate> candidate, Set<Election> election) {
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

	public Set<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(Set<Candidate> candidate) {
		this.candidate = candidate;
	}

	public Set<Election> getElection() {
		return election;
	}

	public void setElection(Set<Election> election) {
		this.election = election;
	}

	@Override
	public String toString() {
		return "Party [party_name=" + partyName + ", leader=" + leader + ", symbol=" + symbol + ", candidate="
				+ candidate + ", election=" + election + "]";
	}
}
