package com.finalproject.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component("placeobj")
@Entity
@Table(name = "place", schema = "logindb", catalog = "")
public class Place {
    private int id;
    private String fund;
    private int quantity;
    private int cust;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fund", nullable = false)
    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "cust", nullable = false)
    public int getCust() {
        return cust;
    }

    public void setCust(int cust) {
        this.cust = cust;
    }
}
