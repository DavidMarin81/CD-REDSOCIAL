package com.campusdual;

import java.util.Date;

public class Comment {
    private String comment;
    Date date;
    User owner;

    public Comment(String comment, Date date, User owner){
        this.comment = comment;
        this.date = date;
        this.owner = owner;
    }

}
