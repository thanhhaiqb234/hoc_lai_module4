package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;
    private String blogName;
    private  String blogDescribe;

    @ManyToOne
    @JoinColumn(name = "category_id" )
    private Category category;

    public Blog() {
    }

    public Blog(int blogId, String blogName, String blogDescribe, Category category) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.blogDescribe = blogDescribe;
        this.category = category;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDescribe() {
        return blogDescribe;
    }

    public void setBlogDescribe(String blogDescribe) {
        this.blogDescribe = blogDescribe;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
