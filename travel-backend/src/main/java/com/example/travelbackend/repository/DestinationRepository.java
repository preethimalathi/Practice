
package com.example.travelbackend.repository;

import com.example.travelbackend.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByRegion(String region);
}
