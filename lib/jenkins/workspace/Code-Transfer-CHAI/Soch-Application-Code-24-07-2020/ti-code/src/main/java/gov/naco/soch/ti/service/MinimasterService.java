package gov.naco.soch.ti.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.projection.MinimasterProjection;
import gov.naco.soch.repository.MasterDataRepository;
import gov.naco.soch.ti.dto.MinimasterResponseDto;
import gov.naco.soch.ti.enums.MinimasterEnum;

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
		minimaster.setGender(responseList);
		break;
	    case HRG_SECONDARY:
		minimaster.setHrgSecondary(responseList);
		break;
	    case MARITAL_STATUS:
		minimaster.setMaritalStatus(responseList);
		break;
	    case MASTER_DESTINATION_DURATION:
		minimaster.setDestDuration(responseList);
		break;
	    case MASTER_EDUCATION_LEVEL:
		minimaster.setEducationLevel(responseList);
		break;
	    case MASTER_OCCUPATION:
		minimaster.setOccupation(responseList);
		break;
	    case MASTER_REG_DONE_AT:
		minimaster.setRegDoneAt(responseList);
		break;
	    case MASTER_STAYING_WITH:
		minimaster.setStayingWith(responseList);
		break;
	    case MIGRANT_OCCUPATION:
		minimaster.setMigrantOccupation(responseList);
		break;
	    case MOBILITY_TYPE:
		minimaster.setMobilityType(responseList);
		break;
	    case OST_BEN_STATUS:
		minimaster.setOstBenStatus(responseList);
		break;
	    case TI_BEN_STATUS:
		minimaster.setTiBenStatus(responseList);
		break;
	    default:
		break;
	    }
	}
	});
	return minimaster;
    }

}
