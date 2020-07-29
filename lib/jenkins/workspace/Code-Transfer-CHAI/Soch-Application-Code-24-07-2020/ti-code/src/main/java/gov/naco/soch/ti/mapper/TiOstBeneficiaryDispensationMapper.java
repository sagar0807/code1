package gov.naco.soch.ti.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.TiOstBeneficiaryDispensationDto;
import gov.naco.soch.dto.TiOstDispensationDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.entity.FacilityStockTrackingType;
import gov.naco.soch.entity.MasterDrug;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBulkDispensation;
import gov.naco.soch.entity.TiOstDispensation;
import gov.naco.soch.entity.TiOstDispensationItem;
import gov.naco.soch.entity.TiOstPrescription;
import gov.naco.soch.enums.FacilityStockTrackingTypeEnum;
import gov.naco.soch.projection.TIDispensationExpectedList;

public class TiOstBeneficiaryDispensationMapper {

	public static List<TiOstBeneficiaryDispensationDto> mapTiOstBeneficiaryDispensationDtoToTiOstBeneficiary(
			List<TiOstBeneficiary> expectedBeneficiaryList, Long drugTypeId, LocalDate date) {
		List<TiOstBeneficiaryDispensationDto> expectedClientList = new ArrayList<TiOstBeneficiaryDispensationDto>();
		expectedBeneficiaryList.forEach(beneficiary -> {
			TiOstBeneficiaryDispensationDto expectedClient = new TiOstBeneficiaryDispensationDto();
			expectedClient.setTiOstBeneficiaryId(beneficiary.getId());
			expectedClient.setDateOfVisit(beneficiary.getRegistrationDate());

			if (beneficiary.getBeneficiary() != null) {
				expectedClient.setAge(beneficiary.getBeneficiary().getAge());
				expectedClient.setBeneficiaryName(
						beneficiary.getBeneficiary().getFirstName() + " " + beneficiary.getBeneficiary().getLastName());
				expectedClient.setSex(beneficiary.getBeneficiary().getGender());
			}

			if (!CollectionUtils.isEmpty(beneficiary.getTiOstPrescriptions())) {
				Map<Long, Optional<TiOstPrescription>> groupedByBeneficiaryId = beneficiary.getTiOstPrescriptions()
						.stream().collect(Collectors.groupingBy(x -> x.getTiOstBeneficiary().getId(),
								Collectors.maxBy(Comparator.comparing(TiOstPrescription::getModifiedTime))));
				List<TiOstPrescription> list = groupedByBeneficiaryId.entrySet().stream().map(x -> x.getValue().get())
						.collect(Collectors.toList());
				list.removeIf(p -> p.getProduct().getId() != drugTypeId);
				if (!list.isEmpty()) {
					for (TiOstPrescription prescription : list) {
						expectedClient.setTiOstPrescriptionId(prescription.getId());
						expectedClient.setDosage(prescription.getDosageQty());
						if (prescription.getProduct() != null) {
							expectedClient.setDrug(prescription.getProduct().getName());
							if (prescription.getProduct().getName().startsWith("Buprenorphine")) {
								if (prescription.getDosageQty() != null) {
									expectedClient = findNumberOfTabletsByDosage(prescription.getDosageQty(),
											expectedClient);
								}
							}
						}
					}
					expectedClientList.add(expectedClient);
				}
			}

		});

		return expectedClientList;
	}

	private static TiOstBeneficiaryDispensationDto findNumberOfTabletsByDosage(Double dosageQty,
			TiOstBeneficiaryDispensationDto expectedClient) {
		Integer numberOf2mgTablet = 0;
		Double numberOf4mgTablet = 0.0;
		Double dosage = dosageQty;
		numberOf2mgTablet = (int) (dosage / 2);
		Double remainder = dosage % 2;
		remainder = Math.round(remainder * 10) / 10.0;
		if (remainder != 0 && remainder <= 0.2) {
			numberOf4mgTablet = numberOf4mgTablet + 0.5;

		} else if (remainder != 0 && remainder >= 0.4) {
			Double quotient = remainder / 0.4;
			Double subRemainder = remainder % 0.4;
			numberOf4mgTablet = Math.round(quotient * 10) / 10.0;
			if (subRemainder != 0 && subRemainder == 0.2) {
				numberOf4mgTablet = numberOf4mgTablet + 0.5;
			}
		}
		expectedClient.setNumberOf4mgTablet(numberOf4mgTablet);
		expectedClient.setNumberOf2mgTablet(numberOf2mgTablet);
		return expectedClient;
	}

