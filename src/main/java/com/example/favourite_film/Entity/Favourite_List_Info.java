package com.example.favourite_film.Entity;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@NoArgsConstructor
public class Favourite_List_Info {
    private String id_viewer;
    private String user_name;
    private String id_movie;
    private String name;
    private String url_image;
    private int year;
    private String type;
    private float score;
    private String status;

    public String getId_viewer() {
        return id_viewer;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getId_movie() {
        return id_movie;
    }

    public String getName() {
        return name;
    }

    public String getUrl_image() {
        return url_image;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public float getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public Favourite_List_Info(String id_viewer, String user_name, String id_movie, String name, String url_image, int year, String type, float score, String status) {
        this.id_viewer = id_viewer;
        this.user_name = user_name;
        this.id_movie = id_movie;
        this.name = name;
        this.url_image = url_image;
        this.year = year;
        this.type = type;
        this.score = score;
        this.status = status;
    }
}
