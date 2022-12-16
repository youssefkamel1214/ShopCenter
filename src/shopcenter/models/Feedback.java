/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopcenter.models;

/**
 *
 * @author youss
 */
// create Table productfeedback (id INTEGER primary key AUTOINCREMENT, FOREIGN KEY (Productid) REFERENCES product(id),FOREIGN KEY (userid) REFERENCES user(id),feedback Text,rate number
public class Feedback {
    private int id;
    private int userid;
    private int productid;
    private int rate;
    private String feedback;

    public Feedback() {
    }

    public Feedback(int userid, int productid, int rate, String feedback) {
        this.userid = userid;
        this.productid = productid;
        this.rate = rate;
        this.feedback = feedback;
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

    public int getRate() {
        return rate;
    }

    public String getFeedback() {
        return feedback;
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

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", userid=" + userid + ", productid=" + productid + ", rate=" + rate + ", feedback=" + feedback + '}';
    }
    
    
}
