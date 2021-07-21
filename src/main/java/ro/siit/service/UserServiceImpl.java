package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.siit.domain.User;
import ro.siit.domain.UserRole;
import ro.siit.model.UserDto;
import ro.siit.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUser(UserDto userDto) {
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setRole(UserRole.USER);
        final User savedUser = userRepository.save(user);
        return (savedUser.getId() != null);
    }


    @Override
    public Optional<UserDto> findByEmail(final String email) {
        return userRepository.findByEmail(email)
                .map(user -> new UserDto(user.getEmail(), user.getFirstName(), user.getLastName()));
    }
}

