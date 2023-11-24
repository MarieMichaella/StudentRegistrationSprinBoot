package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    Teacher saveTeacher(Teacher teacher);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacherById(Long id);
}
