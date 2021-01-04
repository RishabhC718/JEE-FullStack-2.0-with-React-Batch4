package com.cg.spring.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spring.entity.CastVoteEntity;

public interface CastVoteRepository extends JpaRepository<CastVoteEntity, Integer>
{
	@Query("select new com.cg.spring.entity.CastVoteEntity(c.candidateName, p.partyName) from PartyEntity p JOIN p.candidate c JOIN p.election e where e.electionName=?1 AND e.constituency=?2 AND e.date=?3")
	
	public List<CastVoteEntity> getAllCastVote(String election_name, String constituency, LocalDate date);

	@Query("Select new com.cg.spring.entity.CastVoteEntity(cv.electionName, cv.state, cv.constituency, cv.date, cv.candidateName, cv.partyName, cv.voterId) from CastVoteEntity cv where cv.electionName=?1 AND cv.constituency=?2 AND cv.date=?3 AND cv.voterId=?4")
	public List<CastVoteEntity> findAll(String election_name, String constituency, LocalDate date, int voter_id);

}
