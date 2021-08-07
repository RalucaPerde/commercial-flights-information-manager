package ro.siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.siit.domain.Airline;
import ro.siit.repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AirlineServiceTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private final AirlineService airlineService = new AirlineServiceImpl();

    @Test
    void testFindAllAirlines() {
        when(airlineRepository.findAll()).thenReturn(
                List.of(new Airline(1L, "Airborne Express", "United States", "GB", "ABX"),
                        new Airline(2L, "Air Europa", "Spain", "UX", "AEA"),
                        new Airline(3L, "Arik Air", "Nigeria", "W3", "ARA"))
        );

        var airlines = airlineService.findAllAirlines();

        Assertions.assertNotNull(airlines, "The returned list should exist");
        Assertions.assertEquals(3, airlines.size(),
                "The returned list doesn't contain the expected number of elements");
    }

    @Test
    void testFindById() {
        when(airlineRepository.findById(1L)).thenReturn(
                Optional.of(new Airline(3L, "1Time Airline", "South Africa", "1T", "RNX"))
        );

        var airline = airlineService.findById(1L);

        Assertions.assertNotNull(airline, "The returned airline should exist");
    }
}

