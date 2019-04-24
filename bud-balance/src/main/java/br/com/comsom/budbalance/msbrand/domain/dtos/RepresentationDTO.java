package br.com.comsom.budbalance.msbrand.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"code","brandName","representativeCompanyIdNumber"})
public class RepresentationDTO {

	private Long id;
	private String code;
	private String brandName;
	private String representativeCompanyIdNumber;

}
