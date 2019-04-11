package br.com.comsom.budbalance.msperson.domain;

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
@Table(name="PHONE_CONTATCTS_PERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"countryCode","areaCode","number"})
public class PhoneContact {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_CONTACTS_SQ")
	@SequenceGenerator(sequenceName = "phoneContatcts_seq", allocationSize = 1, name = "PHONE_CONTACTS_SQ")
	private Long id;
	@Column(name="COUNTRY_CODE", nullable=false)
	private String countryCode;
	@Column(name="AREA_CODE", nullable=false)
	private String areaCode;
	@Column(name="NUMBER", nullable=false)
	private String number;
}
