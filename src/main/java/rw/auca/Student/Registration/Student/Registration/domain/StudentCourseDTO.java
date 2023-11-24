package rw.auca.Student.Registration.Student.Registration.domain;

import java.math.BigDecimal;

public class StudentCourseDTO {
    private int id;
    private int credits;
    private BigDecimal results;
    private String studentRegistrationId; // Change the type to String
    private String courseId; // Change the type to String

    // getters and setters

    public StudentCourseDTO() {
    }

    public StudentCourseDTO(int id, int credits, BigDecimal results, String studentRegistrationId, String courseId) {
        this.id = id;
        this.credits = credits;
        this.results = results;
        this.studentRegistrationId = studentRegistrationId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public BigDecimal getResults() {
        return results;
    }

    public void setResults(BigDecimal results) {
        this.results = results;
    }

    public String getStudentRegistrationId() { // Change the return type to String
        return studentRegistrationId;
    }

    public void setStudentRegistrationId(String studentRegistrationId) { // Change the parameter type to String
        this.studentRegistrationId = studentRegistrationId;
    }

    public String getCourseId() { // Change the return type to String
        return courseId;
    }

    public void setCourseId(String courseId) { // Change the parameter type to String
        this.courseId = courseId;
    }
}
