package com.ERPsystem.miningcompany.Entity.hr;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long jobPostingId; // Links the applicant to a job posting.

    @Column(nullable = false)
    private String name; // Applicant's full name.

    private String resume; // Link or path to the applicant's resume.

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate applicationDate; // Date of application submission.

    private String position; // Job position applied for.

    private String category; // Category/Department (e.g., Sales, Engineering).

    private String phase; // Current phase of the application process (e.g., 1st Interview).

    @Column(nullable = false)
    private int daysInPhase; // Number of days the application is in the current phase.

    private String messages; // Communication notes or messages.

    private String evaluations; // Evaluation remarks or scores.

    private String notes; // General notes about the applicant.

    private String tags; // Tags for categorizing or marking the application.


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobPostingId() {
        return jobPostingId;
    }

    public void setJobPostingId(Long jobPostingId) {
        this.jobPostingId = jobPostingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public int getDaysInPhase() {
        return daysInPhase;
    }

    public void setDaysInPhase(int daysInPhase) {
        this.daysInPhase = daysInPhase;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(String evaluations) {
        this.evaluations = evaluations;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
