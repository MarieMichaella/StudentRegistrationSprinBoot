package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.StudentCourse;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;
import rw.auca.Student.Registration.Student.Registration.repository.StudentCourseRepository;
import rw.auca.Student.Registration.Student.Registration.repository.StudentRegistrationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentRegistrationRepository studentRegistrationRepository;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    @Override
    public StudentCourse getStudentCourseById(int id) {
        return studentCourseRepository.findById(id).orElse(null);
    }

    @Override
    public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public StudentCourse updateStudentCourse(int id, StudentCourse studentCourse) {
        Optional<StudentCourse> existingStudentCourseOptional = studentCourseRepository.findById(id);
        if (existingStudentCourseOptional.isPresent()) {
            StudentCourse existingStudentCourse = existingStudentCourseOptional.get();
            // Update properties of the existing student course with the new values
            existingStudentCourse.setCredits(studentCourse.getCredits());
            existingStudentCourse.setResults(studentCourse.getResults());
            existingStudentCourse.setStudentRegistration(studentCourse.getStudentRegistration());
            existingStudentCourse.setCourse(studentCourse.getCourse());

            return studentCourseRepository.save(existingStudentCourse);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteStudentCourseById(int id) {
        studentCourseRepository.deleteById(id);
    }

    public List<StudentCourse> getCoursesByStudent(String studentId) {
        StudentRegistration student = studentRegistrationRepository.findByStudentId(studentId);
        return studentCourseRepository.findByStudentRegistration(student);
    }
    @Autowired
    private StudentRegistrationRepository studentRegistrationRepo;

    public List<StudentCourse> getCoursesByStudentId(String studentId) {
        StudentRegistration student = studentRegistrationRepository.findByStudentId(studentId);
        return studentCourseRepository.findByStudentRegistration(student);
    }
    public List<StudentCourse> getStudentByCourseAndSemester(Course course, String semester) {
        List<StudentRegistration> students = studentRegistrationRepository.findBySemesterId(semester);
        List<StudentCourse> result = new ArrayList<>();
        for (StudentRegistration student : students) {
            List<StudentCourse> coursesForStudent = studentCourseRepository.findByCourseAndStudentRegistration(course, student);
            result.addAll(coursesForStudent);
        }
        return result;
    }

    public boolean isStudentExists(String studentId) {
        return studentRegistrationRepository.existsByStudentId(studentId);
    }



    // Other methods...

    public List<StudentCourse> getCoursesForStudent(StudentRegistration studentRegistration) {
        return studentCourseRepository.findByStudentRegistration(studentRegistration);
    }
}
