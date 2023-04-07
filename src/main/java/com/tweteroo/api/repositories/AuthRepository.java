package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.User;

public interface AuthRepository extends JpaRepository<User, Long> {

  List<User> findByUsername(String username);
}
