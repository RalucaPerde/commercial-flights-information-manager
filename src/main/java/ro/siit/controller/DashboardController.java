package ro.siit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.siit.model.FlightDto;
import ro.siit.service.AirlineService;
import ro.siit.service.AirportService;
import ro.siit.service.FlightService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@Controller
public class DashboardController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirlineService airlineService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);


    @GetMapping("/dashboard")
    @RolesAllowed("ROLE_ADMIN")
    public String showDashboard(final Model model) {
        model.addAttribute("flights", flightService.findAllFlights());
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "dashboard";
    }

    @GetMapping("/dashboard/add")
    @RolesAllowed("ROLE_ADMIN")
    public String showAddFlights(final Model model) {
        model.addAttribute("flightDto", new FlightDto());
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "flight-form";
    }

    @PostMapping("process-add")
    public String processAddFlight(@Valid final FlightDto flightDto, final BindingResult bindingResult,
                                   final Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.debug("We have errors in the form : {}", bindingResult);
            model.addAttribute("flightDto", flightDto);
            model.addAttribute("flights", flightService.findAllFlights());
            model.addAttribute("airports", airportService.findAllAirports());
            model.addAttribute("airlines", airlineService.findAllAirlines());
            return "flight-form";
        } else {
            flightService.addFlight(flightDto);
            return "add-success";
        }
    }

    @GetMapping("dashboard/edit/{id}")
    @RolesAllowed("ROLE_ADMIN")
    public String showEditFlight(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("flightDto", flightService.findById(id));
        model.addAttribute("airports", airportService.findAllAirports());
        model.addAttribute("airlines", airlineService.findAllAirlines());
        return "edit-form";
    }

    @PostMapping("process-edit/{id}")
    public String processEditFlight(@PathVariable(name = "id") final Long id,
                                    @Valid final FlightDto flightDto, final BindingResult bindingResult,
                                    final Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.debug("We have errors in the form : {}", bindingResult);
            model.addAttribute("flightDto", flightDto);
            model.addAttribute("flights", flightService.findAllFlights());
            model.addAttribute("airports", airportService.findAllAirports());
            model.addAttribute("airlines", airlineService.findAllAirlines());
            return "edit-form";
        } else {
            flightService.updateFlight(id, flightDto);
            return "edit-success";
        }
    }
}

