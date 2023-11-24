package rw.auca.Student.Registration.Student.Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;

import java.util.List;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, String> {
    boolean existsByDepartmentAndSemester(AcademicUnit department, Semester semester);
    boolean existsByStudentId(String studentId);
    StudentRegistration findByStudentId(String studentId);
    List<StudentRegistration> findBySemester(Semester semester);
    List<StudentRegistration> findByDepartmentAndSemester(AcademicUnit department, Semester semester);
    List<StudentRegistration> findBySemesterId(String semesterId);

    List<StudentRegistration> findByCoursesAndSemester(Course course, Semester semester);

}
