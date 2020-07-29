
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.InventoryStatusDto;
import gov.naco.soch.entity.InventoryStatusMaster;

public class InventoryStatusMapperUtil {

	// method to map InventoryStatus list to InventoryStatusDto list
	public static List<InventoryStatusDto> mapToInventoryStatusDto(List<InventoryStatusMaster> inventoryStatusList) {
		List<InventoryStatusDto> inventoryStatusDtos = new ArrayList<InventoryStatusDto>();
		if (!CollectionUtils.isEmpty(inventoryStatusList)) {
			inventoryStatusList.forEach(inventoryStatus -> {
				InventoryStatusDto inventoryStatusDto = new InventoryStatusDto();
				inventoryStatusDto.setId(inventoryStatus.getId());
				inventoryStatusDto.setInventoryStatusName(inventoryStatus.getInventoryStatusName().trim().toString());
				inventoryStatusDtos.add(inventoryStatusDto);
			});
		}
		return inventoryStatusDtos;
	}

	// method to map InventoryStatusDto class to InventoryStatus class.
	public static InventoryStatusMaster mapToInventoryStatus(InventoryStatusDto inventoryStatusDto,
			InventoryStatusMaster inventoryStatus) {

		if (inventoryStatus == null) {
			inventoryStatus = new InventoryStatusMaster();
		}
		if (inventoryStatusDto != null) {
			inventoryStatus.setId(inventoryStatusDto.getId());
			inventoryStatus.setInventoryStatusName(inventoryStatusDto.getInventoryStatusName().trim().toString());
		}
		return inventoryStatus;
	}

}
