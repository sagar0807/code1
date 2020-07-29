package gov.naco.soch.dto;

import java.time.LocalDate;
import java.util.List;

public class DispensationDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate dispenseDate;
	private String dispensedTo;
	private String facProdStockTransId;
	private Boolean isActive;
	private Boolean isDelete;
	private Long beneficiaryId;
	private Long facilityId;
	//Objects below are added by Rishad Basheer
	private int dispensedQty;
	private LocalDate visitDate;
	private String productDispensed;
	private String adherence;
	private int remainingPills;
	private LocalDate nextAppointmentDate;
    public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}


	//
	private BeneficiaryDto beneficiaryDto;
	private FacilityDto facilityDto;
	
	private List<DispensationItemDto> dispensationItemDtoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	  

	public LocalDate getDispenseDate() {
		return dispenseDate;
	}

	public void setDispenseDate(LocalDate dispenseDate) {
		this.dispenseDate = dispenseDate;
	}


	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getDispensedTo() {
		return dispensedTo;
	}

	public void setDispensedTo(String dispensedTo) {
		this.dispensedTo = dispensedTo;
	}

	public String getFacProdStockTransId() {
		return facProdStockTransId;
	}

	public void setFacProdStockTransId(String facProdStockTransId) {
		this.facProdStockTransId = facProdStockTransId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public BeneficiaryDto getBeneficiaryDto() {
		return beneficiaryDto;
	}

	public void setBeneficiaryDto(BeneficiaryDto beneficiaryDto) {
		this.beneficiaryDto = beneficiaryDto;
	}

	public FacilityDto getFacilityDto() {
		return facilityDto;
	}

	public void setFacilityDto(FacilityDto facilityDto) {
		this.facilityDto = facilityDto;
	}

	public List<DispensationItemDto> getDispensationItemDtoList() {
		return dispensationItemDtoList;
	}

	public void setDispensationItemDtoList(List<DispensationItemDto> dispensationItemDtoList) {
		this.dispensationItemDtoList = dispensationItemDtoList;
	}
	
	
	public int getDispensedQty() {
		return dispensedQty;
	}

	public void setDispensedQty(int dispensedQty) {
		this.dispensedQty = dispensedQty;
	}

	public String getProductDispensed() {
		return productDispensed;
	}

	public void setProductDispensed(String productDispensed) {
		this.productDispensed = productDispensed;
	}
	

	public String getAdherence() {
		return adherence;
	}

	public void setAdherence(String adherence) {
		this.adherence = adherence;
	}

	public int getRemainingPills() {
		return remainingPills;
	}

	public void setRemainingPills(int remainingPills) {
		this.remainingPills = remainingPills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	


	@Override
	public String toString() {
		return "DispensationDto [id=" + id + ", dispenseDate=" + dispenseDate + ", dispensedTo=" + dispensedTo
				+ ", facProdStockTransId=" + facProdStockTransId + ", isActive=" + isActive + ", isDelete=" + isDelete
				+ ", beneficiaryId=" + beneficiaryId + ", facilityId=" + facilityId + ", beneficiaryDto="
				+ beneficiaryDto + ", facilityDto=" + facilityDto + ", dispensationItemDtoList="
				+ dispensationItemDtoList + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DispensationDto other = (DispensationDto) obj;
		if (beneficiaryDto == null) {
			if (other.beneficiaryDto != null)
				return false;
		} else if (!beneficiaryDto.equals(other.beneficiaryDto))
			return false;
		if (beneficiaryId == null) {
			if (other.beneficiaryId != null)
				return false;
		} else if (!beneficiaryId.equals(other.beneficiaryId))
			return false;
		if (dispensationItemDtoList == null) {
			if (other.dispensationItemDtoList != null)
				return false;
		} else if (!dispensationItemDtoList.equals(other.dispensationItemDtoList))
			return false;
		if (dispenseDate == null) {
			if (other.dispenseDate != null)
				return false;
		} else if (!dispenseDate.equals(other.dispenseDate))
			return false;
		if (dispensedTo == null) {
			if (other.dispensedTo != null)
				return false;
		} else if (!dispensedTo.equals(other.dispensedTo))
			return false;
		if (facProdStockTransId == null) {
			if (other.facProdStockTransId != null)
				return false;
		} else if (!facProdStockTransId.equals(other.facProdStockTransId))
			return false;
		if (facilityDto == null) {
			if (other.facilityDto != null)
				return false;
		} else if (!facilityDto.equals(other.facilityDto))
			return false;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		return true;
	}
	
	
	
}
