package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guru.entities.RoleEntity;
import com.guru.entities.UserEntity;
import com.guru.entities.UserRoleEntity;

@Repository
public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity, String>{
	@Query("update UserRoleEntity us set us.user = ?1, us.role = ?2, us.id = ?3")
	void save(@Param("user") UserEntity user, @Param("role") RoleEntity role, @Param("id") String id);
	UserRoleEntity findByUser(UserEntity userEntity);
}
