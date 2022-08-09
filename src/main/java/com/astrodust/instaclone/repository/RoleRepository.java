package com.astrodust.instaclone.repository;

import com.astrodust.instaclone.entity.Role;
import com.astrodust.instaclone.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(@Param("name") RoleEnum name);
}
