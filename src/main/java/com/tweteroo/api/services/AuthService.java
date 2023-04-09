package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.AuthRepository;

@Service
public class AuthService {

  @Autowired
  private AuthRepository repository;

  public void create(User user) {
    this.isUserAlreadyRegistered(user.getUsername());
    this.repository.save(user);
  }

  private void isUserAlreadyRegistered(String username) {
    List<User> registeredUser = this.repository.findByUsername(username);

    if(!registeredUser.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatusCode.valueOf(409), "nome de usuário já cadastrado");
    }
  }

  User isUserRegistered(String username) {
    List<User> dbUser = this.repository.findByUsername(username);

    if(dbUser.isEmpty()) {
      throw new ResponseStatusException(
        HttpStatusCode.valueOf(404), "nome de usuário não encontrado");
    }

    return dbUser.get(0);
  }
}
