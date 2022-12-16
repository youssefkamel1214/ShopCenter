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
public class Product {
   private int id,qauntity;

    public void setId(int id) {
        this.id = id;
    }
   private String title,category;
   private  float price;
   private byte[] image;

    public Product() {
    }

    public Product(int qauntity, String title, String category, float price, byte[] image) {
        this.qauntity = qauntity;
        this.title = title;
        this.category = category;
        this.price = price;
        this.image = image;
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
    public String toString() {
        return "Product{" + "id=" + id + ", qauntity=" + qauntity + ", title=" + title + ", category=" + category + ", price=" + price + ", image=" + image + '}';
    }
}
