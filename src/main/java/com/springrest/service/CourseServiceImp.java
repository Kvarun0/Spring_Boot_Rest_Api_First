package com.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.model.Course;

@Service
public class CourseServiceImp implements CoureseService{

	List<Course> list;
	public CourseServiceImp() {
		list=new ArrayList<Course>();
		list.add(new Course(100,"Core Java","This Course For Core Java"));
		list.add(new Course(1200,"Spring Boot","In This Course We Learn RestApi"));
	}
	 
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourses(long courseId) {
		Course c=null;
		for(Course course:list){
			if (course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}
	
	@Override
	public Course addCourse(Course course){
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourses(Course course) {
		list.forEach(e -> {
			if (e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());

	}




}









