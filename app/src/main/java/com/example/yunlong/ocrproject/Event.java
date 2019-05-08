package com.example.yunlong.ocrproject;

/**
 * Created by yunlong on 2019/5/5.
 */

public abstract class Event {
    public Event() {
        super();
    }



    private int id;
    private String content;
    private String title;
    private String label;
    private String time;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
