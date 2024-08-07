package com.todolist.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "title")
    private String title;

    @Column(name = "is_complete")
    private boolean is_complete;
    

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean is_complete() {
        return is_complete;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
    public void setComplete(boolean is_complete) {
        this.is_complete = is_complete;
    }


    public Task(Integer id, String title, boolean is_complete) {
        this.id = id;
        this.title = title;
        this.is_complete = is_complete;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", Title=" + title + ", is_complete=" + is_complete + "]";
    }

}