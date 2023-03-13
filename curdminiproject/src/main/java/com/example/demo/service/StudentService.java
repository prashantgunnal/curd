package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllstudents() {
		List<Student> students = new ArrayList<Student>();
		studentRepository.findAll().forEach(student1 -> students.add(student1));
		return students;
	}

	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
	}

	public void update(Student student, int roll_number) {
		studentRepository.save(student);
	}

}
