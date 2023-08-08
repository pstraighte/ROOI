package com.rooi.rooi.repository;

import com.rooi.rooi.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
