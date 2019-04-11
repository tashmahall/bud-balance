package br.com.comsom.budbalance.msbrand.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="BRANDS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"name","code"})
public class Brand {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANDS_SQ")
	@SequenceGenerator(sequenceName = "brandse_seq", allocationSize = 1, name = "BRANDS_SQ")
	private Long id;
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	@Column(name="CODE",nullable=false, unique=true)
	private String code;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_BRAND_OWN",referencedColumnName="ID")
	private Brand owner;
	@Column(name="COUNTRY")
	private String country;
}

