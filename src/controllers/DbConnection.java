/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author youssef
 */
import controllers.ProductRegistry;
import java.io.ByteArrayOutputStream;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import shopcenter.models.Product;
import shopcenter.models.User;
import shopcenter.models.Sale;
import shopcenter.models.Category;
import shopcenter.models.Feedback;
import shopcenter.models.Shopcard;

public class DbConnection {
    private static DbConnection instance;
    private   String DBname="ShopDB.db";
    private Connection connection=null;
    private ProductRegistry registry=new ProductRegistry();
    
    private DbConnection() {
             if(fisrttimecreation()){
                  createTables();
                  insertbasicDB();
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
    

    //order (product id, amount, )
    private void createTables() {
         try {
            if(connection==null)
                  connection= DriverManager.getConnection("jdbc:sqlite:"+DBname);
            String productTable ="create Table product (id INTEGER primary key AUTOINCREMENT , title Text , category Text , quantity number , price decimal (10 , 2) , image blob," +
                    " amount_sold number , Discount decimal (1 , 2) )";
            // balance creditcard
            String userTable ="create Table user (id INTEGER primary key AUTOINCREMENT , name Text , email Text , password text , ssn text , phone Text , creditcard Text, balance number )";
            String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, productid ,userid,date Text, count number,FOREIGN KEY (productid) REFERENCES product(id) ON DELETE CASCADE,FOREIGN KEY (userid) REFERENCES user(id))";
            String categoryTable = "create Table category (id INTEGER primary key AUTOINCREMENT , title Text , image blob)";
            String productFeedbackTable = "create Table productfeedback (id INTEGER primary key AUTOINCREMENT,productid,userid,feedback Text,rate number, FOREIGN KEY (productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id))";
            String Shopcard = "create Table shopcard (id INTEGER primary key AUTOINCREMENT,productid,userid,count number, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id))";
            Statement statement=connection.createStatement();
            
            statement.execute(productTable);
            statement.execute(userTable);
            statement.execute(salesTable);
            statement.execute(categoryTable);
            statement.execute(productFeedbackTable);
            statement.execute(Shopcard);
            
            statement.close();
        }catch (SQLException exe){
             System.err.println(exe);
        }
    }
    private void insertbasicDB() {
        
            String[] Titles = {"Jackets","Pants","TShirts","Shoes"};
            int[] Price = new int[]{200,300,400,500};
            int[] Price1 = new int[]{150,300,300,350};
            int[] Price2 = new int[]{200,250,150,300};
            int[] Price3 = new int[]{200,300,300,250};
            for(int i=1; i <= 4;i++)
            { 
                try {
                FileInputStream  fis=new FileInputStream(new File("products\\images\\"+ i + ".png"));
                ByteArrayOutputStream boas= new  ByteArrayOutputStream(); 
                byte[] buff=new byte[1024];
                for(int r;(r=fis.read(buff))!=-1;){
                   boas.write(buff,0,r);
                }
             byte[] image = boas.toByteArray();
             
             Category C =  new Category(Titles[i-1],image);
             insertCategory(C);
             } catch (Exception e) {
             System.err.println(e);
                }
            }
            Titles = new String[]{"Casual","Formal","LeatherJacket","WinterCoat"};
            for(int i=1; i <= 4;i++)
            { 
                try {
                FileInputStream  fis=new FileInputStream(new File("products\\Jackets\\"+ i + ".jpg"));
                ByteArrayOutputStream boas= new  ByteArrayOutputStream(); 
                byte[] buff=new byte[1024];
                for(int r;(r=fis.read(buff))!=-1;){
                   boas.write(buff,0,r);
                }
             byte[] image = boas.toByteArray();
             
             Product C =  new Product(12,Titles[i-1],"Jackets",Price[i-1],image,i+1*2,0);
             insertPoduct(C);
             } catch (Exception e) {
             System.err.println(e);
                }
            }
            
            Titles = new String[]{"jeans","jogger","sweetpants","trousers"};
            for(int i=1; i <= 4;i++)
            { 
                try {
                FileInputStream  fis=new FileInputStream(new File("products\\Pants\\"+ i + ".jpg"));
                ByteArrayOutputStream boas= new  ByteArrayOutputStream(); 
                byte[] buff=new byte[1024];
                for(int r;(r=fis.read(buff))!=-1;){
                   boas.write(buff,0,r);
                }
             byte[] image = boas.toByteArray();
             
             Product C =  new Product(12,Titles[i-1],"Pants",Price1[i-1],image,i+1*2,0);
             insertPoduct(C);
             } catch (Exception e) {
             System.err.println(e);
                }
            }
            
           Titles = new String[]{"boots","casual","leather","snickers"};
            for(int i=1; i <= 4;i++)
            { 
                try {
                FileInputStream  fis=new FileInputStream(new File("products\\Shoes\\"+ i + ".jpg"));
                ByteArrayOutputStream boas= new  ByteArrayOutputStream(); 
                byte[] buff=new byte[1024];
                for(int r;(r=fis.read(buff))!=-1;){
                   boas.write(buff,0,r);
                }
             byte[] image = boas.toByteArray();
             
             Product C =  new Product(12,Titles[i-1],"Shoes",Price3[i-1],image,i+1*2,0);
             insertPoduct(C);
             } catch (Exception e) {
             System.err.println(e);
                }
            }
            
            Titles = new String[]{"Hoodied","Oversized","polo","round"};
            for(int i=1; i <= 4;i++)
            { 
                try {
                FileInputStream  fis=new FileInputStream(new File("products\\Tshirts\\"+ i + ".jpg"));
                ByteArrayOutputStream boas= new  ByteArrayOutputStream(); 
                byte[] buff=new byte[1024];
                for(int r;(r=fis.read(buff))!=-1;){
                   boas.write(buff,0,r);
                }
             byte[] image = boas.toByteArray();
             
             Product C =  new Product(12,Titles[i-1],"TShirts",Price2[i-1],image,i+1*2,0);
             insertPoduct(C);
             } catch (Exception e) {
             System.err.println(e);
                }
            }
            
    }
    
    // products functions
    //insert  GetbyId Getall getbyCategory  Delete
    public void insertPoduct(Product product){
        try {
            String sql="insert into product ( title , category , quantity , price , image,amount_sold, Discount ) values(?,?,?,?,?,?,?)";
            PreparedStatement s=  connection.prepareStatement(sql);
            s.setString(1, product.getTitle());
            s.setString(2, product.getCategory());
            s.setInt(3, product.getQauntity());
            s.setDouble(4, product.getPrice());
            s.setBytes(5, product.getImage());
            s.setInt(6, product.getAmountsold());
            s.setDouble(7, product.getDiscount());
            s.execute();
            s.close();
        } catch (SQLException ex) {
            System.err.println(ex);
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
                 p=registry.getproduct(rs.getString("category"));
                 p.setId(rs.getInt("id"));
                 p.setTitle(rs.getString("title"));
                 p.setPrice(rs.getFloat("Price"));
                 p.setQauntity(rs.getInt("quantity"));
                 p.setImage(rs.getBytes("image"));
                 p.setAmountsold(rs.getInt("amount_sold"));
                 p.setDiscount(rs.getFloat("Discount"));
            }
              rs.close();
                 statement.close();
          }
        catch (Exception ex) {
             System.err.println(ex);
        }
        return p;
    }
    public Product getproductbyTitle(String title){
        Product p=new Product();
        try {
             String sql="select * from product where title = ?";
             PreparedStatement statement=connection.prepareStatement(sql);
             statement.setString(1, title);
             ResultSet rs= statement.executeQuery();
             while (rs.next()) {
                 p=registry.getproduct(rs.getString("category"));
                 p.setId(rs.getInt("id"));
                 p.setTitle(rs.getString("title"));
                 p.setPrice(rs.getFloat("Price"));
                 p.setQauntity(rs.getInt("quantity"));
                 p.setImage(rs.getBytes("image"));
                 p.setAmountsold(rs.getInt("amount_sold"));
                 p.setDiscount(rs.getFloat("Discount"));
            }
              rs.close();
                 statement.close();
          }
        catch (Exception ex) {
             System.err.println(ex);
        }
        return p;
    } 
    public void updateproduct(Product product) {
        try {
            String sql="update product set title = ? , category = ? , quantity = ?, price = ? , image = ?,amount_sold = ?, discount = ?  where id=?";
            PreparedStatement s=  connection.prepareStatement(sql);
            s.setString(1, product.getTitle());
            s.setString(2, product.getCategory());
            s.setInt(3, product.getQauntity());
            s.setDouble(4, product.getPrice());
            s.setBytes(5, product.getImage());
            s.setInt(6, product.getAmountsold());
            s.setDouble(7, product.getDiscount());
            s.setInt(8, product.getId());
            s.execute();
            s.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public void updateproductqauntity(int id,int count){
           try{
               String sql="update product set quantity = quantity -? , amount_sold = amount_sold + ?  where id = ? ";
               PreparedStatement s=  connection.prepareStatement(sql);
               s.setInt(1, count);
               s.setInt(2, count);
               s.setInt(3, id);
               s.execute();

           }catch(Exception e){
               System.err.println(e);
           }
    }
    public void increaseproductstock(int id,int count){
      try{
          String sql="update product set quantity = quantity + ? ,amount_sold= amount_sold - ? where id = ? ";
          PreparedStatement s=  connection.prepareStatement(sql);
          s.setInt(1, count);
          s.setInt(2, count);
          s.setInt(3, id);
          s.execute();
      }catch(Exception e){
            System.err.println(e);
      }
      
    }
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        try {
             String sql="select * from product";
             PreparedStatement statement=connection.prepareStatement(sql);
             ResultSet rs= statement.executeQuery();
             while (rs.next()) {
                Product product = registry.getproduct(rs.getString("category"));
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setPrice(rs.getFloat("Price"));
                product.setQauntity(rs.getInt("quantity"));
                product.setImage(rs.getBytes("image"));
                product.setAmountsold(rs.getInt("amount_sold"));
                product.setDiscount(rs.getFloat("Discount"));
                products.add(product);
            }
              rs.close();
                 statement.close();
          }
        catch (Exception ex) {
             System.err.println(ex);
        }
        return products;
    }
    public List<Product> getProductsbyCategory(String category){
        List<Product> products = new ArrayList<Product>();
        try {
             
             String sql="select * from product where category = ?";
             PreparedStatement statement=connection.prepareStatement(sql);
             statement.setString(1, category);
             ResultSet rs= statement.executeQuery();
             while (rs.next()) {
                 Product product = registry.getproduct(rs.getString("category"));
                product.setId(rs.getInt("id"));
                product.setPrice(rs.getFloat("Price"));
                product.setTitle(rs.getString("title"));
                product.setQauntity(rs.getInt("quantity"));
                product.setImage(rs.getBytes("image"));
                product.setAmountsold(rs.getInt("amount_sold"));
                product.setDiscount(rs.getFloat("Discount"));
                products.add(product);
            }
              rs.close();
                 statement.close();
          }
        catch (Exception ex) {
             System.err.println(ex);
        }
        return products;
    } 
    public void deleteProduct(int id){
        try {
            String sql="delete from product where id = ?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        }
        catch (Exception ex) {
             System.err.println(ex);
        }
    }
    public void deletebyCategory(String title) {
        String sql="Delete from product where category = ?";

          try{
               PreparedStatement statment;
        statment = connection.prepareStatement(sql);
        statment.setString(1, title);
        statment.execute();
        statment.close();
          }
          catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);

       }
    }  



