package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;
import rw.auca.Student.Registration.Student.Registration.service.AcademicUnitService;
import rw.auca.Student.Registration.Student.Registration.service.CourseService;
import rw.auca.Student.Registration.Student.Registration.service.SemesterService;
import rw.auca.Student.Registration.Student.Registration.service.StudentRegistrationService;

import java.util.List;

@RestController
@RequestMapping(value = "/student-registrations", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

public class StudentRegistrationController {

    private final StudentRegistrationService studentRegistrationService;

    @Autowired
    private AcademicUnitService unitService;

    @Autowired
    private SemesterService semesterService;

    @Autowired
    private CourseService courseService;

    public StudentRegistrationController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }

    @GetMapping
    public ResponseEntity<List<StudentRegistration>> getAllStudentRegistrations() {
        List<StudentRegistration> studentRegistrations = studentRegistrationService.getAllStudentRegistrations();
        return new ResponseEntity<>(studentRegistrations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentRegistration> getStudentRegistrationById(@PathVariable String id) {
        StudentRegistration studentRegistration = studentRegistrationService.getStudentRegistrationById(id);
        if (studentRegistration != null) {
            return new ResponseEntity<>(studentRegistration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<StudentRegistration> saveStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        StudentRegistration savedStudentRegistration = studentRegistrationService.saveStudentRegistration(studentRegistration);
        return new ResponseEntity<>(savedStudentRegistration, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentRegistration> updateStudentRegistration(@PathVariable String id, @RequestBody StudentRegistration studentRegistration) {
        StudentRegistration updatedStudentRegistration = studentRegistrationService.updateStudentRegistration(id, studentRegistration);
        if (updatedStudentRegistration != null) {
            return new ResponseEntity<>(updatedStudentRegistration, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentRegistrationById(@PathVariable String id) {
        studentRegistrationService.deleteStudentRegistrationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listByDepartmentAndSemester/{departmentCode}/{semesterId}")
    public ResponseEntity<List<StudentRegistration>> listRegistrationsByDepartmentAndSemester(
            @PathVariable String departmentCode,
            @PathVariable String semesterId) {

        AcademicUnit department = unitService.getAcademicUnitById(departmentCode);
        Semester semester = semesterService.getSemesterById(semesterId);

        if (department != null && semester != null) {
            List<StudentRegistration> registrations = studentRegistrationService.getRegistrationsByDepartmentAndSemester(department, semester);
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listBySemester/{semesterId}")
    public ResponseEntity<List<StudentRegistration>> listRegistrationsBySemester(

            @PathVariable String semesterId) {
        Semester semester = semesterService.getSemesterById(semesterId);

        if (semester != null) {
            List<StudentRegistration> registrations = studentRegistrationService.getRegistrationsBySemester(semester);
            return new ResponseEntity<>(registrations, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/by-courses-and-semester/{courseId}/{semesterId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentRegistration>> getRegistrationsByCoursesAndSemester(
            @PathVariable String courseId,
            @PathVariable String semesterId) {
        Course course = courseService.getCourseById(courseId);
        Semester semester = semesterService.getSemesterById(semesterId);

        List<StudentRegistration> registrations = studentRegistrationService.findRegistrationsByCoursesAndSemester(course, semester);
        return ResponseEntity.ok(registrations);
    }



}
