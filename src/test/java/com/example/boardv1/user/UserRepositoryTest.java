package com.example.boardv1.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_test() {
        // given
        User user = new User();
        user.setUsername("mi5");
        user.setPassword("1234");
        user.setEmail("mi5qjgt@gmail.com");

        // when
        User findUser = userRepository.save(user);

        // eye (user 객체가 DB 데이터와 동기화되었음)
        System.out.println(findUser);
    }

    @Test
    public void findByUsername_test() {
        // given
        String username = "ssar";

        // when
        User finduser = userRepository.findByUsername(username);

        // eye
        System.out.println(finduser);

    }
}
