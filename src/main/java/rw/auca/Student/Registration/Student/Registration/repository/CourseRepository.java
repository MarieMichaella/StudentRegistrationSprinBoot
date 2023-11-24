package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.auca.Student.Registration.Student.Registration.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    // You can add custom query methods here if needed
}
