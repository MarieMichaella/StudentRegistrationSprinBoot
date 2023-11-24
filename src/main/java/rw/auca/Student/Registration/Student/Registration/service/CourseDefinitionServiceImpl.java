package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.CourseDefinition;
import rw.auca.Student.Registration.Student.Registration.repository.CourseDefinitionRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CourseDefinitionServiceImpl implements CourseDefinitionService {

    private final CourseDefinitionRepository courseDefinitionRepository;

    public CourseDefinitionServiceImpl(CourseDefinitionRepository courseDefinitionRepository) {
        this.courseDefinitionRepository = courseDefinitionRepository;
    }

    @Override
    public List<CourseDefinition> getAllCourseDefinitions() {
        return courseDefinitionRepository.findAll();
    }

    @Override
    public CourseDefinition getCourseDefinitionById(Long id) {
        return courseDefinitionRepository.findById(id).orElse(null);
    }

    @Override
    public CourseDefinition saveCourseDefinition(CourseDefinition courseDefinition) {
        return courseDefinitionRepository.save(courseDefinition);
    }

    @Override
    public CourseDefinition updateCourseDefinition(Long id, CourseDefinition courseDefinition) {
        Optional<CourseDefinition> existingCourseDefinitionOptional = courseDefinitionRepository.findById(id);
        if (existingCourseDefinitionOptional.isPresent()) {
            CourseDefinition existingCourseDefinition = existingCourseDefinitionOptional.get();
            // Update properties of the existing course definition with the new values
            existingCourseDefinition.setName(courseDefinition.getName());
            existingCourseDefinition.setDescription(courseDefinition.getDescription());

            return courseDefinitionRepository.save(existingCourseDefinition);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteCourseDefinitionById(Long id) {
        courseDefinitionRepository.deleteById(id);
    }


}
