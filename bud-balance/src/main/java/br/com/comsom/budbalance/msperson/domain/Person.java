package br.com.comsom.budbalance.msperson.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PEOPLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"socialId"})
public class Person {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEOPLE_SQ")
	@SequenceGenerator(sequenceName = "people_seq", allocationSize = 1, name = "PEOPLE_SQ")
	private Long id;
	@Column(name="NAME", nullable=false)
	private String name;
	@Column(name="SOCIAL_ID",nullable=false, unique=true)
	private String socialId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", locale="pt-BR", timezone = "Brazil/East")
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	@Column(name="email")
	private String email;
	@Column(name="addressNumber")
	private String addressNumber;
	@Column(name="addressComplement")
	private String addressComplement;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@OneToMany
	@JoinColumn(name="PERSON_ID",referencedColumnName="ID")
	private List<PhoneContact> phoneContatcList;
	
}
