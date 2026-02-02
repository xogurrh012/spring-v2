package com.example.boardv1.user;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserRepository.class)
@DataJpaTest
public class UserReositorytest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_tast() {

    }

    @Test
    public void findByUsername() {

    }
}
