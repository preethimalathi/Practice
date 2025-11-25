package com.sjprogramming.restapi.service;

import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
	@Autowired
	   private StudentRepository studentRepository;

	   public List<Student> getAllStudents(){
		   return studentRepository.findAll();
	   }

	public Optional<Student> getStudentById(int rollNo) {
		// TODO Auto-generated method stub
		return studentRepository.findById(rollNo);
	}

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	public Student updateStudent(int rollNo, Student student) {
		// TODO Auto-generated method stub
		if(studentRepository.existsById(rollNo)) {
			student.setRollNo(rollNo);
			return studentRepository.save(student);
		}else {
			return null;
		}
		
	}

	public boolean deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		if(studentRepository.existsById(rollNo)) {
			studentRepository.deleteById(rollNo);
		
		return true;
		}else {
			return false;
		}
		
	}}
