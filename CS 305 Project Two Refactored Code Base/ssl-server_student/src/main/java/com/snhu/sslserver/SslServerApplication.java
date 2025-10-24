package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Imports for Java configuration class: HTTP -> HTTPS
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.apache.catalina.connector.Connector;

/* Message for Professor: Importing StandardCharsets to convert String to byte in function rather than 
 * creating a method that converts string to byte. +Big O notation (faster) +cleaner code -DH  */

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@Configuration
class HttpRedirectConfig {
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer(){
		return factory -> {
			Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
			connector.setScheme("http");
			connector.setPort(8080);
			connector.setSecure(false);
			connector.setRedirectPort(8443);
			factory.addAdditionalTomcatConnectors(connector);
		};
	}
}

@RestController
class ServerController{
	
	// private static test data, only used for this class
	private static final String data =  "Hello World Check Sum! - Dylan Harmon";
	
	@GetMapping("/hash")
	public String getChecksum() throws NoSuchAlgorithmException{
		
		// Using SHA256 for checksum
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hex = new StringBuilder();
		for (byte b: hashBytes) {
			hex.append(String.format("%02x", b));
		}
		
		// Include name and data in response for assignment
		return "Name: Dylan H\nData: " + data + "\nChecksum: " + hex.toString();
		
	}
}