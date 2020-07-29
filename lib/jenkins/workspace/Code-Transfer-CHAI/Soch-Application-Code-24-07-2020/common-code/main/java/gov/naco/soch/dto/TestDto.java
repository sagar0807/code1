package gov.naco.soch.dto;

public class TestDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String value;
	private boolean barcodeRequired;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isBarcodeRequired() {
		return barcodeRequired;
	}
	public void setBarcodeRequired(boolean barcodeRequired) {
		this.barcodeRequired = barcodeRequired;
	}
	@Override
	public String toString() {
		return "TestDto [id=" + id + ", value=" + value + ", barcodeRequired=" + barcodeRequired + "]";
	}
	
	
}
