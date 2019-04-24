package br.com.comsom.budbalance.msproduct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="HEARING_AID")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"serialNumber"}) 
public class HearingAid {
	@Id
	@Column(name="ID",updatable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEARING_AID_MODEL_SQ")
	@SequenceGenerator(sequenceName = "hearing_aid_model_seq", allocationSize = 1, name = "HEARING_AID_MODEL_SQ")
	private Long id;
	@Column(name="SERIAL_NUMBER",nullable=false, unique=true)
	private String serialNumber;
	@ManyToOne
	@JoinColumn(name="AID_MODEL_REPR_ID", referencedColumnName="ID")
	private AidModelRepresentation aidModelRepresentation; 

	
	
}
