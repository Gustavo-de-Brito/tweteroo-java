package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.TweetMessage;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private AuthService userSevice;
  @Autowired
  private TweetRepository repository;

  public void create(TweetDTO newTweet) {
    User user = this.userSevice.isUserRegistered(newTweet.username());

    TweetMessage tweet = new TweetMessage(user, newTweet.tweet());

    System.out.println("chegou ali ó");

    this.repository.save(tweet);
  }

}
