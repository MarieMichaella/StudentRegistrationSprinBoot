package rw.auca.Student.Registration.Student.Registration.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_course")
    private List<Course> courses;


    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(String id, String name, LocalDate dob, String telephone, List<Course> courses) {
        super();
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
