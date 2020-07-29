package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;

@Repository
public interface BeneficiarySocialWelfareSchemeRepository extends JpaRepository<BeneficiarySocialWelfareScheme, Long>,
		JpaSpecificationExecutor<BeneficiarySocialWelfareScheme> {

	List<BeneficiarySocialWelfareScheme> findByBeneficiaryId(Long id);

}
