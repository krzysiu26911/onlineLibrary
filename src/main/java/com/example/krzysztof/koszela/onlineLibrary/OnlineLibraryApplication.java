package com.example.krzysztof.koszela.onlineLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineLibraryApplication.class, args);
	}
}
