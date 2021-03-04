package com.example.favourite_film.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rank_Board {
    private int STT;
    private float view;
    private String id_movie;

    public int getSTT() {
        return STT;
    }

    public float getView() {
        return view;
    }

    public String getId_movie() {
        return id_movie;
    }
}