    //user finction 
    // insert getbyID GetAllUsers  countEmail  countCredit   countPhone  Delete
        public void insertUser(User user){
                // String userTable ="create Table user (id INTEGER primary key AUTOINCREMENT , name Text , email Text , password text , ssn number , phone Text , usertype Text )";
            try {
                String sql="insert into user ( name , email , password , ssn , phone , creditcard , balance ) values(?,?,?,?,?,?,?)";
                PreparedStatement s=  connection.prepareStatement(sql);
                s.setString(1, user.getName());
                s.setString(2, user.getEmail());
                s.setString(3, user.getPassword());
                s.setString(4, user.getSsn());
                s.setString(5, user.getPhone());
                s.setString(6, user.getCreditcard());
                s.setInt(7, user.getBalance());
                s.execute();
                s.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        public User getUserbyid(int id){
            User user = new User();
            try {
                
                 String sql="select * from user where id = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     user.setId(rs.getInt("id"));
                     user.setName(rs.getString("name"));
                     user.setEmail(rs.getString("email"));
                     user.setPassword(rs.getString("password"));
                     user.setSsn(rs.getString("ssn"));
                     user.setPhone(rs.getString("phone"));
                     user.setCreditcard(rs.getString("creditcard"));
                     user.setBalance(rs.getInt("balance"));
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return user;
        }
        public List<User> getAllUsers(){
            List<User> users = new ArrayList<User>();
            try {
                // String userTable ="create Table user (id INTEGER primary key AUTOINCREMENT , name Text , email Text , password text , ssm number , phone Text , usertype Text )";
                 String sql="select * from user";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     User user = new User();
                     user.setId(rs.getInt("id"));
                     user.setName(rs.getString("name"));
                     user.setEmail(rs.getString("email"));
                     user.setPassword(rs.getString("password"));
                     user.setSsn(rs.getString("ssn"));
                     user.setPhone(rs.getString("phone"));
                     user.setCreditcard(rs.getString("creditcard"));
                     user.setBalance(rs.getInt("balance"));
                     users.add(user);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return users;
        }
        public int getCountEmail(String email){
            int count = 0;
            try {
                String sql="select count(*) as total from user where email = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, email);
                ResultSet rs= statement.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("total");
                }
                 rs.close();
                 statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return count;
            
        }    
        public int getCountCredit(String credit){
            int count = 0;
            try {
                String sql="select count(*) as total from user where creditcard = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, credit);
                ResultSet rs= statement.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("total");
                }
                 rs.close();
                 statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return count;
            
        }  
        public int getCountphone(String phone){
            int count = 0;
            try {
                String sql="select count(*) as total from user where phone = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, phone);
                ResultSet rs= statement.executeQuery();
                while (rs.next()) {
                    count = rs.getInt("total");
                }
                 rs.close();
                 statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return count;
            
        }
        public void updateUserBalance(int id,int newbalance){
            try {
                String sql="update user set balance = ? where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1, newbalance);
                statement.setInt(2, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
       }
        public void updateUserInfo(int id,User user){
            try {
                String sql="update user set name = ? , email = ? , password = ? , ssn = ? , phone = ? , creditcard = ? ,balance = ? where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getSsn());
                statement.setString(5, user.getPhone());
                statement.setString(6, user.getCreditcard());
                statement.setInt(7, user.getBalance());
                statement.setInt(8, id);

                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
       }
        public void deleteUser(int id){
            try {
                String sql="delete from user where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }
        
        
        
        
        //Sales functions
        //insert  getbyid  getbyUserid   getbyProductid  delete
        public void insertSale(Sale sale){
               //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
            try {
                String sql="insert into sales ( Productid , userid , date ,count ) values(?,?,?,?)";
                PreparedStatement s =  connection.prepareStatement(sql);
                s.setInt(1, sale.getProductid());
                s.setInt(2, sale.getUserid());
                s.setString(3, sale.getDate());
                s.setInt(4, sale.getCount());
                s.execute();
                s.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        public Sale getSalebyid(int id){
            Sale sale = new Sale();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from sales where id = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     sale.setCount(rs.getInt("count"));
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return sale;
        }
        public List<Sale> getAllSale(){
            List<Sale> sales = new ArrayList<Sale>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from sales";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Sale sale = new Sale();
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     sale.setCount(rs.getInt("count"));
                     sales.add(sale);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return sales;
        }     
        public List<Sale> getSalesbyUserid(int id){
            List<Sale> sales = new ArrayList<Sale>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from sales where userid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Sale sale = new Sale();
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     sale.setCount(rs.getInt("count"));
                     sales.add(sale);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return sales;
        }    
        
         public List<Sale> getSalesbyDate(String date){
            List<Sale> sales = new ArrayList<Sale>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from sales where date = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setString(1, date);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Sale sale = new Sale();
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     sale.setCount(rs.getInt("count"));
                     sales.add(sale);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return sales;
        }              
        public List<Sale> getSalesbyProductid(int id){
            List<Sale> sales = new ArrayList<Sale>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from sales where productid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Sale sale = new Sale();
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     sales.add(sale);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return sales;
        }     
        public void deleteSale(int id){
            try {
                String sql="delete from sales where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }  
        public void deletebydate(String Date ){
                        try {
                String sql="delete from sales where date = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setString(1, Date);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }      
        }
        public ArrayList<Sale> SearchByDate(String date) {
            ArrayList<Sale> Sales = new ArrayList<>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="Select * from sales where date= ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setString(1, date);

                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Sale sale = new Sale();
                     sale.setId(rs.getInt("id"));
                     sale.setProductid(rs.getInt("productid"));
                     sale.setUserid(rs.getInt("userid"));
                     sale.setDate(rs.getString("date"));
                     Sales.add(sale);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return Sales;
        }

        
        //category functions
        // insert getById GetALl Delete
        //String categoryTable = "create Table category (id INTEGER primary key AUTOINCREMENT , title Text , image blob)";
        public void insertCategory(Category category){
                //String categoryTable = "create Table category (id INTEGER primary key AUTOINCREMENT , title Text , image blob)";
            try {
                String sql="insert into category ( title , image ) values(?,?)";
                PreparedStatement s =  connection.prepareStatement(sql);
                s.setString(1, category.getTitle());
                s.setBytes(2, category.getImage());
                s.execute();
                s.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }     
        public Category getCategorybyid(int id){
            Category category = new Category();
            try {
                  //String categoryTable = "create Table category (id INTEGER primary key AUTOINCREMENT , title Text , image blob)";
                 String sql="select * from category where id = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                    category.setId(rs.getInt("id"));
                    category.setTitle(rs.getString("title"));
                    category.setImage(rs.getBytes("image"));
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return category;
        }
        public Category GetCategorybyName(String CategoryName) {
       String sql="Select * from category where title = ?";

       PreparedStatement statment;
        try {
            statment = connection.prepareStatement(sql);
            statment.setString(1, CategoryName);
            ResultSet rs= statment.executeQuery();
             if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setTitle(rs.getString("title"));
                category.setImage(rs.getBytes("image"));

                statment.close();
                rs.close();
                return category;
            }
             else{
                 rs.close();
                statment.close();
                return null;
             }

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
        public void UpdateCategory(Category category, String oldtitle) {
         String sql="Update category set title = ?,image = ? where id = ?";
         String sql2="Update product set category = ? where category = ?";
       try{

         PreparedStatement statment;
        statment = connection.prepareStatement(sql);
            statment.setString(1, category.getTitle());
            statment.setBytes(2, category.getImage());
            statment.setInt(3, category.getId());
            statment.execute();
            statment.close();
            statment = connection.prepareStatement(sql2);
            statment.setString(1,category.getTitle());
             statment.setString(2,oldtitle);
             statment.execute();
             statment.close();

       }
       catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);

       }

    }
        public List<Category> getAllCategory(){
            List<Category> categories = new ArrayList<Category>();
            try {
                  //String categoryTable = "create Table category (id INTEGER primary key AUTOINCREMENT , title Text , image blob)";
                 String sql="select * from category";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                    Category category = new Category();
                    category.setId(rs.getInt("id"));
                    category.setTitle(rs.getString("title"));
                    category.setImage(rs.getBytes("image"));
                    categories.add(category);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return categories;
        } 
        public void deleteCategory(int id){
            try {
                String sql="delete from category where id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }
         public boolean checkcategoryexsits(String categoryname) {
            try {
                String sql="Select count(*) as cc from category where title = ?";
                PreparedStatement statment = connection.prepareStatement(sql);
                statment.setString(1, categoryname);
                ResultSet rs= statment.executeQuery();
                 int c=0;
                if (rs.next()) {
                   c=rs.getInt("cc");

                }
                rs.close();
                statment.close();
                if(c>0)
                    return true;
                else return false;

            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
         }
        
        //feedback functions
        //"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
        //list
        public void insertFeedback(Feedback feedback){
               //"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
            try {
                String sql="insert into productfeedback ( Productid , userid , feedback, rate ) values(?,?,?,?)";
                PreparedStatement s =  connection.prepareStatement(sql);
                s.setInt(1, feedback.getProductid());
                s.setInt(2, feedback.getUserid());
                s.setString(3, feedback.getFeedback());
                s.setInt(4, feedback.getRate());
                s.execute();
                s.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }  
        public Feedback getFeedbackbyid(int id){
            Feedback feedback = new Feedback();
            try {
                 ///"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
                 String sql="select * from productfeedback where id = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     feedback.setId(rs.getInt("id"));
                     feedback.setProductid(rs.getInt("productid"));
                     feedback.setUserid(rs.getInt("userid"));
                     feedback.setFeedback(rs.getString("feedback"));
                     feedback.setRate(rs.getInt("rate"));
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return feedback;
        }      
        public List<Feedback> getAllFeedbacks(){
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            try {
                 ///"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
                 String sql="select * from productfeedback";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Feedback feedback = new Feedback();
                     feedback.setId(rs.getInt("id"));
                     feedback.setProductid(rs.getInt("productid"));
                     feedback.setUserid(rs.getInt("userid"));
                     feedback.setFeedback(rs.getString("feedback"));
                     feedback.setRate(rs.getInt("rate"));
                     feedbacks.add(feedback);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return feedbacks;
        }
        public List<Feedback> getFeedbacksbyUserid(int id){
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            try {
                 ///"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
                 String sql="select * from productfeedback where userid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Feedback feedback = new Feedback();
                     feedback.setId(rs.getInt("id"));
                     feedback.setProductid(rs.getInt("productid"));
                     feedback.setUserid(rs.getInt("userid"));
                     feedback.setFeedback(rs.getString("feedback"));
                     feedback.setRate(rs.getInt("rate"));
                     feedbacks.add(feedback);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return feedbacks;
        }
        public List<Feedback> getFeedbacksbyProductid(int id){
            List<Feedback> feedbacks = new ArrayList<Feedback>();
            try {
                 ///"create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number)";
                 String sql="select * from productfeedback where productid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Feedback feedback = new Feedback();
                     feedback.setId(rs.getInt("id"));
                     feedback.setProductid(rs.getInt("productid"));
                     feedback.setUserid(rs.getInt("userid"));
                     feedback.setFeedback(rs.getString("feedback"));
                     feedback.setRate(rs.getInt("rate"));
                     feedbacks.add(feedback);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return feedbacks;
        }
        public void deleteFeedback(int id){
            try {
                String sql="delete from productfeedback where id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }
        
        //shopcard functions
        //insert  getbyid getAll  getbyUserId  getbyProductId Delete
        public void insertShopcard(Shopcard shopcard){
              
            try {
                String sql="insert into shopcard ( Productid , userid , count ) values(?,?,?)";
                PreparedStatement s =  connection.prepareStatement(sql);
                s.setInt(1, shopcard.getProductid());
                s.setInt(2, shopcard.getUserid());
                s.setInt(3, shopcard.getCount());
                s.execute();
                s.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        public void updateShopcardCount(int id, int count){
             try {
                String sql="update shopcard set count = ? where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1,count);
                statement.setInt(2, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }      
        public int getShopcardbyid(){
            int count;
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select count(*) as C from shopcard ";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                    count = rs.getInt("C");
                    return count;
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return -1;
        }
        public List<Shopcard> getAllShopcards(){
            List<Shopcard> shopcards = new ArrayList<Shopcard>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from shopcard";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Shopcard shopcard = new Shopcard();
                     shopcard.setId(rs.getInt("id"));
                     shopcard.setProductid(rs.getInt("productid"));
                     shopcard.setUserid(rs.getInt("userid"));
                     shopcard.setCount(rs.getInt("count"));
                     shopcards.add(shopcard);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return shopcards;
        }   
        public List<Shopcard> getShopcardsbyUserid(int id){
            List<Shopcard> shopcards = new ArrayList<Shopcard>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from shopcard where userid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Shopcard shopcard = new Shopcard();
                     shopcard.setId(rs.getInt("id"));
                     shopcard.setProductid(rs.getInt("productid"));
                     shopcard.setUserid(rs.getInt("userid"));
                     shopcard.setCount(rs.getInt("count"));
                     shopcards.add(shopcard);
                }
                  rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return shopcards;
        }    
        public List<Shopcard> getShopcardsbyProductid(int id){
            List<Shopcard> shopcards = new ArrayList<Shopcard>();
            try {
                 //String salesTable = "create Table sales (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),date Text)";
                 String sql="select * from shopcard where productid = ?";
                 PreparedStatement statement=connection.prepareStatement(sql);
                 statement.setInt(1, id);
                 ResultSet rs= statement.executeQuery();
                 while (rs.next()) {
                     Shopcard shopcard = new Shopcard();
                     shopcard.setId(rs.getInt("id"));
                     shopcard.setProductid(rs.getInt("productid"));
                     shopcard.setUserid(rs.getInt("userid"));
                     shopcard.setCount(rs.getInt("count"));
                     shopcards.add(shopcard);
                }
                 rs.close();
                 statement.close();
              }
            catch (Exception ex) {
                 System.err.println(ex);
            }
            return shopcards;
        }
        public void deleteShopcardByProductId(int Pid){
            try {
                String sql="delete from shopcard where productid = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1, Pid);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }       
        public void deleteShopcardById(int id){
            try {
                String sql="delete from shopcard where id = ?";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }       
        public void deleteallShopcard(){
            try {
                String sql="delete from shopcard";
                PreparedStatement statement=connection.prepareStatement(sql);
                statement.execute();
                statement.close();
            }
            catch (Exception ex) {
                 System.err.println(ex);
            }
        }
        public User ValidateEmail(String Email, String password) {
        try {
            String sql="Select * from user where email = ? and password = ?";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, Email);
            statment.setString(2, password);
            
            ResultSet rs= statment.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setSsn(rs.getString("ssn"));
                user.setPhone(rs.getString("phone"));
                user.setCreditcard(rs.getString("creditcard"));
                user.setBalance(rs.getInt("balance"));
                statment.close();
                rs.close();
                return user;
            }
            else{
                rs.close();
                statment.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }   
        public int getbyEmail(String Email) {
            int id;
        try {
            String sql="Select id from user where email = ?";
            PreparedStatement statment = connection.prepareStatement(sql);
            statment.setString(1, Email);
            ResultSet rs= statment.executeQuery();
            
            if (rs.next()) {
                id=rs.getInt("id");
                rs.close();
                statment.close();
                return id;
            }
            else{
                rs.close();
                statment.close();
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       return 0;
    } 

}
