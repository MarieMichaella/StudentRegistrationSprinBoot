package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;

import java.util.List;
import java.util.Optional;

public interface StudentRegistrationService {
    List<StudentRegistration> getAllStudentRegistrations();
    StudentRegistration getStudentRegistrationById(String id);
    StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration);
    StudentRegistration updateStudentRegistration(String id, StudentRegistration studentRegistration);
    void deleteStudentRegistrationById(String id);

    public List<StudentRegistration> getRegistrationsByDepartmentAndSemester(AcademicUnit department, Semester semester);

    public Semester getSemesterById(String semesterId);

    public List<StudentRegistration> getRegistrationsBySemester(Semester semester);

    public boolean isRegistrationExists(AcademicUnit department, Semester semester);

    public List<StudentRegistration> findRegistrationsByCoursesAndSemester(Course courses, Semester semester);
}
