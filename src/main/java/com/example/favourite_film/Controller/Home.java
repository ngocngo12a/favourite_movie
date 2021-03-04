package com.example.favourite_film.Controller;

import com.example.favourite_film.Entity.Movie;
import com.example.favourite_film.Entity.Rank_Board_Info;
import com.example.favourite_film.Service.FavouriteInfo;
import com.example.favourite_film.Service.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Home")
public class Home {
    @Autowired
    MovieInfo movieInfo;
    @Autowired
    FavouriteInfo favouriteInfo;
    @GetMapping(value = "/Movie/{MovieName}")
    public Movie getMovieByName(@PathVariable (name = "MovieName") String movieName){
        return movieInfo.findMovieByName(movieName);
    }
    @GetMapping(value = "/MovieType/{Type}")
    public List<Movie> getMovieByType(@PathVariable(name = "Type") String type){
        return  movieInfo.findMovieByType(type);
    }
    @GetMapping(value = "/MovieStatus/{Status}")
    public List<Movie> getMovieByStatus(@PathVariable(name = "Status") String status){
        return  movieInfo.findMovieByStatus(status);
    }
    @GetMapping(value = "/MovieRank")
    public List<Rank_Board_Info> getMovieByRank(){
        return  movieInfo.findMovieByRank();
    }

    @GetMapping(value = "/MovieList")
    public List<Movie> getAllMovie(){
        return  movieInfo.findAllMovie();
    }
    @PutMapping(value = "/RateMovie")
    public void RateMovie(@RequestBody Movie movie){
        movieInfo.rateMovie(movie.getName(),movie.getScore());
    }
}
