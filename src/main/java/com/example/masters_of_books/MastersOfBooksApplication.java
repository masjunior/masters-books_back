package com.example.masters_of_books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com/example/masters_of_books/repository")
public class MastersOfBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MastersOfBooksApplication.class, args);
	}

}
