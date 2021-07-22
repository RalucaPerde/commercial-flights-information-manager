package ro.siit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.siit.model.UserDto;
import ro.siit.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(final Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/process-register")
    public String processRegistration(@Valid final UserDto userDto) {
        userService.saveUser(userDto);
        return "register-success";
    }
}

