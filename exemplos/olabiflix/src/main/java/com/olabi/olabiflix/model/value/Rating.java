package com.olabi.olabiflix.model.value;

public class Rating {
    private String rating;
    private String likes;

    public Rating(String rating, String likes) {
        this.rating = rating;
        this.likes = likes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
