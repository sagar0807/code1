package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.ProductDispatchHistoryDto;
import gov.naco.soch.dto.RemarkDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.FacilityConsignmentStatusMaster;
import gov.naco.soch.entity.FacilityDispatch;
import gov.naco.soch.entity.FacilityDispatchReceiptRemark;
import gov.naco.soch.entity.FacilityDispatchStatusMaster;
import gov.naco.soch.entity.FacilityReceipt;
import gov.naco.soch.entity.FacilityRelocationRequestStatusMaster;
import gov.naco.soch.enums.DispatchStatusEnum;
import gov.naco.soch.inventory.mapper.DispatchMapperUtil;
import gov.naco.soch.repository.FacilityDispatchRepository;
import gov.naco.soch.repository.FacilityReceiptRepository;
import gov.naco.soch.repository.FacilityRepository;

@Service
public class FacilityRelocationService {

	private static final Logger logger = LoggerFactory.getLogger(FacilityRelocationService.class);

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private FacilityDispatchRepository facilityDispatchRepository;

	@Autowired
	private FacilityReceiptRepository facilityReceiptRepository;

	public List<ProductDispatchHistoryDto> fetchFacilityRelocationListToFacility(Long facilityId) {

		logger.debug("In fetchFacilityRelocationListToFacility of FacilityRelocationService");

		List<Long> consignorIdList = new ArrayList<>();
		consignorIdList.add(facilityId);

		List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId, Boolean.FALSE,
				Boolean.TRUE);
		if (!CollectionUtils.isEmpty(facilityList)) {
			List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
			consignorIdList.addAll(facilityIds);
		}

		List<FacilityDispatch> facilityDispatchList = facilityDispatchRepository
				.findByConsignorIdsForRelocate(consignorIdList);
		if (!CollectionUtils.isEmpty(facilityDispatchList)) {
			List<ProductDispatchHistoryDto> relocateList = DispatchMapperUtil
					.mapFacilityDispatchListToProductDispatchHistoryDtoList(facilityDispatchList);
			relocateList.forEach(relocate -> {
				FacilityReceipt facilityReceipt = facilityReceiptRepository
						.findByFacilityDispatch_FacilityDispatchId(relocate.getFacilityDispatchId());
				if (facilityReceipt != null) {
					if (facilityReceipt.getFacilityReceiptStatusMaster() != null) {
						relocate.setReceiptStatus(facilityReceipt.getFacilityReceiptStatusMaster().getStatus());
					}
				} else {
					if (relocate.getRequestStatusId() == 3L) {
						relocate.setReceiptStatus(DispatchStatusEnum.REJECTED.getDispatchStatus());
					} else {
						relocate.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
					}
				}
			});
			return relocateList;
		}
		return null;
	}

	public Boolean approveRelocation(Long facilityDispatchId, String status, @Valid RemarkDto remarkDto) {
		FacilityRelocationRequestStatusMaster facilityRelocationRequestStatusMaster = new FacilityRelocationRequestStatusMaster();
		FacilityDispatchStatusMaster facilityDispatchStatusMaster = new FacilityDispatchStatusMaster();
		FacilityConsignmentStatusMaster facilityConsignmentStatusMaster = new FacilityConsignmentStatusMaster();
		if (status.equalsIgnoreCase("approve")) {
			facilityRelocationRequestStatusMaster.setId(2L);
			facilityDispatchStatusMaster.setId(2L);
		} else if (status.equalsIgnoreCase("reject")) {
			facilityRelocationRequestStatusMaster.setId(3L);
			facilityConsignmentStatusMaster.setId(4L);
		}
		FacilityDispatch facilityDispatch = facilityDispatchRepository.findByFacilityDispatchId(facilityDispatchId);
		if (facilityDispatch != null) {

			facilityDispatch.setFacilityRelocationRequestStatusMaster(facilityRelocationRequestStatusMaster);
			if (facilityDispatchStatusMaster.getId() != null) {
				facilityDispatch.setFacilityDispatchStatusMaster(facilityDispatchStatusMaster);
			}
			if (facilityConsignmentStatusMaster.getId() != null) {
				facilityDispatch.setFacilityConsignmentStatusMaster(facilityConsignmentStatusMaster);
			}

			if (remarkDto.getRemarks() != "") {
				FacilityDispatchReceiptRemark remark = new FacilityDispatchReceiptRemark();
				remark.setRemarks(remarkDto.getRemarks());
				remark.setFacilityDispatch(facilityDispatch);
				if (facilityDispatchStatusMaster.getId() != null) {
					remark.setFacilityDispatchStatusMaster(facilityDispatchStatusMaster);
				} else {
					remark.setFacilityDispatchStatusMaster(facilityDispatch.getFacilityDispatchStatusMaster());
				}
				remark.setIsActive(Boolean.TRUE);
				remark.setIsDelete(Boolean.FALSE);

				Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarkSet = new HashSet<>();
				facilityDispatchReceiptRemarkSet.add(remark);
				facilityDispatch.setFacilityDispatchReceiptRemarks(facilityDispatchReceiptRemarkSet);
			}

			facilityDispatchRepository.save(facilityDispatch);

			return true;
		}
		return false;
	}

	public List<ProductDispatchHistoryDto> fetchFacilityRelocationHistoryBysearchValue(Long facilityId,
			String stnNumber, String consignee, LocalDate dispatchDate, String productName) {
		logger.debug("In fetchFacilityRelocationHistoryBysearchValue of FacilityRelocationService");

		List<Long> consignorIdList = new ArrayList<>();
		consignorIdList.add(facilityId);

		List<Facility> facilityList = facilityRepository.findBySacsIdAndIsDeleteAndIsActive(facilityId, Boolean.FALSE,
				Boolean.TRUE);
		if (!CollectionUtils.isEmpty(facilityList)) {
			List<Long> facilityIds = facilityList.stream().map(f -> f.getId()).collect(Collectors.toList());
			consignorIdList.addAll(facilityIds);
		}

		String searchQuery = DispatchMapperUtil.createSearchQuery(consignorIdList, stnNumber, consignee, dispatchDate,
				productName);

		List<FacilityDispatch> facilityDispatchList = facilityDispatchRepository.findBysearchValue(searchQuery);
		if (!CollectionUtils.isEmpty(facilityDispatchList)) {
			List<ProductDispatchHistoryDto> relocateList = DispatchMapperUtil
					.mapFacilityDispatchListToProductDispatchHistoryDtoList(facilityDispatchList);
			relocateList.forEach(relocate -> {
				FacilityReceipt facilityReceipt = facilityReceiptRepository
						.findByFacilityDispatch_FacilityDispatchId(relocate.getFacilityDispatchId());
				if (facilityReceipt != null) {
					if (facilityReceipt.getFacilityReceiptStatusMaster() != null) {
						relocate.setReceiptStatus(facilityReceipt.getFacilityReceiptStatusMaster().getStatus());
					}
				} else {
					if (relocate.getRequestStatusId() == 3L) {
						relocate.setReceiptStatus(DispatchStatusEnum.REJECTED.getDispatchStatus());
					} else {
						relocate.setReceiptStatus(DispatchStatusEnum.PENDING.getDispatchStatus());
					}

				}
			});
			return relocateList;
		}
		return null;
	}

}
