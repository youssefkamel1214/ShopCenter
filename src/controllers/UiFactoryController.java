/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Ui.FeedbackForm;
import Ui.Home;
import Ui.Login;
import Ui.Payment;
import Ui.ProductDescription;
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
               else if(type.equals("Register"))
                   return new Register();
               else if(type.equals("Login"))
                   return new Login();
               else if(type.equals("Payment"))
                   return new Payment();
               return null;
          } 
          public Ui getuiParametrized(String type,int Userid)
          {
            if(type.equals("Home"))
                return new Home(Userid);
              return null;
          }
          public Ui getuiParametrized(String type,int Userid,int Productid)
          {
               if(type.equals("Feedback"))
                   return new FeedbackForm(Userid,Productid);
              return null;
          }
          public Ui getuiParametrized(String type,String ProductType,int Userid)
          {
              if(type==null||type.isEmpty())
                   return null;
              if(type.equals("ProductDescription"))
                   return new ProductDescription(ProductType,Userid);
              return null;
          }
}
