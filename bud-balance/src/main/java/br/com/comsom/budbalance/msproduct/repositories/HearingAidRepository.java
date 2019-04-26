package br.com.comsom.budbalance.msproduct.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.comsom.budbalance.msproduct.domain.HearingAid;

@Repository
public class HearingAidRepository {
	@Autowired
	private IHearingAidRepository repository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public HearingAid findBySerialNumber(String serialNumber) {
		return repository.findBySerialNumber(serialNumber);
	}
	public List<HearingAid> findAvaiableByModel(String modelName){
		String sql = "SELECT * FROM HEARING_AIDS HA  "
				+ "LEFT JOIN HEARING_MODEL_REPRESENTATIONS HMR ON HA.AID_MODEL_REPR_ID = HMR.ID"
				+ "LEFT JOIN HEARING_AID_MODELS HAM ON HAM.ID = HMR.HEARING_AID_MODEL_ID "
				+ "WHERE HAM.NAME = :modelName";
		return null;
		
	}

}
