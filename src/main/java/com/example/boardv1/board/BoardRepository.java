package com.example.boardv1.board;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

/**
 * 하이버네이트 기술
 */

@RequiredArgsConstructor // final이 붙어 있는 모든 필드를 초기화하는 생성자를 만들어줌.
@Repository
public class BoardRepository {

    private final EntityManager em;

    // DI = 의존성 주입 (의존하고 있는게 IoC에 떠있어야됨)
    // public BoardRepository(EntityManager em) {
    // this.em = em;
    // }

    public Optional<Board> findByIdJoinUser(int id) {
        Query query = em.createQuery("select b from Board b join fetch b.user u where b.id = :id", Board.class);
        query.setParameter("id", id);
        try {
            Board board = (Board) query.getSingleResult();
            return Optional.of(board);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.ofNullable(null);
        }
    }

    public List<Board> findAll() {
        Query query = em.createQuery("select b from Board b order by b.id desc", Board.class);
        List<Board> findBoards = query.getResultList(); // 객체지향쿼리
        return findBoards;
    }

    public Board save(Board board) {
        em.persist(board); // 영속화(영구히 저장하다.)
        return board;
    }

    public void delete(Board board) {
        em.remove(board);
    }

}