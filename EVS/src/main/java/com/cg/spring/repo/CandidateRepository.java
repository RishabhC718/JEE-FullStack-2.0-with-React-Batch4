package com.cg.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spring.entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {

}
