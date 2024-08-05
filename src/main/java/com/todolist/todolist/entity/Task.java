package com.todolist.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Task {
    @Id
    private Integer id;
    private String Title;
    private boolean isComplete;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return Title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Task(Integer id, String title, boolean isComplete) {
        this.id = id;
        Title = title;
        this.isComplete = isComplete;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", Title=" + Title + ", isComplete=" + isComplete + "]";
    }

}