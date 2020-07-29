package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstAssessment;

@Repository
public interface TIOSTAssessmentRepository
		extends JpaRepository<TiOstAssessment, Long>, JpaSpecificationExecutor<TiOstAssessment> {
    
    @Override
    @EntityGraph(value = "tiOstAssessGraph")
    Page<TiOstAssessment> findAll(Specification<TiOstAssessment> spec, Pageable pageable);

}
