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
import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.domain.dtos.RepresentationDTO;
import br.com.comsom.budbalance.msbrand.services.BrandService;
import br.com.comsom.budbalance.msbrand.services.RepresentationService;
import br.com.comsom.budbalance.msbrand.services.RepresentativeService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;
@RunWith(MockitoJUnitRunner.class)
public class RepresentationControllerTest {
	@InjectMocks
	private RepresentationController controller;
	@Mock
	private RepresentationService service;
	
	@Mock
	private BrandService brandService;

	@Mock
	private RepresentativeService representativeService;

	private JsonNode request;
	private Representation entity;
	private RepresentationDTO entityDTO;
	
	@Before
	public void load() throws ParseException {
		Brand brandEntity = new Brand();
		brandEntity.setId(1L);
		brandEntity.setName("New Brand Test");
		brandEntity.setCode("1234567890");
		brandEntity.setCountry("Brazil");
		
		Representative representativeEntity = new Representative();
		representativeEntity.setId(1L);
		representativeEntity.setName("New Brand Test");
		representativeEntity.setCompanyIdNumber("1234567890");

		entity = new Representation();
		entity.setId(1L);
		entity.setCode("1234567890");
		entity.setBrand(brandEntity);
		entity.setRepresentative(representativeEntity);
		
		entityDTO = new RepresentationDTO();
		entityDTO.setBrandName(entity.getBrand().getName());
		entityDTO.setCode(entity.getCode());
		entityDTO.setRepresentativeCompanyIdNumber(entity.getRepresentative().getCompanyIdNumber());
		entityDTO.setId(entity.getId());
		
		request = JackJsonUtils.entityToObjectNode(entityDTO);
	}
	@Test
	public void testAddRepresentationd() {
		when(service.save(entity)).thenReturn(entity);
		when(representativeService.findByCompanyIdNumber(entity.getRepresentative().getCompanyIdNumber())).thenReturn(entity.getRepresentative());
		when(brandService.findByName(entity.getBrand().getName())).thenReturn(entity.getBrand());
		ResponseEntity<JsonNode> response = controller.addRepresentation(request);
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

	@Test
	public void getRepresentationByCode() {
		when(service.findByCode(entity.getCode())).thenReturn(entity);
		ResponseEntity<JsonNode> response = controller.getRepresentationByCode(entity.getCode());
		ResponseEntity<JsonNode> responseTest = ResponseEntity.status(HttpStatus.OK).body(request);
		assertEquals(responseTest,response);
	}

}
