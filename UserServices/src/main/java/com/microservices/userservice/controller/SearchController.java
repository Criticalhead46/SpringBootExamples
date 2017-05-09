package com.microservices.userservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.userservice.model.SearchCriteria;
import com.microservices.userservice.services.UserService;

@RestController
public class SearchController {
	private final Logger logger = LoggerFactory.getLogger(SearchController.class);
    UserService userService;
    
    RestTemplate restTemplate;
    

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) {
    	logger.debug("User details requested for {}",search.getUsername());
        return userService.findByUserNameOrEmail(search.getUsername(), errors);

    }
		
}
