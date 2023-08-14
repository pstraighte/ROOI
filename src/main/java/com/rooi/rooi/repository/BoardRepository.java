package com.rooi.rooi.repository;

import com.rooi.rooi.entity.Board;
import com.rooi.rooi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByUserId(Long userId);
}