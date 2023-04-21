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
import com.systemsaberpro.app.entity.Coordinator;
import com.systemsaberpro.app.repository.CoordinatorRepository;


@RestController
@RequestMapping(value = "/api/coordinators")
public class CoordinatorController {
	@Autowired
	private CoordinatorRepository coordinatorRepository;

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/")
	public List<Coordinator> getAllCoordinators() {
		return coordinatorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Coordinator> getCoordinator(@PathVariable String id) {
		return coordinatorRepository.findById(id);
	}
	

	@PostMapping("/")
	public Coordinator insertCoordinator(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Coordinator coordinator = mapper.convertValue(body, Coordinator.class);
		return coordinatorRepository.insert(coordinator);
	}

	@PutMapping("/{id}")
	public Coordinator updateCoordinator(@PathVariable String id, @RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Coordinator student = mapper.convertValue(body, Coordinator.class);
		student.setId(id);
		return coordinatorRepository.save(student);
	}

	@DeleteMapping("/{id}")
	public Optional<Coordinator> deleteCoordinator(@PathVariable String id) {
		Optional<Coordinator> student = coordinatorRepository.findById(id);
		coordinatorRepository.deleteById(id);
		return student;
	}
}
