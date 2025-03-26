package com.batuhan.smartenergymanagementapplication.repository;

import com.batuhan.smartenergymanagementapplication.model.EnergyUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository


public interface EnergyUsageRepository extends JpaRepository<EnergyUsage, Long> {

}
