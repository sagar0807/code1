package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtBeneficiaryStatus;

@Repository
public interface MasterArtBeneficiaryStatusRepository extends JpaRepository<MasterArtBeneficiaryStatus, Long> {

	List<MasterArtBeneficiaryStatus> findByIsDelete(Boolean isDelete);

}
