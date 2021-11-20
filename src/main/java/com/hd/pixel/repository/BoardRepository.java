package com.hd.pixel.repository;

import com.hd.pixel.domain.Board;
import com.hd.pixel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
