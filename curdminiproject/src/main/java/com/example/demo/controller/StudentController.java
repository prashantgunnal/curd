package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/student")
	private List<Student> getAllStudents() {
		return studentService.getAllstudents();
	}

	@GetMapping("/student/{rollNumber}")
	private Student getStudent(@PathVariable("rollNumber") int rollNumber) {
		return studentService.getStudentById(rollNumber);
	}

	@DeleteMapping("/student/{rollNumber}")
	private void deleteStudent(@PathVariable("rollNumber") int rollNumber) {
		try {
		studentService.delete(rollNumber);
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student.getRoll_number();
	}

	@PutMapping("/student")
	private Student update(@RequestBody Student student) {
		studentService.saveOrUpdate(student);
		return student;
	}
}
