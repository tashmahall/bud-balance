package br.com.comsom.budbalance.msbrand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.repositories.IRepresentationRepository;

@Service
public class RepresentationService {
	@Autowired
	private IRepresentationRepository repository;
	@Autowired 
	private RepresentativeService representativeService;
	@Autowired
	private BrandService brandService;
	
	public Representation findByCode(String code) {
		return repository.findByCode(code);
	}
	public List<Representation> findByBrand(String brandName){
		Brand bTemp = brandService.findByName(brandName);
		return repository.findByBrand(bTemp);
	}
	public List<Representation> findByRepresentative(String companyIdNumber){
		Representative rTemp =representativeService.findByCompanyIdNumber(companyIdNumber);
		return repository.findByRepresentative(rTemp);
	}

}
