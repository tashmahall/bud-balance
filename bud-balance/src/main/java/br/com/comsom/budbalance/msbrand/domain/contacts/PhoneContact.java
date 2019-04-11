package br.com.comsom.budbalance.msbrand.domain.contacts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.comsom.budbalance.msbrand.domain.Representative;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="REPR_PHONE_CONTATCTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"countryCode","areaCode","number","representative"})
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
	@ManyToOne
	@JoinColumn(name="REPR_ID",referencedColumnName="ID")
	private Representative representative;
}
