/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopcenter.models;

/**
 *
 * @author youss
 */
public class Sale {
    private int id;
    private int userid;
    private int productid;
    private String date;

    public Sale() {
    }

    public Sale(int userid, int productid, String date) {
        this.userid = userid;
        this.productid = productid;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public int getProductid() {
        return productid;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" + "id=" + id + ", userid=" + userid + ", productid=" + productid + ", date=" + date + '}';
    }
    
    
}
