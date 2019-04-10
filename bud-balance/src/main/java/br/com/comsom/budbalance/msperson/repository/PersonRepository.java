package br.com.comsom.budbalance.msperson.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.comsom.budbalance.msperson.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
		public List<Person> findByName(String name);
		public Person findBySocialId(String socialId);
}