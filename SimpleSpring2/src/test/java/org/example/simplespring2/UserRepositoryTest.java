package org.example.simplespring2;

import org.example.simplespring2.model.User;
import org.example.simplespring2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void testFindUserByEmail() {
        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane.doe@example.com");

        userRepository.save(user);

        User found = userRepository.findAll().get(0);

        assertThat(found.getEmail()).isEqualTo(user.getEmail());
    }
}
