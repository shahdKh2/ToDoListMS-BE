package com.todolist.todolist.dto;

public class TaskDTO {
    private Integer id;
    private String Title;
    private boolean isComplete;

    public TaskDTO(Integer id, String Title, boolean isComplete) {
        this.id = id;
       this.Title = Title;
        this.isComplete = isComplete;
    }

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

    @Override
    public String toString() {
        return "Task [id=" + id + ", Title=" + Title + ", isComplete=" + isComplete + "]";
    }

}
