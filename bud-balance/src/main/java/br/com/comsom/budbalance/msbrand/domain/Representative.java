package br.com.comsom.budbalance.msbrand.domain;

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

import br.com.comsom.budbalance.msbrand.domain.contacts.AddressContact;
import br.com.comsom.budbalance.msbrand.domain.contacts.EmailContact;
import br.com.comsom.budbalance.msbrand.domain.contacts.PhoneContact;
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
public class Representative {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEOPLE_SQ")
	@SequenceGenerator(sequenceName = "people_seq", allocationSize = 1, name = "PEOPLE_SQ")
	private Long id;
	@Column(name="NAME", nullable=false)
	private String name;
	@Column(name="COMP_ID_NUMBER",nullable=false, unique=true)
	private String companyIdNumber;
	@OneToMany
	@JoinColumn(name="REPR_ID",referencedColumnName="ID")
	private List<PhoneContact> phoneContactList;
	@OneToMany
	@JoinColumn(name="REPR_ID",referencedColumnName="ID")
	private List<EmailContact> emailContactList;
	@OneToMany(mappedBy="representative")
	private List<AddressContact> addressContactList;
}
