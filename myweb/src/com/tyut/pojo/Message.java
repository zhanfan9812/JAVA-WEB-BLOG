package com.tyut.pojo;

public class Message {
    private String title;
    private String mid;
    private String username;
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", mid='" + mid + '\'' +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Message() {
    }

    public Message(String title, String username, String content) {
        this.title = title;
        this.username = username;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
