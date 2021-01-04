package com.cg.spring.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.entity.CastVoteEntity;
import com.cg.spring.entity.ElectionEntity;
import com.cg.spring.exception.AlreadyVotedException;
import com.cg.spring.exception.CandidateNotFoundException;
import com.cg.spring.exception.ElectionNotFoundException;
import com.cg.spring.json.CastVote;
import com.cg.spring.repo.CastVoteRepository;
import com.cg.spring.repo.ElectionRepository;
import com.cg.spring.utils.CastVoteUtil;

@Service
public class CastVoteServiceImpl implements CastVoteService
{
	private static final Logger logger = LogManager.getLogger(CastVoteServiceImpl.class);
	@Autowired
	private CastVoteRepository castVoteRepo;
	
	@Autowired
	private ElectionRepository electionRepo;
	
	@Override
	public CastVote createCastVote(CastVote castVote) throws AlreadyVotedException, CandidateNotFoundException 
	{
		int count=0;
		List<CastVoteEntity> castVoteCandidateCheck = castVoteRepo.getAllCastVote(castVote.getElectionName(),castVote.getConstituency(),castVote.getDate());
		for(CastVoteEntity cast:castVoteCandidateCheck)
		{
			if(!(castVote.getCandidateName().equalsIgnoreCase(cast.getCandidateName())))
			{
				continue;
			}
			else
			{
				if(!(castVote.getPartyName().equalsIgnoreCase(cast.getPartyName())))
				{
					continue;
				}
				else
				{
					count = 1;
					break;
				}
			}
		}
		if(count==1)
		{
			logger.info("Candidate was successfully found!");
			List<CastVoteEntity> castVoteEntityList = castVoteRepo.findAll(castVote.getElectionName(),castVote.getConstituency(),castVote.getDate(),castVote.getVoterId());
			if(castVoteEntityList.isEmpty())
			{
				logger.info("Casting vote successfully!");
				CastVoteEntity castVoteEntity = castVoteRepo.save(CastVoteUtil.convertCastVoteIntoCastVoteEntity(castVote));
				return CastVoteUtil.convertCastVoteEntityIntoCastVote(castVoteEntity);
			}
			else
			{
				logger.error("Voter has already casted their vote!");
				throw new AlreadyVotedException("You have already voted!");
			}
		}
		else
		{
			logger.info("Candidate entered is not in the list!");
			throw new CandidateNotFoundException("Selected candidate not in list!");
		}
	}
	
	@Override
	public List<CastVote> getCastVote(String election_name, String state, String constituency, LocalDate date) throws ElectionNotFoundException {
		List<ElectionEntity> election = electionRepo.findAll(election_name,state,constituency,date);
		if(election.isEmpty())
		{
			logger.info("Entered election doesn't exist on given date!");
			throw new ElectionNotFoundException("No election schedule today!");
		}
		else
		{
			logger.info("Candidate List for given election is generated!");
			return CastVoteUtil.convertCastVoteEntityListIntoCastVoteList(castVoteRepo.getAllCastVote(election_name,constituency,date));
		}
	}

}
