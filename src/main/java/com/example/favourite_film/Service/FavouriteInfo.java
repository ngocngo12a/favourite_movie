package com.example.favourite_film.Service;

import com.example.favourite_film.Entity.Favourite_List_Info;
import com.example.favourite_film.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteInfo {
    @Autowired
    JpaConfig jpaConfig;
    public void addFavouriteList(String id_viewer,String id_movie){
        String sql ="INSERT INTO favourite_list (id_viewer,id_movie) values ('"+id_viewer+"','"+id_movie+"'); ";
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("Add favourite_movie complete");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Add favourite_movie failed ");
        }
    }
    public void updateFavouriteList(String id_viewer,String id_movie){
        String sql = "Update favourite_list set id_movie = '"+id_movie+"' where id_viewer = '"+id_viewer+"'; ";
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("update favourite_movie complete");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("update favourite_movie failed ");
        }
    }
    public void deleteFavouriteList(String id_viewer,String id_movie){
        String sql = "DELETE FROM favourite_list where id_viewer = '"+id_viewer+"' and id_movie = '"+id_movie+"' ; ";
        try {
            Statement statement = jpaConfig.getConnections().createStatement();
            statement.execute(sql);
            System.out.println("update favourite_movie complete");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("update favourite_movie failed ");
        }
    }
    public List<Favourite_List_Info> showFavouriteInfo(){
        String sql = "SELECT favourite_list.id_viewer,user_name,favourite_list.id_movie,name,url_image,year,type,score,status" +
                " FROM favourite_list,viewer,movie " +
                " WHERE favourite_list.id_viewer = viewer.id_viewer" +
                " AND   favourite_list.id_movie  = movie.id_movie  ; " ;
        List<Favourite_List_Info> favourite_list_infos = new ArrayList<>();
        try{
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Favourite_List_Info favourite_list_info = new Favourite_List_Info(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getFloat(8),resultSet.getString(9));
                favourite_list_infos.add(favourite_list_info);
            }
            System.out.println("Get List Completed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Get List failed");
            return null;
        }finally {
            return  favourite_list_infos;
        }
    }
    public List<Favourite_List_Info> showFavouriteInfoByUser(String id_viewer){
        String sql = "SELECT favourite_list.id_viewer,user_name,favourite_list.id_movie,name,url_image,year,type,score,status" +
                " FROM favourite_list,viewer,movie " +
                " WHERE favourite_list.id_viewer = viewer.id_viewer" +
                " AND   favourite_list.id_movie  = movie.id_movie   " +
                " AND viewer.id_viewer = '"+id_viewer+"' ; " ;
        List<Favourite_List_Info> favourite_list_infos = new ArrayList<>();
        try{
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Favourite_List_Info favourite_list_info = new Favourite_List_Info(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
                        resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getFloat(8),resultSet.getString(9));
                favourite_list_infos.add(favourite_list_info);
            }
            System.out.println("Get List Completed");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Get List failed");
            return null;
        }finally {
            return  favourite_list_infos;
        }
    }
}
