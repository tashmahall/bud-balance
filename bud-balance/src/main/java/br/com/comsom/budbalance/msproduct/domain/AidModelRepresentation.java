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
@Table(name="HEARING_MODEL_REPRESENTATIN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"hearingAidModel","representation"}) 
public class AidModelRepresentation {
	@Id
	@Column(name="ID",updatable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HEAR_AID_MODEL_REPRE_SQ")
	@SequenceGenerator(sequenceName = "hear_aid_model_repre_seq", allocationSize = 1, name = "HEAR_AID_MODEL_REPRE_SQ")
	private Long id;
	@ManyToOne
	@JoinColumn(name="HEARING_AID_MODEL_ID",referencedColumnName="ID",nullable=false)
	private HearingAidModel hearingAidModel;
	@ManyToOne
	@JoinColumn(name="REPRESENTATION_ID",referencedColumnName="ID", nullable=false)
	private RepresentationProd representation;
}
