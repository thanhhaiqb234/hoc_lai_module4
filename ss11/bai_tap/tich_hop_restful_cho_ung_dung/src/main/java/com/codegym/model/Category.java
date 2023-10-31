package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String namee;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> postsSet;

    public Category() {
    }

    public Category(int id, String namee, Set<Blog> postsSet) {
        this.id = id;
        this.namee = namee;
        this.postsSet = postsSet;
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

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public Set<Blog> getPostsSet() {
        return postsSet;
    }

    public void setPostsSet(Set<Blog> postsSet) {
        this.postsSet = postsSet;
    }
}
