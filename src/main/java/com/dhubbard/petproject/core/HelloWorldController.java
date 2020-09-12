package com.dhubbard.petproject.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HelloWorldController {

	private ArrayList<User> users = new ArrayList<>();

	@PostMapping("/login")
	ResponseEntity loginUser(@RequestBody UserLogin userLogin) {
		for (User user : this.users) {
			if (user.getEmail().equals(userLogin.getEmail()) && user.getPassword().equals(userLogin.getPassword())) {
				return ResponseEntity.status(200).body("Logged in");
			}
		}
		return ResponseEntity.status(401).body("Incorrect email or password");
	}

	@PostMapping("/register")
	ResponseEntity registerUser(@RequestBody UserLogin userLogin) {
		User newUser = new User(userLogin.getEmail(), userLogin.getPassword());
		for (User user : this.users) {
			if (user.getEmail().equals(newUser.getEmail())) {
				return ResponseEntity.status(409).body("User email already exists");
			}
		}
		this.users.add(newUser);
		return ResponseEntity.status(200).body("Successful registration");
	}
}
