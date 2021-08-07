package ro.siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.siit.domain.Airline;
import ro.siit.domain.Airport;
import ro.siit.domain.Flight;
import ro.siit.model.FlightDto;
import ro.siit.repository.AirlineRepository;
import ro.siit.repository.AirportRepository;
import ro.siit.repository.FlightRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private final FlightService flightService = new FlightServiceImpl();

    @Test
    void testFindById() {
        when(flightRepository.findById(1L)).thenReturn(
                Optional.of(new Flight(1L, "1S234",
                        LocalDateTime.of(2021, 7, 29, 0, 0, 0),
                        LocalDateTime.of(2021, 7, 29, 1, 30, 0),
                        new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                "GKA", "AYGA", "-6.081689835", "145.3919983"),
                        new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                "MAG", "AYMD", "-5.207079887", "145.7890015"),
                        new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX"))));

        var flight = flightService.findById(1L);

        Assertions.assertNotNull(flight, "The returned flight should exist");
    }

    @Test
    void testFindAllFlights() {
        when(flightRepository.findAll()).thenReturn(
                List.of(new Flight(1L, "1S234",
                                LocalDateTime.of(2021, 7, 29, 0, 0, 0),
                                LocalDateTime.of(2021, 7, 29, 1, 30, 0),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")),
                        new Flight(2L, "1ST634",
                                LocalDateTime.of(2021, 8, 30, 0, 0, 0),
                                LocalDateTime.of(2021, 8, 30, 1, 30, 0),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")),
                        new Flight(3L, "S58234",
                                LocalDateTime.of(2021, 9, 29, 0, 0, 0),
                                LocalDateTime.of(2021, 9, 29, 1, 30, 0),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")))
        );

        var flights = flightService.findAllFlights();

        Assertions.assertNotNull(flights, "The returned list should exist");
        Assertions.assertEquals(3, flights.size(),
                "The returned list doesn't contain the expected number of elements");
    }

    @Test
    void testFindAllActualFlights() {
        when(flightRepository.findAll()).thenReturn(
                List.of(new Flight(1L, "1S234",
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")),
                        new Flight(2L, "1ST634",
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")),
                        new Flight(3L, "S58234",
                                LocalDateTime.now(),
                                LocalDateTime.now(),
                                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX")))
        );

        var flights = flightService.findAllActualFlights();

        Assertions.assertNotNull(flights, "The returned list should exist");
        Assertions.assertEquals(3, flights.size(),
                "The returned list doesn't contain the expected number of elements");
    }


    @Test
    void testAddFlight() {
        final Flight flight1 = new Flight(1L, "1S234",
                LocalDateTime.of(2021, 7, 29, 0, 0, 0),
                LocalDateTime.of(2021, 7, 29, 1, 30, 0),
                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX"));

        final FlightDto flightDto = new FlightDto(1L, "1S234",
                LocalDateTime.of(2021, 7, 29, 0, 0, 0).toString(),
                LocalDateTime.of(2021, 7, 29, 1, 30, 0).toString(),
                1L, 2L, 3L);

        when(flightRepository.save(any(Flight.class))).thenReturn(flight1);

        var flight = flightService.addFlight(flightDto);
    }

    @Test
    void testUpdateFlight() {
        final Flight flight1 = new Flight(1L, "1S234",
                LocalDateTime.of(2021, 7, 29, 0, 0, 0),
                LocalDateTime.of(2021, 7, 29, 1, 30, 0),
                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX"));

        final FlightDto flightDto = new FlightDto(1L, "1234",
                LocalDateTime.of(2021, 7, 29, 0, 0, 0).toString(),
                LocalDateTime.of(2021, 7, 29, 1, 30, 0).toString(),
                1L, 2L, 3L);

        when(flightRepository.save(any(Flight.class))).thenReturn(flight1);

        flightService.updateFlight(1L, flightDto);
    }

    @Test
    void testDeleteFlight() {
        final Flight flight = new Flight(1L, "1S234",
                LocalDateTime.of(2021, 7, 29, 0, 0, 0),
                LocalDateTime.of(2021, 7, 29, 1, 30, 0),
                new Airport(1L, "Goroka Airport", "Goroka", "Papua New Guinea",
                        "GKA", "AYGA", "-6.081689835", "145.3919983"),
                new Airport(2L, "Madang Airport", "Madang", "Papua New Guinea",
                        "MAG", "AYMD", "-5.207079887", "145.7890015"),
                new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX"));

        when(flightRepository.findById(flight.getId())).thenReturn(Optional.of(flight));
        flightService.deleteFlight(flight.getId());
        verify(flightRepository).delete(flight);
    }
}

