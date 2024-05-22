package com.example.sample0509;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	public Person getPersonById(int id) {
		Optional<Person> person = personRepository.findById(id);
		return person.orElse(null);
	}

	public List<Person> searchPerson(String keyword) {
		return personRepository.findByNameContaining(keyword);
	}
}