package ro.siit.service;

import ro.siit.model.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {

    Optional<AirportDto> findByAirportName(String airportName);

    List<AirportDto> findAllAirports();

    Optional<AirportDto> findById(Long id);
}

