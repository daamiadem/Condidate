package com.esprit.microservice.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.candidate.entity.Candidate;
import com.esprit.microservice.candidate.repo.ICandidateRepository;
import com.esprit.microservice.candidate.service.CandidateService;


@RestController
public class CandidateRestAPI {
	private String title="Hello, I'm the candidate Microservice";
	@Autowired
	ICandidateRepository CondidateRepo ; 
	
	@Autowired
	CandidateService candidatService ; 
	
	
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title) ;
		return title;
	}

	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidate> createCandidat(@RequestBody Candidate candidat) {
		return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK) ;

	}

	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidate> updateCandidat(@PathVariable(value="id") int id,
	@RequestBody Candidate candidat){
	return new ResponseEntity<>(candidatService.updateCandidat(id, candidat),HttpStatus.OK);
	}
	@DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCandidat(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(candidatService.deleteCandidate(id),HttpStatus.OK);

	}
	
	
}







