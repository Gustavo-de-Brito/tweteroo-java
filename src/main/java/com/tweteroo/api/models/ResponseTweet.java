package com.tweteroo.api.models;

import lombok.Data;

@Data
public class ResponseTweet {

  public ResponseTweet(String username, String avatar, String tweet) {
    this.username = username;
    this.avatar = avatar;
    this.tweet = tweet;
  }

  private String username;
  private String avatar;
  private String tweet;
}
