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

import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.services.RepresentativeService;
import br.com.comsom.budbalance.msperson.JackJsonUtils;

@RestController
@Path(value="/representatives")
public class RepresentativeController {
	@Autowired
	private RepresentativeService service;
	@PostMapping(path="/representatives",consumes={MediaType.APPLICATION_JSON},produces={MediaType.APPLICATION_JSON})
	public ResponseEntity<JsonNode> addRepresentative(@RequestBody JsonNode request) {
		ObjectNode response = JackJsonUtils.entityToObjectNode(service.save(createRepresentative(request)));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@GetMapping(path="/representatives/{codeRepresentative}", consumes= {MediaType.TEXT_PLAIN},produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<JsonNode> getRepresentationByCode(@PathVariable(name="codeRepresentative") String companyIdNumber){
		Representative entity = service.findByCompanyIdNumber(companyIdNumber);
		ObjectNode response = JackJsonUtils.entityToObjectNode(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	private Representative createRepresentative(JsonNode request) {
		Representative bTemp = new Representative();
		bTemp.setCompanyIdNumber(request.get("companyIdNumber").textValue());
		bTemp.setName((request.get("name").textValue()));
		return bTemp;
	}

}
