package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, String> {
}
