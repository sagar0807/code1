package gov.naco.soch.ti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.dto.TiOstBeneficiaryDispensationDto;
import gov.naco.soch.entity.BeneficiaryTransitFacility;
import gov.naco.soch.entity.BeneficiaryTransitFacility_;
import gov.naco.soch.entity.Beneficiary_;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.Facility_;
import gov.naco.soch.entity.MasterBeneficiaryOstStatus;
import gov.naco.soch.entity.MasterBeneficiaryOstStatus_;
import gov.naco.soch.entity.MasterDrug;
import gov.naco.soch.entity.MasterDrug_;
import gov.naco.soch.entity.MasterOstClientStatus;
import gov.naco.soch.entity.MasterOstClientStatus_;
import gov.naco.soch.entity.Product;
import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.entity.TiOstAssessment_;
//import gov.naco.soch.entity.Facility_;
//import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.entity.TiOstBeneficiary_;
import gov.naco.soch.entity.TiOstDispensationItem;
import gov.naco.soch.entity.TiOstDispensationItem_;
import gov.naco.soch.entity.TiOstPrescription;
import gov.naco.soch.entity.TiOstPrescription_;
import gov.naco.soch.enums.MasterDrugEnum;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.repository.TiOstDispensationItemRepository;
import gov.naco.soch.ti.dto.TiOstBeneficiaryDispensationCriteria;
import gov.naco.soch.ti.mapper.TiOstBeneficiaryMapper;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;

@Service
@Transactional(readOnly = true)
public class TiOstBeneficiaryDispensationQueryService extends QueryService<TiOstBeneficiary> {
    private final Logger log = LoggerFactory.getLogger(TiOstBeneficiaryDispensationQueryService.class);

    private final TiOstBeneficiaryRepository tiOstBeneficiaryRepository;

    private final TiOstBeneficiaryMapper tiOstBeneficiaryMapper;

    private final TiOstDispensationItemRepository tiOstDispensationItemRepository;

    @PersistenceContext
    private EntityManager em;

    public TiOstBeneficiaryDispensationQueryService(TiOstBeneficiaryRepository tiOstBeneficiaryRepository,
	    TiOstBeneficiaryMapper tiOstBeneficiaryMapper,
	    TiOstDispensationItemRepository tiOstDispensationItemRepository) {
	this.tiOstBeneficiaryMapper = tiOstBeneficiaryMapper;
	this.tiOstBeneficiaryRepository = tiOstBeneficiaryRepository;
	this.tiOstDispensationItemRepository = tiOstDispensationItemRepository;
    }

