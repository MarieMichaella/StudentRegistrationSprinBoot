package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import rw.auca.Student.Registration.Student.Registration.domain.Course;
import rw.auca.Student.Registration.Student.Registration.domain.StudentCourse;
import rw.auca.Student.Registration.Student.Registration.domain.StudentRegistration;
import rw.auca.Student.Registration.Student.Registration.repository.StudentCourseRepository;

import java.util.ArrayList;
import java.util.List;

public interface StudentCourseService {
    List<StudentCourse> getAllStudentCourses();
    StudentCourse getStudentCourseById(int id);
    StudentCourse saveStudentCourse(StudentCourse studentCourse);
    StudentCourse updateStudentCourse(int id, StudentCourse studentCourse);
    void deleteStudentCourseById(int id);

    public List<StudentCourse> getCoursesByStudent(String studentId);


    public List<StudentCourse> getCoursesByStudentId(String studentId);
    public List<StudentCourse> getStudentByCourseAndSemester(Course course, String semester);

    public boolean isStudentExists(String studentId);


    public List<StudentCourse> getCoursesForStudent(StudentRegistration studentRegistration);
}
