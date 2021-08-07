package ro.siit.service;

import ro.siit.model.AirlineDto;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    List<AirlineDto> findAllAirlines();

    Optional<AirlineDto> findById(Long id);
}

