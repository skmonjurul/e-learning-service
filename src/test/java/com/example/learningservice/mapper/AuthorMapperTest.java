package com.example.learningservice.mapper;

import com.example.learningservice.dto.Author;
import com.example.learningservice.entity.AuthorEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorMapperTest {
    
    @Test
    void shouldMapAuthorEntityToAuthor() {
        // Given
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(1L);
        authorEntity.setFirstName("John");
        authorEntity.setLastName("Doe");
        authorEntity.setEmail("john.doe@gmail.com");
        authorEntity.setAge(30);
        authorEntity.setCreatedAt(java.time.LocalDateTime.now());
        // When
        Author author = AuthorMapper.INSTANCE.authorEntityToAuthor(authorEntity);
        // Then
        assertEquals(authorEntity.getId(), author.getId());
        assertEquals(authorEntity.getFirstName(), author.getFirstName());
        assertEquals(authorEntity.getLastName(), author.getLastName());
        assertEquals(authorEntity.getEmail(), author.getEmail());
        assertEquals(authorEntity.getAge(), author.getAge());
        assertEquals(authorEntity.getCreatedAt(), author.getCreatedAt());
    }
}

