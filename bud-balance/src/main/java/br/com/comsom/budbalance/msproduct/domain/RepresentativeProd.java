package br.com.comsom.budbalance.msproduct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="REPRESENTATIVES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"companyIdNumber"})
public class RepresentativeProd {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEOPLE_SQ")
	@SequenceGenerator(sequenceName = "people_seq", allocationSize = 1, name = "PEOPLE_SQ")
	private Long id;
	@Column(name="NAME", nullable=false,updatable=false)
	private String name;
	@Column(name="COMP_ID_NUMBER",updatable=false,nullable=false, unique=true)
	private String companyIdNumber;
}
