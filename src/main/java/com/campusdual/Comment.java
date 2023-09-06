package com.campusdual;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private String userComment;
    private String date;
    private User user;

    public Comment(User user, String comment){
        this.user = user;
        this.userComment = comment;
        date = crearDate();

    }

    public String crearDate(){
        /*
        int days = (int)(Math.random()*28+1);
        int months = (int)(Math.random()*12+1);
        int years = (int)(Math.random()*22+100); //Empieza en 1900
        int hours = (int)(Math.random()*24);
        int minutes = (int)(Math.random()*60);
        int seconds = (int)(Math.random()*60);

        Date date = new Date(years, months, days, hours, minutes, seconds);
        System.out.println(date);
        */
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
                ", userComment='" + userComment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
