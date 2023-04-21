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
import com.systemsaberpro.app.entity.Ratings;
import com.systemsaberpro.app.repository.RatingsRepository;

@RestController
@RequestMapping(value = "/api/ratings")
public class RatingsController {
	@Autowired
	private RatingsRepository ratingsRepository;

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/")
	public List<Ratings> getAllRatings() {
		return ratingsRepository.findAll();
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/{id}")
	public Optional<Ratings> getRating(@PathVariable String id) {
		return ratingsRepository.findById(id);
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping("/byStudent/{id}")
	public Optional<Ratings> getRatingByStudent(@PathVariable String id) {
		return Optional.ofNullable(ratingsRepository.findByStudent(id));
	}
	
	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
	@PostMapping("/")
	public Ratings insertRatings(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Ratings coordinator = mapper.convertValue(body, Ratings.class);
		return ratingsRepository.insert(coordinator);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
	@PutMapping("/{id}")
	public Ratings updateRating(@PathVariable String id, @RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Ratings student = mapper.convertValue(body, Ratings.class);
		student.setId(id);
		return ratingsRepository.save(student);
	}

	@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	@DeleteMapping("/{id}")
	public Optional<Ratings> deleteRating(@PathVariable String id) {
		Optional<Ratings> student = ratingsRepository.findById(id);
		ratingsRepository.deleteById(id);
		return student;
	}
}
