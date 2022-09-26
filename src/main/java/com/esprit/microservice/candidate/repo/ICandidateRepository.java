package com.esprit.microservice.candidate.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.candidate.entity.Candidate;

public interface ICandidateRepository extends JpaRepository<Candidate,Integer> {
//	@Query ( " select c from Candidate c where c.nom like : nom " )
//	public Page< Candidate > candidatByNom ( @Param ( "nom" ) String n , Pageable pageable ) ;
}