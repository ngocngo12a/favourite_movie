package com.example.favourite_film.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favourite_List {
    private String id_viewer;
    private String id_movie;

    public String getId_viewer() {
        return id_viewer;
    }

    public String getId_movie() {
        return id_movie;
    }
}
