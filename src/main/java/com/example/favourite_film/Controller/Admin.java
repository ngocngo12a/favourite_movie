package com.example.favourite_film.Controller;

import com.example.favourite_film.Entity.Favourite_List_Info;
import com.example.favourite_film.Entity.Movie;
import com.example.favourite_film.Entity.Rank_Board;
import com.example.favourite_film.Entity.Viewer;
import com.example.favourite_film.Service.FavouriteInfo;
import com.example.favourite_film.Service.MovieInfo;
import com.example.favourite_film.Service.RankBoardInfo;
import com.example.favourite_film.Service.ViewerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/Admin")
public class Admin {
    @Autowired
    FavouriteInfo favouriteInfo;
    @Autowired
    MovieInfo movieInfo;
    @Autowired
    ViewerInfo viewerInfo;
    @Autowired
    RankBoardInfo rankBoardInfo;
    @PostMapping(value = "/CreateMovie")
    public void CreateMovie(@RequestBody Movie movie){
        movieInfo.addMovie(movie.getId_movie(),movie.getName(),movie.getUrl_image(),movie.getYear(),movie.getType(),movie.getScore(),movie.getStatus());
    }
    @PutMapping(value = "/UpdateMovie")
    public void UpdateMovie(@RequestBody Movie movie){
        movieInfo.updateMovie(movie.getId_movie(),movie.getName(),movie.getUrl_image(),movie.getYear(),movie.getType(),movie.getScore(),movie.getStatus());
    }
    @DeleteMapping(value = "/DeleteMovie")
    public void DeleteMovie(@RequestBody Movie movie){
        movieInfo.deleteMovie(movie.getName());
    }
    @PutMapping(value = "/UpdateUser")
    public void PutUser(@RequestBody Viewer viewer){
        viewerInfo.updateUser(viewer.getId_viewer(),viewer.getUser_name(),viewer.getPass_word(),viewer.getEmail());
    }
    @DeleteMapping(value = "/DeleteUser")
    public void DeleteUser(@RequestBody Viewer viewer){
        viewerInfo.deleteUser(viewer.getUser_name());
    }
    @PostMapping(value = "/AddMovieRank")
    public void AddMovieRank(@RequestBody Rank_Board rank_board){
        rankBoardInfo.addMovieRank(rank_board.getSTT(),rank_board.getView(),rank_board.getId_movie());
    }
    @PutMapping(value = "/UpdateMovieRank")
    public void UpdateMovieRank(@RequestBody Rank_Board rank_board){
        rankBoardInfo.updateMovieRank(rank_board.getSTT(),rank_board.getView(),rank_board.getId_movie());
    }
    @DeleteMapping(value = "/DeleteMovieRank")
    public void DeleteMovieRank(@RequestBody Rank_Board rank_board){
        rankBoardInfo.deleteMovieRank(rank_board.getId_movie());
    }
    @GetMapping(value = "/FavouriteList")
    public List<Favourite_List_Info> getFavouriteList(){
        return favouriteInfo.showFavouriteInfo();
    }
}
