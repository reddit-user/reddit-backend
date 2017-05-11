package com.greenfoxacademy.reddit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kond on 2017. 05. 11..
 */
@Controller
@CrossOrigin("*")
public class MainController {

  @RequestMapping("/")
  public String index() {
    return "redirect:http://localhost:8080";
  }

}
