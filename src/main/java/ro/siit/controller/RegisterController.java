package ro.siit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.siit.model.UserDto;
import ro.siit.service.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(final Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/process-register")
    public String processRegistration(@Valid final UserDto userDto,
                                      final BindingResult bindingResult, final Model model) {

        if (bindingResult.hasErrors()) {
            LOGGER.debug("We have errors in the form : {}", bindingResult);
            model.addAttribute("userDto", userDto);
            return "register";
        } else {
            userService.saveUser(userDto);
            return "register-success";
        }
    }
}

