package rw.auca.Student.Registration.Student.Registration.service;

import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;

import java.util.List;

public interface AcademicUnitService {
    List<AcademicUnit> getAllAcademicUnits();
    AcademicUnit getAcademicUnitById(String id);
    AcademicUnit saveAcademicUnit(AcademicUnit academicUnit);
    AcademicUnit updateAcademicUnit(String id, AcademicUnit academicUnit);
    void deleteAcademicUnitById(String id);
}
