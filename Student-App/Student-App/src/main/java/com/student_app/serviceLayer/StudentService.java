package com.student_app.serviceLayer;

import java.util.List;

import com.student_app.entities.Student;



public interface StudentService {
	public List<Student> getAllStudent();
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student , Integer studentId);
	
	public Student findById(Integer StudentId);
	
	public void deleteStudent(Integer StudentId);
}
