package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.DesignationDto;
import gov.naco.soch.dto.MachineDto;
import gov.naco.soch.entity.Machine;

public class MachineMapperUtil {

	public static List<MachineDto> mapToMachineDto(List<Machine> machineList) {
		List<MachineDto> machineDtoList = new ArrayList<MachineDto>();
		if (!CollectionUtils.isEmpty(machineList)) {
			machineList.forEach(machine -> {
				MachineDto machineDto = new MachineDto();
				machineDto.setId(machine.getId());
				machineDto.setName(machine.getMachineName());
				machineDto.setIsActive(machine.getIsActive());
				machineDto.setStatus(machine.getStatus());
				machineDto.setIsDelete(machine.getIsDelete());
				machineDtoList.add(machineDto);
			});
		}
		return machineDtoList;

	}

}
