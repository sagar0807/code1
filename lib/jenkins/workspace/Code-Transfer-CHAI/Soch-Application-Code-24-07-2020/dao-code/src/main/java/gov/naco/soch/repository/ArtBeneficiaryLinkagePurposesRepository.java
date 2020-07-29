package gov.naco.soch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;

@Repository
public interface ArtBeneficiaryLinkagePurposesRepository extends JpaRepository<ArtBeneficiaryLinkagePurposes, Long> {

	@Query(nativeQuery = true, value = "select a.* from soch.art_beneficiary_linkage_purposes as a "
			+ "where a.beneficiary_id = :id")
	List<ArtBeneficiaryLinkagePurposes> findByBeneficaryId(Long id);


}
