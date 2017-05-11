package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kond on 2017. 05. 11..
 */
public interface PostRepository extends CrudRepository<Post, Long> {

}
