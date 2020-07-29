package gov.naco.soch.enums;

public enum StockAddDeductEnum {
	
	ADD("A"),DEDUCT("D");
	
	private String status;
	
	StockAddDeductEnum(String status){
		this.status=status;
	}

	public String getStatus() {
		return status;
	}


}
