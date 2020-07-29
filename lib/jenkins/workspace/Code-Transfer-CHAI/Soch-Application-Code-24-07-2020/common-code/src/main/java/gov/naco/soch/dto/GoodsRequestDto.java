package gov.naco.soch.dto;

import java.time.LocalDate;

public class GoodsRequestDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long productId;
	private String productName;
	private Long requestedQuantity;
	private LocalDate requestedDeliveryDate;
	private String indentNumber;
	private Long indentReasonId;
	private String indentReason;
	private Long approvedQuantity;
	private LocalDate estimateDeliveryDate;
	private Long goodsRequestStatusId;
	private String goodsRequestStatus;
	private LocalDate requestedDate;
	private LocalDate approvedDate;
	private Long facilityId;
	private String facilityName;
	private String facilityAddress;
	private Long sacsId;
	private String sacsName;
	private String sacsAddress;
	private Boolean isDispatched;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(Long requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public LocalDate getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(LocalDate requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public Long getIndentReasonId() {
		return indentReasonId;
	}

	public void setIndentReasonId(Long indentReasonId) {
		this.indentReasonId = indentReasonId;
	}

	public String getIndentReason() {
		return indentReason;
	}

	public void setIndentReason(String indentReason) {
		this.indentReason = indentReason;
	}

	public Long getApprovedQuantity() {
		return approvedQuantity;
	}

	public void setApprovedQuantity(Long approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
	}

	public LocalDate getEstimateDeliveryDate() {
		return estimateDeliveryDate;
	}

	public void setEstimateDeliveryDate(LocalDate estimateDeliveryDate) {
		this.estimateDeliveryDate = estimateDeliveryDate;
	}

	public Long getGoodsRequestStatusId() {
		return goodsRequestStatusId;
	}

	public void setGoodsRequestStatusId(Long goodsRequestStatusId) {
		this.goodsRequestStatusId = goodsRequestStatusId;
	}

	public String getGoodsRequestStatus() {
		return goodsRequestStatus;
	}

	public void setGoodsRequestStatus(String goodsRequestStatus) {
		this.goodsRequestStatus = goodsRequestStatus;
	}

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityAddress() {
		return facilityAddress;
	}

	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
	}

	public Long getSacsId() {
		return sacsId;
	}

	public void setSacsId(Long sacsId) {
		this.sacsId = sacsId;
	}

	public String getSacsName() {
		return sacsName;
	}

	public void setSacsName(String sacsName) {
		this.sacsName = sacsName;
	}

	public String getSacsAddress() {
		return sacsAddress;
	}

	public void setSacsAddress(String sacsAddress) {
		this.sacsAddress = sacsAddress;
	}

	public Boolean getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
