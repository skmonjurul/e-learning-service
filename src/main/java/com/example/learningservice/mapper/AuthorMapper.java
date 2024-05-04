package com.example.learningservice.mapper;


import com.example.learningservice.dto.Author;
import com.example.learningservice.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(AuthorMapper.class);
    
    Author authorEntityToAuthor(AuthorEntity authorEntity);
    
    AuthorEntity authorToAuthorEntity(Author author);
}
