package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHrgSecondary;

@Repository
public interface MasterHrgSecondaryRepository extends JpaRepository<MasterHrgSecondary, Long> {

	List<MasterHrgSecondary> findByIsDelete(Boolean isDelete);

}