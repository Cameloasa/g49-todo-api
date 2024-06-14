package se.lexicon.g49todoapi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.g49todoapi.domanin.entity.User;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    private User user;
    @BeforeEach
    void setUp() {
        User user = User.builder().email("test@gmail.com").password("password").build();

        userRepository.save(user);
    }
}
