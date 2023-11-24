package rw.auca.Student.Registration.Student.Registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Student;
import rw.auca.Student.Registration.Student.Registration.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(String id, Student student) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);
        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            // Update properties of the existing student with the new values
            existingStudent.setName(student.getName());
            existingStudent.setCourses(student.getCourses());

            return studentRepository.save(existingStudent);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
}
