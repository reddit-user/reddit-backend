package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.models.User;
import com.greenfoxacademy.reddit.services.PostRepository;
import com.greenfoxacademy.reddit.services.PostsService;
//import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class PostsController {

  @Autowired
  PostsService postsService;

  @GetMapping("/posts")
  public Iterable<Post> getPosts(@RequestHeader("Username") String user) {
    return postsService.getPosts(user);
  }

  @PostMapping("/posts")
  public Post addPost(@RequestHeader("Username") String user,
                      @RequestBody Post newPost) {
    return postsService.addPost(user, newPost);
  }

  @PutMapping("/posts/{id}/upvote")
  public Post upvote(@RequestHeader("Username") String user,
                     @PathVariable("id") long id) {
    return postsService.vote(user, id, "up");
  }

  @PutMapping("/posts/{id}/downvote")
  public Post downvote(@RequestHeader("Username") String user,
                       @PathVariable("id") long id) {
    return postsService.vote(user, id, "down");
  }

  @DeleteMapping("/posts/{id}")
  public Post deletePost(@RequestHeader("Username") String user,
                         @PathVariable("id") long id) {
    return postsService.delete(user, id);
  }

  @PutMapping("/posts/{id}")
  public Post modifyPost(@RequestHeader("Username") String user,
                         @PathVariable("id") long id,
                         @RequestBody Post modifiedPost) {
    return postsService.modify(user, id, modifiedPost);
  }

}
