package com.example.favourite_film.Service;

import com.example.favourite_film.Entity.Movie;
import com.example.favourite_film.Entity.Rank_Board_Info;
import com.example.favourite_film.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieInfo {
    @Autowired
    JpaConfig jpaConfig;

    public boolean verifyMovie(String name){
        String sql = "Select id_movie FROM MOVIE WHERE  name  = '" + name +"'; ";
        try{
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                System.out.println("This movie has already existed");
                return true;
            }
            else{
                System.out.println("This movie hasn't already existed");
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        }
    }
    public Movie findMovieByName(String name){
            if(verifyMovie(name)) {
                String sql = "Select * FROM MOVIE WHERE name =  '" + name + "' ;  ";
                Movie movie = null;
                try {
                    Statement statement = jpaConfig.getConnections().createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);
                    if (resultSet.next()) {
                        movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                                resultSet.getInt(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getString(7));
                    }
                    return movie;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Error !!!!");
                } finally {
                    return movie;
                }
            }
            else return null;
    }
    public List<Movie> findAllMovie(){
            String sql = "Select * FROM MOVIE;  ";
            List<Movie> movies = new ArrayList<>();

            try {
                Statement statement = jpaConfig.getConnections().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while(resultSet.next()) {
                    Movie movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                            resultSet.getInt(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getString(7));
                    movies.add(movie);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Error !!!!");
            } finally {
                return movies;
            }
    }
    public void addMovie(String id_movie,String name,String url_image,int year,String type,float score,String status){
        if(verifyMovie(name)) {
            return;
        }
        else {
            String sql = "INSERT INTO MOVIE (Id_movie, name,url_image,year, type,score, status) VALUES ('" + id_movie +"', '" + name +"', '" + url_image + "', '"+year+"', '"+type+"', '"+score+"', '" +status+"'); ";
            try {
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Add Movie complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Add Movie failed ");
            }
        }
    }
    public void rateMovie(String name,Float score){
        if(!verifyMovie(name)) return ;
        else{
            String sql  = "UPDATE movie SET score = '"+score+"' WHERE (name = '"+name+"');";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Rate movie complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Rate movie failed");
            }
        }
    }
    public void updateMovie(String id_movie,String name,String url_image,int year,String type,float score,String status){
        if(!verifyMovie(name)) return ;
        else{
            String sql  = "UPDATE movie SET url_image = '"+url_image+"', year = '"+year+"', type = '"+type+"', score = '"+score+"', status = '"+score+"' WHERE (name = '"+name+"');";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Update movie complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Update movie failed");
            }
        }
    }
    public List<Movie> findMovieByType(String type){
        String sql = "SELECT * FROM MOVIE WHERE TYPE = '"+type+"' ; ";
        List<Movie> movies = new ArrayList<>();
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Movie movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getString(7));
                movies.add(movie);
            }
            System.out.println("Find movie completed");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("find movie failed");
        }finally {
            return  movies;
        }
    }
    public List<Movie> findMovieByStatus(String status){
        String sql = "SELECT * FROM MOVIE WHERE STATUS = '"+status+"' ; ";
        List<Movie> movies = new ArrayList<>();
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Movie movie = new Movie(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getFloat(6), resultSet.getString(7));
                movies.add(movie);
            }
            System.out.println("Find movie completed");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("find movie failed");
        }finally {
            return  movies;
        }
    }
    public List<Rank_Board_Info> findMovieByRank(){
        String sql = "Select STT,view,rank_board.id_movie,name,url_image,year,type,score,status FROM rank_board,movie WHERE rank_board.Id_movie = movie.Id_movie ;";
        List<Rank_Board_Info> rank_board_infos = new ArrayList<>();
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Rank_Board_Info rank_board_info = new Rank_Board_Info(resultSet.getInt(1), resultSet.getFloat(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7),resultSet.getFloat(8),resultSet.getString(9));
                rank_board_infos.add(rank_board_info);
            }
            System.out.println("Find movie completed");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("find movie failed");
        }finally {
            return  rank_board_infos;
        }
    }
    public void deleteMovie(String name){
        String sql = "DELETE FROM MOVIE WHERE name = '"+name+"' ;   ";
        try{
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("Delete movie completed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Delete movie failed ");
        }
    }
}
