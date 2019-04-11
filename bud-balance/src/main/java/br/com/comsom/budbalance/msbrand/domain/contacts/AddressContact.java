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
@Table(name="REPR_ADDRESS_CONTACT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class AddressContact {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPR_ADRS_CONT_SQ")
	@SequenceGenerator(sequenceName = "reprAdrsCont_seq", allocationSize = 1, name = "REPR_ADRS_CONT_SQ")
	private Long id;
	@Column(name="addressNumber")
	private String addressNumber;
	@Column(name="addressComplement")
	private String addressComplement;
	@Column(name="POSTAL_CODE")
	private String postalCode;
	@Column(name="LANDMARK")
	private String landmark;
	@ManyToOne
	@JoinColumn(name="REPR_ID",referencedColumnName="ID")
	private Representative representative;
}
