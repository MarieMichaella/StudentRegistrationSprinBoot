package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable String id) {
        Course course = courseService.getCourseById(id);
        return course != null
                ? new ResponseEntity<>(course, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        Course updatedCourse = courseService.updateCourse(id, course);
        return updatedCourse != null
                ? new ResponseEntity<>(updatedCourse, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable String id) {
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
