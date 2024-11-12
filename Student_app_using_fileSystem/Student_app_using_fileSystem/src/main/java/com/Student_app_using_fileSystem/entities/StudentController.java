package com.Student_app_using_fileSystem.entities;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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


@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/get-all")
	public ResponseEntity<List<Students>> getAll() throws IOException{
		List<Students> students =  service.findAll();
		
		return new ResponseEntity<List<Students>>(students,HttpStatus.OK);
	}
	
	@PostMapping("/add-student")
	public ResponseEntity<Students> create_student(@RequestBody Students student) throws IOException{
		
		Students newStudent =  service.save(student);
		
		return new ResponseEntity<Students>(newStudent,HttpStatus.OK);
	}
	
	@GetMapping("/get-student/{id}")
	public ResponseEntity<Students> getById(@PathVariable Integer id) throws IOException{
		Optional<Students> students =  service.findById(id);
		
		if(students.isPresent()) {
			return new ResponseEntity<>(students.get(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/update-student/{id}")
	public ResponseEntity<Students> updateStudent(@PathVariable Integer id , @RequestBody Students students) throws IOException{
		
		Optional<Students> student =  service.findById(id);
		
		if(student.isPresent()) {
			Students s  = student.get();
			
			s.setStudentName(students.getStudentName());
			s.setEmailId(students.getEmailId());
			s.setRollNo(students.getRollNo());
			s.setMobNo(students.getMobNo());
			try {
				return  ResponseEntity.ok(service.save(s));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete-student/{id}")
	public ResponseEntity<String> delete_student(@PathVariable Integer id) throws IOException{
		
		Optional<Students> student = service.findById(id);
		
		if(student.isPresent()) {
			service.deleteById(id);
			
			return new ResponseEntity<String>("{ Student with Id "+ id +" deleted successfully. } "  , HttpStatus.OK) ;
		}
		
		return new ResponseEntity<String>("Student with id "+ id +" not found.", HttpStatus.NOT_FOUND);
	}
	
}
