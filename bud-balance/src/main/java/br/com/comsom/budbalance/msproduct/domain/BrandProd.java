package br.com.comsom.budbalance.msproduct.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class BrandProd {
	@Id
	@Column(name="ID",updatable=false)
	private Long id;
	@Column(name="NAME", nullable=false, unique=true)
	private String name;
	@Column(name="CODE",nullable=false, unique=true)
	private String code;
}

