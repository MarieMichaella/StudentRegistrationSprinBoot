package rw.auca.Student.Registration.Student.Registration.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "studentregistration")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class StudentRegistration {
    @Id
    @Column(name = "regNo")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_Id")
    private Semester semester;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_Id")
    private AcademicUnit department;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("courses") // Change "Courses" to "courses"
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;


    private LocalDate regDate;

    public StudentRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StudentRegistration(String id, Student student, Semester semester, AcademicUnit department,
                               List<Course> courses, LocalDate regDate) {
        super();
        this.id = id;
        this.student = student;
        this.semester = semester;
        this.department = department;
        this.courses = courses;
        this.regDate = regDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public AcademicUnit getDepartment() {
        return department;
    }

    public void setDepartment(AcademicUnit department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public StudentRegistration(String id) {
        this.id = id;
    }

}