	public static String createSearchQuerySearch(Long facilityId, String drugtype, String name, LocalDate date,
			Boolean isTransit, String param, String uid, String ostNo, String mobile) {

		String subQuery = null;
		String searchQuery = "select res1.ti_ost_beneficiary_id as tiOstBeneficiaryId,top1.id as tiOstPrescriptionId,\r\n"
				+ "tob.ost_number as ostNumber,b.uid as uid,b.first_name as firstName,\r\n"
				+ "b.last_name as secondName, b.gender as sex,b.age as age, md.name as drug,\r\n"
				+ "top1.dosage_qty as dosage from soch.ti_ost_beneficiary tob join \r\n"
				+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
				+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
				+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
				+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
				+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
				+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
				+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
				+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
				+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
				+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
				+ "on(md.id=top1.substitution_drug) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7)"
				+ " AND tob.consent_taken_date<='%" + date + "%'" + "";
		if (name != null) {
			searchQuery = searchQuery
					+ "  AND b.first_name like '%" + name + "%'" + " OR b.middle_name like '%" + name + "%'" + " OR b.last_name like '%" + name
					+ "%'";
		}
		if (uid != null) {
			searchQuery = searchQuery
					+ "  AND b.uid='%" + uid
					+ " %'";
		}
		if (ostNo != null) {
			searchQuery = searchQuery
					+ "  AND tob.ost_number='%" + ostNo
					+ " %'";
		}if (mobile != null) {
			searchQuery = searchQuery
					+ " AND b.mobile_number='%" + mobile
					+ " %'";
		}if (param != null) {
			searchQuery = searchQuery
					+ "  AND b.uid='%" + param + "%'" + " OR b.first_name like '%" + param + "%'" + ""
					+ " OR b.middle_name like '%" + param + "%'" + " OR b.last_name like '%" + param + "%'" + " OR b.mobile_number='%" + param+ " %'";
		}if (isTransit.equals(Boolean.TRUE)) {
			subQuery = " JOIN soch.beneficiary_transit_facility btf on(btf.facility_id="+facilityId+") WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
					+ drugtype + " and tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=true AND (tob.facility_id!=" + facilityId + " OR linked_facility_id="
					+ facilityId +" OR btf.facility_id="+facilityId+ ")";
		} else {
			subQuery = "AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")";
		}
		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	
	}
	
	public static String getCountForSearchQuerySearch(Long facilityId, String drugtype, String name, LocalDate date,
			Boolean isTransit, String param, String uid, String ostNo, String mobile) {

		String subQuery = null;
		String searchQuery = "select count(res1.ti_ost_beneficiary_id) as tiOstBeneficiaryId \r\n"
				+ " from soch.ti_ost_beneficiary tob join \r\n"
				+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
				+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
				+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
				+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
				+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
				+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
				+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
				+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
				+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
				+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
				+ "on(md.id=top1.substitution_drug) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7)"
				+ " AND tob.consent_taken_date<='%" + date + "%'" + "";
		if (name != null) {
			searchQuery = searchQuery
					+ "  AND b.first_name like '%" + name + "%'" + " OR b.middle_name like '%" + name + "%'" + " OR b.last_name like '%" + name
					+ "%'";
		}
		if (uid != null) {
			searchQuery = searchQuery
					+ "  AND b.uid='%" + uid
					+ " %'";
		}
		if (ostNo != null) {
			searchQuery = searchQuery
					+ "  AND tob.ost_number='%" + ostNo
					+ " %'";
		}if (mobile != null) {
			searchQuery = searchQuery
					+ " AND b.mobile_number='%" + mobile
					+ " %'";
		}if (param != null) {
			searchQuery = searchQuery
					+ "  AND b.uid='%" + param + "%'" + " OR b.first_name like '%" + param + "%'" + ""
					+ " OR b.middle_name like '%" + param + "%'" + " OR b.last_name like '%" + param + "%'" + " OR b.mobile_number='%" + param+ " %'";
		}if (isTransit.equals(Boolean.TRUE)) {
			subQuery = " JOIN soch.beneficiary_transit_facility btf on(btf.facility_id="+facilityId+") WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
					+ drugtype + " and tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=true AND (tob.facility_id!=" + facilityId + " OR linked_facility_id="
					+ facilityId +" OR btf.facility_id="+facilityId+ ")";
		} else {
			subQuery = "AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")";
		}
		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	
	}

	public static TiOstBulkDispensation mapToTiOstBulkDispensation(TiOstDispensationDto tiOstDispensationDto) {
		TiOstBulkDispensation tiOstBulkDispensation = new TiOstBulkDispensation();
		tiOstBulkDispensation.setOstBulkDispensationDate(LocalDate.now());
		Facility facility = new Facility();
		facility.setId(tiOstDispensationDto.getFacilityId());
		tiOstBulkDispensation.setFacility(facility);
		MasterDrug masterDrug = new MasterDrug();
		masterDrug.setId(tiOstDispensationDto.getSubstituitionDrugId());
		tiOstBulkDispensation.setMasterDrug(masterDrug);
		Set<TiOstDispensation> tiOstDispensations = mapToTiOstDispensation(tiOstDispensationDto, tiOstBulkDispensation);
		tiOstBulkDispensation.setTiOstDispensations(tiOstDispensations);
		return tiOstBulkDispensation;
	}

	private static Set<TiOstDispensation> mapToTiOstDispensation(TiOstDispensationDto tiOstDispensationDto,
			TiOstBulkDispensation tiOstBulkDispensation) {
		Set<TiOstDispensation> tiOstDispensations = new HashSet<>();
		tiOstDispensationDto.getBatchDetails().forEach(batch -> {
			TiOstDispensation tiOstDispensation = new TiOstDispensation();
			tiOstDispensation.setAvailableQty(batch.getAvailableQuantity());
			tiOstDispensation.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(tiOstDispensationDto.getFacilityId());
			tiOstDispensation.setFacility(facility);
			tiOstDispensation.setTotalDosageQty(batch.getDosage());
			tiOstDispensation.setTotalDispensedQty(batch.getDispensedQuantity());
			tiOstDispensation.setTiOstBulkDispensation(tiOstBulkDispensation);
			Product product = new Product();
			product.setId(batch.getProductId());
			tiOstDispensation.setProduct(product);
			tiOstDispensation.setOstDispensationDate(LocalDate.now());
			tiOstDispensations.add(tiOstDispensation);
		});
		return tiOstDispensations;
	}

	public static Set<TiOstDispensationItem> mapToTiOstDispensationItem(TiOstDispensationDto tiOstDispensationDto,
			TiOstBulkDispensation tiOstBulkDispensation, Long productId, String drugType) {
		Set<TiOstDispensationItem> tiOstDispensationItems = new HashSet<>();
		tiOstDispensationDto.getBeneficiaries().forEach(beneficiary -> {
			TiOstDispensationItem tiOstDispensationItem = new TiOstDispensationItem();
			Product product = new Product();

			tiOstDispensationItem.setDispensationDate(tiOstDispensationDto.getDate());
			tiOstDispensationItem.setLastDispensationDate(tiOstDispensationDto.getDate());
			tiOstDispensationItem.setActualDispensationDate(LocalDate.now());

			if (drugType == "methadone") {
				tiOstDispensationItem.setDispensedQty(beneficiary.getDosage());
				tiOstDispensationItem.setDosageQty(beneficiary.getDosage());
			} else if (drugType == "buprenorphine2mg") {
				tiOstDispensationItem.setDispensedQty(beneficiary.getNumberOf2mgTablet());
				tiOstDispensationItem.setDosageQty(beneficiary.getNumberOf2mgTablet() * 2);
			} else if (drugType == "buprenorphine4mg") {
				tiOstDispensationItem.setDispensedQty(beneficiary.getNumberOf4mgTablet());
				tiOstDispensationItem.setDosageQty(beneficiary.getNumberOf4mgTablet() * 0.4);
			}
			product.setId(productId);
			tiOstDispensationItem.setProduct(product);
			TiOstBeneficiary tiOstBeneficiary = new TiOstBeneficiary();
			tiOstBeneficiary.setId(beneficiary.getTiOstBeneficiaryId());
			TiOstPrescription tiOstPrescription = new TiOstPrescription();
			tiOstPrescription.setId(beneficiary.getTiOstPrescriptionId());
			Facility facility = new Facility();
			facility.setId(tiOstDispensationDto.getFacilityId());
			tiOstDispensationItem.setTiOstBeneficiary(tiOstBeneficiary);
			tiOstDispensationItem.setTiOstBulkDispensation(tiOstBulkDispensation);
			tiOstDispensationItem.setTiOstPrescription(tiOstPrescription);
			tiOstDispensationItem.setFacility(facility);

			tiOstDispensationItems.add(tiOstDispensationItem);
		});

		return tiOstDispensationItems;
	}

	public static List<FacilityStockTracking> mapToFacilityStockTracking(
			@Valid TiOstDispensationDto tiOstDispensationDto, TiOstBulkDispensation tiOstBulkDispensation) {
		List<FacilityStockTracking> facilityStockTrackings = new ArrayList<>();
		tiOstDispensationDto.getBatchDetails().forEach(batch -> {
			FacilityStockTracking facilityStockTracking = new FacilityStockTracking();
			facilityStockTracking.setBatchNumber(batch.getBatchNumber());
			Facility facility = new Facility();
			facility.setId(tiOstDispensationDto.getFacilityId());
			facilityStockTracking.setFacility(facility);
			FacilityStockTrackingType facilityStockTrackingType = new FacilityStockTrackingType();
			facilityStockTrackingType
					.setId(FacilityStockTrackingTypeEnum.Ti_Ost_Drug_Dispensation.getFacilityStockTrackingTypeId());
			facilityStockTracking.setFacilityStockTrackingType(facilityStockTrackingType);
			Product product = new Product();
			product.setId(batch.getProductId());
			facilityStockTracking.setProduct(product);
			facilityStockTracking.setBatchNumber(batch.getBatchNumber());
			facilityStockTracking.setTransactionDate(LocalDate.now());
			facilityStockTracking.setReferenceNo(tiOstBulkDispensation.getOstBulkDispensationId());
			facilityStockTracking.setQuantity(-batch.getDispensedQuantity());
			facilityStockTrackings.add(facilityStockTracking);
		});
		return facilityStockTrackings;
	}

	public static TiOstBeneficiaryDispensationDto mapTiOstDispensationItemToTiOstBeneficiaryDispensationDto(
			TiOstBeneficiary beneficiary, List<TiOstDispensationItem> todaysDispensedList) {
		TiOstBeneficiaryDispensationDto dto = new TiOstBeneficiaryDispensationDto();
		if(beneficiary.getBeneficiary()!=null) {
			dto.setAge(beneficiary.getBeneficiary().getAge());
			dto.setBeneficiaryName(
					beneficiary.getBeneficiary().getFirstName() + " " + beneficiary.getBeneficiary().getLastName());
			dto.setSex(beneficiary.getBeneficiary().getGenderId().getName());
			dto.setUid(beneficiary.getBeneficiary().getUid());

		}
		
		dto.setTiOstBeneficiaryId(beneficiary.getId());
		dto.setDateOfVisit(beneficiary.getRegistrationDate());
		dto.setOstNumber(beneficiary.getOstNumber());
		

		Double dispensedQty = 0.0;

		for (TiOstDispensationItem dispensation : todaysDispensedList) {
			if (dispensation.getDosageQty() != null) {
				dispensedQty = dispensedQty + dispensation.getDosageQty();
			}
		}
		dto.setDosage(dispensedQty);
		dto = findNumberOfTabletsByDosage(dispensedQty, dto);

		if ((!CollectionUtils.isEmpty(todaysDispensedList)) && todaysDispensedList.get(0) != null
				&& todaysDispensedList.get(0).getTiOstBulkDispensation() != null) {
			dto.setDrug(todaysDispensedList.get(0).getTiOstBulkDispensation().getMasterDrug().getName());
			dto.setLastDispensationDate(todaysDispensedList.get(0).getLastDispensationDate());

		}

		return dto;
	}

	public static String createSearchQuery(Long facilityId, String name, Long drugtypeId, LocalDate date,
			Boolean isTransit) {
		String subQuery = null;

		String searchQuery = "select res1.ti_ost_beneficiary_id as tiOstBeneficiaryId,top1.id as tiOstPrescriptionId,\r\n"
				+ "tob.ost_number as ostNumber,tob.linked_facility_id as linkedFacilityId,b.uid as uid,b.first_name as firstName,\r\n"
				+ "b.last_name as secondName, mg.name as sex,b.age as age, md.name as drug,\r\n"
				+ "top1.dosage_qty as dosage from soch.ti_ost_beneficiary tob join \r\n"
				+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
				+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
				+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
				+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
				+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
				+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
				+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
				+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
				+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
				+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
				+ "on(md.id=top1.substitution_drug) join soch.master_gender mg on(b.gender_id=mg.id) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
				+ drugtypeId + " AND tob.consent_taken_date<='%" + date + "%'" 
				+ " \r\n";
		if (name != null && name.length() != 0) {
			searchQuery = searchQuery
					+ " AND b.first_name like '%" + name
					+ "%'";
		}
		if (isTransit.equals(Boolean.TRUE)) {
			searchQuery = "select distinct res1.ti_ost_beneficiary_id as tiOstBeneficiaryId,top1.id as tiOstPrescriptionId,\r\n"
					+ "tob.ost_number as ostNumber,tob.linked_facility_id as linkedFacilityId,b.uid as uid,b.first_name as firstName,\r\n"
					+ "b.last_name as secondName, b.gender as sex,b.age as age, md.name as drug,\r\n"
					+ "top1.dosage_qty as dosage from soch.ti_ost_beneficiary tob join \r\n"
					+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
					+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
					+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
					+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
					+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
					+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
					+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
					+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
					+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
					+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
					+ "on(md.id=top1.substitution_drug)\r\n"
					+"JOIN soch.beneficiary_transit_facility btf on (btf.ti_ost_beneficiary_id=tob.id) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
					+ drugtypeId + " AND tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=true AND (btf.facility_id="+facilityId+ ")";

		} else {
			/*subQuery = " WHERE tob.ost_status_id =2 AND b.client_status_id IN (1,7) AND top1.substitution_drug="
					+ drugtypeId + " and tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")";  */
			subQuery = " AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")"; 
		}
		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}
	
	public static String getCountForSearchQuery(Long facilityId, String name, Long drugtypeId, LocalDate date,
			Boolean isTransit) {
		String subQuery = null;

		String searchQuery = "select count (res1.ti_ost_beneficiary_id) as tiOstBeneficiaryId \r\n"
				+ "from soch.ti_ost_beneficiary tob join \r\n"
				+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
				+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
				+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
				+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
				+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
				+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
				+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
				+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
				+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
				+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
				+ "on(md.id=top1.substitution_drug) join soch.master_gender mg on(b.gender_id=mg.id) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
				+ drugtypeId + " AND tob.consent_taken_date<='%" + date + "%'" 
				+ " \r\n";
		if (name != null && name.length() != 0) {
			searchQuery = searchQuery
					+ " AND b.first_name like '%" + name
					+ "%'";
		}
		if (isTransit.equals(Boolean.TRUE)) {
			searchQuery = "select distinct res1.ti_ost_beneficiary_id as tiOstBeneficiaryId,top1.id as tiOstPrescriptionId,\r\n"
					+ "tob.ost_number as ostNumber,tob.linked_facility_id as linkedFacilityId,b.uid as uid,b.first_name as firstName,\r\n"
					+ "b.last_name as secondName, b.gender as sex,b.age as age, md.name as drug,\r\n"
					+ "top1.dosage_qty as dosage from soch.ti_ost_beneficiary tob join \r\n"
					+ "(select top.ti_ost_beneficiary_id, max(top.id) as maxId \r\n"
					+ "from soch.ti_ost_prescription top group by top.ti_ost_beneficiary_id ) res1\r\n"
					+ "on (tob.id = res1.ti_ost_beneficiary_id)\r\n"
					+ "join(select toa.ti_ost_beneficiary_id,max(toa.id) as maxId \r\n"
					+ "from soch.ti_ost_assessment toa group by toa.ti_ost_beneficiary_id) \r\n"
					+ "res2 on tob.id=res2.ti_ost_beneficiary_id\r\n"
					+ "join soch.ti_ost_prescription top1 on (top1.id = res1.maxId) \r\n"
					+ "join soch.ti_ost_assessment toa1 on(toa1.id=res2.maxId) join \r\n"
					+ "soch.master_client_status_ost mcs on(tob.status_id=mcs.id) join \r\n"
					+ "soch.beneficiary b on(b.id=tob.beneficiary_id) join soch.master_drugs md\r\n"
					+ "on(md.id=top1.substitution_drug)\r\n"
					+"JOIN soch.beneficiary_transit_facility btf on (btf.ti_ost_beneficiary_id=tob.id) WHERE tob.ost_status_id =2 AND mcs.id IN (1,7) AND top1.substitution_drug="
					+ drugtypeId + " AND tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=true AND (btf.facility_id="+facilityId+ ")";

		} else {
			/*subQuery = " WHERE tob.ost_status_id =2 AND b.client_status_id IN (1,7) AND top1.substitution_drug="
					+ drugtypeId + " and tob.consent_taken_date<='%" + date + "%'"
					+ " AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")";  */
			subQuery = " AND tob.is_transit=false AND( tob.facility_id=" + facilityId + " OR linked_facility_id="
					+ facilityId + ")"; 
		}
		if (subQuery != null) {
			searchQuery = searchQuery + subQuery;
		}
		return searchQuery;
	}

	public static List<TiOstBeneficiaryDispensationDto> mapTiOstProjectionToTiOstBeneficiary(
			List<TIDispensationExpectedList> expectedBeneficiaryList, Long drugTypeId, LocalDate date) {
		List<TiOstBeneficiaryDispensationDto> expectedClientList = new ArrayList<TiOstBeneficiaryDispensationDto>();
		expectedBeneficiaryList.forEach(beneficiary -> {
			TiOstBeneficiaryDispensationDto expectedClient = new TiOstBeneficiaryDispensationDto();
			if (beneficiary.getTiOstBeneficiaryId()!=null) {
				expectedClient.setTiOstBeneficiaryId(beneficiary.getTiOstBeneficiaryId().longValue());
			}
			if (beneficiary.getAge()!=null) {
				expectedClient.setAge(beneficiary.getAge());
			}
			if (beneficiary.getFirstName() !=null && beneficiary.getSecondName()!=null) {
				expectedClient.setBeneficiaryName(beneficiary.getFirstName() + " " + beneficiary.getSecondName());
			}
			if(beneficiary.getSex()!=null) {
				expectedClient.setSex(beneficiary.getSex());
			}
			if(beneficiary.getTiOstPrescriptionId()!=null) {
				expectedClient.setTiOstPrescriptionId(beneficiary.getTiOstPrescriptionId().longValue());
			}
			if(beneficiary.getDrug()!=null) {
				expectedClient.setDrug(beneficiary.getDrug());
			}
			if(beneficiary.getDosage()!=null) {
				expectedClient.setDosage(beneficiary.getDosage().doubleValue());
			}
			if(beneficiary.getOstNumber()!=null) {
				expectedClient.setOstNumber(beneficiary.getOstNumber());
			}
			expectedClient.setUid(beneficiary.getUid());
			if (beneficiary.getDrug().startsWith("Buprenorphine")) {
				if (beneficiary.getDosage() != null) {
					expectedClient = findNumberOfTabletsByDosage(beneficiary.getDosage().doubleValue(), expectedClient);
				}
			}
			expectedClientList.add(expectedClient);

		});
		return expectedClientList;
	}

}
