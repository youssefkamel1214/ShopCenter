/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Ui.Home;
import Ui.Login;
import Ui.Register;
import Ui.Ui;

/**
 *
 * @author youssef
 */
public class UiFactoryController {
         public Ui getui(String type){
               if(type==null||type.isEmpty())
                   return null;
               else if(type.equals("Home"))
                   return new Home();
               else if(type.equals("Register"))
                   return new Register();
               else if(type.equals("Login"))
                   return new Login();
               return null;
         } 
}
