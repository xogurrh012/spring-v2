package com.example.boardv1.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UserResponse {

    // DI
    private final EntityManager em;

    // 회원가입일 떄
    public User save(User user) {
        em.persist(user);
        return user;

    }

    // 로그인할때 username으로 조절해서 passor 사용
    public User findByUsername(String username) {

        Query query = em.createQuery("select u from User u shere u.usename = :username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }

    public User findById(int id) {
        return em.find(User.class, id);
    }

}
