package br.com.exemplo.logincustomizado.application.jose;

import java.security.KeyPair;
import java.security.KeyPairGenerator;


/*
 * EXECUTADA APENAS NA INICIALIZACAO DO PROJETO
 * DEPOIS DISSO AS CHAVES PERMANECE DA MESMA FORMA
 */
final class KeyGeneratorUtils {
	
private KeyGeneratorUtils() {}
	

	static KeyPair generateRsaKey() {
		KeyPair keyPair;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keyPair = keyPairGenerator.generateKeyPair();
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		}
		return keyPair;
	}


}
