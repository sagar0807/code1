package gov.naco.soch.inventory.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.GoodsRequestDto;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.GoodsRequest;
import gov.naco.soch.entity.IndentReasonsMaster;
import gov.naco.soch.entity.IndentRequestStatusMaster;
import gov.naco.soch.entity.Product;
import gov.naco.soch.exception.ServiceException;
import gov.naco.soch.inventory.controller.GoodsRequestController;
import gov.naco.soch.inventory.mapper.GoodsRequestMapperUtil;
import gov.naco.soch.repository.FacilityRepository;
import gov.naco.soch.repository.GoodsRequestRepository;
import gov.naco.soch.repository.IndentReasonsMasterRepository;
import gov.naco.soch.repository.IndentRequestStatusMasterRepository;
import gov.naco.soch.repository.ProductRepository;

@Service
public class GoodsRequestService {

	private static final Logger logger = LoggerFactory.getLogger(GoodsRequestController.class);

	@Autowired
	private GoodsRequestRepository goodsRequestRepository;

	@Autowired
	private IndentReasonsMasterRepository indentReasonsMasterRepository;

	@Autowired
	private IndentRequestStatusMasterRepository indentRequestStatusMasterRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ProductRepository productRepository;

	public GoodsRequestDto saveGoodsRequest(@Valid GoodsRequestDto goodsRequestDto) {
		logger.debug("In saveGoodsRequest() of GoodsRequestService");

		Optional<Facility> facilityOpt = facilityRepository.findById(goodsRequestDto.getFacilityId());

		if (facilityOpt.isPresent()) {
			GoodsRequest goodsRequest = new GoodsRequest();
			goodsRequest.setFacility(facilityOpt.get());

			Optional<Facility> sacsOpt = facilityRepository.findById(facilityOpt.get().getSacsId());
			if (sacsOpt.isPresent()) {
				goodsRequest.setSacs(sacsOpt.get());

				Optional<Product> productOpt = productRepository.findById(goodsRequestDto.getProductId());

				if (productOpt.isPresent()) {

					goodsRequest.setProduct(productOpt.get());

					Optional<IndentReasonsMaster> reason = indentReasonsMasterRepository
							.findById(goodsRequestDto.getIndentReasonId());

					IndentRequestStatusMaster status = indentRequestStatusMasterRepository
							.findByIndentRequestStatusNameAndIsDelete("Requested", Boolean.FALSE);
					if (reason.isPresent() && status != null) {
						goodsRequest.setRequestedQuantity(goodsRequestDto.getRequestedQuantity());
						goodsRequest.setRequestedDeliveryDate(goodsRequestDto.getRequestedDeliveryDate());
						goodsRequest.setRequestedDate(LocalDate.now());
						goodsRequest.setIndentReason(reason.get());
						goodsRequest.setGoodsRequestStatus(status);
						goodsRequest.setIsDispatched(Boolean.FALSE);
						goodsRequest.setIsActive(Boolean.TRUE);
						goodsRequest.setIsDelete(Boolean.FALSE);

						goodsRequest = goodsRequestRepository.save(goodsRequest);

						String indentNumber = "IND" + StringUtils.leftPad(goodsRequest.getId().toString(), 13, "0");
						goodsRequest.setIndentNumber(indentNumber);
						goodsRequest = goodsRequestRepository.save(goodsRequest);
						goodsRequestDto.setId(goodsRequest.getId());
						goodsRequestDto.setIndentNumber(indentNumber);
						return GoodsRequestMapperUtil.mapToGoodsRequestDto(goodsRequest);
					} else {
						throw new ServiceException("Invalid status or reason", null, HttpStatus.BAD_REQUEST);
					}
				} else {
					throw new ServiceException("Invalid Product Id", null, HttpStatus.BAD_REQUEST);
				}

			} else {
				throw new ServiceException("Invalid Facility Id", null, HttpStatus.BAD_REQUEST);
			}

		} else {
			throw new ServiceException("Invalid Facility Id", null, HttpStatus.BAD_REQUEST);
		}
	}

