package br.com.comsom.budbalance.msproduct.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.comsom.budbalance.msproduct.domain.HearingAid;

interface IHearingAidRepository extends CrudRepository<HearingAid, Long>{
	public HearingAid findBySerialNumber(String serialNumber);
}
