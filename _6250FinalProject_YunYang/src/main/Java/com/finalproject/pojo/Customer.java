package com.finalproject.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component("customerobj")
@Entity
@Table(name = "customer", schema = "logindb", catalog = "")
public class Customer {
    private int cid;
    private String name;
    private String email;

    @Id
    @Column(name = "cid", unique = true, nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
