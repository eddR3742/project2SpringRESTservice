package com.eduardor.Student.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.eduardor.Student.entity.Student;
import com.eduardor.Student.repository.StudentRepository;



@RestController
public class StudentController {

private final StudentRepository repository;

StudentController(StudentRepository repository) {
	this.repository = repository;
	  
	}
//Aggregate root
//tag::get-aggregate-root[]
@GetMapping("/students")
List<Student> all() {
 return repository.findAll();
}

//end::get-aggregate-root[]
@PostMapping("/students")
Student newStudent(@RequestBody Student newStudent) {
 return repository.save(newStudent);
}

//Single item
@GetMapping("/students/{id}")
Student one(@PathVariable Long id) {
 
 return repository.findById(id)
   .orElseThrow(() -> new StudentNotFoundException(id));
}

//save operation
@PutMapping("/students/{id}")
Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
 
 return repository.findById(id)
   .map(Student -> {
     Student.setName(newStudent.getName());
     Student.setGpa(newStudent.getGpa());
     Student.setGender(newStudent.getGender());
     return repository.save(Student);
   })
   .orElseGet(() -> {
     newStudent.setId(id);
     return repository.save(newStudent);
   });
}

//delete operation
@DeleteMapping("/students/{id}")
void deleteStudent(@PathVariable Long id) {
 repository.deleteById(id);
}
}
