package br.com.comsom.budbalance.msperson.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.comsom.budbalance.msperson.JackJsonUtils;
import br.com.comsom.budbalance.msperson.domain.Person;
import br.com.comsom.budbalance.msperson.services.PersonService;
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
	@InjectMocks
	private PersonController controller;
	@Mock
	private PersonService service;
	
	private JsonNode request;
	private Person person;
	
	@Before
	public void load() throws ParseException {
		person = new Person();
		person.setName("Ryu Santos");
		person.setSocialId("1234567890");
		person.setEmail("asdd@qwer.zxc");
		person.setPostalCode("1234567");
		person.setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("2000-03-09T14:49:36"));
		person.setAddressComplement("apt 1703 Bl2");
		person.setAddressNumber("169");
		request = JackJsonUtils.entityToObjectNode(person);
		
	}
	
	@Test
	public void testAddPerson() {
		when(service.save(person)).thenReturn(person);
		ResponseEntity<JsonNode> response = controller.addPerson(request);
		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(request),response);
	}

	@Test
	public void testGetPersonBySocialId() {
		when(service.findBySocialId(person.getSocialId())).thenReturn(person);
		ResponseEntity<JsonNode> response = controller.getPersonBySocialId(person.getSocialId());
		assertEquals(ResponseEntity.status(HttpStatus.OK).body(request), response);
	}

	@Test
	public void testGetPeopleByName() {
		List<Person> lperson = new ArrayList<Person>();
		lperson.add(person);
		when(service.findByName(person.getName())).thenReturn(lperson);
		ResponseEntity<JsonNode> response = controller.getPeopleByName(person.getName());
		ResponseEntity<JsonNode> knowResponse = ResponseEntity.status(HttpStatus.OK).body(JackJsonUtils.listEntityToArrayNode(lperson));
		assertEquals(knowResponse,response);
	}

}
