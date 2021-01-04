package com.cg.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spring.entity.PartyEntity;

public interface PartyRepository extends JpaRepository<PartyEntity, String>{

}
