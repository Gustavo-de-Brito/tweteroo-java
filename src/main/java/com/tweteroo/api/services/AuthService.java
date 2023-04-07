package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.AuthRepository;

@Service
public class AuthService {

  @Autowired
  private AuthRepository repository;

  public void create(User user) {
    this.repository.save(user);
  }
}
