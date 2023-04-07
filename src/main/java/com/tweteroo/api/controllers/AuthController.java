package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.AuthService;

@RestController
@RequestMapping("/sign-up")
public class AuthController {
  @Autowired
  private AuthService service;

  @PostMapping
  public void create(@RequestBody UserDTO req) {
    this.service.create(new User(req));
  }
}
