package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.auca.Student.Registration.Student.Registration.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Add any custom queries if needed
}
