package com.swiftride.customer_service.Repositories;

import com.swiftride.customer_service.Entities.LocationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationHistory, Long> {
}
