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
@Table(name="REPRESENTATIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"brand","representative"})
public class RepresentationProd {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPRESENTATIONS_SQ")
	@SequenceGenerator(sequenceName = "representations_seq", allocationSize = 1, name = "REPRESENTATIONS_SQ")
	private Long id;
	@Column(name="CODE", nullable=false, unique=true,updatable=false)
	private String code;
	@ManyToOne
	@JoinColumn(name="BRAND_ID",referencedColumnName="ID",updatable=false ,nullable=false)
	private BrandProd brand;
	@ManyToOne
	@JoinColumn(name="REPRESENTATIVE_ID",referencedColumnName="ID", updatable=false,nullable=false)
	private RepresentativeProd representative;

}
