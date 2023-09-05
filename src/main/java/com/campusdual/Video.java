package com.campusdual;

public class Video {
    private String title;
    private String quality;
    private float duration;

    public Video(String title, String quality, float duration) {
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
