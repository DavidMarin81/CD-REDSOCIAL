package com.campusdual;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Post {
    private String date;
    private ArrayList<Comment> commentsList = new ArrayList<>();
    private Video video;
    private Image image;
    private String text;
    private User user;

    public Post(User user, String text) {
        this.user = user;
        this.date = putDate();
        this.text = text;
    }

    public Post(User user, Video video, ArrayList<Comment> commentsList) {
        this.user = user;
        this.date = putDate();
        this.commentsList = commentsList;
        this.video = video;
    }

    public Post(User user, Image image, ArrayList<Comment> commentsList) {
        this.user = user;
        this.date = putDate();
        this.commentsList = commentsList;
        this.image = image;
    }

    public String putDate(){
        date = DateTimeFormatter.ofPattern("dd-MM-yyyy, hh:mm:ss")
                .format(LocalDateTime.now());
        return date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(ArrayList<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addComment(Comment comment){
        commentsList.add(comment);
    }

    public void deleteComment(int index){
        commentsList.remove(index);
    }

    @Override
    public String toString() {
        return "Post{" +
                "date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", commentsList=" + commentsList +
                '}';
    }
}
