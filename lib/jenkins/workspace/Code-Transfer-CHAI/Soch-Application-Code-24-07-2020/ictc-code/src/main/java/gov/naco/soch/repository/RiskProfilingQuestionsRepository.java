package gov.naco.soch.repository;

import gov.naco.soch.domain.RiskProfilingQuestions;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the RiskProfilingQuestions entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RiskProfilingQuestionsRepository extends JpaRepository<RiskProfilingQuestions, Long>, JpaSpecificationExecutor<RiskProfilingQuestions> {
}
