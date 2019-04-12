package br.com.comsom.budbalance.msbrand.controllers;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.services.BrandService;
import br.com.comsom.budbalance.msbrand.services.RepresentationService;
import br.com.comsom.budbalance.msbrand.services.RepresentativeService;

@RestController
@Path(value="/representation")
public class RepresentationController {
	@Autowired
	private RepresentationService service;
	@Autowired 
	private BrandService brandService;
	@Autowired
	private RepresentativeService representativeService;
	@PostMapping(consumes={MediaType.APPLICATION_JSON},produces={MediaType.APPLICATION_JSON})
	public Representation addRepresentation(@RequestBody JsonNode request) {
			return null;
	}
	

}
