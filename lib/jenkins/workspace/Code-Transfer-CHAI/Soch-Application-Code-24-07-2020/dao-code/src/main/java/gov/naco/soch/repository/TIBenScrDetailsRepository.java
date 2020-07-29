package gov.naco.soch.repository;
import java.time.ZonedDateTime;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenScrDetails;


/**
 * Spring Data  repository for the TIBenScrDetails entity.
 */
@Repository
public interface TIBenScrDetailsRepository extends JpaRepository<TIBenScrDetails, Long>, JpaSpecificationExecutor<TIBenScrDetails> {

	@Query(nativeQuery=true,value="select scr.* from soch.ti_ben_scr_details  scr join (select infection,max(date_of_screening) as latestscreeningdate "
			+ " from soch.ti_ben_scr_details group by infection ) groupedscr  "
			+ " on scr.infection=groupedscr.infection and scr.date_of_screening=groupedscr.latestscreeningdate where scr.beneficiary_id=:beneficiaryId ")
	Stream<TIBenScrDetails> findScreeningDetailsByBeneficiary(@Param("beneficiaryId")Long beneficiaryId);

	@Query("select  max(id) from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId ")
	Long findLatestRecord(@Param("infectionId")Long infectionId, @Param("beneficiaryId")Long beneficiaryId);
	
	@Query("select  max(dateOfScreening) from TIBenScrDetails where infection.id=:infectionId and beneficiary.id=:beneficiaryId ")
	ZonedDateTime findLatestScreeningDate(@Param("beneficiaryId")Long beneficiaryId, @Param("infectionId")Long infectionId);

}
