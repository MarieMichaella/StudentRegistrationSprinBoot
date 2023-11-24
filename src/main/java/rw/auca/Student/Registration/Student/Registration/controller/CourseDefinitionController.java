package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.CourseDefinition;
import rw.auca.Student.Registration.Student.Registration.service.CourseDefinitionService;

import java.util.List;

@RestController
@RequestMapping("/course-definitions")
public class CourseDefinitionController {

    private final CourseDefinitionService courseDefinitionService;

    public CourseDefinitionController(CourseDefinitionService courseDefinitionService) {
        this.courseDefinitionService = courseDefinitionService;
    }

    @GetMapping
    public List<CourseDefinition> getAllCourseDefinitions() {
        return courseDefinitionService.getAllCourseDefinitions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDefinition> getCourseDefinitionById(@PathVariable Long id) {
        CourseDefinition courseDefinition = courseDefinitionService.getCourseDefinitionById(id);
        return courseDefinition != null
                ? new ResponseEntity<>(courseDefinition, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<CourseDefinition> saveCourseDefinition(@RequestBody CourseDefinition courseDefinition) {
        CourseDefinition savedCourseDefinition = courseDefinitionService.saveCourseDefinition(courseDefinition);
        return new ResponseEntity<>(savedCourseDefinition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDefinition> updateCourseDefinition(@PathVariable Long id, @RequestBody CourseDefinition courseDefinition) {
        CourseDefinition updatedCourseDefinition = courseDefinitionService.updateCourseDefinition(id, courseDefinition);
        return updatedCourseDefinition != null
                ? new ResponseEntity<>(updatedCourseDefinition, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseDefinitionById(@PathVariable Long id) {
        courseDefinitionService.deleteCourseDefinitionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
