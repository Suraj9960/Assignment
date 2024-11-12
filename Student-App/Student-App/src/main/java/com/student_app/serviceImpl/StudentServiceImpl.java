package com.student_app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_app.entities.Student;
import com.student_app.repository.StudentRepository;
import com.student_app.serviceLayer.StudentService;



@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> getAllStudent() {
	
		return repo.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student findById(Integer StudentId) {
		
		Student student = repo.findById(StudentId).get();
		
		return student;
	}

	@Override
	public void deleteStudent(Integer StudentId) {
		Student student = repo.findById(StudentId).get();
		
		repo.delete(student);	
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		Student student1 = repo.findById(studentId).get();
		student1.setStudentName(student.getStudentName());
		student1.setRollNo(student.getRollNo());
		student1.setEmailId(student.getEmailId());
		student1.setMobNo(student.getMobNo());
		
		repo.save(student1);
		
		return student1;
	}

}
