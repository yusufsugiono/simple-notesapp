package com.yusufsugiono.notesapp.models;

public class Note {
    private Long id;
    private String title;
    private String body;
    private String createdAt;

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
