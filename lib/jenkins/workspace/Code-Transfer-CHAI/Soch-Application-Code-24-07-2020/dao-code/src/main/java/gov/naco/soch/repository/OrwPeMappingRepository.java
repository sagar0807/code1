package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OrwPeMapping;

@Repository
public interface OrwPeMappingRepository extends JpaRepository<OrwPeMapping, Long> {

	OrwPeMapping findByPeUserIdAndIsDelete(Long peId, Boolean false1);

	Optional<OrwPeMapping> findByOrwUserIdAndPeUserId(Long id, Long id2);

}
