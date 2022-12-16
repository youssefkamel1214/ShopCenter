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
import java.util.HexFormat;
import java.util.List;

public class ShopCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DbConnection conn=DbConnection.getInstance();
        //Product(int qauntity, String title, String category, float price, byte[] image) {
        byte[] image = HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d");
        Product product = new Product(5, "title", "category", 10, image);
        
        User user = new User("name", "email", "password", 123, "phone", "userType", "creditcard", 999);
        
        //conn.insertPoduct(product);
        //conn.insertUser(user);
          conn.deleteProduct(1);
        
        List<Product> products = conn.getAllProducts();
        for(int i = 0 ; i < products.size();i++){
            System.out.println(products.get(i).toString());
        }
        
        List<User> users = conn.getAllUsers();
        for(int i = 0 ; i < users.size();i++){
            System.out.println(users.get(i).toString());
        }
        
        Shopcard shopcard = new Shopcard(0, 0, 0);
        
        //conn.insertShopcard(shopcard);
        conn.deleteShopcard(1);
        
        

        List<Shopcard> shopcards = conn.getAllShopcards();
        for(int i = 0 ; i < shopcards.size();i++){
            System.out.println(shopcards.get(i).toString());
        }
        

        
        

    }
    
}
