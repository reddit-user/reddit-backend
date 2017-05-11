package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kond on 2017. 05. 11..
 */
@Component
public class PostsService {

  @Autowired
  PostRepository postRepository;
  @Autowired
  VoteRepository voteRepository;

  public PostsService() {
  }

  public Iterable<Post> getPosts(String user) {
    Iterable<Post> posts = postRepository.findAll();
    for (Post p : posts) {
      p = updateVote(user, p);
    }
    return posts;
  }

  public Post addPost(String user, Post p) {
    p.setOwner(user);
    postRepository.save(p);
    return p;
  }

  public Post vote(String user, long postId, String dir) {
    int vote = (dir.equals("up")) ? 1 : -1;
    Vote v = voteRepository.findByUserNameAndPostId(user, postId);
    if (v == null) {
      voteRepository.save(new Vote(user, postId, vote));
    } else {
      v.setVote(vote);
      voteRepository.save(v);
    }

    Post p = postRepository.findOne(postId);
    if (dir.equals("up"))
      p.upvote();
    else
      p.downvote();
    postRepository.save(p);
      p.setVote(vote);
    return p;
  }

  public Post delete(String user, long id) {
    Post p = postRepository.findOne(id);
    if (p.getOwner().equals(user)) {
      postRepository.delete(id);
      List<Vote> votesToDelete = voteRepository.findByPostId(id);
      for (Vote v : votesToDelete) {
        voteRepository.delete(v.getId());
      }
    }
    return updateVote(user, p);
  }

  public Post modify(String user, long id, Post modifiedPost) {
    Post p = postRepository.findOne(id);
    if (p.getOwner().equals(user)) {
      p.setTitle(modifiedPost.getTitle());
      p.setHref(modifiedPost.getHref());
      postRepository.save(p);
    }
    return updateVote(user, p);
  }

  private Post updateVote(String user, Post p) {
    Vote v = voteRepository.findByUserNameAndPostId(user, p.getId());
    if (v != null)
      p.setVote(v.getVote());
    return p;
  }
}
