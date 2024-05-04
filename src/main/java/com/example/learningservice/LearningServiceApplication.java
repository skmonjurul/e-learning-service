package com.example.learningservice;

import com.example.learningservice.entity.AuthorEntity;
import com.example.learningservice.entity.VideoEntity;
import com.example.learningservice.repository.AuthorRepository;
import com.example.learningservice.repository.ResourceRepository;
import com.example.learningservice.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class LearningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningServiceApplication.class, args);
	}
}
