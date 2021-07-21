package ro.siit.service;

import ro.siit.model.UserDto;

import java.util.Optional;

public interface UserService {

    boolean saveUser(UserDto userDto);

    Optional<UserDto> findByEmail(String email);
}

