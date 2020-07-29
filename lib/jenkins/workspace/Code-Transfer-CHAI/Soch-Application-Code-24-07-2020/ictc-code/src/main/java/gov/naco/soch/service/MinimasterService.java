package gov.naco.soch.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.projection.MinimasterProjection;
import gov.naco.soch.repository.MasterDataRepository;
import gov.naco.soch.service.dto.MinimasterResponseDto;
import gov.naco.soch.enums.MinimasterEnum;

@Service
@Transactional
public class MinimasterService {

    private final MasterDataRepository masterDataRepository;

    public MinimasterService(MasterDataRepository masterDataRepository) {
	this.masterDataRepository = masterDataRepository;
    }

    public List<MinimasterProjection> get(String tableName) {

	List<MinimasterProjection> responseList = masterDataRepository.getValues(tableName);
	responseList.sort(Comparator.comparing(MinimasterProjection::getName));
	return responseList;
    }

    public MinimasterResponseDto get() {
	List<String> tables = Stream.of(MinimasterEnum.values()).sorted().map(MinimasterEnum::getTable)
		.collect(Collectors.toList());
	MinimasterResponseDto minimaster = new MinimasterResponseDto();
	tables.stream().sorted().forEach(x -> {
	    List<MinimasterProjection> responseList = get(x);
	    MinimasterEnum miniMaster = MinimasterEnum.get(x);
	    if(minimaster!=null)
	    {
	    switch (miniMaster) {
	    case GENDER:
		minimaster.setGenderList(responseList);
		break;
	    case MARITAL_STATUS:
		minimaster.setMaritalList(responseList);
		break;
	    case MASTER_OCCUPATION:
		minimaster.setOccupationList(responseList);
		break;
	    case MASTER_EDUCATION_LEVEL:
		minimaster.setEducationList(responseList);
		break;
	    case ARV_PROPHYLAXIS:
		minimaster.setArvProphylaxisList(responseList);
		break;
	    case INFANT_BREAST_FED:
		minimaster.setInfantBreastFedList(responseList);
		break;
	    case REFERRED_BY:
		minimaster.setReferredByList(responseList);
		break;
	    case PREG_TYPE_OF_CASE:
		minimaster.setPregnancyTypeOfCase(responseList);
		break;
	    case ROUTE_OF_TRANS:
		minimaster.setRouteofTransmission(responseList);
		break;
	    case NOT_TESTING_REASON:
		minimaster.setReasonforNotTesting(responseList);
		break;
	    case TB_RESULT:
		minimaster.setResultofTb(responseList);
		break;
	    case SYPHILIS_STATUS:
		minimaster.setResultofSyphilis(responseList);
		break;
	    case HIV_STATUS:
		minimaster.setHivStatusList(responseList);
		break;
	    case HIV_TYPE:
		minimaster.setHivTypeList(responseList);
		break;
	    case FOLLOW_UP_TYPE:
		minimaster.setFollowUpType(responseList);
		break;
	    case ICTC_BENEFICIARY_STATUS:
		minimaster.setBeneficiaryStatusList(responseList);
		break;
	    case PARTNER_STATUS:
		minimaster.setPartnerStatus(responseList);
		break;
	    case DELIVERY_OUTCOME:
		minimaster.setDeliveryOutcome(responseList);
		break;
	    case SAMPLE_COLLECTION_STATUS:
		minimaster.setSampleCollectionStatus(responseList);
		break;
	    case REFERRAL_STATUS:
		minimaster.setReferralStatusList(responseList);
		break;
	    case BENEFICIARY_CATEGORY:
		minimaster.setCategoryList(responseList);
		break;
//	    case TEST_TYPE:
//		minimaster.setTestTypeList(responseList);
//		break;
//	    case BATCH_STATUS:
//		minimaster.setBatchStatus(responseList);
//		break;
//	    case DBS_RESULT_STATUS:
//		minimaster.setDbsTestResultStatus(responseList);
//		break;
	    case RELATION_TYPE:
		minimaster.setRelationshipTypeList(responseList);
		break;
	    default:
		break;
	    }
	}
	});
	List<MinimasterProjection> batchstatusList = masterDataRepository.getBatchStatusValues();
	minimaster.setBatchStatus(batchstatusList);
	List<MinimasterProjection> testTypeList = masterDataRepository.getTestTypeValues();
	minimaster.setTestTypeList(testTypeList);
	List<MinimasterProjection> resultStatusList = masterDataRepository.getResultStatusValues();
	minimaster.setDbsTestResultStatus(resultStatusList);
	List<MinimasterProjection> deleteReasonList = masterDataRepository.getDeleteReasonValues();
	minimaster.setDeleteReasonList(deleteReasonList);
	return minimaster;
    }

}
