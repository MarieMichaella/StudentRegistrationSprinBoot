package rw.auca.Student.Registration.Student.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.auca.Student.Registration.Student.Registration.domain.AcademicUnit;
import rw.auca.Student.Registration.Student.Registration.service.AcademicUnitService;

import java.util.List;

@RestController
@RequestMapping("/academic-units")
public class AcademicUnitController {

    private final AcademicUnitService academicUnitService;

    @Autowired
    public AcademicUnitController(AcademicUnitService academicUnitService) {
        this.academicUnitService = academicUnitService;
    }

    @GetMapping
    public ResponseEntity<List<AcademicUnit>> getAllAcademicUnits() {
        List<AcademicUnit> academicUnits = academicUnitService.getAllAcademicUnits();
        return new ResponseEntity<>(academicUnits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicUnit> getAcademicUnitById(@PathVariable String id) {
        AcademicUnit academicUnit = academicUnitService.getAcademicUnitById(id);
        return academicUnit != null
                ? new ResponseEntity<>(academicUnit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<AcademicUnit> saveAcademicUnit(@RequestBody AcademicUnit academicUnit) {
        AcademicUnit savedAcademicUnit = academicUnitService.saveAcademicUnit(academicUnit);
        return new ResponseEntity<>(savedAcademicUnit, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicUnitById(@PathVariable String id) {
        academicUnitService.deleteAcademicUnitById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicUnit> updateAcademicUnit(@PathVariable String id, @RequestBody AcademicUnit academicUnit) {
        AcademicUnit updatedAcademicUnit = academicUnitService.updateAcademicUnit(id, academicUnit);
        return updatedAcademicUnit != null
                ? new ResponseEntity<>(updatedAcademicUnit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
