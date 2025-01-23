package com.paul.security.user_security.controller;

import com.paul.security.user_security.SecurityConfig;
import com.paul.security.user_security.model.UserTable;
import com.paul.security.user_security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retail/user")
public class SecurityController {

	Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	UserService service;


	@GetMapping("/home")
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserTable>> getUsers(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/token")
	public CsrfToken getToken(HttpServletRequest httpServletRequest){
		return (CsrfToken) httpServletRequest.getAttribute("_csrf");

	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody List<UserTable> users){

		service.save(users);
//		return new ResponseEntity<>("Added", HttpStatus.CREATED);
		return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully.");
	}

	@DeleteMapping("delete/{userId}")
	public ResponseEntity<String> deleteUsers(@PathVariable String userId){
		service.delete(userId);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
	}
	
}
