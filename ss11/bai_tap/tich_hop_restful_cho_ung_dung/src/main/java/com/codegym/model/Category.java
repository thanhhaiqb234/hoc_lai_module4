package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> postsSet;

    public Category() {
    }

    public Category(int id, String name, Set<Blog> postsSet) {
        this.id = id;
        this.name = name;
        this.postsSet = postsSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Blog> getPostsSet() {
        return postsSet;
    }

    public void setPostsSet(Set<Blog> postsSet) {
        this.postsSet = postsSet;
    }
}
