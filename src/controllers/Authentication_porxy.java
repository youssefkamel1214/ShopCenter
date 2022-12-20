/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.DbConnection;
import controllers.UiFactoryController;
import java.util.Calendar;
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
    private Authentication auth;
    private Map <String,Integer> mp ;
    private JFrame jf;
    private Calendar cal;
    private boolean block=false;
    
    public Authentication_porxy(JFrame jf) {
        this.jf=jf;
        mp=new HashMap<String, Integer>(); 
        auth= new Authentication_main(jf);
        cal=Calendar.getInstance();
    }
    
    @Override
    public void authenaticat_user(String Email, String password) {
        if(block&&!checktimepassed()){
             JOptionPane.showMessageDialog(jf,
        "wait until time passed ");
             return;
        }
        else{
              block=false;
        }
        if(mp.getOrDefault(Email, 0)>=3){
            JOptionPane.showMessageDialog(jf,
        "Too many tries with the same email please wait for 30 sec and try again");
            mp.clear();
            cal=Calendar.getInstance();
            block=true;
            return;
        }
        if(Email.equals("admin")&&password.equals("admin")){
          auth.authenaticat_user(Email, password);
          return;
        } 
        
       DbConnection db=DbConnection.getInstance();
       User user=db.ValidateEmail(Email,password);
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

    private boolean checktimepassed() {
        Calendar now =Calendar.getInstance(),temp=Calendar.getInstance();
        temp.setTimeInMillis(cal.getTimeInMillis());
        temp.add(Calendar.SECOND, 30);
        if(now.after(temp))
            return true;
        else 
            return false;
    }


}
