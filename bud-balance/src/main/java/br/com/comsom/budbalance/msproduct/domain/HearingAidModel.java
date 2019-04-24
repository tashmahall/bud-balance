package br.com.comsom.budbalance.msproduct.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="HEARING_AID_MODEL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"name"}) 
public class HearingAidModel {
	@Id
	@Column(name="ID",updatable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEARING_AID_MODEL_SQ")
	@SequenceGenerator(sequenceName = "hearing_aid_model_seq", allocationSize = 1, name = "HEARING_AID_MODEL_SQ")
	private Long id;
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	@OneToMany(mappedBy="hearingAidModel")
	private List<AidModelRepresentation> aidModelRepresentation;
}
