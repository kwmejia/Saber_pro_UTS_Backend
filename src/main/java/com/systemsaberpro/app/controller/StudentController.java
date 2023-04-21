package com.systemsaberpro.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.systemsaberpro.app.entity.Student;
import com.systemsaberpro.app.repository.StudentRepository;
import com.systemsaberpro.app.service.FindByNitService;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FindByNitService findByNitService;
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/{id}")
	public Optional<Student> getStudent(@PathVariable String id) {
		return studentRepository.findById(id);
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/nit/{nit}")
	public Student getStudentByNit(@PathVariable String nit) {
		return findByNitService.findByNit(nit);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@PostMapping("/")
	public Student insertStudent(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.convertValue(body, Student.class);
		return studentRepository.insert(student);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable String id, @RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Student student = mapper.convertValue(body, Student.class);
		student.setId(id);
		return studentRepository.save(student);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.DELETE})
	@DeleteMapping("/{id}")
	public Optional<Student> deleteStudent(@PathVariable String id) {
		Optional<Student> student = studentRepository.findById(id);
		studentRepository.deleteById(id);
		return student;
	}
}
