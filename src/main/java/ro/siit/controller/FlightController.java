package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.siit.model.AirportDto;
import ro.siit.model.FlightDto;
import ro.siit.service.AirlineService;
import ro.siit.service.AirportService;
import ro.siit.service.FlightService;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/flights")
    public String showFlightsPage(final Model model) {
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        model.addAttribute("flightDto", new FlightDto());
        return "flights";
    }

    @PostMapping("/show-flights")
    public String showFlightsResult(final Model model, final FlightDto flightDto) {
        model.addAttribute("flights", flightService.findAllActualFlights());
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "flights-result";
    }

    @PostMapping("/show-flights-airlines")
    public String showFlightsResultByAirline(final Model model, final FlightDto flightDto) {
        model.addAttribute("flights", flightService.findAllActualFlights());
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "flights-result-by-airline";
    }
}

