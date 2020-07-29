package gov.naco.soch.inventory.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.dto.FacilityStockAdjustDto;
import gov.naco.soch.dto.FacilityStockAdjustHistoryDto;
import gov.naco.soch.dto.FacilityStockAdjustmentTypeMasterDto;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockAdjustment;
import gov.naco.soch.entity.FacilityStockAdjustmentTypeMaster;
import gov.naco.soch.entity.FacilityStockTracking;
import gov.naco.soch.inventory.mapper.FacilityStockAdjustmentMapper;
import gov.naco.soch.repository.FacilityStockAdjustmentRepository;
import gov.naco.soch.repository.FacilityStockAdjustmentTypeMasterRepository;
import gov.naco.soch.repository.FacilityStockRepository;
import gov.naco.soch.repository.FacilityStockTrackingRepository;

@Service
@Transactional
public class FacilityStockAdjustmentService {

	@Autowired
	private FacilityStockAdjustmentRepository facilityStockAdjustmentRepository;

	@Autowired
	private FacilityStockTrackingRepository facilityStockTrackingRepository;

	@Autowired
	private FacilityStockRepository facilityStockRepository;

	@Autowired
	private FacilityStockAdjustmentTypeMasterRepository facilityStockAdjustmentTypeMasterRepository;

	/**
	 * adjustStock : Method to save stock adjustment details
	 * 
	 * @param dispatchDetailedDto
	 * @return DispatchDetailedDto
	 */
	public FacilityStockAdjustDto adjustStock(@Valid FacilityStockAdjustDto facilityStockAdjustDto) {

		FacilityStockAdjustment facilityStockAdjustment = FacilityStockAdjustmentMapper
				.mapFacilityStockAdjustDtoToFacilityStockAdjustment(facilityStockAdjustDto);
		facilityStockAdjustment=facilityStockAdjustmentRepository.save(facilityStockAdjustment);

		FacilityStockTracking facilityStockTracking = FacilityStockAdjustmentMapper
				.mapToFacilityStockTracking(facilityStockAdjustDto,facilityStockAdjustment.getId());
		facilityStockTrackingRepository.save(facilityStockTracking);

		FacilityStock facilityStock = facilityStockRepository.findByBatchNumberAndProduct_IdAndFacility_Id(
				facilityStockAdjustDto.getBatchNumber(), facilityStockAdjustDto.getProductId(),
				facilityStockAdjustDto.getFacilityId());
		facilityStock = FacilityStockAdjustmentMapper.mapToFacilityStock(facilityStockAdjustDto, facilityStock);
		facilityStockRepository.save(facilityStock);
		return facilityStockAdjustDto;
	}

	public List<FacilityStockAdjustmentTypeMasterDto> getStockAdjustmentTypeWithReasons() {
		List<FacilityStockAdjustmentTypeMaster> stockAdjustmentTypes = facilityStockAdjustmentTypeMasterRepository
				.findAll();
		List<FacilityStockAdjustmentTypeMasterDto> stockAdjustmentTypeMasterDtos = FacilityStockAdjustmentMapper
				.mapFacilityStockAdjustmentTypes(stockAdjustmentTypes);

		return stockAdjustmentTypeMasterDtos;
	}

	public List<FacilityStockAdjustHistoryDto> getStockAdjustmentHistory(Long facilityId, Long productId) {

		List<FacilityStockAdjustment>facilityStockAdjustments=facilityStockAdjustmentRepository.findAllByFacility_IdAndProduct_Id(facilityId,productId);
		List<FacilityStockAdjustHistoryDto> facilityStockAdjustHistoryDtos=FacilityStockAdjustmentMapper.mapToFacilityStockAdjustHistoryDto(facilityStockAdjustments);
		return facilityStockAdjustHistoryDtos;
	}

}
