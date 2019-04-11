package br.com.comsom.budbalance.msperson.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comsom.budbalance.msperson.domain.Person;
import br.com.comsom.budbalance.msperson.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repository;
	
	public Person save(Person entity) {
		convertToCharCases(entity);
		return repository.save(entity);
	}
	public List<Person> findByName(String name){
		return repository.findByName(name);
	}
	public Person findBySocialId(String socialId) {
		return repository.findBySocialId(socialId);
	}
	private void convertToCharCases(Person person) {
		person.setAddressComplement(person.getAddressComplement()!=null?person.getAddressComplement().toUpperCase():null);
		person.setName(person.getName()!=null?person.getName().toUpperCase():null);
		person.setEmail(person.getEmail()!=null?person.getEmail().toLowerCase():null);
	}
}
