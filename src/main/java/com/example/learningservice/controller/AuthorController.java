package com.example.learningservice.controller;


import com.example.learningservice.dto.Author;
import com.example.learningservice.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    
    private final AuthorService authorService;
    
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    
    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.save(author));
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
                                                      @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        return ResponseEntity.ok(authorService.getAllAuthors(pageNumber, pageSize));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        return ResponseEntity.ok(authorService.updateAuthor(author, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
