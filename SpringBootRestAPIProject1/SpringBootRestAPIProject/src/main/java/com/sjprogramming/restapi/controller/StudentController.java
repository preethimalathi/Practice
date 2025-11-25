package com.sjprogramming.restapi.controller;

import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{rollNo}")
	public ResponseEntity<Student> getStudentById(@PathVariable int rollNo){
		Optional<Student> student = studentService.getStudentById(rollNo);
		return student.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
		
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student savedStudent=studentService.addStudent(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
		
	}
	@PutMapping("/{rollNo}")
	public ResponseEntity<Student> updateStudent(@PathVariable int rollNo,@RequestBody Student student){
		Student updatedStudent=studentService.updateStudent(rollNo, student);
		return updatedStudent != null ? ResponseEntity.ok(updatedStudent):ResponseEntity.notFound().build() ;
		
	}
	@DeleteMapping("/{rollNo}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int rollNo){
		boolean deleted = studentService.deleteStudent(rollNo);
		return deleted ? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
	}}
