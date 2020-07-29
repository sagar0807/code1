package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatchReceiptRemark;

@Repository
public interface FacilityDispatchReceiptRemarkRepository extends JpaRepository<FacilityDispatchReceiptRemark, Long> {

}
