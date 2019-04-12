package br.com.comsom.budbalance.msbrand.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.comsom.budbalance.msbrand.domain.Brand;

public interface IBrandRepository extends CrudRepository<Brand, Long> {
	public Brand findByName(String name);
	public Brand findByCode(String code);
}
