package br.com.exemplo.logincustomizado.infrastructure.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home(Authentication authentication) {
		return "Security JWT! - Username: " + authentication.getName() + " - " + authentication.getAuthorities();
	}
	
	@GetMapping("/user")
	public String user(Authentication authentication) {
		return "Bem vindo a página de Usuario! - Nome: " + authentication.getName() + " - " + authentication.getAuthorities();
	}
	
	@GetMapping("/admin")
	public String admin(Authentication authentication) {
		return "Bem vindo a pagina de Adnimistrador! - Nome: " + authentication.getName() + " - " + authentication.getAuthorities();
	}

}
