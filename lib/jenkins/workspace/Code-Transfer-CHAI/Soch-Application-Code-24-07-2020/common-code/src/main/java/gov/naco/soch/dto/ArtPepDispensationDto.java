package gov.naco.soch.dto;

import java.util.List;

public class ArtPepDispensationDto extends BaseDto{
	
	private ArtPepDetailsDto artPepDetailsDto;	
	public ArtPepDetailsDto getArtPepDetailsDto() {
		return artPepDetailsDto;
	}

	public void setArtPepDetailsDto(ArtPepDetailsDto artPepDetailsDto) {
		this.artPepDetailsDto = artPepDetailsDto;
	}

		
	//
	private List<ArtPepDispenseItemDto> artPepDispenseItemsDto;

	public List<ArtPepDispenseItemDto> getArtPepDispenseItemsDto() {
		return artPepDispenseItemsDto;
	}

	public void setArtPepDispenseItemsDto(List<ArtPepDispenseItemDto> artPepDispenseItemsDto) {
		this.artPepDispenseItemsDto = artPepDispenseItemsDto;
	}

	
	
	

}
