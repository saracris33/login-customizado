package br.com.exemplo.logincustomizado.application.jose;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import com.nimbusds.jose.jwk.RSAKey;

/*
 * EXECUTADA APENAS NA INICIALIZACAO DO PROJETO
 * DEPOIS DISSO AS CHAVES PERMANECE A MESMA
 */
public final class Jwks {
	
	private Jwks() {
	}

	/*
	 * CRIA CHAVE JWS
	 */
	public static RSAKey generateRsa() {
		KeyPair keyPair = KeyGeneratorUtils.generateRsaKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		System.err.println("\n\nKeys:\n\tPublic Key: " + publicKey + " \n\n\n\tPrivate Key: " + privateKey + "\n\n");
		return new RSAKey.Builder(publicKey)
				.privateKey(privateKey)
				.keyID(UUID.randomUUID().toString())
				.build();
	}

}
