package com.example.favourite_film.Entity;

public class ViewerReset {
    private String id_viewer;
    private String user_name;
    private String pass_word;
    private String email;
    private String new_pass_word;

    public String getId_viewer() {
        return id_viewer;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPass_word() {
        return pass_word;
    }

    public String getEmail() {
        return email;
    }

    public String getNew_pass_word() {
        return new_pass_word;
    }

    public ViewerReset(String id_viewer, String user_name, String pass_word, String email, String new_pass_word) {
        this.id_viewer = id_viewer;
        this.user_name = user_name;
        this.pass_word = pass_word;
        this.email = email;
        this.new_pass_word = new_pass_word;
    }
}
