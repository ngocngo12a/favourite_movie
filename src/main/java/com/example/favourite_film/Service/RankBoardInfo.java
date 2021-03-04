package com.example.favourite_film.Service;

import com.example.favourite_film.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Statement;

@Service
public class RankBoardInfo {
    @Autowired
    JpaConfig jpaConfig;
    public void addMovieRank(int STT,float view,String idMovie){
            String sql = "INSERT INTO rank_board (STT,view,id_Movie) VALUES ('"+STT+"' , '"+view+"' , '" + idMovie+"'); ";
            try {
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Add MovieRank complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Add MovieRank failed ");
            }
    }
    public void updateMovieRank(int STT,float view,String idMovie){
        String sql = "UPDATE rank_board SET STT = '"+STT+"' ,view = '" +view+"' WHERE id_movie = '"+idMovie+"' ;  ";
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("Update MovieRank complete");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Update MovieRank failed ");
        }
    }
    public void deleteMovieRank(String idMovie){
        String sql = "DELETE FROM rank_board where id_movie = '"+idMovie+"';  ";
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("Delete MovieRank complete");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Delete MovieRank failed ");
        }
    }
}
