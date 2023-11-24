package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.Semester;

import java.util.List;

public interface SemesterService {
    List<Semester> getAllSemesters();
    Semester getSemesterById(String id);
    Semester saveSemester(Semester semester);
    Semester updateSemester(String id, Semester semester);
    void deleteSemesterById(String id);
}