    @Transactional(readOnly = true)
    public Page<TiOstBeneficiaryDispensationDto> findByCriteria(TiOstBeneficiaryDispensationCriteria criteria,
	    Pageable page) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TiOstBeneficiary> specification = createSpecification(criteria);
	Page<TiOstBeneficiary> pageList = tiOstBeneficiaryRepository.findAll(specification, page);
	List<TiOstBeneficiary> list = pageList.getContent();
	return mapTiOstBeneficiaryToTiOstBeneficiaryDto(list,criteria);
    }

    private List<TiOstBeneficiaryDispensationDto> sortByDosage(TiOstBeneficiaryDispensationCriteria criteria, List<TiOstBeneficiaryDispensationDto> tiOstBeneficiaryDispensationDtos) {
	    List<TiOstBeneficiaryDispensationDto> response = new ArrayList<>();
	if (!tiOstBeneficiaryDispensationDtos.isEmpty()) {
	    if (criteria.getSortParam() != null) {
		String sortParam = criteria.getSortParam().getEquals();
		switch (sortParam) {
		case "dosage_desc":
		     response= tiOstBeneficiaryDispensationDtos.stream().sorted(Comparator.comparingDouble(TiOstBeneficiaryDispensationDto::getDosage).reversed()).collect(Collectors.toList());
		    break;
		case "dosage_asc":
		    response=tiOstBeneficiaryDispensationDtos.stream().sorted(Comparator.comparingDouble(TiOstBeneficiaryDispensationDto::getDosage)).collect(Collectors.toList());
		    break;
		default:
		    break;
		}
	    }
	}
	return response;
    }

    @Transactional(readOnly = true)
    public long countByCriteria(TiOstBeneficiaryDispensationCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TiOstBeneficiary> specification = createSpecification(criteria);
	return getCount(specification);
    }

    @Transactional(readOnly = true)
    public Page<TiOstBeneficiaryDispensationDto> findByCriteriaForTodaysDispensation(
	    TiOstBeneficiaryDispensationCriteria criteria, Pageable page) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TiOstBeneficiary> specification = createSpecificationForTodaysDispensation(criteria);
	Page<TiOstBeneficiary> pageList = tiOstBeneficiaryRepository.findAll(specification, page);
	List<TiOstBeneficiary> list = pageList.getContent();
	return mapTiOstBeneficiaryToTiOstBeneficiaryDto(list,criteria);
    }

    @Transactional(readOnly = true)
    public Long countByCriteriaForTodaysDispensation(TiOstBeneficiaryDispensationCriteria criteria) {
	log.debug("find by criteria : {}", criteria);
	final Specification<TiOstBeneficiary> specification = createSpecificationForTodaysDispensation(criteria);
	return getCount(specification);
    }

    private long getCount(Specification<TiOstBeneficiary> specification) {
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Long> query = cb.createQuery(Long.class);
	Root<TiOstBeneficiary> root = query.from(TiOstBeneficiary.class);

	Predicate p = specification.toPredicate(root, query, cb);

	query.select(cb.countDistinct(root));
	query.where(p);
	long count = em.createQuery(query).getSingleResult().longValue();
	return count;
    }

    private Page<TiOstBeneficiaryDispensationDto> mapTiOstBeneficiaryToTiOstBeneficiaryDto(
	    List<TiOstBeneficiary> tiOstBeneficiaryList, TiOstBeneficiaryDispensationCriteria criteria) {
	List<TiOstBeneficiaryDispensationDto> tiOstBeneficiaryDispensationDtos = new ArrayList<TiOstBeneficiaryDispensationDto>();
	tiOstBeneficiaryList.forEach(tiOstBeneficiary -> {
	    TiOstBeneficiaryDispensationDto tiOstBeneficiaryDispensationDto = new TiOstBeneficiaryDispensationDto();
	    if (tiOstBeneficiary.getId() != null) {
		tiOstBeneficiaryDispensationDto.setTiOstBeneficiaryId(tiOstBeneficiary.getId().longValue());
	    }
	    if (tiOstBeneficiary.getIsTransit() != null) {
		tiOstBeneficiaryDispensationDto.setIsTransit(tiOstBeneficiary.getIsTransit());
	    }

	    if (tiOstBeneficiary.getOstNumber() != null) {
		tiOstBeneficiaryDispensationDto.setOstNumber(tiOstBeneficiary.getOstNumber());
	    }

	    if (tiOstBeneficiary.getBeneficiary() != null) {
		if (tiOstBeneficiary.getBeneficiary().getUid() != null) {
		    tiOstBeneficiaryDispensationDto.setUid(tiOstBeneficiary.getBeneficiary().getUid());
		}

		if (tiOstBeneficiary.getBeneficiary().getFirstName() != null) {
		    tiOstBeneficiaryDispensationDto
			    .setBeneficiaryName(tiOstBeneficiary.getBeneficiary().getFirstName());
		}
		if (tiOstBeneficiary.getBeneficiary().getFirstName() != null
			&& tiOstBeneficiary.getBeneficiary().getLastName() != null) {
		    tiOstBeneficiaryDispensationDto.setBeneficiaryName(tiOstBeneficiary.getBeneficiary().getFirstName()
			    + " " + tiOstBeneficiary.getBeneficiary().getLastName());
		}

		if (tiOstBeneficiary.getBeneficiary().getAge() != null) {
		    tiOstBeneficiaryDispensationDto.setAge(tiOstBeneficiary.getBeneficiary().getAge());
		}
		if (tiOstBeneficiary.getBeneficiary().getGenderId() != null) {
		    tiOstBeneficiaryDispensationDto.setSex(tiOstBeneficiary.getBeneficiary().getGenderId().getName());
		}
	    }
	    if (!tiOstBeneficiary.getTiOstPrescriptions().isEmpty()) {
//			    tiOstBeneficiary.getOstAssess().stream().map(x->{
//				x.getTiOstPrescriptions().stream().max(Comparator.comparing(TiOstPrescription::getId)).get();
//			    });
		TiOstPrescription tiOstPrescription = tiOstBeneficiary.getTiOstPrescriptions().stream()
			.max(Comparator.comparing(TiOstPrescription::getId)).get();
		tiOstBeneficiaryDispensationDto.setTiOstPrescriptionId(tiOstPrescription.getId());
		tiOstBeneficiaryDispensationDto.setDosage(tiOstPrescription.getDosageQty());
		if (tiOstPrescription.getProduct() != null && tiOstPrescription.getProduct().getName() != null
			&& tiOstPrescription.getProduct().getName().startsWith("Buprenorphine")) {
		    if (tiOstPrescription.getDosageQty() != null) {
			tiOstBeneficiaryDispensationDto = findNumberOfTabletsByDosage(
				tiOstPrescription.getDosageQty().doubleValue(), tiOstBeneficiaryDispensationDto);
		    }

		}
		if (tiOstPrescription.getProduct() != null && tiOstPrescription.getProduct().getName() != null) {
		    tiOstBeneficiaryDispensationDto.setDrug(tiOstPrescription.getProduct().getName());
		}
	    }
	    if (tiOstBeneficiary.getOstNumber() != null) {
		tiOstBeneficiaryDispensationDto.setOstNumber(tiOstBeneficiary.getOstNumber());
	    }

	    tiOstBeneficiaryDispensationDtos.add(tiOstBeneficiaryDispensationDto);
	   
	});
	List<TiOstBeneficiaryDispensationDto> responseList= sortByDosage(criteria, tiOstBeneficiaryDispensationDtos);
	

	final Page<TiOstBeneficiaryDispensationDto> response = new PageImpl<>(responseList);
	return response;
    }

    private static TiOstBeneficiaryDispensationDto findNumberOfTabletsByDosage(Double dosageQty,
	    TiOstBeneficiaryDispensationDto tiOstBeneficiaryDispensationDto) {
	Integer numberOf2mgTablet = 0;
	Double numberOf4mgTablet = 0.0;
	Double dosage = dosageQty;
	numberOf2mgTablet = (int) (dosage / 2);
	Double remainder = dosage % 2;
	remainder = Math.round(remainder * 10) / 10.0;
	if (remainder != 0 && remainder <= 0.2) {
	    numberOf4mgTablet = numberOf4mgTablet + 0.5;

	} else if (remainder != 0 && remainder >= 0.4) {
	    Double quotient = remainder / 0.4;
	    Double subRemainder = remainder % 0.4;
	    numberOf4mgTablet = Math.round(quotient * 10) / 10.0;
	    if (subRemainder != 0 && subRemainder == 0.2) {
		numberOf4mgTablet = numberOf4mgTablet + 0.5;
	    }
	}
	tiOstBeneficiaryDispensationDto.setNumberOf4mgTablet(numberOf4mgTablet);
	tiOstBeneficiaryDispensationDto.setNumberOf2mgTablet(numberOf2mgTablet);
	return tiOstBeneficiaryDispensationDto;
    }

    protected Specification<TiOstBeneficiary> createSpecification(TiOstBeneficiaryDispensationCriteria criteria) {
	Specification<TiOstBeneficiary> specification = Specification.where(null);

	if (criteria != null) {

	    if (criteria.getName() != null) {
		specification = specification.or(buildSpecification(criteria.getName(),
			root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	    }

	    if (criteria.getIsTransit() != null) {
		specification = specification
			.or(buildSpecification(criteria.getIsTransit(), TiOstBeneficiary_.isTransit));
	    }

	    Long drugTypeId = 0l;
	    if (criteria.getDrugType().getEquals().equals("Buprenorphine")) {
		drugTypeId = MasterDrugEnum.Buprenorphine.getMasterDrugId();
	    } else if (criteria.getDrugType().getEquals().equalsIgnoreCase("Methadone")) {
		drugTypeId = MasterDrugEnum.methadone.getMasterDrugId();
	    }

	    specification = specification.and(getDetails(criteria.getDate().getEquals(),
		    criteria.getFacilityId().getEquals(), criteria.getIsTransit().getEquals(), drugTypeId));

	    if (criteria.getFacilityId() != null) {
		specification = specification.and(buildSpecification(criteria.getFacilityId(),
			root -> root.join(TiOstBeneficiary_.facility, JoinType.LEFT).get(Facility_.id)));
	    }

	    if (criteria.getParam() != null) {
		specification = specification.and(andSearchParam(criteria.getParam(), specification));

	    }
	}
	return specification;
    }

    private Specification<TiOstBeneficiary> andSearchParam(StringFilter param,
	    Specification<TiOstBeneficiary> specification) {
	specification = specification.and(buildSpecification(param,
		root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.uid)));
	specification = specification.or(buildSpecification(param,
		root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	specification = specification.or(buildSpecification(param,
		root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.middleName)));
	specification = specification.or(buildSpecification(param,
		root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.lastName)));
	specification = specification.or(buildSpecification(param,
		root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.mobileNumber)));
	specification = specification.or(buildStringSpecification(param, TiOstBeneficiary_.ostNumber));

	return specification;
    }

    public static Specification<TiOstBeneficiary> getDetails(LocalDate date, Long facilityId, Boolean isTransit,
	    Long drugTypeId) {
	return (root, query, cb) -> {

	    SetJoin<TiOstBeneficiary, TiOstAssessment> ti = root.join(TiOstBeneficiary_.ostAssess, JoinType.LEFT);
	    SetJoin<TiOstAssessment, TiOstPrescription> ap = ti.join(TiOstAssessment_.tiOstPrescriptions,
		    JoinType.LEFT);
	    SetJoin<TiOstBeneficiary, TiOstPrescription> presc = root.join(TiOstBeneficiary_.tiOstPrescriptions,
		    JoinType.LEFT);

	    Subquery<Long> tiOstAssessmentmaxSubQuery = query.subquery(Long.class);
	    Root<TiOstAssessment> tiOstAssessment = tiOstAssessmentmaxSubQuery.from(TiOstAssessment.class);
	    Join<TiOstAssessment, TiOstBeneficiary> b = tiOstAssessment.join(TiOstAssessment_.tiOstBeneficiary,
		    JoinType.LEFT);

	    Join<TiOstBeneficiary, MasterOstClientStatus> p1 = b.join(TiOstBeneficiary_.status, JoinType.LEFT);
	    Join<TiOstBeneficiary, MasterBeneficiaryOstStatus> p2 = b.join(TiOstBeneficiary_.ostStatus, JoinType.LEFT);

	    Predicate c1 = cb.equal(p2.get(MasterBeneficiaryOstStatus_.id), 2);
	    Predicate c2 = cb.lessThanOrEqualTo(b.get(TiOstBeneficiary_.consentTakenDate), date);
	    Predicate c3 = p1.get(MasterOstClientStatus_.id).in(1, 7);

	    Subquery<Long> dispensationItemSubQuery = tiOstAssessmentmaxSubQuery.subquery(Long.class);
	    Root<TiOstDispensationItem> tiOstDispensationItem = dispensationItemSubQuery
		    .from(TiOstDispensationItem.class);
	    Join<TiOstDispensationItem, TiOstBeneficiary> j1 = tiOstDispensationItem
		    .join(TiOstDispensationItem_.tiOstBeneficiary, JoinType.LEFT);

	    dispensationItemSubQuery.select(j1.get(TiOstBeneficiary_.id));
	    Predicate d = cb.lessThanOrEqualTo(tiOstDispensationItem.get(TiOstDispensationItem_.dispensationDate),
		    date);
	    dispensationItemSubQuery.where(d);

	    Predicate c4 = cb.not(b.get(TiOstBeneficiary_.id).in(dispensationItemSubQuery));
	    tiOstAssessmentmaxSubQuery.groupBy(b.get(TiOstBeneficiary_.id));
	    tiOstAssessmentmaxSubQuery.where(c1, c2, c3, c4);

	    tiOstAssessmentmaxSubQuery.select(cb.greatest(tiOstAssessment.get(TiOstAssessment_.id)));

	    // Predicate z = ti.get(TiOstAssessment_.id).in(tiOstAssessmentmaxSubQuery);

	    // New Change
	    Subquery<Long> tiOstPrescriptionmaxSubQuery = query.subquery(Long.class);
	    Root<TiOstPrescription> tiOstPrescription = tiOstPrescriptionmaxSubQuery.from(TiOstPrescription.class);
	    Join<TiOstPrescription, TiOstBeneficiary> ostBen = tiOstPrescription
		    .join(TiOstPrescription_.tiOstBeneficiary, JoinType.LEFT);
	    Join<TiOstPrescription, MasterDrug> m = tiOstPrescription.join(TiOstPrescription_.product, JoinType.LEFT);

	    Join<TiOstPrescription, TiOstAssessment> j2 = tiOstPrescription.join(TiOstPrescription_.tiOstAssessment,
		    JoinType.LEFT);
	    Predicate s1 = cb.equal(m.get(MasterDrug_.id), drugTypeId);
	    Predicate s2 = j2.get(TiOstAssessment_.id).in(tiOstAssessmentmaxSubQuery);
	    tiOstPrescriptionmaxSubQuery.where(s1, s2);
	    Predicate s3 = ap.get(TiOstPrescription_.id)
		    .in(tiOstPrescriptionmaxSubQuery.select(cb.greatest(tiOstPrescription.get(TiOstPrescription_.id))));
	    tiOstPrescriptionmaxSubQuery.groupBy(ostBen.get(TiOstBeneficiary_.id));
	    Predicate s4 = cb.equal(ap.get(TiOstPrescription_.id), presc.get(TiOstPrescription_.id));
	    Join<TiOstBeneficiary, Facility> f = root.join(TiOstBeneficiary_.linkedFacility, JoinType.LEFT);
	    Predicate s = cb.isNull(f.get(Facility_.id));
	    Predicate btf = null;
	    if (isTransit == true) {
		SetJoin<TiOstBeneficiary, BeneficiaryTransitFacility> tf = root
			.join(TiOstBeneficiary_.transitFacilities, JoinType.LEFT);
		btf = cb.equal(tf.join(BeneficiaryTransitFacility_.facility, JoinType.LEFT).get(Facility_.id),
			facilityId);
		return cb.and(s, btf, s3, s4);
	    } else {
		return cb.and(s, s3, s4);
	    }
	};
    }

    protected Specification<TiOstBeneficiary> createSpecificationForTodaysDispensation(
	    TiOstBeneficiaryDispensationCriteria criteria) {
	Specification<TiOstBeneficiary> specification = Specification.where(null);

	if (criteria != null) {

	    if (criteria.getName() != null) {
		specification = specification.or(buildSpecification(criteria.getName(),
			root -> root.join(TiOstBeneficiary_.beneficiary, JoinType.LEFT).get(Beneficiary_.firstName)));
	    }

	    if (criteria.getIsTransit() != null) {
		specification = specification
			.or(buildSpecification(criteria.getIsTransit(), TiOstBeneficiary_.isTransit));
	    }

	    Long drugTypeId = 0l;
	    if (criteria.getDrugType().getEquals().equals("Buprenorphine")) {
		drugTypeId = MasterDrugEnum.Buprenorphine.getMasterDrugId();
	    } else if (criteria.getDrugType().getEquals().equalsIgnoreCase("Methadone")) {
		drugTypeId = MasterDrugEnum.methadone.getMasterDrugId();
	    }

	    specification = specification.and(getDetailsForTodaysDispensation(criteria.getDate().getEquals(),
		    criteria.getFacilityId().getEquals(), drugTypeId));

	    if (criteria.getFacilityId() != null) {
		specification = specification.and(buildSpecification(criteria.getFacilityId(),
			root -> root.join(TiOstBeneficiary_.facility, JoinType.LEFT).get(Facility_.id)));
	    }

	    if (criteria.getParam() != null) {
		specification = specification.and(andSearchParam(criteria.getParam(), specification));

	    }
	}
	return specification;

    }

    public static Specification<TiOstBeneficiary> getDetailsForTodaysDispensation(LocalDate date, Long facilityId,
	    Long drugTypeId) {
	return (root, query, cb) -> {

	    Join<TiOstBeneficiary, TiOstDispensationItem> ti = root.join(TiOstBeneficiary_.tiOstDispensationItems,
		    JoinType.LEFT);

	    Join<TiOstDispensationItem, Product> k = ti.join(TiOstDispensationItem_.product, JoinType.LEFT);

	    SetJoin<TiOstBeneficiary, TiOstPrescription> c = root.join(TiOstBeneficiary_.tiOstPrescriptions,
		    JoinType.LEFT);
	    Join<TiOstPrescription, MasterDrug> m = c.join(TiOstPrescription_.product, JoinType.LEFT);

	    Subquery<Long> beneficiaryTransitFacilitySubQuery = query.subquery(Long.class);
	    Root<BeneficiaryTransitFacility> btf = beneficiaryTransitFacilitySubQuery
		    .from(BeneficiaryTransitFacility.class);

	    beneficiaryTransitFacilitySubQuery
		    .select((btf.get(BeneficiaryTransitFacility_.tiOstBeneficiary).get(TiOstBeneficiary_.id)));

	    Predicate p1 = cb.equal(m.get(MasterDrug_.id), drugTypeId);
	    Predicate p2 = cb.equal(ti.get(TiOstDispensationItem_.dispensationDate), date);
	    Predicate p3 = cb.equal(ti.get(TiOstDispensationItem_.facility).get(Facility_.id), facilityId);

	    Predicate p4 = root.get(TiOstBeneficiary_.id).in(beneficiaryTransitFacilitySubQuery);
	    Predicate p5 = cb.or(p3, p4);
	    return cb.and(p1, p2, p5);
	};
    }

}
