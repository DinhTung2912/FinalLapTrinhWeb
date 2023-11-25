
package com.example.finallaptrinhweb.model;

import java.sql.Timestamp;

public class Feedback {
    private int id;
    private String email;
    private int userId;
    private String content;
    private Timestamp submissionDate;

    public Feedback() {
    }

    public Feedback(int id, String email, int userId, String content, Timestamp submissionDate) {
        this.id = id;
        this.email = email;
        this.userId = userId;
        this.content = content;
        this.submissionDate = submissionDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getSubmissionDate() {
        return this.submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String toString() {
        return "Feedback{id=" + this.id + ", email='" + this.email + "', userId=" + this.userId + ", content='" + this.content + "', submissionDate=" + this.submissionDate + "}";
    }
}