package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockDailyBalance;

@Repository
public interface FacilityStocklDailyBalanceRepository extends JpaRepository<FacilityStockDailyBalance, Long>{

}
