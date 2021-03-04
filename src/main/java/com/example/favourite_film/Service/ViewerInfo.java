package com.example.favourite_film.Service;

import com.example.favourite_film.config.JpaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class ViewerInfo {
    @Autowired
    JpaConfig jpaConfig;
    public boolean verifyUser(String userName){
        String sql = "Select id_viewer FROM viewer WHERE user_name ='"+userName+"' ;  ";
        try{
            Statement statement = jpaConfig.getConnections().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                System.out.println("This userName has already existed");
                return true;
            }
            else{
                System.out.println("This userName hasn't already existed");
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  false;
        }
    }
    public void addUser(String id_viewer,String userName,String passWord,String email){
        if(verifyUser(userName)) return;
        else {
            String sql = "Insert into viewer (id_viewer,user_name,pass_word,email) values" +
                    "   ( '"+id_viewer+"' , '"+userName+ "' , '"+passWord+"' ,  '" + email + "') ;       ";
            try {
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Add User complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Add User failed ");
            }
        }
    }
    public String checkUser(String user_name,String passWord){
        if(!verifyUser(user_name)) return "Login is failed";
        else{
            String sql ="Select id_viewer FROM viewer WHERE user_name = '"+user_name+"' AND pass_word = '" +passWord+"' ;  ";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    return "Login is completed";
                }else{
                    return "Login is failed";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                return "Login is failed";
            }
        }
    }
    public void updateUser(String id_viewer,String userName,String passWord,String email){
        if(!verifyUser(userName)) return;
        else{
            String sql = "Update viewer set id_viewer = '" + id_viewer +"' , pass_word = '" + passWord+"' , email = '"+email+"' WHERE user_name = '"+userName+"' ;  ";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Update user complete");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Update user failed");
            }
        }
    }
    public void updatePassWord(String userName,String oldPassWord,String newPassWord){
        if(checkUser(userName,oldPassWord).equals("Login is completed")){
            String sql = "Update viewer set pass_word = '"+newPassWord+"' WHERE user_name = '"+userName+"' ;  ";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("Update pass completed");
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Update pass failed");
            }
        }
        else {
            System.out.println("Update pass failed");
        }
    }
    public void deleteUser(String userName){
        if(!verifyUser(userName)) return;
        else{
            String sql = "DELETE FROM viewer WHERE user_name = '"+userName+"' ; ";
            try{
                Statement statement = jpaConfig.getConnections().createStatement();
                statement.execute(sql);
                System.out.println("delete user completed");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("delete user failed");
            }
        }
    }
}
