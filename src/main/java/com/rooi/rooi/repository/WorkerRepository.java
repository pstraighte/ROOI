package com.rooi.rooi.repository;

import com.rooi.rooi.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> findAllByUserId(Long id);
}
