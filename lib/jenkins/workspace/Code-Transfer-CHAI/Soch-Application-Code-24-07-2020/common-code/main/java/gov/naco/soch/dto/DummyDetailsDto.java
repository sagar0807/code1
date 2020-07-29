package gov.naco.soch.dto;

//DTO class used for transfer data between front end and back end.
public class DummyDetailsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String address;
	
	private String mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

    

}
