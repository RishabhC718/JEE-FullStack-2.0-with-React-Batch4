package com.cg.spring.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spring.entity.ElectionEntity;

public interface ElectionRepository extends JpaRepository<ElectionEntity, Integer> {

	@Query("Select new com.cg.spring.entity.ElectionEntity(e.electionName, e.state, e.constituency, e.date) from ElectionEntity e where e.electionName=?1 AND e.state=?2 AND e.constituency=?3 AND e.date=?4")
	List<ElectionEntity> findAll(String election_name, String state, String constituency, LocalDate date);

}
