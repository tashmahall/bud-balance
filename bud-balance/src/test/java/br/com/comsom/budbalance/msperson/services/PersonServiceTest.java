package br.com.comsom.budbalance.msperson.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.comsom.budbalance.msperson.domain.Person;
import br.com.comsom.budbalance.msperson.repositories.PersonRepository;
import br.com.comsom.budbalance.msperson.services.PersonService;
@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
	@InjectMocks
	private PersonService service;
	@Mock
	private PersonRepository repository;

	private Person personTest;
	private String personName = "Eu Silva Santos";
	private String personSocialId = "12345678";
	private Date personBirthDate = new Date();
	private List<Person> listPerson = new ArrayList<Person>();
	
	@Before
	public void load() {
		personTest = new Person();
		personTest.setName(personName);
		personTest.setPostalCode("24220401");
		personTest.setAddressNumber("155");
		personTest.setAddressComplement("apto 1703 BL2");
		personTest.setSocialId(personSocialId);
		personTest.setEmail("abc@def.ghi");
		personTest.setBirthDate(personBirthDate);
		listPerson.add(personTest);
		
	}
	@Test
	public void testSave() {
		when(repository.save(personTest)).thenReturn(personTest);
		Person pTest = service.save(personTest);
		assertEquals(personTest,pTest);
	}

	@Test
	public void testFindByName() {
		when(repository.findByName(personName)).thenReturn(listPerson);
		List<Person> ltest = service.findByName(personName);
		assertEquals(listPerson,ltest);
	}

	@Test
	public void testFindBySocialId() {
		when(repository.findBySocialId(personSocialId)).thenReturn(personTest);
		Person ptest = service.findBySocialId(personSocialId);
		assertEquals(personTest, ptest);
	}

}
