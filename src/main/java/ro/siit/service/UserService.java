package ro.siit.service;

import org.springframework.ui.Model;
import ro.siit.model.UserDto;

import java.util.Optional;

public interface UserService {

    boolean saveUser(UserDto userDto);

    Optional<UserDto> findByEmail(String email);

    void addModelAttribute(String email, Model model);
}

