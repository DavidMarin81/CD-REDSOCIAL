package com.campusdual;

public class Image {
    private String title;
    private float X;
    private float Y;

    public Image(String title, float x, float y) {
        this.title = title;
        X = x;
        Y = y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getX() {
        return X;
    }

    public void setX(float x) {
        X = x;
    }

    public float getY() {
        return Y;
    }

    public void setY(float y) {
        Y = y;
    }
}
