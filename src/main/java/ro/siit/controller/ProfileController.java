package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.siit.service.UserService;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String getProfile(final Model model, final Principal principal) {
        final String email = principal.getName();
        userService.addModelAttribute(email, model);
        return "profile";
    }
}

