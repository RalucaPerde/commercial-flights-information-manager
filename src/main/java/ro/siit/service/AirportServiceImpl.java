package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.model.AirportDto;
import ro.siit.repository.AirportRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Optional<AirportDto> findByAirportName(final String airportName) {
        return airportRepository.findByAirportName(airportName)
                .map(airport -> new AirportDto(airport.getId(), airport.getAirportName(), airport.getCity(), airport.getCountry()
                        , airport.getIata(), airport.getIcao(), airport.getLatitude(), airport.getLongitude()));
    }

    @Override
    public List<AirportDto> findAllAirports() {
        return airportRepository.findAll().stream()
                .map(airport -> new AirportDto(airport.getId(), airport.getAirportName(), airport.getCity(), airport.getCountry()
                        , airport.getIata(), airport.getIcao(), airport.getLatitude(), airport.getLongitude()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AirportDto> findById(final Long id) {
        return airportRepository.findById(id)
                .map(airport -> new AirportDto(airport.getId(), airport.getAirportName(), airport.getCity(), airport.getCountry()
                        , airport.getIata(), airport.getIcao(), airport.getLatitude(), airport.getLongitude()));
    }
}

