package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.User;

public interface AuthRepository extends JpaRepository<User, Long> {
  
}
