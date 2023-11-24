package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.CourseDefinition;

import java.util.List;

public interface CourseDefinitionService {
    List<CourseDefinition> getAllCourseDefinitions();
    CourseDefinition getCourseDefinitionById(Long id);
    CourseDefinition saveCourseDefinition(CourseDefinition courseDefinition);
    CourseDefinition updateCourseDefinition(Long id, CourseDefinition courseDefinition);
    void deleteCourseDefinitionById(Long id);
}
