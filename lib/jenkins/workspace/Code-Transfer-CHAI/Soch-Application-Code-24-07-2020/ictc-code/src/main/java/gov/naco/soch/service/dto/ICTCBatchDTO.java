package gov.naco.soch.service.dto;
import java.io.Serializable;
import java.util.List;


public class ICTCBatchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Long labId;
    
    private String consignmentId;
    
    private List<Long> samples;

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public String getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(String consignmentId) {
		this.consignmentId = consignmentId;
	}

	public List<Long> getSamples() {
		return samples;
	}

	public void setSamples(List<Long> samples) {
		this.samples = samples;
	}

    
    
    
    
}
