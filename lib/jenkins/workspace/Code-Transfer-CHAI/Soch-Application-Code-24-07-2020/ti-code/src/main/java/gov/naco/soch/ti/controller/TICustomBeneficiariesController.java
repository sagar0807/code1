//<<<<<<< HEAD
////package gov.naco.soch.ti.controller;
////
////import java.net.URISyntaxException;
////import java.util.List;
////
////import javax.validation.Valid;
////
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.domain.Page;
////import org.springframework.data.domain.Pageable;
////import org.springframework.http.HttpHeaders;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
////
////import gov.naco.soch.dto.TICustomBeneficiaryDto;
////import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
////import gov.naco.soch.ti.service.TICustomBeneficiariesService;
////import gov.naco.soch.ti.service.TICustomBeneficiaryQueryService;
////import io.github.jhipster.web.util.PaginationUtil;
////@RestController
////@RequestMapping("/api")
////public class TICustomBeneficiariesController {
////	
////	private final Logger log = LoggerFactory.getLogger(TICustomBeneficiariesController.class);
////	 private static final String ENTITY_NAME = "tIBeneficiary";
////	
////	 @Autowired
////	 TICustomBeneficiariesService tiCustomBeneficiariesService;
////	 
////
////	 @Autowired
////	 TICustomBeneficiaryQueryService tICustomBeneficiaryQueryService;
////	 
////
////	 
////	@PostMapping("/ti-beneficiary/save")
////	public TICustomBeneficiaryDto createTIBeneficiary(@Valid @RequestBody TICustomBeneficiaryDto tiCustomBeneficiaryDto) throws URISyntaxException {
////		log.debug("REST request to save TIBeneficiary : {}", tiCustomBeneficiaryDto);
////		
////		return tiCustomBeneficiariesService.save(tiCustomBeneficiaryDto);
////	}
////
////	
////	
////	@PostMapping("/ti-beneficiary/update")
////	public TICustomBeneficiaryDto updateTIBeneficiary(@Valid @RequestBody TICustomBeneficiaryDto tiCustomBeneficiaryDto) throws URISyntaxException {
////		log.debug("REST request to update TIBeneficiary : {}", tiCustomBeneficiaryDto);
////		
////		return tiCustomBeneficiariesService.update(tiCustomBeneficiaryDto);
////	}
////	
////
////
////	
////	@GetMapping("/ti-beneficiary")
////    public ResponseEntity<List<TICustomBeneficiaryDto>> getAllTIBeneficiaries(TIBeneficiaryCriteria criteria, Pageable pageable) {
////        log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
////        Page<TICustomBeneficiaryDto> page = tICustomBeneficiaryQueryService.findByCriteria(criteria, pageable);
////        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
////        return ResponseEntity.ok().headers(headers).body(page.getContent());
////    }
////
////
////}
//=======
//package gov.naco.soch.ti.controller;
//
//import java.net.URISyntaxException;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import gov.naco.soch.dto.TICustomBeneficiaryDto;
//import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
//import gov.naco.soch.ti.service.TICustomBeneficiariesService;
//import gov.naco.soch.ti.service.TICustomBeneficiaryQueryService;
//import io.github.jhipster.service.filter.BooleanFilter;
//import io.github.jhipster.service.filter.LongFilter;
//import io.github.jhipster.web.util.PaginationUtil;
//@RestController
//@RequestMapping("/api")
//public class TICustomBeneficiariesController {
//	
//	private final Logger log = LoggerFactory.getLogger(TICustomBeneficiariesController.class);
//	 private static final String ENTITY_NAME = "tIBeneficiary";
//	
//	 @Autowired
//	 TICustomBeneficiariesService tiCustomBeneficiariesService;
//	 
//
//	 @Autowired
//	 TICustomBeneficiaryQueryService tICustomBeneficiaryQueryService;
//	 
//
//	 
//	@PostMapping("/ti-beneficiary/save")
//	public TICustomBeneficiaryDto createTIBeneficiary(@Valid @RequestBody TICustomBeneficiaryDto tiCustomBeneficiaryDto) throws URISyntaxException {
//		log.debug("REST request to save TIBeneficiary : {}", tiCustomBeneficiaryDto);
//		
//		return tiCustomBeneficiariesService.save(tiCustomBeneficiaryDto);
//	}
//
//	
//	
//	@PostMapping("/ti-beneficiary/update")
//	public TICustomBeneficiaryDto updateTIBeneficiary(@Valid @RequestBody TICustomBeneficiaryDto tiCustomBeneficiaryDto) throws URISyntaxException {
//		log.debug("REST request to update TIBeneficiary : {}", tiCustomBeneficiaryDto);
//		
//		return tiCustomBeneficiariesService.update(tiCustomBeneficiaryDto);
//	}
//	
//
//
//	
//	@GetMapping("/ti-beneficiary/{id}")
//    public ResponseEntity<List<TICustomBeneficiaryDto>> getAllTIBeneficiaries(@PathVariable long id, Pageable pageable) {
//        
//		TIBeneficiaryCriteria criteria = new TIBeneficiaryCriteria();
//		
//		LongFilter facilityId = new LongFilter();
//		facilityId.setEquals(id);
//		BooleanFilter isDelete = new BooleanFilter();
//		isDelete.setEquals(false);
//		
//		criteria.setFacilityId(facilityId);
//		criteria.setIsDeleted(isDelete);
//		
//		
//		log.debug("REST request to get TIBeneficiaries by criteria: {}", criteria);
//        Page<TICustomBeneficiaryDto> page = tICustomBeneficiaryQueryService.findByCriteria(criteria, pageable);
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
//        return ResponseEntity.ok().headers(headers).body(page.getContent());
//    }
//
//
//}
//>>>>>>> 66bb362a864e27ab092adedb36c4f990b9db4dc1
