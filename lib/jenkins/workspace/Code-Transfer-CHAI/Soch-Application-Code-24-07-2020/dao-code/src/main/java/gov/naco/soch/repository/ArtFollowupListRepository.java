package gov.naco.soch.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtFollowupList;
import gov.naco.soch.entity.Beneficiary;


@Repository
public interface ArtFollowupListRepository extends JpaRepository<ArtFollowupList, Long> {

	@Query(nativeQuery = true, value = "select * from soch.art_followup_list where year_generated =:year and month_generated =:month  and facility_id=:facilityId")
	List<ArtFollowupList> findByYearAndDateAndFaciltyId(@Param("year") Integer year, @Param("month") Integer month,@Param("facilityId") Long facilityId);
	//List<ArtFollowupList> findByYearAndDate(@Param("year") Integer year, @Param("month") Integer month);

	@Query(nativeQuery=true, value = "select COUNT(*) from soch.art_followup_list where  beneficiary_id=:beneficiaryId and month_generated =:month and year_generated =:year ")
	int FindCountByBeneficiaryIdAndCurrentMonthAndCurrentYear(@Param("beneficiaryId") Long beneficiaryId, @Param("month") Integer month,
			@Param("year") Integer year);

}
