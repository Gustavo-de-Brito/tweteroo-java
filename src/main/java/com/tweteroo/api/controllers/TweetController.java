package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RequestMapping("/tweets")
@RestController
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public void create(@Valid @RequestBody TweetDTO req) {
    this.service.create(req);
  }
}
