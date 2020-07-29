package gov.naco.soch.repository;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TiOstAssessment;
import gov.naco.soch.entity.TiOstFollowUp;


/**
 * Spring Data  repository for the TIBenFollowUp entity.
 */
@Repository
public interface TIOstFollowUpRepository extends JpaRepository<TiOstFollowUp, Long>, JpaSpecificationExecutor<TiOstFollowUp> {

    @Override
    @EntityGraph(value = "tiOstFollowUpGraph")
     Page<TiOstFollowUp> findAll(Specification<TiOstFollowUp> spec, Pageable pageable);
    
	TiOstFollowUp findByTiOstBeneficiary_IdAndNextFollowupDate(Long id, LocalDate date);

}
