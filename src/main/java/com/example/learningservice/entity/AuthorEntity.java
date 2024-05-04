package com.example.learningservice.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class AuthorEntity extends BaseEntity {
    
    @Column(nullable = false, length = 50)
    private String firstName;
    
    @Column(length = 50)
    private String lastName;
    
    @Column(unique = true, length = 100)
    private String email;
    
    private Integer age;
    
    @ManyToMany(mappedBy = "authorEntities")
    private List<CourseEntity> courseEntities;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public List<CourseEntity> getCourseEntities() {
        return courseEntities;
    }
    
    public void setCourseEntities(List<CourseEntity> courseEntities) {
        this.courseEntities = courseEntities;
    }
}
