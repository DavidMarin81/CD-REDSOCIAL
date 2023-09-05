package com.campusdual;

import java.util.ArrayList;

public class User {
    private String userName;
    private ArrayList<User> usersList = new ArrayList<>();
    private ArrayList<String> postsLists = new ArrayList<>();

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    public ArrayList<String> getPostsLists() {
        return postsLists;
    }

    public void setPostsLists(ArrayList<String> postsLists) {
        this.postsLists = postsLists;
    }

    @Override
    public String toString() {
        return userName;
    }
}
