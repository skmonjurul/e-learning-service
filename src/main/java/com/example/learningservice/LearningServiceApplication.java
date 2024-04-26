package com.example.learningservice;

import com.example.learningservice.entity.AuthorEntity;
import com.example.learningservice.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningServiceApplication.class, args);
	}
    
    
    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository repository) {
        return args -> {
            // Add some authors
            AuthorEntity author1 = new AuthorEntity();
            author1.setFirstName("John");
            author1.setLastName("Doe");
            author1.setCreatedAt(java.time.LocalDateTime.now());
            repository.save(author1);
        };
    }

}
