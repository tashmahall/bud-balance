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
@Table(name="REPR_EMAIL_CONTACTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class EmailContact {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAIL_SQ")
	@SequenceGenerator(sequenceName = "email_seq", allocationSize = 1, name = "EMAIL_SQ")
	private Long id;
	@Column(name="EMAIL",unique=false, nullable=false)
	private String email;
	@ManyToOne
	@JoinColumn(name="REPR_ID",referencedColumnName="ID")
	private Representative representative;
}
