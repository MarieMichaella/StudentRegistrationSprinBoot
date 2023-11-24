package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.Teacher;
import rw.auca.Student.Registration.Student.Registration.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        if (updatedTeacher != null) {
            return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
