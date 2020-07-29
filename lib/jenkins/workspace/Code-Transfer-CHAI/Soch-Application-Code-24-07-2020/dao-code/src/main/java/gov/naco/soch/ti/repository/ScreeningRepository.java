package gov.naco.soch.ti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.ti.entity.Screening;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long>, JpaSpecificationExecutor<Screening> {
    
}