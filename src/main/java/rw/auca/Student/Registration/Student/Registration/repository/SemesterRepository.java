package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;

public interface SemesterRepository extends JpaRepository<Semester, String> {
    // Add custom queries if needed
}
