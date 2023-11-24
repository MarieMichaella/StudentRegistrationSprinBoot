package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(String id);
    Course saveCourse(Course course);
    Course updateCourse(String id, Course course);
    void deleteCourseById(String id);
}
