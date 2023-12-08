package com.example.finallaptrinhweb.model;

import java.sql.Timestamp;

public class Feedback {
    private String email;
    private String name;
    private String content;
    private Timestamp submissionDate;

    public Feedback() {
    }

    public Feedback(String email, String name, String content, Timestamp submissionDate) {
        this.email = email;
        this.name = name;
        this.content = content;
        this.submissionDate = submissionDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Feedback{ email='" + this.email + "', name='" + this.name + "', content='" + this.content + "', submissionDate=" + this.submissionDate + "}";
    }
}
