package com.digimondo.styleHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digimondo.styleHub.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

