package ro.siit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.siit.domain.Airline;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

    Optional<Airline> findById(Long id);
}

