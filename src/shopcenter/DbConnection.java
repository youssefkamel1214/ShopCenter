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
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import shopcenter.models.Product;
public class DbConnection {
    private static DbConnection instance;
    private   String DBname="ShopDB.db";
    private Connection connection=null;
    private DbConnection() {
             if(fisrttimecreation()){
                  createTables();
             }
             if(connection==null)
                  try {
                      connection= DriverManager.getConnection("jdbc:sqlite:"+DBname);
             } catch (SQLException ex) {
                 Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    public static DbConnection getInstance() {
        if(instance==null){
            instance=new DbConnection();
        }
        return instance;
    }
  
    private boolean fisrttimecreation() {
      File f = new File(DBname);
        if(f.exists()&&!f.isDirectory()){
            return false;
        }
        else{
              return true;
        }
    }
    public void insert_product(Product product){
        try {
            String sql="insert into product ( title , category , quantity , price , image ) values(?,?,?,?,?)";
            PreparedStatement s=  connection.prepareStatement(sql);
            s.setString(1, product.getTitle());
            s.setString(2, product.getCategory());
            s.setInt(3, product.getQauntity());
            s.setDouble(4, product.getPrice());
            s.setBytes(5, product.getImage());
            s.execute();
            s.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    private void createTables() {
         try {
            if(connection==null)
                  connection= DriverManager.getConnection("jdbc:sqlite:"+DBname);
            String productTable ="create Table product (id INTEGER primary key AUTOINCREMENT , title Text , category Text , quantity number , price number decimal (10 , 2) , image blob" +
                    " amount_sold number  )";
            String userTable ="create Table user (id int primary key , name Text , email Text , password text , ssm number , phone Text , usertype Text )";
            Statement statement=connection.createStatement();
            statement.execute(productTable);
            statement.execute(userTable);
            statement.close();
        }catch (SQLException exe){
             System.err.println(exe);
        }
    }
    public Product getproductbyid(int id){
        Product p=new Product();
        try {
             String sql="select * from product where id = ?";
             PreparedStatement statement=connection.prepareStatement(sql);
             statement.setInt(1, id);
             ResultSet rs= statement.executeQuery();
             while (rs.next()) {
                 p.setTitle(rs.getString("title"));
                 p.setCategory(rs.getString("category"));
                 p.setQauntity(rs.getInt("quantity"));
                 p.setImage(rs.getBytes("image"));
                 
            }
          }
        catch (Exception e) {
        }
        return p;
    }
}
