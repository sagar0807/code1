package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import gov.naco.soch.dto.OrwPeMappingDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.OrwPeMapping;
import gov.naco.soch.entity.UserMaster;

public class OrwPeMapperUtil {

	public static List<OrwPeMapping> mapToOrwPeMappingList(OrwPeMappingDto orwPeMappingDto) {
		List<OrwPeMapping> orwPeMappings = new ArrayList<>();
		UserMaster orwUser = new UserMaster();
		orwUser.setId(orwPeMappingDto.getOrwUser().getId());
		for (UserMasterDto peUserDto : orwPeMappingDto.getPeUsers()) {
			OrwPeMapping orwPeMapping = new OrwPeMapping();
			UserMaster peUser = new UserMaster();
			peUser.setId(peUserDto.getId());
			orwPeMapping.setIsActive(true);
			orwPeMapping.setIsDelete(false);
			orwPeMapping.setOrwUser(orwUser);
			orwPeMapping.setPeUser(peUser);
			orwPeMappings.add(orwPeMapping);
		}
		return orwPeMappings;
	}

	public static List<UserMaster> findPeListForDropdownFromTotalResult(List<UserMaster> resultList) {
		List<UserMaster> userList = new ArrayList<>();
		for (UserMaster userMaster : resultList) {
			boolean isPe = false;
			if (userMaster.getPeUsers().isEmpty()) {
				isPe = true;
			} else {
				List<OrwPeMapping> list = userMaster.getPeUsers().stream().collect(Collectors.toList());
				Collections.sort(list);
				for (OrwPeMapping orwPeMapping : list) {
					if (orwPeMapping.getIsDelete()) {
						isPe = true;
					}else {
						isPe=false;
						break;
					}
				}
			}
			if (isPe) {
				userList.add(userMaster);
			}
		}
		return userList;
	}

	public static OrwPeMapping mapToOrwPeMapping(OrwPeMappingDto orwPeMappingDto) {
		OrwPeMapping orwPeMapping = new OrwPeMapping();
		UserMaster orwUser = new UserMaster();
		orwUser.setId(orwPeMappingDto.getOrwUser().getId());
		for (UserMasterDto peUserDto : orwPeMappingDto.getPeUsers()) {		
			UserMaster peUser = new UserMaster();
			peUser.setId(peUserDto.getId());
			orwPeMapping.setIsActive(true);
			orwPeMapping.setIsDelete(false);
			orwPeMapping.setOrwUser(orwUser);
			orwPeMapping.setPeUser(peUser);
		}
		return orwPeMapping;
	}

}