	public List<GoodsRequestDto> fetchGoodsRequestForSacs(Long sacsId, String indentNumber, String productName) {
		logger.debug("In fetchGoodsRequestForSacs() of GoodsRequestService");
		Optional<Facility> facilityOpt = facilityRepository.findById(sacsId);
		if (facilityOpt.isPresent()) {
			List<GoodsRequest> goodsRequestList=new ArrayList<>();
			if(indentNumber==null&&productName==null) {
				goodsRequestList = goodsRequestRepository.findBySacsId(sacsId);
			}else {
				String searchQuery=GoodsRequestMapperUtil.createSearchQueryForGoodsRequestForSacs(sacsId,indentNumber,productName);
				goodsRequestList = goodsRequestRepository.findGoodsRequestForSacsBySearchValue(searchQuery);
			}

			

			if (!CollectionUtils.isEmpty(goodsRequestList)) {

				List<GoodsRequestDto> dtoList = goodsRequestList.stream()
						.map(g -> GoodsRequestMapperUtil.mapToGoodsRequestDto(g)).collect(Collectors.toList());
				return dtoList;
			}
		} else {
			throw new ServiceException("Invalid Facility Id", null, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	public List<GoodsRequestDto> fetchGoodsRequestForFacility(Long facilityId, String indentNumber, String productName) {
		logger.debug("In fetchGoodsRequestForFacility() of GoodsRequestService");
		Optional<Facility> facilityOpt = facilityRepository.findById(facilityId);
		if (facilityOpt.isPresent()) {
			
			List<GoodsRequest> goodsRequestList=new ArrayList<GoodsRequest>();
			
			if(indentNumber==null&&productName==null) {
				goodsRequestList = goodsRequestRepository.findByFacilityId(facilityId);
			}else {
				String searchQuery=GoodsRequestMapperUtil.createSearchQuery(facilityId,indentNumber,productName);
				goodsRequestList = goodsRequestRepository.findGoodsRequestBySearchValue(searchQuery);
			}

			if (!CollectionUtils.isEmpty(goodsRequestList)) {

				List<GoodsRequestDto> dtoList = goodsRequestList.stream()
						.map(g -> GoodsRequestMapperUtil.mapToGoodsRequestDto(g)).collect(Collectors.toList());
				return dtoList;
			}
		} else {
			throw new ServiceException("Invalid Facility Id", null, HttpStatus.BAD_REQUEST);
		}
		return null;
	}

	public GoodsRequestDto approveGoodsRequest(Long requestId, @Valid GoodsRequestDto goodsRequestDto) {
		logger.debug("In approveGoodsRequest() of GoodsRequestService");

		Optional<GoodsRequest> requestOpt = goodsRequestRepository.findById(requestId);

		if (requestOpt.isPresent()) {

			GoodsRequest request = requestOpt.get();

			IndentRequestStatusMaster status = indentRequestStatusMasterRepository
					.findByIndentRequestStatusNameAndIsDelete("Approved", Boolean.FALSE);

			request.setApprovedDate(LocalDate.now());
			request.setApprovedQuantity(goodsRequestDto.getApprovedQuantity());
			request.setEstimateDeliveryDate(goodsRequestDto.getEstimateDeliveryDate());
			request.setGoodsRequestStatus(status);
			request = goodsRequestRepository.save(request);
			return GoodsRequestMapperUtil.mapToGoodsRequestDto(request);

		} else {
			throw new ServiceException("Invalid Goods Request Id", null, HttpStatus.BAD_REQUEST);
		}
	}

	public GoodsRequestDto rejectGoodsRequest(Long requestId) {
		logger.debug("In rejectGoodsRequest() of GoodsRequestService");
		Optional<GoodsRequest> requestOpt = goodsRequestRepository.findById(requestId);

		if (requestOpt.isPresent()) {
			GoodsRequest request = requestOpt.get();

			IndentRequestStatusMaster status = indentRequestStatusMasterRepository
					.findByIndentRequestStatusNameAndIsDelete("Rejected", Boolean.FALSE);

			request.setGoodsRequestStatus(status);
			request = goodsRequestRepository.save(request);
			return GoodsRequestMapperUtil.mapToGoodsRequestDto(request);

		} else {
			throw new ServiceException("Invalid Goods Request Id", null, HttpStatus.BAD_REQUEST);
		}
	}

	public GoodsRequestDto fetchPreviousGoodsRequestForProductInFacility(Long productId, Long facilityId) {

		List<GoodsRequest> goodsRequestList = goodsRequestRepository.findByProductIdAndFacilityId(productId,
				facilityId);
		Optional<GoodsRequest> request = goodsRequestList.stream().findFirst();
		if (request.isPresent()) {
			return GoodsRequestMapperUtil.mapToGoodsRequestDto(request.get());
		}
		return null;
	}

}
