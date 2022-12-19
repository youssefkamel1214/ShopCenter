/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ui;

import controllers.DbConnection;
import controllers.UiFactoryController;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import shopcenter.models.User;

/**
 *
 * @author MahmoudNasser
 */
public class Authentication_porxy implements  Authentication{
    Authentication auth;
    Map <String,Integer> mp ;
    private JFrame jf;
    
    public Authentication_porxy(JFrame jf) {
        this.jf=jf;
        mp=new HashMap<String, Integer>(); 
        auth= new Authentication_main(jf);
    }
    
    @Override
    public void authenaticat_user(String Email, String password) {
         DbConnection db=DbConnection.getInstance();
        User user=db.ValidateEmail(Email,password);
        
        
        
        if(mp.getOrDefault(Email, 0)>=3){
            JOptionPane.showMessageDialog(jf,
        "Too many tries with the same email please wait for 30 sec and try again");
            return;
        }
      if(user==null){
          mp.put(Email,mp.getOrDefault(Email, 0)+1);
           JOptionPane.showMessageDialog(jf,
        "This Email dosen't Exist");
           
      }
      else{
          auth.authenaticat_user(Email, password);
      }
      return;
    }


}
