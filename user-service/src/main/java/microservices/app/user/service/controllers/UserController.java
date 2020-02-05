package microservices.app.user.service.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.app.user.service.models.Users;
import microservices.app.user.service.models.dto.UserDto;
import microservices.app.user.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private Environment env;

	@GetMapping("/check/status")
	public String checkStatus(){
		return "User Services is working on " + env.getProperty("local.server.port");
	}
	
	@GetMapping
	public List<UserDto> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{userId}")
	public UserDto getUser(@PathVariable String userId) {
		return userService.getUser(userId);
	}

	@GetMapping("/email/{email}")
	public UserDto getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public UserDto updateUser(@PathVariable String userId, @RequestBody UserDto user) {
		return userService.updateUser(userId, user);
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable String userId) {
		return userService.deleteUser(userId);
	}
}
