package com.webbanthuocthuy.model;

import java.sql.Timestamp;

public class Feedback {
    private int id;
    private String email;
    private int userId;
    private String content;
    private Timestamp submissionDate;

    // Constructor
    public Feedback(){

    }
    public Feedback(int id, String email, int userId, String content, Timestamp submissionDate) {
        this.id = id;
        this.email = email;
        this.userId = userId;
        this.content = content;
        this.submissionDate = submissionDate;
    }

    // Các phương thức getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", submissionDate=" + submissionDate +
                '}';
    }
}
