package br.com.comsom.budbalance.msbrand.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.repositories.IBrandRepository;

@Service
public class BrandService {
	@Autowired
	private IBrandRepository repository;
	public Brand findByName(String name) {
		return repository.findByName(name);
	}
	public Brand findByCode(String code) {
		return repository.findByCode(code);
	}
	public Brand save(Brand entity) {
		return repository.save(entity);
	}
}
