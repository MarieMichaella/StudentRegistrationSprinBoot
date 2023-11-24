package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.service.SemesterService;

import java.util.List;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {

    private final SemesterService semesterService;

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping
    public ResponseEntity<List<Semester>> getAllSemesters() {
        List<Semester> semesters = semesterService.getAllSemesters();
        return new ResponseEntity<>(semesters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable String id) {
        Semester semester = semesterService.getSemesterById(id);
        if (semester != null) {
            return new ResponseEntity<>(semester, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        Semester createdSemester = semesterService.saveSemester(semester);
        return new ResponseEntity<>(createdSemester, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable String id, @RequestBody Semester semester) {
        Semester updatedSemester = semesterService.updateSemester(id, semester);
        if (updatedSemester != null) {
            return new ResponseEntity<>(updatedSemester, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable String id) {
        semesterService.deleteSemesterById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
