package gov.naco.soch.mapper;

import java.util.HashSet;
import java.util.Set;

import gov.naco.soch.dto.FacilityStockAdjustDto;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.entity.FacilityStockAdjustment;

public class StockAdjustMapper {

	public static FacilityStock createFacilityStockAdjustment(FacilityStock facilityStock, FacilityStockAdjustDto stockAdjustDto) {
		
		/* if(stockAdjustDto.getAction().equals("add"))
		    {
		    	//facilityStock.setCurrentQuantity(stockAdjustDto.getCurrentStock()+stockAdjustDto.getAdjustQuantity());
		    }
		    else if (stockAdjustDto.getAction().equals("subtract"))
		    {
		    	//facilityStock.setCurrentQuantity(stockAdjustDto.getCurrentStock()-stockAdjustDto.getAdjustQuantity());
		    }
		FacilityStockAdjustment fsa = new FacilityStockAdjustment();
		//fsa.setAdjustStockQuantity(stockAdjustDto.getAdjustQuantity());
		///fsa.setCurrentStockQuantity(stockAdjustDto.getCurrentStock());
		//fsa.setFacilityId(stockAdjustDto.getFacilityId());
		fsa.setType(stockAdjustDto.getAction());
		fsa.setRemark(stockAdjustDto.getRemarks());
		fsa.setReasonCode(stockAdjustDto.getReasonCode());
		fsa.setFacilityStock(facilityStock);
		Set<FacilityStockAdjustment> facilityStockAdjustments = new HashSet<>(); 
		facilityStockAdjustments.add(fsa);
		facilityStock.setFacilityStockAdjustments(facilityStockAdjustments);*/
		return facilityStock;
		
	}

}
