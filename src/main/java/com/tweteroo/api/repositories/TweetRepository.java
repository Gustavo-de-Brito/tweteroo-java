package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.TweetMessage;

public interface TweetRepository extends JpaRepository<TweetMessage, Long> {

  List<TweetMessage> findByUserId(Long userId);
}
