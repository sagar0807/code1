package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDiagnosisType;

@Repository
public interface MasterDiagnosisTypeRepository extends JpaRepository<MasterDiagnosisType, Long> {

	List<MasterDiagnosisType> findByIsDelete(Boolean isDelete);

}