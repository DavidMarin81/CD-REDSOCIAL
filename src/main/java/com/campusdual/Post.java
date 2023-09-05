package com.campusdual;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Post {
    private Calendar date = new GregorianCalendar() {
    };
    private ArrayList<String> commentsList = new ArrayList<>();
    private Video video;
    private Image image;
    private String text;

    public Post(Calendar date, ArrayList<String> commentsList, String text) {
        this.date = date;
        this.commentsList = commentsList;
        this.text = text;
    }

    public Post(Calendar date, ArrayList<String> commentsList, Video video) {
        this.date = date;
        this.commentsList = commentsList;
        this.video = video;
    }

    public Post(Calendar date, ArrayList<String> commentsList, Image image) {
        this.date = date;
        this.commentsList = commentsList;
        this.image = image;
    }
}
