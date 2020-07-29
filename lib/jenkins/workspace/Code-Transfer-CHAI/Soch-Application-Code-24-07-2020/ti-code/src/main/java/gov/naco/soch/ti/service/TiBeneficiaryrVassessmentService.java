//package gov.naco.soch.ti.service;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import gov.naco.soch.dto.TiBeneficiaryrVassessmentDto;
//import gov.naco.soch.entity.Beneficiary;
//import gov.naco.soch.entity.TiBeneficiaryrVassessment;
//import gov.naco.soch.repository.BeneficiaryRepository;
//import gov.naco.soch.repository.TIBenRVAssessmentRepository;
//import gov.naco.soch.ti.mapper.TiBeneficiaryrVassessmentMapperUtil;
//
////TiBeneficiaryrVassessmentService class interact data with database
//@Transactional
//@Service
//public class TiBeneficiaryrVassessmentService {
//
//	@Autowired
//	TIBenRVAssessmentRepository tiBeneficiaryrVassessmentRepository;
//
//	@Autowired
//	private BeneficiaryRepository beneficiaryRepository;
//
//	// method to store Risk and vulnerability assessment details into
//	// TiBeneficiaryrVassessment table
//	public void addR_VAssesmentDetails(TiBeneficiaryrVassessmentDto tiBeneficiaryrVassessmentDto) {
//
//		tiBeneficiaryrVassessmentDto.setIsActive(true);
//		tiBeneficiaryrVassessmentDto.setIsDelete(false);
//
//		TiBeneficiaryrVassessment tiBeneficiaryrVassessment = new TiBeneficiaryrVassessment();
//		tiBeneficiaryrVassessment = TiBeneficiaryrVassessmentMapperUtil
//				.mapTiScreeningDetailDtoToTiScreeningDetail(tiBeneficiaryrVassessmentDto);
//
//		Beneficiary beneficiary = null;
//		beneficiary = beneficiaryRepository.findById(tiBeneficiaryrVassessmentDto.getBeneficiaryId()).get();
//		beneficiary.setBeneficiaryActivityStatus("Pending For Screening");
//		beneficiary = beneficiaryRepository.save(beneficiary);
//
//		tiBeneficiaryrVassessmentRepository.save(tiBeneficiaryrVassessment);
//
//		tiBeneficiaryrVassessmentDto.setId(tiBeneficiaryrVassessment.getId());
//	}
//
//}
