package br.com.comsom.budbalance.msbrand.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.services.RepresentativeService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;
@RunWith(MockitoJUnitRunner.class)
public class RepresentativeControllerTest {
	@InjectMocks
	private RepresentativeController controller;
	@Mock
	private RepresentativeService service;
	
	private JsonNode request;
	private Representative entity;
	
	@Before
	public void load() throws ParseException {
		entity = new Representative();
		entity.setId(1L);
		entity.setName("New Brand Test");
		entity.setCompanyIdNumber("1234567890");
		request = JackJsonUtils.entityToObjectNode(entity);
	}
	@Test
	public void testAddBrand() {
		when(service.save(entity)).thenReturn(entity);
		ResponseEntity<JsonNode> response = controller.addRepresentative(request);
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

	@Test
	public void getBrandByCode() {
		when(service.findByCompanyIdNumber(entity.getCompanyIdNumber())).thenReturn(entity);
		ResponseEntity<JsonNode> response = controller.getRepresentativeByCode(entity.getCompanyIdNumber());
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

}
