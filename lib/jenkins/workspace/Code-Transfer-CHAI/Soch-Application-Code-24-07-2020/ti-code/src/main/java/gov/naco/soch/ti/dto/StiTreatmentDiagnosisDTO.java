package gov.naco.soch.ti.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class StiTreatmentDiagnosisDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private LocalDate firstFollowupDate;
    
    private Long id;

    public LocalDate getFirstFollowupDate() {
        return firstFollowupDate;
    }

    public void setFirstFollowupDate(LocalDate firstFollowupDate) {
        this.firstFollowupDate = firstFollowupDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

}
