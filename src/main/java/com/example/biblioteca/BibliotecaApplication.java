package com.example.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
	@Bean
	CommandLineRunner run(PasswordEncoder encoder) {
		return args -> {
			System.out.println("Senha criptografada:");
			System.out.println(encoder.encode("123456"));
		};
	}

}
