/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopcenter.models;

/**
 *
 * @author youssef
 */
public class Product implements Cloneable{
   private int id,qauntity;

    public void setId(int id) {
        this.id = id;
    }
   private String title,category;
   private  float price;
   private byte[] image;
   private int amountsold;
   private float Discount;
    public Product() {
    }

    public float getDiscount() {
        return Discount;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public int getAmountsold() {
        return amountsold;
    }

    public void setAmountsold(int amountsold) {
        this.amountsold = amountsold;
    }

   

    public Product(int qauntity, String title, String category, float price, byte[] image, int amountsold,float discount) {
        this.qauntity = qauntity;
        this.title = title;
        this.category = category;
        this.price = price;
        this.image = image;
        this.amountsold = amountsold;
        this.Discount = discount;
    }

    public int getId() {
        return id;
    }

   

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    } 

    @Override
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", qauntity=" + qauntity + ", title=" + title + ", category=" + category + ", price=" + price + ", image=" + image + ", amountsold=" + amountsold + '}';
    }


    
}
