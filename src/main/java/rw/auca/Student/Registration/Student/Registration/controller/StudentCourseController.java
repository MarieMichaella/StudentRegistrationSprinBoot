package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.StudentCourse;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;
import rw.auca.Student.Registration.Student.Registration.service.CourseService;
import rw.auca.Student.Registration.Student.Registration.service.StudentCourseService;
import rw.auca.Student.Registration.Student.Registration.service.StudentRegistrationService;

import java.util.List;

@RestController
@RequestMapping("/student-courses")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    CourseService courseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping
    public ResponseEntity<List<StudentCourse>> getAllStudentCourses() {
        List<StudentCourse> studentCourses = studentCourseService.getAllStudentCourses();
        return new ResponseEntity<>(studentCourses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable int id) {
        StudentCourse studentCourse = studentCourseService.getStudentCourseById(id);
        if (studentCourse != null) {
            return new ResponseEntity<>(studentCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<StudentCourse> saveStudentCourse(@RequestBody StudentCourse studentCourse) {
        // Retrieve the existing course from the database
        Course existingCourse = courseService.getCourseById(studentCourse.getCourse().getId());

        // Check if the course exists
        if (existingCourse != null) {
            // Set the existing course in the student course
            studentCourse.setCourse(existingCourse);

            // Save the StudentCourse
            StudentCourse savedStudentCourse = studentCourseService.saveStudentCourse(studentCourse);

            return new ResponseEntity<>(savedStudentCourse, HttpStatus.CREATED);
        } else {
            // Handle case where course does not exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentCourse> updateStudentCourse(@PathVariable int id, @RequestBody StudentCourse studentCourse) {
        StudentCourse updatedStudentCourse = studentCourseService.updateStudentCourse(id, studentCourse);
        if (updatedStudentCourse != null) {
            return new ResponseEntity<>(updatedStudentCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentCourseById(@PathVariable int id) {
        studentCourseService.deleteStudentCourseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/listByCourse/{studentId}")
    public ResponseEntity<List<StudentCourse>> listByCourse(@PathVariable String studentId){
        StudentRegistration stud = studentRegistrationService.getStudentRegistrationById(studentId);

        if (stud != null) {
            List<StudentCourse> crs = studentCourseService.getCoursesByStudentId(studentId);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/listByCourseAndSemester/{courseCode}/{semesterId}")
    public ResponseEntity<List<StudentCourse>> listByCourseAndSemester(@PathVariable String courseCode, @PathVariable String semesterId) {
        Course course = courseService.getCourseById(courseCode);

        if (course != null) {
            List<StudentCourse> crs = studentCourseService.getStudentByCourseAndSemester(course, semesterId);
            return new ResponseEntity<>(crs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/courses/{studentId}")
    public ResponseEntity<List<StudentCourse>> getCoursesForStudent(@PathVariable String studentId) {
        // Assuming you have a method to retrieve a StudentRegistration object by studentId
        StudentRegistration student = studentRegistrationService.getStudentRegistrationById(studentId);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        List<StudentCourse> courses = studentCourseService.getCoursesForStudent(student);
        return ResponseEntity.ok(courses);
    }
}
