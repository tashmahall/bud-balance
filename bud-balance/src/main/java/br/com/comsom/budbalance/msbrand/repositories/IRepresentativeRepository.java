package br.com.comsom.budbalance.msbrand.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.comsom.budbalance.msbrand.domain.Representative;

public interface IRepresentativeRepository extends CrudRepository<Representative, Long> {
	public Representative findByCompanyIdNumber(String code);
	public List<Representative> findByName(String name);
}
