package com.rooi.rooi.repository;

import com.rooi.rooi.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
