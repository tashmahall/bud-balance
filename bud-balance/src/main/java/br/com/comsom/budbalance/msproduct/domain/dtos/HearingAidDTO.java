package br.com.comsom.budbalance.msproduct.domain.dtos;

import br.com.comsom.budbalance.msproduct.domain.HearingAid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"serialNumber"}) 
public class HearingAidDTO {
	private Long id;
	private String serialNumber;
	private String hearingAidModel;
	private String hearingAidBrand;
	public HearingAidDTO(HearingAid hearingAid) {
		this.serialNumber = hearingAid.getSerialNumber();
		this.hearingAidModel = hearingAid.getAidModelRepresentation().getHearingAidModel().getName();
		this.hearingAidBrand = hearingAid.getAidModelRepresentation().getRepresentation().getBrand().getName();
		this.id=hearingAid.getId();
	}
}
