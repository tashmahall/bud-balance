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

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.services.BrandService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;
@RunWith(MockitoJUnitRunner.class)
public class BrandControllerTest {
	@InjectMocks
	private BrandController controller;
	@Mock
	private BrandService service;
	
	private JsonNode request;
	private Brand entity;
	
	@Before
	public void load() throws ParseException {
		entity = new Brand();
		entity.setId(1L);
		entity.setName("New Brand Test");
		entity.setCode("1234567890");
		entity.setCountry("Brazil");
		request = JackJsonUtils.entityToObjectNode(entity);
	}
	@Test
	public void testAddBrand() {
		when(service.save(entity)).thenReturn(entity);
		ResponseEntity<JsonNode> response = controller.addBrand(request);
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

	@Test
	public void getBrandByCode() {
		when(service.findByCode(entity.getCode())).thenReturn(entity);
		ResponseEntity<JsonNode> response = controller.getBrandByCode(entity.getCode());
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

}
