package br.com.comsom.budbalance.msperson.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.comsom.budbalance.msperson.JackJsonUtils;
import br.com.comsom.budbalance.msperson.domain.Person;
import br.com.comsom.budbalance.msperson.services.PersonService;

@RestController
@Path(value="/people")
public class PersonController {
	@Autowired
	private PersonService service;
	@PostMapping(consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<JsonNode> addPerson(@RequestBody JsonNode request){
		ObjectNode  response;
		try {
			Person entity = createPerson(request);	
			entity = service.save(entity);
			response = JackJsonUtils.entityToObjectNode(entity);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}catch (ParseException e){
			response = JackJsonUtils.getNewNode();
			response.put("code","400");
			response.put("error", "Bad Request");
			response.put("cause", "Wrong attributes sent");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	@GetMapping(path="{socialId}", consumes= {MediaType.TEXT_PLAIN_VALUE},produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonNode> getPersonBySocialId (@PathVariable(name="socialId") String socialId){
		Person entity = service.findBySocialId(socialId);
		ObjectNode response = JackJsonUtils.entityToObjectNode(entity);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(consumes= {MediaType.TEXT_PLAIN_VALUE}, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonNode> getPeopleByName(@RequestParam(name="name") String name){
		List<Person> lPerson = service.findByName(name);
		ArrayNode response = JackJsonUtils.listEntityToArrayNode(lPerson);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	private Person createPerson(JsonNode request) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Person person = new Person();
		person.setName(request.get("name").textValue());
		person.setSocialId(request.get("socialId").textValue());
		person.setEmail(request.get("email").textValue());
		person.setPostalCode(request.get("postalCode").textValue());
		person.setBirthDate(sdf.parse(request.get("birthDate").textValue()));
		person.setAddressNumber(request.get("addressNumber").textValue());
		person.setAddressComplement(request.get("addressComplement").textValue());
		return person;
	}
}
