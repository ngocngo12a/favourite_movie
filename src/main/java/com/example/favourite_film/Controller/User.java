package com.example.favourite_film.Controller;

import com.example.favourite_film.Entity.Favourite_List;
import com.example.favourite_film.Entity.Favourite_List_Info;
import com.example.favourite_film.Entity.Viewer;
import com.example.favourite_film.Entity.ViewerReset;
import com.example.favourite_film.Service.FavouriteInfo;
import com.example.favourite_film.Service.ViewerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/User")
public class User {
    @Autowired
    ViewerInfo viewerInfo;
    @Autowired
    FavouriteInfo favouriteInfo;
    @PostMapping(value = "/Register")
    public  void PostUser(@RequestBody Viewer viewer){
        viewerInfo.addUser(viewer.getId_viewer(),viewer.getUser_name(),viewer.getPass_word(),viewer.getEmail());
    }
    @GetMapping(value = "/Login")
    public String GetUser(@RequestBody Viewer viewer){
        return viewerInfo.checkUser(viewer.getUser_name(),viewer.getPass_word());
    }
    @GetMapping(value = "/FavouriteList/{Id_viewer}")
    public List<Favourite_List_Info> getFavouriteListByUser(@PathVariable(name = "Id_viewer") String id_viewer){
        return favouriteInfo.showFavouriteInfoByUser(id_viewer);
    }
    @PutMapping(value = "ResetPassWord")
    public void ResetPass(@RequestBody ViewerReset viewerReset){
        viewerInfo.updatePassWord(viewerReset.getUser_name(),viewerReset.getPass_word(),viewerReset.getNew_pass_word());
    }
    @PostMapping(value="/FavouriteList/Add")
    public void PostFavourite(@RequestBody Favourite_List favourite_list){
        favouriteInfo.addFavouriteList(favourite_list.getId_viewer(),favourite_list.getId_movie());
    }
    @PutMapping(value = "/FavouriteList/Update")
    public void PutFavourite(@RequestBody Favourite_List favourite_list){
        favouriteInfo.updateFavouriteList(favourite_list.getId_viewer(),favourite_list.getId_movie());
    }
    @DeleteMapping(value = "/FavouriteList/Delete")
    public void DeleteFavourite(@RequestBody Favourite_List favourite_list){
        favouriteInfo.deleteFavouriteList(favourite_list.getId_viewer(),favourite_list.getId_movie());
    }
}
