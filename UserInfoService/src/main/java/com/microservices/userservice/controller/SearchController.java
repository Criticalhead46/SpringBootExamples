package com.microservices.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.userservice.model.User;
import com.microservices.userservice.services.UserService;

@RestController
public class SearchController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

  @RequestMapping("/usersearch/{username}")
  public List<User> getUserByName(@PathVariable("username") String username)
  {
	 return  userService.findByUserName(username);
	  
  }
  
}
