package com.rooi.rooi.repository;

import com.rooi.rooi.entity.Permission;
import com.rooi.rooi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	boolean existsByBoardIdAndUserId(Long boardId, Long userId);

	List<Permission> findAllByBoardId(Long boardId);

	List<Permission> findAllByUserId(Long userId);
}
