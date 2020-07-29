package gov.naco.soch.inventory.dto;

import java.util.List;

public class SACSDashboardReponseDto {

	private DashBoardResponseDto responseDto;
	private List<SACSDispatchAndAdjustDto> dispatchAndAdjustDtos;

	public DashBoardResponseDto getResponseDto() {
		return responseDto;
	}

	public void setResponseDto(DashBoardResponseDto responseDto) {
		this.responseDto = responseDto;
	}

	public List<SACSDispatchAndAdjustDto> getDispatchAndAdjustDtos() {
		return dispatchAndAdjustDtos;
	}

	public void setDispatchAndAdjustDtos(List<SACSDispatchAndAdjustDto> dispatchAndAdjustDtos) {
		this.dispatchAndAdjustDtos = dispatchAndAdjustDtos;
	}

}
