package ro.siit.service;

import ro.siit.model.FlightDto;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    Optional<FlightDto> findById(Long id);

    List<FlightDto> findAllFlights();

    List<FlightDto> findAllActualFlights();

    boolean addFlight(FlightDto flightDto);

    void updateFlight(Long id, FlightDto flightDto);
}

