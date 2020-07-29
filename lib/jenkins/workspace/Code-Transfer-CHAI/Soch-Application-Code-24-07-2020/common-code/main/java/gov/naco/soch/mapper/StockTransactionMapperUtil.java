package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.StockTransactionDto;
import gov.naco.soch.projection.StockTransactionProjection;

public class StockTransactionMapperUtil {
	
	public static List<StockTransactionDto> mapToStockTransactionSet(List<StockTransactionProjection> stockTransactionList){
		List<StockTransactionDto> stockTransactionDtos = new ArrayList<StockTransactionDto>();
		if (!CollectionUtils.isEmpty(stockTransactionList)) {
			stockTransactionList.forEach(stockTransaction -> {

				StockTransactionDto stockTransactionDto = new StockTransactionDto();

				stockTransactionDto.setStrCenName(stockTransaction.getStrCenName());
				stockTransactionDto.setStrPrdName(stockTransaction.getStrPrdName());
				stockTransactionDto.setStrTrnDate(stockTransaction.getStrTrnDate());
				stockTransactionDto.setStrTrnType(stockTransaction.getStrTrnType());
				stockTransactionDto.setStrDepTbs(stockTransaction.getStrDepTbs());
				stockTransactionDto.setStrWdlTbs(stockTransaction.getStrWdlTbs());
				stockTransactionDto.setStrBalance(stockTransaction.getStrBalance());
				stockTransactionDto.setStrTrnRem(stockTransaction.getStrTrnRem());
				stockTransactionDtos.add(stockTransactionDto);

			});
		}
		return stockTransactionDtos;
		
	}

}
