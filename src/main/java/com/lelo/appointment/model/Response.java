package com.lelo.appointment.model;

public class Response {

    private Integer id;
    private String officer;
    private String subject;
    private int size;

    public String getSubject() {
        return subject;
    }

    public Integer getId() {
        return id;
    }

    public String getOfficer() {
        return officer;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}