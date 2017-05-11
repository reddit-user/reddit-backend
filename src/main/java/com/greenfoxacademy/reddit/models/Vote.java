package com.greenfoxacademy.reddit.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kond on 2017. 05. 11..
 */
@Entity
public class Vote {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String userName;
  private long postId;
  private int vote;

  public Vote() {}

  public Vote(String userName, long postId, int vote) {
    this.userName = userName;
    this.postId = postId;
    this.vote = vote;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }
}
