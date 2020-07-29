/**
 * 
 */
package gov.naco.soch.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.naco.soch.dto.GitStatusDto;
import gov.naco.soch.entity.GitStatusMaster;

/**
 * @date 2020-Dec-30 12:37:56 PM
 */

// Class to map between bean class(GitStatusDto) and entity
// class(GitStatusEntity)
public class GitStatusMapperUtil {

	// Function to map list of GitStatusEntity class to list of GitStatusDto class
	public static List<GitStatusDto> mapToGitStatusDtoList(List<GitStatusMaster> GitStatusList) {
		List<GitStatusDto> gitStatusDtos = new ArrayList<GitStatusDto>();
		if (!CollectionUtils.isEmpty(GitStatusList)) {
			GitStatusList.forEach(gitStatus -> {
				GitStatusDto gitStatusDto = new GitStatusDto();
				gitStatusDto.setId(gitStatus.getId());
				gitStatusDto.setGitStatusName(gitStatus.getGitStatusName().trim());
				gitStatusDto.setIs_active(gitStatus.getIsActive());
				gitStatusDto.setIs_delete(gitStatus.getIsDelete());
				gitStatusDtos.add(gitStatusDto);
			});
		}
		return gitStatusDtos;
	}

	// Function to map GitStatusDto class to GitStatusEntity class
	public static GitStatusMaster mapToGitStatusEntity(GitStatusDto gitStatusDto,GitStatusMaster gitStatusMaster) {
		
		if(gitStatusMaster == null) {
			gitStatusMaster = new GitStatusMaster();
		}
		if (gitStatusDto != null) {
			gitStatusMaster.setGitStatusName(gitStatusDto.getGitStatusName().trim());
			gitStatusMaster.setIsActive(gitStatusDto.getIs_active());
			gitStatusMaster.setIsDelete(gitStatusDto.getIs_delete());
		}
		return gitStatusMaster;
	}

	// Function to map GitStatusEntity class to GitStatusDto class
	public static GitStatusDto mapToGitStatusDto(GitStatusMaster gitStatus) {
		GitStatusDto gitStatusDto = new GitStatusDto();
		if (gitStatus != null) {
			gitStatusDto.setId(gitStatus.getId());
			gitStatusDto.setGitStatusName(gitStatus.getGitStatusName().trim());
			gitStatusDto.setIs_active(gitStatus.getIsActive());
			gitStatusDto.setIs_delete(gitStatus.getIsDelete());
		}
		return gitStatusDto;
	}
}
