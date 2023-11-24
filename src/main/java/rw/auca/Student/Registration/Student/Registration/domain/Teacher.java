package rw.auca.Student.Registration.Student.Registration.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or use GenerationType.AUTO
    private Long id;


    private String name;

    @Enumerated(EnumType.STRING)
    private EQualification qualification;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "teacher_academicunit",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "academicunit_id")
    )
    private List<AcademicUnit> academicUnits;

    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Teacher(Long id, String name, EQualification qualification, List<AcademicUnit> academicUnits) {
        super();
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.academicUnits = academicUnits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EQualification getQualification() {
        return qualification;
    }

    public void setQualification(EQualification qualification) {
        this.qualification = qualification;
    }

    public List<AcademicUnit> getAcademicUnits() {
        return academicUnits;
    }

    public void setAcademicUnits(List<AcademicUnit> academicUnits) {
        this.academicUnits = academicUnits;
    }


}
