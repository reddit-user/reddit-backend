package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.models.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kond on 2017. 05. 11..
 */
@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

//  @Query("SELECT v.vote from Vote v WHERE v.userName = ?1 AND v.postId = ?2")
//  int getVote(long userId, long postId);

  Vote findByUserNameAndPostId(String userName, long postId);
  List<Vote> findByPostId(long postId);
}
