package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.StudentCourse;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
    boolean existsByCourse(Course course);
    List<StudentCourse> findByStudentRegistration(StudentRegistration studentRegistration);
    List<StudentCourse> findByCourseAndStudentRegistration(Course course, StudentRegistration studentRegistration);
}
