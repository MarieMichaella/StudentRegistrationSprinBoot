package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.repository.AcademicUnitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicUnitServiceImpl implements AcademicUnitService {

    private final AcademicUnitRepository academicUnitRepository;

    @Autowired
    public AcademicUnitServiceImpl(AcademicUnitRepository academicUnitRepository) {
        this.academicUnitRepository = academicUnitRepository;
    }

    @Override
    public List<AcademicUnit> getAllAcademicUnits() {
        return academicUnitRepository.findAll();
    }

    @Override
    public AcademicUnit getAcademicUnitById(String id) {
        return academicUnitRepository.findById(id).orElse(null);
    }

    @Override
    public AcademicUnit saveAcademicUnit(AcademicUnit academicUnit) {
        return academicUnitRepository.save(academicUnit);
    }

    @Override
    public void deleteAcademicUnitById(String id) {
        academicUnitRepository.deleteById(id);
    }

    @Override
    public AcademicUnit updateAcademicUnit(String id, AcademicUnit academicUnit) {
        Optional<AcademicUnit> existingAcademicUnitOptional = academicUnitRepository.findById(id);
        if (existingAcademicUnitOptional.isPresent()) {
            AcademicUnit existingAcademicUnit = existingAcademicUnitOptional.get();
            existingAcademicUnit.setName(academicUnit.getName());
            existingAcademicUnit.setType(academicUnit.getType());
            existingAcademicUnit.setTeachers(academicUnit.getTeachers());
            existingAcademicUnit.setUnit(academicUnit.getUnit());

            return academicUnitRepository.save(existingAcademicUnit);
        }
        return null; // Or throw an exception if you prefer
    }
}
