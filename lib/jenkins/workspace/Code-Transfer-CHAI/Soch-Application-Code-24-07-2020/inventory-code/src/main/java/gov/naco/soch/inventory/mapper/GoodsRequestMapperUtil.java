package gov.naco.soch.inventory.mapper;

import gov.naco.soch.dto.GoodsRequestDto;
import gov.naco.soch.entity.GoodsRequest;

public class GoodsRequestMapperUtil {

	public static GoodsRequestDto mapToGoodsRequestDto(GoodsRequest goodsRequest) {
		GoodsRequestDto dto = new GoodsRequestDto();

		dto.setId(goodsRequest.getId());

		if (goodsRequest.getProduct() != null) {
			dto.setProductId(goodsRequest.getProduct().getId());
			dto.setProductName(goodsRequest.getProduct().getProductName());
		}

		dto.setRequestedQuantity(goodsRequest.getRequestedQuantity());
		dto.setRequestedDeliveryDate(goodsRequest.getRequestedDeliveryDate());
		dto.setRequestedDate(goodsRequest.getRequestedDate());

		dto.setIndentNumber(goodsRequest.getIndentNumber());
		dto.setApprovedQuantity(goodsRequest.getApprovedQuantity());
		dto.setEstimateDeliveryDate(goodsRequest.getEstimateDeliveryDate());
		dto.setApprovedDate(goodsRequest.getApprovedDate());
		dto.setIsDispatched(goodsRequest.getIsDispatched());

		if (goodsRequest.getIndentReason() != null) {
			dto.setIndentReasonId(goodsRequest.getIndentReason().getId());
			dto.setIndentReason(goodsRequest.getIndentReason().getIndentReasonsName());
		}

		if (goodsRequest.getGoodsRequestStatus() != null) {
			dto.setGoodsRequestStatusId(goodsRequest.getGoodsRequestStatus().getId());
			dto.setGoodsRequestStatus(goodsRequest.getGoodsRequestStatus().getIndentRequestStatusName());
		}

		if (goodsRequest.getFacility() != null) {
			dto.setFacilityId(goodsRequest.getFacility().getId());
			dto.setFacilityName(goodsRequest.getFacility().getName());
			dto.setFacilityAddress(goodsRequest.getFacility().getAddress().getAddress());
		}

		if (goodsRequest.getSacs() != null) {
			dto.setSacsId(goodsRequest.getSacs().getId());
			dto.setSacsName(goodsRequest.getSacs().getName());
			dto.setSacsAddress(goodsRequest.getSacs().getAddress().getAddress());
		}

		return dto;
	}

	public static String createSearchQuery(Long facilityId, String indentNumber, String productName) {

		String subQuery = null;

		String searchQuery = "select * from soch.goods_request gr where gr.facility_id=" + facilityId + "\r\n";
		if (indentNumber != null && productName == null) {
			indentNumber = indentNumber.toLowerCase();
			subQuery = "select * from soch.goods_request gr where gr.facility_id=" + facilityId + "\r\n"
					+ " and LOWER(gr.indent_num) like '%" + indentNumber + "%'";
		} else if (productName != null && indentNumber == null) {
			productName = productName.toLowerCase();
			subQuery = "select * from soch.goods_request gr join soch.product p on(p.id=gr.product_id)\r\n"
					+ "where gr.facility_id=" + facilityId + "\r\n" + " and LOWER(p.product_name) like '%" + productName
					+ "%'";
		} else if (productName != null && indentNumber != null) {
			productName = productName.toLowerCase();
			indentNumber = indentNumber.toLowerCase();
			subQuery = "select * from soch.goods_request gr join soch.product p on(p.id=gr.product_id)\r\n"
					+ "where gr.facility_id=" + facilityId + "\r\n" + "and gr.indent_num like '%" + indentNumber
					+ "%' and LOWER(p.product_name) like '%" + productName + "%'";
		}

		if (subQuery != null) {
			return subQuery;
		} else {
			return searchQuery;
		}

	}

	public static String createSearchQueryForGoodsRequestForSacs(Long sacsId, String indentNumber, String productName) {
		String searchQuery = "select * from soch.goods_request g join soch.product p on(p.id=g.product_id)"
				+ " where g.sacs_id =" + sacsId;
		if (indentNumber != null) {
			indentNumber = indentNumber.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(g.indent_num) like '%" + indentNumber + "%'";
		}
		if (productName != null) {
			productName = productName.toLowerCase().trim();
			searchQuery = searchQuery + " and LOWER(p.product_name) like '%" + productName + "%'";
		}
		return searchQuery;
	}
}
