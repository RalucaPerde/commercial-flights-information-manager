package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.domain.Airline;
import ro.siit.domain.Airport;
import ro.siit.domain.Flight;
import ro.siit.model.FlightDto;
import ro.siit.repository.AirlineRepository;
import ro.siit.repository.AirportRepository;
import ro.siit.repository.FlightRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public Optional<FlightDto> findById(final Long id) {

        return flightRepository.findById(id)
                .map(flight -> new FlightDto(flight.getId(), flight.getFlightNo(), flight.getDeparture().toString(),
                        flight.getArrival().toString(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()));
    }

    @Override
    public List<FlightDto> findAllFlights() {

        return flightRepository.findAll().stream()
                .map(flight -> new FlightDto(flight.getId(), flight.getFlightNo(), flight.getDeparture().toString(),
                        flight.getArrival().toString(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()))
                .toList();
    }

    @Override
    public List<FlightDto> findAllActualFlights() {
        return flightRepository.findAll().stream()
                .filter(flight -> (flight.getDeparture().toLocalDate().equals(LocalDate.now()) ||
                        flight.getArrival().toLocalDate().equals(LocalDate.now())))
                .map(flight -> new FlightDto(flight.getFlightNo(), flight.getDeparture().toString(), flight.getArrival().toString(),
                        flight.getDepartureAirport().getId(), flight.getArrivalAirport().getId(),
                        flight.getAirline().getId()))
                .toList();
    }

    @Override
    public boolean addFlight(FlightDto flightDto) {
        final Flight flight = new Flight();
        flight.setFlightNo(flightDto.getFlightNo());
        flight.setDeparture(LocalDateTime.parse(flightDto.getDeparture()));
        flight.setArrival(LocalDateTime.parse(flightDto.getArrival()));
        flight.setDepartureAirport(airportRepository.findById(flightDto.getDepartureAirportId()).orElseGet(
                () -> new Airport(-1L, "N/A", "N/A", "N/A", "N/A",
                        "N/A", "N/A", "N/A")));
        flight.setArrivalAirport(airportRepository.findById(flightDto.getArrivalAirportId()).orElseGet(
                () -> new Airport(-1L, "N/A", "N/A", "N/A", "N/A",
                        "N/A", "N/A", "N/A")));
        flight.setAirline(airlineRepository.findById(flightDto.getAirlineId()).orElseGet(
                () -> new Airline(-1L, "N/A", "N/A", "N/A", "N/A")));
        final Flight savedFlight = flightRepository.save(flight);
        return (savedFlight.getId() != null);
    }

    @Override
    public void updateFlight(final Long id, final FlightDto flightDto) {
        flightRepository.findById(id).ifPresent(flight -> {
            flight.setFlightNo(flightDto.getFlightNo());
            flight.setDeparture(LocalDateTime.parse(flightDto.getDeparture()));
            flight.setArrival(LocalDateTime.parse(flightDto.getArrival()));
            flight.setDepartureAirport(airportRepository.findById(flightDto.getDepartureAirportId()).orElseGet(
                    () -> new Airport(-1L, "N/A", "N/A", "N/A", "N/A",
                            "N/A", "N/A", "N/A")));
            flight.setArrivalAirport(airportRepository.findById(flightDto.getArrivalAirportId()).orElseGet(
                    () -> new Airport(-1L, "N/A", "N/A", "N/A", "N/A",
                            "N/A", "N/A", "N/A")));
            flight.setAirline(airlineRepository.findById(flightDto.getAirlineId()).orElseGet(
                    () -> new Airline(-1L, "N/A", "N/A", "N/A", "N/A")));
            flightRepository.save(flight);
        });
    }
}

