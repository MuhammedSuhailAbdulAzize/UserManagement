package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
@RestController
@RequestMapping("/stud")
public class StudentController {
@Autowired
StudentService service;
@PostMapping
public Student addStudent(@RequestBody Student student) {
	return service.saveStudent(student);
	
}
@GetMapping
public List<Student>getStudent(){
	return service.getAllStudents();
}
@GetMapping("/{id}")
public Student fetchStudentById(@PathVariable int id) {
	return service.getStudentById(id);
}
@DeleteMapping("/{id}")
public String deleteStudent(@PathVariable int id) {
	service.deleteStudent(id);
	return "deleted Sucessfully";
}
@PutMapping("/{id}")
public Student updateStudent(@PathVariable int id,@RequestBody Student s) {
	s.setId(id);
	return service.saveStudent(s);
}
}
