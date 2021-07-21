package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.siit.model.UserDto;
import ro.siit.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}/profile")
    @PreAuthorize("isAuthenticated()")
    public String getProfile(@PathVariable("userName") final String email, final Model model, final Principal principal) {
        userService.findByEmail(email).ifPresentOrElse(userDto -> model.addAttribute("user", userDto),
                () -> model.addAttribute("user", new UserDto("N/A", "N/A", "N/A")));
        return "profile";
    }
}

