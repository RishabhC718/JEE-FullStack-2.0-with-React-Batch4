package com.cg.spring.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.spring.exception.AlreadyVotedException;
import com.cg.spring.exception.CandidateNotFoundException;
import com.cg.spring.exception.ElectionNotFoundException;
import com.cg.spring.json.CastVote;

public interface CastVoteService 
{
	public CastVote createCastVote(CastVote castVote) throws AlreadyVotedException, CandidateNotFoundException;

	public List<CastVote> getCastVote(String election_name, String state, String constituency, LocalDate date) throws ElectionNotFoundException;
}
