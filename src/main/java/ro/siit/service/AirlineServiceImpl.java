package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.model.AirlineDto;
import ro.siit.repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override
    public List<AirlineDto> findAllAirlines() {
        return airlineRepository.findAll().stream()
                .map(airline -> new AirlineDto(airline.getId(), airline.getAirlineName(), airline.getCountry(),
                        airline.getIata(), airline.getIcao()))
                .toList();
    }

    @Override
    public Optional<AirlineDto> findById(final Long id) {
        return airlineRepository.findById(id)
                .map(airline -> new AirlineDto(airline.getId(), airline.getAirlineName(), airline.getCountry(),
                        airline.getIata(), airline.getIcao()));
    }
}

