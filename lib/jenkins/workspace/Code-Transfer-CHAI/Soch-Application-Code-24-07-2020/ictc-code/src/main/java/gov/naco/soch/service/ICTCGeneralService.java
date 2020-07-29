package gov.naco.soch.service;

import gov.naco.soch.service.dto.ICTCBeneficiaryDO;
import gov.naco.soch.service.dto.ICTCBeneficiaryDTO;
import gov.naco.soch.service.dto.ICTCPregancyFollowUpDTO;
import gov.naco.soch.service.dto.IctcBeneficiaryDeleteDTO;
import gov.naco.soch.service.dto.UpdateRelationshipDTO;
import gov.naco.soch.service.dto.UpdateTestResultDTO;

public interface ICTCGeneralService {
	
	ICTCBeneficiaryDTO createICTCBeneficiary(ICTCBeneficiaryDO beneficiaryDO);
	
	ICTCBeneficiaryDO getICTCBeneficiaryDetails(Long ictcBeneficiaryId);
	
	ICTCBeneficiaryDO updateICTCBeneficiaryDetails(ICTCBeneficiaryDO details);
	
	UpdateTestResultDTO updateTestResult(UpdateTestResultDTO updateTestResultDTO);
	
	void deleteICTCBeneficiary(Long id);
	
	ICTCBeneficiaryDO updatePostCounselling(ICTCBeneficiaryDO details);
	
	ICTCBeneficiaryDTO updateInfantRelationship(UpdateRelationshipDTO relationship);
	
	ICTCBeneficiaryDTO initiateIctcFollowUpVisit(Long followUpId, Long facilityId);
	
	ICTCPregancyFollowUpDTO updatePregrancyFollowUpDetails(ICTCPregancyFollowUpDTO details);
	
	void deleteIctcBeneficiaryWithReason(IctcBeneficiaryDeleteDTO beneficiaryDeleteDTO);
	
	void revokeTestResult(Long testResultId);
}
