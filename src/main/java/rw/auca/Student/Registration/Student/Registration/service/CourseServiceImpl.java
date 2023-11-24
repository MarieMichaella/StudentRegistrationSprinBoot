package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(String id, Course course) {
        Optional<Course> existingCourseOptional = courseRepository.findById(id);
        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            // Update properties of the existing course with the new values
            existingCourse.setName(course.getName());
            existingCourse.setSemester(course.getSemester());
            existingCourse.setStudentCourses(course.getStudentCourses());
            existingCourse.setCourseDefinition(course.getCourseDefinition());
            existingCourse.setDepartment(course.getDepartment());
            existingCourse.setStudents(course.getStudents());

            return courseRepository.save(existingCourse);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }
}
