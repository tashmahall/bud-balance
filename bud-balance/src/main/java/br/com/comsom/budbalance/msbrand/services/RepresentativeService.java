package br.com.comsom.budbalance.msbrand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comsom.budbalance.msbrand.domain.Representative;
import br.com.comsom.budbalance.msbrand.repositories.IRepresentativeRepository;

@Service
public class RepresentativeService {
	@Autowired
	private IRepresentativeRepository repository;
	public Representative findByCompanyIdNumber(String companyIdNumber) {
		return repository.findByCompanyIdNumber(companyIdNumber);
	}
	public List<Representative> findByName(String name){
		return repository.findByName(name);
	}
	public Representative save(Representative entity) {
		return repository.save(entity);
	}
}
