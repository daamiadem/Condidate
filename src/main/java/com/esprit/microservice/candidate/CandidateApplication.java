package com.esprit.microservice.candidate;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.esprit.microservice.candidate.entity.Candidate;
import com.esprit.microservice.candidate.repo.ICandidateRepository;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateApplication.class, args);
	}
	
	@Bean
	 ApplicationRunner init(ICandidateRepository repository){
		return args ->{
			Stream.of("Adem","meriam","toto").forEach(nom ->{
				repository.save(new Candidate(nom));
			});
			repository.findAll().forEach(System.out::println);
		};
	}
	


}
