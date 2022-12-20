/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.DbConnection;
import controllers.UiFactoryController;
import javax.swing.JFrame;
import shopcenter.models.User;

/**
 *
 * @author MahmoudNasser
 */

public class Authentication_main implements Authentication{
JFrame jf ;
int id;
    public Authentication_main(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void authenaticat_user(String Email, String password) {
        if(Email.equals("admin")&&password.equals("admin")){
            UiFactoryController ui = new UiFactoryController();
            ui.getui("Admin").showui();
            jf.dispose();
            return;
        } 
        DbConnection db=DbConnection.getInstance();
        id = db.getbyEmail(Email);
        jf.dispose();
        UiFactoryController ui = new UiFactoryController();
        ui.getuiParametrized("Home",id).showui();
        
    }
 
    
}
