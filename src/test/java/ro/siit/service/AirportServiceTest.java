package ro.siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ro.siit.domain.Airport;
import ro.siit.repository.AirportRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private final AirportService airportService = new AirportServiceImpl();

    @Test
    void testFindByAirportName() {
        when(airportRepository.findByAirportName("Charlo Airport")).thenReturn(
                Optional.of(new Airport(1L, "Charlo Airport", "Charlo", "Canada", "YCL",
                        "CYCL", "47.990799", "-66.330299"))
        );

        var airline = airportService.findByAirportName("Charlo Airport");

        Assertions.assertNotNull(airline, "The returned airport should exist");
    }

    @Test
    void testFindAllAirports() {
        when(airportRepository.findAll()).thenReturn(
                List.of(new Airport(1L, "Charlo Airport", "Charlo", "Canada", "YCL",
                                "CYCL", "47.990799", "-66.330299"),
                        new Airport(2L, "Kugluktuk Airport", "Coppermine", "Canada", "YCO",
                                "CYCO", "67.816704", "-115.143997"),
                        new Airport(3L, "Coronation Airport", "Coronation", "Canada", "YCT",
                                "CYCT", "52.07500076", "-111.4449997"))
        );

        var airlines = airportService.findAllAirports();

        Assertions.assertNotNull(airlines, "The returned list should exist");
        Assertions.assertEquals(3, airlines.size(),
                "The returned list doesn't contain the expected number of elements");
    }

    @Test
    void testFindById() {
        when(airportRepository.findById(1L)).thenReturn(
                Optional.of(new Airport(1L, "Charlo Airport", "Charlo", "Canada", "YCL",
                        "CYCL", "47.990799", "-66.330299"))
        );

        var airline = airportService.findById(1L);

        Assertions.assertNotNull(airline, "The returned airport should exist");
    }
}

