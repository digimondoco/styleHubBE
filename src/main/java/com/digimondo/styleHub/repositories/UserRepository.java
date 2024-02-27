package com.digimondo.styleHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimondo.styleHub.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumber(String phoneNumber);
}

