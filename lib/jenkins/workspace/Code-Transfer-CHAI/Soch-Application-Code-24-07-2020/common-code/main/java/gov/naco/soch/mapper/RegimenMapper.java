package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.naco.soch.dto.RegimenConstituentDto;
import gov.naco.soch.dto.RegimenDto;
import gov.naco.soch.entity.MasterData;
import gov.naco.soch.entity.Regimen;
import gov.naco.soch.entity.RegimenConstituent;

public class RegimenMapper {

	/*
	 * function to map list of RegimenDto class to Regimen
	 */
	public static Regimen mapToRegimen(RegimenDto regimenDto, Regimen regimen) {
		if (regimen == null) {
			regimen = new Regimen();
		}
		regimen.setRegimenName(regimenDto.getRegimenName());
		regimen.setIsActive(regimenDto.isActive());

		MasterData adultPed = null;
		if (regimenDto.getAdultPedId() != null && regimenDto.getAdultPedId() != 0) {
			adultPed = new MasterData();
			adultPed.setId(regimenDto.getAdultPedId());
		}

		MasterData line = null;
		if (regimenDto.getLineId() != null && regimenDto.getLineId() != 0) {
			line = new MasterData();
			line.setId(regimenDto.getLineId());
		}
		regimen.setMasterData1(adultPed);
		regimen.setMasterData2(line);
		regimen.setIsDelete(false);
		return regimen;
	}

	/*
	 * function to map Regimen class to RegimenDto
	 */
	public static RegimenDto mapToRegimenDto(Regimen regimen) {
		RegimenDto regimenDto = new RegimenDto();
		regimenDto.setId(regimen.getId());
		regimenDto.setRegimenName(regimen.getRegimenName());
		regimenDto.setActive(regimen.getIsActive());
		if (regimen.getMasterData1() != null) {
			regimenDto.setAdultPedId(regimen.getMasterData1().getId());
			regimenDto.setAdultPed(regimen.getMasterData1().getName());
		}
		if (regimen.getMasterData2() != null) {
			regimenDto.setLineId(regimen.getMasterData2().getId());
			regimenDto.setLine(regimen.getMasterData2().getName());
		}

		if (regimen.getRegimenConstituents() != null && !regimen.getRegimenConstituents().isEmpty()) {
			List<RegimenConstituentDto> regimenConstituentDtoList = new ArrayList<RegimenConstituentDto>();
			for (RegimenConstituent regimenConstituent : regimen.getRegimenConstituents()) {
				RegimenConstituentDto regimenConstituentDto = new RegimenConstituentDto();
				regimenConstituentDto.setId(regimenConstituent.getId());

				if (regimenConstituent.getProduct() != null) {
					regimenConstituentDto.setProductId(regimenConstituent.getProduct().getId());
					regimenConstituentDto.setProductName(regimenConstituent.getProduct().getProductName());
				}

				if (regimenConstituent.getProductUomMaster() != null) {
					regimenConstituentDto.setUomId(regimenConstituent.getProductUomMaster().getId());
					regimenConstituentDto.setUomName(regimenConstituent.getProductUomMaster().getUomName());
				}
				regimenConstituentDto.setQuantity(regimenConstituent.getQuantity());

				regimenConstituentDtoList.add(regimenConstituentDto);
			}
			regimenDto.setRegimenConstituentList(regimenConstituentDtoList);
		}

		return regimenDto;
	}

	public static String advanceSearchQueryCreator(Map<String, String> searchValue) {
		String regimenName = searchValue.get("name");
		String adultOrPed = searchValue.get("adultorped");
		String line = searchValue.get("line");
		String constituent = searchValue.get("constituent");
		String searchQuery = "";
		if (constituent != null && constituent != "") {
			searchQuery = "select r.* from soch.regimen r \r\n"
					+ "join soch.regimen_constituent rc on rc.regimen_id=r.id \r\n"
					+ "where r.is_delete=false and rc.is_delete=false and rc.product_id="
					+ constituent + " ";
		} else {
			searchQuery = "select r.* from soch.regimen r where r.is_delete=false ";
		}
		if (regimenName != null && regimenName != "") {
			searchQuery = searchQuery.concat("and lower(r.regimen_name) Like lower('%" + regimenName + "%') ");
		}
		if (adultOrPed != null && adultOrPed != "") {
			searchQuery = searchQuery.concat("and r.adult_ped=" + adultOrPed + " ");
		}
		if (line != null && line != "") {
			searchQuery = searchQuery.concat("and r.line=" + line + " ");
		}
		searchQuery = searchQuery.concat("group by r.id order by r.regimen_name asc");
		return searchQuery;
	}

}
