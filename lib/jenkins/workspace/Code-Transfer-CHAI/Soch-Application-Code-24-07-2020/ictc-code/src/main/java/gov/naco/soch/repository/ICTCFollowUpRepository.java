package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.domain.ICTCFollowUp;
import gov.naco.soch.domain.ICTCVisit;

/**
 * Spring Data  repository for the ICTCFollowUp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ICTCFollowUpRepository extends JpaRepository<ICTCFollowUp, Long>, JpaSpecificationExecutor<ICTCFollowUp> {
	
	@Modifying
	@Query("update ICTCFollowUp ifu set ifu.isActive=false where ifu.id=:id")
	void markEntryAsInActive(@Param("id") Long id);
	
	@Query("select ifu from ICTCFollowUp ifu where ifu.followUpType=:followUpType and ifu.visit.id=:visitId")
	Optional<ICTCFollowUp> findByFollowUpTypeAndVisitId(@Param("followUpType") Integer followUpType, @Param("visitId") Long visitId);
}
