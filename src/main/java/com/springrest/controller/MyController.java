package com.springrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Course;
import com.springrest.service.CoureseService;

import sun.security.provider.certpath.ResponderId;

@RestController
public class MyController {
	
	@Autowired
	public CoureseService courseService;
	
	@GetMapping("/home")
	public String home(){
		return "Request For Home";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourse(){
		
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId){
		return courseService.getCourses(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/courses",consumes="application/json")
	public Course addCourse(@RequestBody Course course){
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course){
		return this.courseService.updateCourses(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}