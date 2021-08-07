package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.model.FlightDto;
import ro.siit.repository.AirportRepository;
import ro.siit.repository.FlightRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Optional<FlightDto> findById(final Long id) {

        return flightRepository.findById(id)
                .map(flight -> new FlightDto(flight.getFlightNo(), flight.getDeparture(), flight.getArrival(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()));
    }

    @Override
    public List<FlightDto> findAllFlights() {

        return flightRepository.findAll().stream()
                .map(flight -> new FlightDto(flight.getFlightNo(), flight.getDeparture(), flight.getArrival(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> findAllActualFlights() {
        return flightRepository.findAll().stream()
                .filter(flight -> (flight.getDeparture().equals(LocalDate.now()) || flight.getArrival().equals(LocalDate.now())))
                .map(flight -> new FlightDto(flight.getFlightNo(), flight.getDeparture(), flight.getArrival(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()))
                .collect(Collectors.toList());
    }
}

