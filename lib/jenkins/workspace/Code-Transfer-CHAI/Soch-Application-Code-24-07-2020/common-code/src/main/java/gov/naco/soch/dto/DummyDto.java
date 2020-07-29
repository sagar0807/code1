package gov.naco.soch.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//DTO class used for transfer data between front end and back end.
public class DummyDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String firstName;
	
	private String name;

	private String email;

    private LocalDateTime createdDate;
    
    private LocalDate dateOfBirth;
    
    private LocalDateTime submittedTime;
    
    private List<DummyDetailsDto> dummyDetailsList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public LocalDateTime getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(LocalDateTime submittedTime) {
		this.submittedTime = submittedTime;
	}
	
	public List<DummyDetailsDto> getDummyDetailsList() {
		return dummyDetailsList;
	}

	public void setDummyDetailsList(List<DummyDetailsDto> dummyDetailsList) {
		this.dummyDetailsList = dummyDetailsList;
	}

	@Override
	public String toString() {
		return "DummyDto [id=" + id + ", firstName=" + firstName + ", name=" + name + ", email=" + email
				+ ", createdDate=" + createdDate + "]";
	}	
    
    

}
