/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopcenter.models;

/**
 *
 * @author youss
 */
public class Category {


    private int id;
    private String title;
    private byte[] image;

    public Category() {
    }

    public Category(String title, byte[] image) {
        this.title = title;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", title=" + title + ", image=" + image + '}';
    }
    
}
