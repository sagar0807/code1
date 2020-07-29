package gov.naco.soch.ti.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gov.naco.soch.dto.BeneficiaryDto;
import gov.naco.soch.dto.TiBeneficiaryReferralDto;
import gov.naco.soch.entity.BeneficiaryReferral;
import gov.naco.soch.ti.dto.FacilityDTO;
import gov.naco.soch.ti.dto.ReferralTimeLineDto;
import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
import gov.naco.soch.ti.dto.TiBenReferralCriteriaNew;
import gov.naco.soch.ti.dto.TiBenReferralDtoNew;
import gov.naco.soch.ti.dto.TiBenTransferCriteria;
import gov.naco.soch.ti.dto.TiBenTransferDto;
import gov.naco.soch.ti.service.BeneficiaryQueryService;
import gov.naco.soch.ti.service.FacilitySettingService;
import gov.naco.soch.ti.service.TIBeneficiaryServiceImpl;
import gov.naco.soch.ti.service.TiBeneficiaryReferralQueryService;
import gov.naco.soch.ti.service.TiBeneficiaryReferralService;
import gov.naco.soch.ti.service.TransferQueryService;
import gov.naco.soch.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.web.util.PaginationUtil;

@RestController
@RequestMapping("/referral")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TiBeneficiaryReferralController {

	private static final Logger logger = LoggerFactory.getLogger(TiBeneficiaryReferralController.class);

	@Autowired
	private TiBeneficiaryReferralService tiBeneficiaryReferralService;

	@Autowired
	private FacilitySettingService facilitySettingService;

	@Autowired
	private TiBeneficiaryReferralQueryService tIBenReferralQueryService;

	@Autowired
	TransferQueryService TransferQueryService;

	@Autowired
	private BeneficiaryQueryService beneficiaryQueryService;
	
	@Autowired
	private TIBeneficiaryServiceImpl tiBeneficiaryServiceImpl ;

	@GetMapping("/ti-ben-referrals")
	public ResponseEntity<List<TiBenReferralDtoNew>> getAllTiBenReferrals(TiBenReferralCriteriaNew criteria,
			Pageable pageable) {
		if (criteria.getIsDelete() == null) {
			BooleanFilter isDelete = new BooleanFilter();
			isDelete.setEquals(false);
			criteria.setIsDelete(isDelete);
		}
		Page<TiBenReferralDtoNew> page = tIBenReferralQueryService.findByCriteria(criteria, pageable);
		long totalCount = tIBenReferralQueryService.countByCriteria(criteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}
	
	
	@PutMapping("/refer/{referalId}")
	public boolean referBeneficiary(@PathVariable("referalId") Long id,
			@RequestParam(value = "facilityId", required = false) Long facilityId,
			@RequestParam(value = "beneficiaryId", required = false) Long beneficiaryId,
			@RequestParam(value = "referDate", required = false) LocalDate referDate,
			@RequestParam("action") String action) {

		try {
			return tiBeneficiaryReferralService.referBeneficiary(id, facilityId, action, beneficiaryId,referDate);
		} catch (BadRequestAlertException be) {
			throw be;
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping("/ti-ben-referrals/search")
	public ResponseEntity<List<TiBenReferralDtoNew>> searchAllTiBenForReferral(TiBenReferralCriteriaNew criteria,
			Pageable pageable) {
		if (criteria.getIsDelete() == null) {
			BooleanFilter isDelete = new BooleanFilter();
			isDelete.setEquals(false);
			criteria.setIsDelete(isDelete);
		}
		Page<TiBenReferralDtoNew> page = tIBenReferralQueryService.findByCriteriaSearch(criteria, pageable);
		long totalCount = tIBenReferralQueryService.countByCriteriaSearch(criteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/facility/list")
	public List<FacilityDTO> listAllFacilities() {
		return tiBeneficiaryReferralService.listFacilities();
	}

	@GetMapping("/transfer-in")
	public ResponseEntity<List<TiBenTransferDto>> listAllTiransfers(TiBenTransferCriteria benTransferCriteria,
			Pageable pageable) {
		Page<TiBenTransferDto> page = TransferQueryService.findByCriteria(benTransferCriteria, pageable);
		long totalCount = TransferQueryService.countByCriteria(benTransferCriteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return (ResponseEntity.ok().headers(headers).body(page.getContent()));
	}
	
	@GetMapping("/transfer-in/globalSearch")
	public ResponseEntity<List<TiBenTransferDto>> listAllPendingTransfers(TiBenTransferCriteria benTransferCriteria,
			Pageable pageable) {
		Page<TiBenTransferDto> page = TransferQueryService.findByStatusCriteria(benTransferCriteria, pageable);
		long totalCount = TransferQueryService.countByStatusCriteria(benTransferCriteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return (ResponseEntity.ok().headers(headers).body(page.getContent()));
	}

//	@GetMapping("/transit-list")
//	public ResponseEntity<List<TIBenTransitListDto>> getAllTIBenExtDetails(TIBenExtDetailsCriteria criteria,
//			Pageable pageable) {
//		Page<TIBenTransitListDto> page = tIBenExtDetailsQueryService.transitListFindByCriteria(criteria, pageable);
//		HttpHeaders headers = PaginationUtil
//				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//		return ResponseEntity.ok().headers(headers).body(page.getContent());
//	}

	@PutMapping("/transfer")
	public boolean acceptTransfer(@RequestParam(name = "transferId") Long transferId,
			@RequestParam(name = "facilityId", required = false) Long facilityTo,
			@RequestParam(name = "action") String action) {
		return tiBeneficiaryReferralService.transferTo(transferId, facilityTo, action);
	}

	@GetMapping("beneficiary-global")
	public BeneficiaryDto findById(@RequestParam("beneficiaryId") Long beneficiaryId,
			@RequestParam("facilityId") Long facilityId) {
		BeneficiaryDto beneficiaryDto = beneficiaryQueryService.findByGlobalBeneficiaryId(beneficiaryId, facilityId);
		return beneficiaryDto;
	}

	@PostMapping("/ti-beneficiary/save")
	public boolean createTIBeneficiaryForReferral(@RequestBody TIBeneficiaryDTO beneficiaryDTO) {
		boolean check = tiBeneficiaryServiceImpl.validateTICode(beneficiaryDTO.getTiCode(),beneficiaryDTO.getFacility().getId());
		if (check == false) {
			throw new BadRequestAlertException("TiCode  already exists", "TiBeneficiary", "1");

		}
		
		if (beneficiaryDTO.getBeneficiaryReferralDto() != null&&beneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility()!=null) {
			String facilityType = tiBeneficiaryServiceImpl
					.checkDuplicateReferral(beneficiaryDTO.getMasterBeneficiary().getId(),beneficiaryDTO.getBeneficiaryReferralDto().getReferredToFacility());
			if (facilityType !=null) {
				throw new BadRequestAlertException("Beneficiary is already registered in "+ facilityType, "TiBeneficiary", "3");
			}
		}
		
		return tiBeneficiaryReferralService.saveTiBeneficiary(beneficiaryDTO);
	}

	@GetMapping("/ti-ben-referrals/outrefsearch")
	public ResponseEntity<List<TiBenReferralDtoNew>> getAllTiBenOutReferralsSearch(TiBenReferralCriteriaNew criteria,
			Pageable pageable) {
		Page<TiBenReferralDtoNew> page = tIBenReferralQueryService.findByCriteriaOutRefSearch(criteria, pageable);
		long totalCount = tIBenReferralQueryService.countBySearchCriteria(criteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	@GetMapping("/transfer-in/search")
	public ResponseEntity<List<TiBenTransferDto>> listAllTiransferssearch(TiBenTransferCriteria benTransferCriteria,
			Pageable pageable) {
		Page<TiBenTransferDto> page = TransferQueryService.findByCriteriainRefSearch(benTransferCriteria, pageable);
		long totalCount = TransferQueryService.countBySearchCriteria(benTransferCriteria);
		   if (!page.getContent().isEmpty()) {
			page.getContent().get(0).setCount(totalCount);
		    }
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return (ResponseEntity.ok().headers(headers).body(page.getContent()));
	}

	// New API for referral time line
	@GetMapping("/timeline/{beneficiaryId}/{referredFromId}")
	public ReferralTimeLineDto getTimeLine(@PathVariable(name = "beneficiaryId") Long beneficiaryId,@PathVariable(name = "referredFromId") Long referredFromId) {
		return tiBeneficiaryReferralService.getReferralTimeLine(beneficiaryId,referredFromId);
	}
	
	

	// New API to save beneficiary referral
	@PostMapping("/partnerlinkage")
	public boolean addBeneficiaryReferral(
			@RequestBody TiBeneficiaryReferralDto tiBeneficiaryReferralDto) {
		logger.debug("addBeneficiaryReferral method is invoked");
		if (tiBeneficiaryReferralDto != null&&tiBeneficiaryReferralDto.getReferredFacility()!=null) {
			String facilityType = tiBeneficiaryServiceImpl
					.checkDuplicateReferral(tiBeneficiaryReferralDto.getBeneficiaryId(),Long.valueOf(tiBeneficiaryReferralDto.getReferredFacility()));
			if (facilityType !=null) {
				throw new BadRequestAlertException("Beneficiary is already registered in "+ facilityType, "\"tIBeneficiary\"", "3");
			}
		}
		return tiBeneficiaryReferralService.addBeneficiaryReferral(tiBeneficiaryReferralDto);
	}

}
