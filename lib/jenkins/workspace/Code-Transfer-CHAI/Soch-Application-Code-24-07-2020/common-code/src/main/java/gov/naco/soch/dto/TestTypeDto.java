package gov.naco.soch.dto;

public class TestTypeDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Long value;
	private String viewValue;
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getViewValue() {
		return viewValue;
	}
	public void setViewValue(String viewValue) {
		this.viewValue = viewValue;
	}
	@Override
	public String toString() {
		return "TestTypeDto [value=" + value + ", viewValue=" + viewValue + "]";
	}
	
	
}
