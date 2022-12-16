/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopcenter.models;

/**
 *
 * @author youss
 */
public class Shopcard {
    private int id;
    private int userid;
    private int productid;
    private int count;

    public Shopcard() {
    }

    public Shopcard(int userid, int productid, int count) {
        this.userid = userid;
        this.productid = productid;
        this.count = count;
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

    public int getCount() {
        return count;
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

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Shopcard{" + "id=" + id + ", userid=" + userid + ", productid=" + productid + ", count=" + count + '}';
    }
    
    
}
