package rw.auca.Student.Registration.Student.Registration.service;

import java.util.List;

import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Student;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String id);
    Student saveStudent(Student student);
    Student updateStudent(String id, Student student);
    void deleteStudentById(String id);
}