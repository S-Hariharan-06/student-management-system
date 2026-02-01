package com.student.studentmanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String registrationNo;

    private String name;
    private String email;
    private String course;

    // Default constructor (IMPORTANT)
    public Student() {
    }

    // Parameterized constructor
   public Student(String name, String registrationNo, String email, String course) {
    this.name = name;
    this.registrationNo = registrationNo;
    this.email = email;
    this.course = course;
}


    // Getters and Setters
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
    public String getRegistrationNo() {
    return registrationNo;
}

public void setRegistrationNo(String registrationNo) {
    this.registrationNo = registrationNo;
}


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
