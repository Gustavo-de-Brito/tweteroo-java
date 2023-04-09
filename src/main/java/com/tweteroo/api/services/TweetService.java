package com.tweteroo.api.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.models.ResponseTweet;
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

    this.repository.save(tweet);
  }

  public List<ResponseTweet> getTweets(int page) {
    if(page <= 0) {
      throw new ResponseStatusException(
        HttpStatusCode.valueOf(400), "o valor da página deve ser um inteiro igual ou maior que 1"
      );
    }
  
    Page<TweetMessage> tweetsMessage = this.repository.findAll(PageRequest.of(page - 1, 5));

    return this.convertToReponseTweets(tweetsMessage.getContent());
  }

  public List<ResponseTweet> getTweetsByUsername(String username) {
    User user = this.userSevice.isUserRegistered(username);

    List<TweetMessage> tweets = this.repository.findByUserId(user.getId());

    return this.convertToReponseTweets(tweets);
  }

  private List<ResponseTweet> convertToReponseTweets(List<TweetMessage> tweets) {
    List<ResponseTweet> formatedTweets = new ArrayList<>();

    for(int i = 0; i < tweets.size(); i++) {
      ResponseTweet formatedTweet = new ResponseTweet(
        tweets.get(i).getUser().getUsername(),
        tweets.get(i).getUser().getAvatar(),
        tweets.get(i).getTweet()
      );

      formatedTweets.add(formatedTweet);
    }

    return formatedTweets;
  }

}
