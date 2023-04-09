package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.TweetMessage;

public interface TweetRepository extends JpaRepository<TweetMessage, Long> {

}
