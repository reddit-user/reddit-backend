package com.greenfoxacademy.reddit.services;

import com.greenfoxacademy.reddit.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kond on 2017. 05. 11..
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
