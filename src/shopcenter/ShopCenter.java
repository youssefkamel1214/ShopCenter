/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopcenter;

/**
 *
 * @author youssef
 */
import controllers.UiFactoryController;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import shopcenter.models.Product;
import shopcenter.models.User;
import shopcenter.models.Sale;
import shopcenter.models.Category;
import shopcenter.models.Feedback;
import shopcenter.models.Shopcard;
import java.util.ArrayList;
import java.util.List;

public class ShopCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        UiFactoryController uicon=new UiFactoryController();
//        uicon.getui("Login").showui();
        //DbConnection conn=DbConnection.getInstance();
        UiFactoryController F = new UiFactoryController();
        F.getui("Home").showui();
    
}
}

