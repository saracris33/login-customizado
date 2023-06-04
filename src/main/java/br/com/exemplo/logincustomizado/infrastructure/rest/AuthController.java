package br.com.exemplo.logincustomizado.infrastructure.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.logincustomizado.application.service.TokenService;
import lombok.extern.slf4j.Slf4j;

/*
 * CONTROLADOR DE AUTENTICACAO
 */
@Slf4j
@RestController
public class AuthController {


	private final TokenService tokenService;
	
	
	
    public AuthController(TokenService tokenService) {
		this.tokenService = tokenService;
	}

    /*
     * END POIT APOS SOLICITACAO SE FORNECER O NOME E USUARIO E SENHA CORRETO
     */
	@PostMapping("/token")
    public String token(Authentication authentication) {
		log.debug("Token request for user: '{}'", authentication.getName());
		String token = tokenService.generateToken(authentication);
		log.debug("Token: {}", token);
		return token;
	}

}
