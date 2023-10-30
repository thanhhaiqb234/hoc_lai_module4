package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String namee;
    private int quantity;
    @OneToMany(mappedBy = "books")
    private Set<Orders> orders;

    public Books() {
    }

    public Books(int id, String namee, int quantity, Set<Orders> orders) {
        this.id = id;
        this.namee = namee;
        this.quantity = quantity;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String name) {
        this.namee = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
