package microservices.app.authenticationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

	

	@GetMapping()
	public String hello() {
		return "Hello";
	}

}
