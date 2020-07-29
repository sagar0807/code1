package gov.naco.soch.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.UserAuthDto;
import gov.naco.soch.dto.UserMasterDto;
import gov.naco.soch.entity.UserAuth;
import gov.naco.soch.entity.UserMaster;

public class UserAuthsMapperUtil {
	
	public static Set<UserAuthDto> mapToUserAuthDtoSet(Set<UserAuth> userAuthList) {
		Set<UserAuthDto> userAuthDtos = new HashSet<UserAuthDto>();
		if (!CollectionUtils.isEmpty(userAuthList)) {
			userAuthList.forEach(userAuth -> {
				UserAuthDto userAuthDto = new UserAuthDto();
				userAuthDto.setId(userAuth.getId());
				userAuthDto.setEmail(userAuth.getEmail());
				userAuthDto.setIsActive(userAuth.getIsActive());
				userAuthDto.setIsDelete(userAuth.getIsDelete());
				userAuthDto.setLastLoginTime(userAuth.getLastLoginTime());
				userAuthDto.setPassword(userAuth.getPassword());
				userAuthDto.setUsername(userAuth.getUsername());
				UserMasterDto userMasterDto=new UserMasterDto();
				userMasterDto=UserMapperUtil.mapToUserMasterDto(userAuth.getUserMaster());
				userAuthDto.setUserMasterDto(userMasterDto);
				userAuthDtos.add(userAuthDto);
			});
		}
		return userAuthDtos;
	}
	
	// function to map UserAuthDto class to UserAuth class.
		public static UserAuth mapToUserAuth(UserAuthDto userAuthDto) {
			UserAuth userAuth = new UserAuth();
			if (userAuthDto != null) {
				userAuth.setId(userAuthDto.getId());
				userAuth.setEmail(userAuthDto.getEmail());
				userAuth.setIsActive(userAuthDto.getIsActive());
				userAuth.setIsDelete(userAuthDto.getIsDelete());
				userAuth.setLastLoginTime(userAuthDto.getLastLoginTime());
				userAuth.setPassword(userAuthDto.getPassword());
				userAuth.setUsername(userAuthDto.getUsername());
				UserMaster userMaster=new UserMaster();
				userMaster=UserMapperUtil.mapToUserMaster(userAuthDto.getUserMasterDto());
				userAuth.setUserMaster(userMaster);
			}
			return userAuth;
		}
		
		// function to map User class to UserDto class.
		public static UserAuthDto mapToUserAuthDto(UserAuth userAuth) {
			UserAuthDto userAuthDto = new UserAuthDto();
			if (userAuth != null) {
				userAuthDto.setId(userAuth.getId());
				userAuthDto.setEmail(userAuth.getEmail());
				userAuthDto.setIsActive(userAuth.getIsActive());
				userAuthDto.setIsDelete(userAuth.getIsDelete());
				userAuthDto.setLastLoginTime(userAuth.getLastLoginTime());
				userAuthDto.setPassword(userAuth.getPassword());
				userAuthDto.setUsername(userAuth.getUsername());
				UserMasterDto userMasterDto=new UserMasterDto();
				userMasterDto=UserMapperUtil.mapToUserMasterDto(userAuth.getUserMaster());
				userAuthDto.setUserMasterDto(userMasterDto);
			}
			return userAuthDto;
		}

		public static Set<UserAuthDto> mapToUserAuthDtoSetWithoutUserMaster(Set<UserAuth> userAuthList) {
			Set<UserAuthDto> userAuthDtos = new HashSet<UserAuthDto>();
			if (!CollectionUtils.isEmpty(userAuthList)) {
				userAuthList.forEach(userAuth -> {
					UserAuthDto userAuthDto = new UserAuthDto();
					userAuthDto.setId(userAuth.getId());
					userAuthDto.setEmail(userAuth.getEmail());
					userAuthDto.setIsActive(userAuth.getIsActive());
					userAuthDto.setIsDelete(userAuth.getIsDelete());
					userAuthDto.setLastLoginTime(userAuth.getLastLoginTime());
					userAuthDto.setPassword(userAuth.getPassword());
					userAuthDto.setUsername(userAuth.getUsername());
					userAuthDtos.add(userAuthDto);
				});
			}
			return userAuthDtos;
		}
		
		// function to map UserAuthDto class to UserAuth class.
			public static UserAuth mapToUserAuthWithoutUserMaster(UserAuthDto userAuthDto) {
				UserAuth userAuth = new UserAuth();
				if (userAuthDto != null) {
					userAuth.setId(userAuthDto.getId());
					userAuth.setEmail(userAuthDto.getEmail());
					userAuth.setIsActive(userAuthDto.getIsActive());
					userAuth.setIsDelete(userAuthDto.getIsDelete());
					userAuth.setLastLoginTime(userAuthDto.getLastLoginTime());
					userAuth.setPassword(userAuthDto.getPassword());
					userAuth.setUsername(userAuthDto.getUsername());
				}
				return userAuth;
			}
			
			// function to map User class to UserDto class.
			public static UserAuthDto mapToUserAuthDtoWithoutUserMaster(UserAuth userAuth) {
				UserAuthDto userAuthDto = new UserAuthDto();
				if (userAuth != null) {
					userAuthDto.setId(userAuth.getId());
					userAuthDto.setEmail(userAuth.getEmail());
					userAuthDto.setIsActive(userAuth.getIsActive());
					userAuthDto.setIsDelete(userAuth.getIsDelete());
					userAuthDto.setLastLoginTime(userAuth.getLastLoginTime());
					userAuthDto.setPassword(userAuth.getPassword());
					userAuthDto.setUsername(userAuth.getUsername());
				}
				return userAuthDto;
			}
			
			public static UserAuthDto mapToUserAuthDtoWithoutPassword(UserAuth userAuth) {
				UserAuthDto userAuthDto = new UserAuthDto();
				if (userAuth != null) {
					userAuthDto.setId(userAuth.getId());
					userAuthDto.setEmail(userAuth.getEmail());
					userAuthDto.setIsActive(userAuth.getIsActive());
					userAuthDto.setIsDelete(userAuth.getIsDelete());
					userAuthDto.setLastLoginTime(userAuth.getLastLoginTime());
					userAuthDto.setUsername(userAuth.getUsername());
				}
				return userAuthDto;
			}

}
