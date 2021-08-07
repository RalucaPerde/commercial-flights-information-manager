package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.model.AirlineDto;
import ro.siit.service.AirlineService;

@Controller
public class AirlinesController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/airlines")
    public String showAirportProfile(@RequestParam(value = "id", required = false) final Long airlineId,
                                     final Model model, final AirlineDto airlDto) {
        if (airlineId == null) {
            model.addAttribute("airlines", airlineService.findAllAirlines());
            return "airlines";
        } else {
            airlineService.findById(airlineId).ifPresent(airlineDto -> model.addAttribute("airlineDto", airlineDto));
            return "airline";
        }
    }
}

