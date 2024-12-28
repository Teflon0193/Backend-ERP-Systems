package com.ERPsystem.miningcompany.Entity.hr;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String certification;
    private String employmentContract;
    private String name;
    private String jobTitle;
    private String training;
    private String workSchedule;
    private String image;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Attendance> attendanceRecords;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getTraining() {
        return training;
    }
    public void setTraining(String training) {
        this.training = training;
    }

    public String getEmploymentContract() {
        return employmentContract;
    }
    public void setEmploymentContract(String employmentContract) {
        this.employmentContract = employmentContract;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }
    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(List<Attendance> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }


}
