package ro.siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ro.siit.domain.User;
import ro.siit.domain.UserRole;
import ro.siit.model.UserDto;
import ro.siit.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public boolean saveUser(UserDto userDto) {
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRole(UserRole.USER);
        final User savedUser = userRepository.save(user);
        return (savedUser.getId() != null);
    }


    @Override
    public Optional<UserDto> findByEmail(final String email) {
        return userRepository.findByEmail(email)
                .map(user -> new UserDto(user.getEmail(), user.getFirstName(), user.getLastName()));
    }

    @Override
    public void addModelAttribute(final String email, final Model model) {
        findByEmail(email).ifPresentOrElse(userDto -> model.addAttribute("user", userDto),
                () -> model.addAttribute("user", new UserDto("N/A", "N/A", "N/A")));
    }
}

