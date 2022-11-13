package com.springrest.service;
import java.util.List;

import com.springrest.model.Course;

public interface CoureseService {
	
	public List<Course> getCourses();
	
	public Course getCourses(long courseId);

	public Course addCourse(Course course);

	public Course updateCourses(Course course);

	public void deleteCourse(long parseLong);
}
