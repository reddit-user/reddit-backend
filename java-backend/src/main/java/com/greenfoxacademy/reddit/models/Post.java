package com.greenfoxacademy.reddit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by kond on 2017. 05. 11..
 */
@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private String href;
  private Timestamp timestamp;
  private int score;
  private String owner;
  private int vote;

  public Post() {
    this.timestamp = new Timestamp(System.currentTimeMillis() / 1000);
    this.score = 0;
    this.vote = 0;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

  public void upvote() {
    this.score++;
  }

  public void downvote() {
    this.score--;
  }
}
