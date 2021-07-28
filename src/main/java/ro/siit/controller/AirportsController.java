package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.model.AirportDto;
import ro.siit.service.AirportService;
import ro.siit.service.FlightService;

@Controller
public class AirportsController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @GetMapping("/airports")
    public String showAirportProfile(@RequestParam(value = "airportName", required = false) final String airportName,
                                     final Model model, final AirportDto airDto) {
        if (airportName == null) {
            model.addAttribute("airports", airportService.findAllAirports());
            return "airports";
        } else {
            airportService.findByAirportName(airportName).ifPresentOrElse(airportDto -> model.addAttribute("airportDto", airportDto),
                    () -> model.addAttribute("airportDto", new AirportDto("N/A", "N/A",
                            "N/A", "N/A", "N/A", "N/A", "N/A")));
            return "airport";
        }
    }

    @GetMapping("/airport/{airportName}")
    public String showProfile(@PathVariable("airportName") final String airportName,
                              final Model model, final AirportDto airDto) {

        airportService.findByAirportName(airportName).ifPresentOrElse(airportDto -> model.addAttribute("airportDto", airportDto),
                () -> model.addAttribute("airportDto", new AirportDto("N/A", "N/A",
                        "N/A", "N/A", "N/A", "N/A", "N/A")));
        return "airport";
    }
}

