package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Student p = studentService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Student getPerson(@RequestParam String firstName) {
		return studentService.getByFirstName(firstName);
	}
	@RequestMapping("/getAll")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
		Student p = studentService.update(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName) {
		studentService.delete(firstName);
		return "Deleted "+firstName;
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		studentService.deleteAll();
		return "Deleted all records";
	}
	
}
