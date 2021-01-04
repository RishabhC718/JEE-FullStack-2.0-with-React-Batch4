package com.cg.spring.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.exception.AlreadyVotedException;
import com.cg.spring.exception.CandidateNotFoundException;
import com.cg.spring.exception.ElectionNotFoundException;
import com.cg.spring.json.CastVote;
import com.cg.spring.service.CastVoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("/evs")
@Api(value = "Vote Casting related APIs")

//Controller for vote casting
public class CastVoteController
{
	private static final Logger logger = LogManager.getLogger(CastVoteController.class);
	
	@Autowired
	private CastVoteService castVoteService;
	
	@ApiOperation(value = "Cast new Vote")
	@ApiResponses(value = { @ApiResponse(code=201, message="New vote casted!"), @ApiResponse(code=404, message="Vote not casted!")})
	
	//Mapping to create new CastVote object in CastVoteEntity
	@PostMapping(value="/election/castvote", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CastVote> createNewCastVote(@Valid @RequestBody CastVote castVote) throws AlreadyVotedException, CandidateNotFoundException
	{
		logger.info("Recording data of the vote casted by voter");
		return new ResponseEntity<CastVote>(castVoteService.createCastVote(castVote),HttpStatus.OK);
	}
	
	@ApiOperation(value="Returns list of Candidates to be voted with respective Party name.")
	@ApiResponses(value= {@ApiResponse(code=404, message="List of candidates not found for given election!")})
	
	//Mapping to get list of candidates to be voted in elections
	@GetMapping(value="/election/castvote/{election_name}/{state}/{constituency}/{date}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CastVote> getCandidateList(@PathVariable("election_name") String election_name, @PathVariable("state") String state, @PathVariable("constituency") String constituency, @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ElectionNotFoundException
	{
		logger.info("Displaying Candidate List for the given Elections in given Constituency");
		logger.warn("warning logger");
		logger.error("error logger");
		logger.debug("debug logger");
		return castVoteService.getCastVote(election_name, state, constituency, date);
	}
}