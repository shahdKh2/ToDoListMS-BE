package com.todolist.todolist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {
    private Integer id;
    private String title;

    @JsonProperty("is_complete") 
    private boolean is_complete;

    public TaskDTO(Integer id, String title, boolean is_complete) {
        this.id = id;
        this.title = title;
        this.is_complete = is_complete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("is_complete")
    public boolean is_complete() {
        return is_complete;
    }

    public TaskDTO() {
    }

    public void setComplete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", Title=" + title + ", is_complete=" + is_complete + "]";
    }
}
