//package gov.naco.soch.ti.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.metamodel.SingularAttribute;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import gov.naco.soch.dto.TICustomBeneficiaryDto;
//import gov.naco.soch.entity.TIBeneficiary;
//import gov.naco.soch.entity.TIBeneficiary_;
//import gov.naco.soch.mapper.CustomTIMapper;
//import gov.naco.soch.repository.TICustomBeneficiaryRepository;
//import gov.naco.soch.ti.dto.TIBeneficiaryCriteria;
//import gov.naco.soch.ti.dto.TIBeneficiaryDTO;
//import gov.naco.soch.ti.mapper.TIBeneficiaryMapper;
//import io.github.jhipster.service.QueryService;
//import io.github.jhipster.service.filter.LongFilter;
//
///**
// * Service for executing complex queries for {@link TIBeneficiary} entities in
// * the database. The main input is a {@link TIBeneficiaryCriteria} which gets
// * converted to {@link Specification}, in a way that all the filters must apply.
// * It returns a {@link List} of {@link TIBeneficiaryDTO} or a {@link Page} of
// * {@link TIBeneficiaryDTO} which fulfills the criteria.
// */
//@Service
//@Transactional(readOnly = true)
//public class TICustomBeneficiaryQueryService extends QueryService<TIBeneficiary> {
//
//	private final Logger log = LoggerFactory.getLogger(TICustomBeneficiaryQueryService.class);
//
//	private final TICustomBeneficiaryRepository tICustomBeneficiaryRepository;
//
//	private final TIBeneficiaryMapper tIBeneficiaryMapper;
//	
//	public TICustomBeneficiaryQueryService(TICustomBeneficiaryRepository tICustomBeneficiaryRepository,
//			TIBeneficiaryMapper tIBeneficiaryMapper) {
//		this.tICustomBeneficiaryRepository = tICustomBeneficiaryRepository;
//		this.tIBeneficiaryMapper = tIBeneficiaryMapper;
//	}
//
//	
//
//	
//	/**
//	 * Return a {@link Page} of {@link TIBeneficiaryDTO} which matches the
//	 * criteria from the database.
//	 * 
//	 * @param criteria
//	 *            The object which holds all the filters, which the entities
//	 *            should match.
//	 * @param page
//	 *            The page, which should be returned.
//	 * @return the matching entities.
//	 */
//	@Transactional(readOnly = true)
//	public Page<TICustomBeneficiaryDto> findByCriteria(TIBeneficiaryCriteria criteria, Pageable page) {
//		log.debug("find by criteria : {}, page: {}", criteria, page);
//		final Specification<TIBeneficiary> specification = createSpecification(criteria);
//		Page<TIBeneficiary> pageList = tICustomBeneficiaryRepository.findAll(specification, page);
//		List<TIBeneficiary> customlist = pageList.getContent();
//		List<TICustomBeneficiaryDto> custBenDtolList = new ArrayList<TICustomBeneficiaryDto>();
//		 
//		for (TIBeneficiary obj: customlist) {
//			TICustomBeneficiaryDto dtoObj = CustomTIMapper.mapToTIBeneficiaryDTO(obj);
//			custBenDtolList.add(dtoObj);
//		}
//		final Page<TICustomBeneficiaryDto> custBenDtoPage = new PageImpl<>(custBenDtolList,page,custBenDtolList.size());
//		return custBenDtoPage;
//		 
//	}
//
//
//	/**
//	 * Function to convert {@link TIBeneficiaryCriteria} to a
//	 * {@link Specification}
//	 * 
//	 * @param criteria
//	 *            The object which holds all the filters, which the entities
//	 *            should match.
//	 * @return the matching {@link Specification} of the entity.
//	 */
//	protected Specification<TIBeneficiary> createSpecification(TIBeneficiaryCriteria criteria) {
//		Specification<TIBeneficiary> specification = Specification.where(null);
//		if (criteria != null) {
//			if (criteria.getFacilityId() != null) {
//				specification = specification.and(buildSpecification(criteria.getFacilityId(), TIBeneficiary_.facilityId));
//			}
//			if (criteria.getIsDeleted() != null) {
//				specification = specification
//						.and(buildSpecification(criteria.getIsDeleted(), TIBeneficiary_.isDeleted));
//			}
//		}	
//		return specification;
//	}
//
//
//}
