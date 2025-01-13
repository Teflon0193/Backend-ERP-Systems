package com.ERPsystem.miningcompany.Entity.hr;
import jakarta.persistence.*;

@Entity
@Table(name = "employee_training")
public class EmployeeTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private SafetyTraining safetyTraining;
    private String completionStatus;
    private String certificate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SafetyTraining getSafetyTraining() {
        return safetyTraining;
    }

    public void setSafetyTraining(SafetyTraining safetyTraining) {
        this.safetyTraining = safetyTraining;
    }

    public String getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(String completionStatus) {
        this.completionStatus = completionStatus;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
