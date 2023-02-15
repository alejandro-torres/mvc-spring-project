package alejandro.torres.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@GetMapping({"/","/index"})
	public String index() {
		return "login";
	}
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
