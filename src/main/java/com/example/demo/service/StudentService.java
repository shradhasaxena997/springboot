package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
   
	@Autowired
	private StudentRepository studentRepository;
	
	//Create operation
	public Student create(String firstName, String lastName, int age) {
		return studentRepository.save(new Student(firstName, lastName, age));
	}
	//Retrieve operation
	public List<Student> getAll(){
		return studentRepository.findAll();
	}
	public Student getByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	//Update operation
	public Student update(String firstName, String lastName, int age) {
		Student p = studentRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return studentRepository.save(p);
	}
	//Delete operation
	public void deleteAll() {
		studentRepository.deleteAll();
	}
	public void delete(String firstName) {
		Student p = studentRepository.findByFirstName(firstName);
		studentRepository.delete(p);
	}
}
