package rw.auca.Student.Registration.Student.Registration.service;

import org.springframework.stereotype.Service;
import rw.auca.Student.Registration.Student.Registration.domain.Semester;
import rw.auca.Student.Registration.Student.Registration.repository.SemesterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImpl implements SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterServiceImpl(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Override
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    @Override
    public Semester getSemesterById(String id) {
        return semesterRepository.findById(id).orElse(null);
    }

    @Override
    public Semester saveSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    @Override
    public Semester updateSemester(String id, Semester semester) {
        Optional<Semester> existingSemesterOptional = semesterRepository.findById(id);
        if (existingSemesterOptional.isPresent()) {
            Semester existingSemester = existingSemesterOptional.get();
            // Update properties of the existing semester with the new values
            existingSemester.setName(semester.getName());
            existingSemester.setStartDate(semester.getStartDate());
            existingSemester.setEndDate(semester.getEndDate());

            return semesterRepository.save(existingSemester);
        }
        return null; // Or throw an exception if you prefer
    }

    @Override
    public void deleteSemesterById(String id) {
        semesterRepository.deleteById(id);
    }
}
