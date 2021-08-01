package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.siit.service.AirlineService;
import ro.siit.service.AirportService;
import ro.siit.service.FlightService;

import javax.annotation.security.RolesAllowed;

@Controller
public class DashboardController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;


    @GetMapping("/dashboard")
    @RolesAllowed("ROLE_ADMIN")
    public String showDashboard(final Model model) {
        model.addAttribute("flights", flightService.findAllFlights());
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "dashboard";
    }
}

