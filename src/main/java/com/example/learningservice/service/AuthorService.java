package com.example.learningservice.service;


import com.example.learningservice.dto.Author;
import com.example.learningservice.entity.AuthorEntity;
import com.example.learningservice.exception.ResourceNotFoundException;
import com.example.learningservice.mapper.AuthorMapper;
import com.example.learningservice.repository.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Author save(Author author) {
        AuthorEntity authorEntity = AuthorMapper.INSTANCE.authorToAuthorEntity(author);
        return AuthorMapper.INSTANCE.authorEntityToAuthor(authorRepository.save(authorEntity));
    }
    
    public Author getAuthorById(Long id) {
        return AuthorMapper.INSTANCE.authorEntityToAuthor(authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Author with id %s not found", id))));
    }
    
    public List<Author> getAllAuthors(Integer pageNumber, Integer pageSize) {
        pageNumber = pageNumber != null ? pageNumber : 0;
        if (pageSize == null || pageSize < 0) {
            return getAllAuthors();
        }
        return pageSize == 0 ? List.of() : getAllAuthors(PageRequest.of(pageNumber, pageSize));
    }
    
    private List<Author> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper.INSTANCE::authorEntityToAuthor)
                .toList();
    }
    
    private List<Author> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).stream()
                .map(AuthorMapper.INSTANCE::authorEntityToAuthor)
                .toList();
    }
    
    public Author updateAuthor(Author author, Long id) {
        Author existedAuthor = getAuthorById(id);
        author.setId(id);
        author.setFirstName(author.getFirstName() != null ? author.getFirstName() : existedAuthor.getFirstName());
        author.setLastName(author.getLastName() != null ? author.getLastName() : existedAuthor.getLastName());
        author.setEmail(author.getEmail() != null ? author.getEmail() : existedAuthor.getEmail());
        author.setAge(author.getAge() != null ? author.getAge() : existedAuthor.getAge());
        return save(author);
    }
    
    public Author updateAuthor(Author author) {
        return save(author);
    }
    
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
