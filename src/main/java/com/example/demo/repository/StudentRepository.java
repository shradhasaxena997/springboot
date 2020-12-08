package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
   public Student findByFirstName(String firstName);
   public List<Student> findByAge(int age);
}
