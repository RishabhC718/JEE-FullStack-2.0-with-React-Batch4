package com.cg.spring.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.spring.entity.CastVoteEntity;
import com.cg.spring.json.CastVote;

public class CastVoteUtil
{
	public static CastVote convertCastVoteEntityIntoCastVote(CastVoteEntity castVoteEntity)
	{
		CastVote castVote = new CastVote(castVoteEntity.getCastId(),castVoteEntity.getElectionName(), castVoteEntity.getState(), castVoteEntity.getConstituency(), castVoteEntity.getDate(), castVoteEntity.getCandidateName(), castVoteEntity.getPartyName(), castVoteEntity.getVoterId());
		return castVote;
	}
	
	public static CastVoteEntity convertCastVoteIntoCastVoteEntity(CastVote castVote)
	{
		CastVoteEntity castVoteEntity = new CastVoteEntity(castVote.getElectionName(), castVote.getState(), castVote.getConstituency(), castVote.getDate(), castVote.getCandidateName(), castVote.getPartyName(), castVote.getVoterId());
		return castVoteEntity;
	}
	
	public static CastVote convertCastVoteEntityIntoCastVote1(CastVoteEntity castVoteEntity)
	{
		CastVote castVote = new CastVote(castVoteEntity.getCandidateName(), castVoteEntity.getPartyName());
		return castVote;
	}
	
	public static CastVoteEntity convertCastVoteIntoCastVoteEntity1(CastVote castVote)
	{
		CastVoteEntity castVoteEntity = new CastVoteEntity(castVote.getCandidateName(), castVote.getPartyName());
		return castVoteEntity;
	}

	public static List<CastVote> convertCastVoteEntityListIntoCastVoteList(List<CastVoteEntity> castVoteEntityList)
	{
		List<CastVote> castVote = new ArrayList<CastVote>();
		for(CastVoteEntity castVoteEntity:castVoteEntityList)
		{
			castVote.add(convertCastVoteEntityIntoCastVote1(castVoteEntity));
		}
		return castVote;
	}
}