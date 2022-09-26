package com.esprit.microservice.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.candidate.entity.Candidate;
import com.esprit.microservice.candidate.repo.ICandidateRepository;

@Service
public class CandidateService {
	@Autowired
	private ICandidateRepository candidatRepository; 
	
	public Candidate addCandidat(Candidate candidat) {
		return candidatRepository.save(candidat);

	}
	
	public Candidate updateCandidat(int id, Candidate newCandidat) {
		if (candidatRepository.findById(id).isPresent()) {
			Candidate existingCandidat = candidatRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setEmail(newCandidat.getEmail());

			return candidatRepository.save(existingCandidat);
			} else
			return null;
	

}
	public String deleteCandidate(int id) {
		if (candidatRepository.findById(id).isPresent()) {
			candidatRepository.deleteById(id);
			return "candidat suppring";
} else
return "candidat non supprimé";
	}



}

 
