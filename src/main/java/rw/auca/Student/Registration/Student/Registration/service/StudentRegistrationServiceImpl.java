package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;
import rw.auca.Student.Registration.Student.Registration.repository.SemesterRepository;
import rw.auca.Student.Registration.Student.Registration.repository.StudentRegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    private final StudentRegistrationRepository studentRegistrationRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    @Override
    public List<StudentRegistration> getAllStudentRegistrations() {
        return studentRegistrationRepository.findAll();
    }

    @Override
    public StudentRegistration getStudentRegistrationById(String id) {
        return studentRegistrationRepository.findById(id).orElse(null);
    }

    @Override
    public StudentRegistration saveStudentRegistration(StudentRegistration studentRegistration) {
        return studentRegistrationRepository.save(studentRegistration);
    }

    @Override
    public StudentRegistration updateStudentRegistration(String id, StudentRegistration studentRegistration) {
        Optional<StudentRegistration> existingStudentRegistrationOptional = studentRegistrationRepository.findById(id);
        if (existingStudentRegistrationOptional.isPresent()) {
            StudentRegistration existingStudentRegistration = existingStudentRegistrationOptional.get();
            // Update properties of the existing student registration with the new values
            existingStudentRegistration.setStudent(studentRegistration.getStudent());
            existingStudentRegistration.setSemester(studentRegistration.getSemester());
            existingStudentRegistration.setDepartment(studentRegistration.getDepartment());
            existingStudentRegistration.setCourses(studentRegistration.getCourses());
            existingStudentRegistration.setRegDate(studentRegistration.getRegDate());

            return studentRegistrationRepository.save(existingStudentRegistration);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteStudentRegistrationById(String id) {
        studentRegistrationRepository.deleteById(id);
    }

    public List<StudentRegistration> getRegistrationsByDepartmentAndSemester(AcademicUnit department, Semester semester) {
        return studentRegistrationRepository.findByDepartmentAndSemester(department, semester);
    }

    public Semester getSemesterById(String semesterId) {
        // Implement logic to retrieve a Semester entity by ID from your repository
        Optional<Semester> optionalSemester = semesterRepository.findById(semesterId);
        return optionalSemester.orElse(null);
    }

    public List<StudentRegistration> getRegistrationsBySemester(Semester semester) {
        return studentRegistrationRepository.findBySemester(semester);
    }

    public boolean isRegistrationExists(AcademicUnit department, Semester semester) {
        return studentRegistrationRepository.existsByDepartmentAndSemester(department, semester);
    }

    public List<StudentRegistration> findRegistrationsByCoursesAndSemester(Course course, Semester semester) {
        return studentRegistrationRepository.findByCoursesAndSemester(course, semester);
    }
}
