package com.olabi.olabiflix.model.value;

import com.olabi.olabiflix.model.entity.Serie;
import jakarta.persistence.*;


@Entity
@Table(name="ratings")
public class Ratings {
    @Id
    @SequenceGenerator(name = "ratingsSequence", sequenceName = "ratingsSeq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratingsSequence")
    //@Column(name="ratingsID")
    private Long ratingID;
    private String rating;
    private String likes;
    @OneToOne
    private Serie serie;

    public Ratings(String rating, String likes) {
        this.rating = rating;
        this.likes = likes;
    }

    protected Ratings(){}

    public Long getRatingID() {
        return ratingID;
    }

    public void setRatingID(Long ratingID) {
        this.ratingID = ratingID;
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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

}
