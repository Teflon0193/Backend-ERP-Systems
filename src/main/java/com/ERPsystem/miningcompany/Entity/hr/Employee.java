package com.ERPsystem.miningcompany.Entity.hr;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String certification;
    private String training;
    private String employmentContract;
    private String workSchedule;


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
}
