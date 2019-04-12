package br.com.comsom.budbalance.msbrand.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.comsom.budbalance.msbrand.domain.Brand;
import br.com.comsom.budbalance.msbrand.domain.Representation;
import br.com.comsom.budbalance.msbrand.domain.Representative;

public interface IRepresentationRepository extends CrudRepository<Representation, Long> {
	public Representation findByCode(String code);
	public List<Representation> findByBrand(Brand brand);
	public List<Representation> findByRepresentative(Representative representative);
}
