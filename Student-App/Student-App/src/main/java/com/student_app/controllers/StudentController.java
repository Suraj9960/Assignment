package com.student_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student_app.entities.Student;
import com.student_app.serviceImpl.StudentServiceImpl;


@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl serviceImpl;
	
	@GetMapping("/get-students")
	public ResponseEntity<List<Student>> get_all_students(){
		
		List<Student> students = serviceImpl.getAllStudent();
		
		return new ResponseEntity<List<Student>>(students , HttpStatus.OK);
	}
	
	@PostMapping("/add-student")
	public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
		
		Student newStudent = serviceImpl.addStudent(student);
		
		return new ResponseEntity<Student>(newStudent,HttpStatus.OK);
	}
	
	@GetMapping("/get-student/{studentId}")
	public ResponseEntity<Student> getById(@PathVariable Integer studentId){
		
		Student student = serviceImpl.findById(studentId);
		
		return new ResponseEntity<Student>(student , HttpStatus.OK);
	}
	
	@PutMapping("/update-student/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer studentId ,@RequestBody Student student){
		
		Student updatedStudent = serviceImpl.updateStudent(student, studentId);
		
		return new ResponseEntity<Student>(updatedStudent , HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-student/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId){
		
		serviceImpl.deleteStudent(studentId);
		
		return new ResponseEntity<String>(" { Users deleted Successfully with Id "+ studentId + " } " , HttpStatus.OK);
	}
	
	
	
	
	
	

}
