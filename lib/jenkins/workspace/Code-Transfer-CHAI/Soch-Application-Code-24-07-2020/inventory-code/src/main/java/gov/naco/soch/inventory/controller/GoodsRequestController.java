package gov.naco.soch.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.GoodsRequestDto;
import gov.naco.soch.inventory.service.GoodsRequestService;

@RestController
@RequestMapping("/goodsrequest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GoodsRequestController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsRequestController.class);

	@Autowired
	private GoodsRequestService goodsRequestService;

	@PostMapping("/save")
	public GoodsRequestDto saveGoodsRequest(@Valid @RequestBody GoodsRequestDto goodsRequestDto) {
		logger.debug("saveGoodsRequest method is invoked");
		return goodsRequestService.saveGoodsRequest(goodsRequestDto);
	}

	@GetMapping("/list/sacs/{sacsId}")
	public List<GoodsRequestDto> fetchGoodsRequestForSacs(@PathVariable("sacsId") Long sacsId,
			@RequestParam(value="indentNumber",required=false)String indentNumber,
			@RequestParam(value="productName",required=false)String productName) {
		logger.debug("fetchGoodsRequestForSacs method is invoked");
		return goodsRequestService.fetchGoodsRequestForSacs(sacsId,indentNumber,productName);
	}

	@GetMapping("/list/facility/{facilityId}")
	public List<GoodsRequestDto> fetchGoodsRequestForFacility(@PathVariable("facilityId") Long facilityId,
			@RequestParam(value="indentNumber",required=false)String indentNumber,
			@RequestParam(value="productName",required=false)String productName) {
		logger.debug("fetchGoodsRequestForFacility method is invoked");
		return goodsRequestService.fetchGoodsRequestForFacility(facilityId,indentNumber,productName);
	}

	@PostMapping("/approve/{requestId}")
	public GoodsRequestDto approveGoodsRequest(@PathVariable("requestId") Long requestId,
			@Valid @RequestBody GoodsRequestDto goodsRequestDto) {
		logger.debug("approveGoodsRequest method is invoked");
		return goodsRequestService.approveGoodsRequest(requestId, goodsRequestDto);
	}

	@PostMapping("/reject/{requestId}")
	public GoodsRequestDto rejectGoodsRequest(@PathVariable("requestId") Long requestId) {
		logger.debug("rejectgoodsRequest method is invoked");
		return goodsRequestService.rejectGoodsRequest(requestId);
	}
	
	@GetMapping("/previousrequest/{productId}/{facilityId}")
	public GoodsRequestDto fetchPreviousGoodsRequestForProductInFacility(@PathVariable("productId") Long productId, @PathVariable("facilityId") Long facilityId) {
		logger.debug("fetchGoodsRequestForFacility method is invoked");
		return goodsRequestService.fetchPreviousGoodsRequestForProductInFacility(productId, facilityId);
	}


}
