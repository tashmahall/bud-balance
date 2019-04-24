package br.com.comsom.budbalance.msbrand.controllers;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.services.BrandService;
import br.com.comsom.budbalance.msbrand.services.RepresentationService;
import br.com.comsom.budbalance.msbrand.services.RepresentativeService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;

@RestController
@Path(value="/representations")
public class RepresentationController {
	@Autowired
	private RepresentationService service;
	@Autowired 
	private BrandService brandService;
	@Autowired
	private RepresentativeService representativeService;
	@PostMapping(path="/representations",consumes={MediaType.APPLICATION_JSON},produces={MediaType.APPLICATION_JSON})
	public ResponseEntity<JsonNode> addRepresentation(@RequestBody JsonNode request) {
		ObjectNode response = createJsonRepresentation(service.save(createRepresentation(request)));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@GetMapping(path="/representations/{codeRepresentation}", consumes= {MediaType.TEXT_PLAIN},produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<JsonNode> getRepresentationByCode(@PathVariable(name="codeRepresentation") String socialId){
		Representation entity = service.findByCode(socialId);
		ObjectNode response = createJsonRepresentation(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	private Representation createRepresentation(JsonNode request) {
		Representation representation = new Representation();
		representation.setCode(String.valueOf((new Date().getTime())));
		Representative rTemp = representativeService.findByCompanyIdNumber(request.get("representativeCompanyIdNumber").textValue());
		representation.setRepresentative(rTemp);
		Brand bTemp = brandService.findByName(request.get("brandName").textValue());
		representation.setBrand(bTemp);
		return representation;
	}
	private ObjectNode createJsonRepresentation(Representation representation) {
		ObjectNode node = JackJsonUtils.getNewNode();
		node.put("id",representation.getId());
		node.put("code",representation.getCode());
		node.put("brandName", representation.getBrand().getName());
		node.put("representativeCompanyIdNumber", representation.getRepresentative().getCompanyIdNumber());
		return node;
	}

}
