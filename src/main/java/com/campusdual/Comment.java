package com.campusdual;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Comment {
    private String userComment;
    private String date;
    private User user;

    public Comment(User user, String comment){
        this.user = user;
        this.userComment = comment;
        date = putDate();

    }

    public String putDate(){
        date = DateTimeFormatter.ofPattern("dd-MM-yyyy, hh:mm:ss")
                .format(LocalDateTime.now());
        return date;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", user=" + user +
                "userComment='" + userComment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
