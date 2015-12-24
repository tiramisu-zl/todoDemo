package com.tw.todo.model;


public class Todo {
    private Integer id;
    private String content;
    private boolean status;

    public Todo() {}

    public Todo(Integer id, boolean status) {
        this.id = id;
        this.status = status;
    }

    public Todo(Integer id, String content, boolean status) {
        this.id = id;
        this. content = content;
        this.status = status;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getContent(){
        return  this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
