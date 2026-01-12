package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	public Student saveStudent(Student s) {
		return repo.save(s);
		
	}
	public List<Student>getAllStudents(){
		return repo.findAll();
	}
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}
}
