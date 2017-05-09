package com.microservices.userservice.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.client.RestTemplate;

import com.microservices.userservice.model.AjaxResponseBody;
import com.microservices.userservice.model.User;

@Service
public class UserService {

    RestTemplate restTemplate;
    public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
    

    public ResponseEntity<?>  findByUserNameOrEmail(String username,Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }

        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity("http://localhost:8090/usersearch/"+username, User[].class);
           
        List<User> users = Arrays.asList(responseEntity.getBody());

        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);
        return ResponseEntity.ok(result);
    }
}
