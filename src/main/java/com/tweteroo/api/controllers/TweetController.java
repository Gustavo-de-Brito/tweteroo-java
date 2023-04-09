package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.ResponseTweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/tweets")
@RestController
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public void create(@Valid @RequestBody TweetDTO req) {
    this.service.create(req);
  }

  @GetMapping()
  public List<ResponseTweet> getTweets(@RequestParam int page) {
    return this.service.getTweets(page);
  }
}
