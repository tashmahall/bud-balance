package br.com.comsom.budbalance.msbrand.controllers;

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
import br.com.comsom.budbalance.msbrand.services.BrandService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;

@RestController
@Path(value="/brands")
public class BrandController {
	@Autowired
	private BrandService service;
	@PostMapping(path="/brands",consumes={MediaType.APPLICATION_JSON},produces={MediaType.APPLICATION_JSON})
	public ResponseEntity<JsonNode> addBrand(@RequestBody JsonNode request) {
		ObjectNode response = JackJsonUtils.entityToObjectNode(service.save(createBrand(request)));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@GetMapping(path="/brands/{codeBrand}", consumes= {MediaType.TEXT_PLAIN},produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<JsonNode> getBrandByCode(@PathVariable(name="codeBrand") String brandCode){
		Brand entity = service.findByCode(brandCode);
		ObjectNode response = JackJsonUtils.entityToObjectNode(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	private Brand createBrand(JsonNode request) {
		Brand bTemp = new Brand();
		bTemp.setCode(request.get("code").textValue());
		bTemp.setName((request.get("name").textValue()));
		bTemp.setCountry((request.get("country").textValue()));
		return bTemp;
	}

}
