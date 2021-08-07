package ro.siit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ro.siit.domain.User;
import ro.siit.domain.UserRole;
import ro.siit.model.UserDto;
import ro.siit.repository.UserRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private final UserService userService = new UserServiceImpl();

    @Test
    void testSaveUser() {
        final User user = new User(1L, "test@email.com", "parola",
                "firstN", "lastN", UserRole.USER);

        final UserDto userDto = new UserDto("test@email.com", "firstN", "lastN",
                "parola", UserRole.USER);

        when(userRepository.save(any(User.class))).thenReturn(user);

        var saveUser = userService.saveUser(userDto);
    }

    @Test
    void testFindByEmail() {
        when(userRepository.findByEmail("test@email.com")).thenReturn(
                Optional.of(new User(1L, "test@email.com", "parola",
                        "firstN", "lastN", UserRole.USER))
        );

        var user = userService.findByEmail("test@email.com");

        Assertions.assertNotNull(user, "The returned user should exist");
    }
}

