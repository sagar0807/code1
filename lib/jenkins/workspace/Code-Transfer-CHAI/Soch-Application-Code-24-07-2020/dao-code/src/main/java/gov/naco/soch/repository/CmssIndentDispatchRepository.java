package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssIndentDispatch;

@Repository
public interface CmssIndentDispatchRepository extends JpaRepository<CmssIndentDispatch, Long> {

}
