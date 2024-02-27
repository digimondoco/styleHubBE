package com.digimondo.styleHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimondo.styleHub.entities.PhoneNumberToken;

public interface PhoneNumberTokenRepository extends JpaRepository<PhoneNumberToken, Long> {
    PhoneNumberToken findByToken(String token);
}
