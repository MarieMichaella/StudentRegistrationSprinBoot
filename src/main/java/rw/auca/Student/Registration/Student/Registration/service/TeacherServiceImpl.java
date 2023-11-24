package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Teacher;
import rw.auca.Student.Registration.Student.Registration.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> existingTeacherOptional = teacherRepository.findById(id);
        if (existingTeacherOptional.isPresent()) {
            Teacher existingTeacher = existingTeacherOptional.get();
            // Update properties of the existing teacher with the new values
            existingTeacher.setName(teacher.getName());
            existingTeacher.setQualification(teacher.getQualification());
            existingTeacher.setAcademicUnits(teacher.getAcademicUnits());

            return teacherRepository.save(existingTeacher);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
