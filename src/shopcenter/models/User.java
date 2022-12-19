/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopcenter.models;

/**
 *
 * @author youss
 */


public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String ssn;
    private String phone;
    private String creditcard;
    private int balance;

    public User(String name, String email, String password, String ssn, String phone,String creditcard,int balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ssn = ssn;
        this.phone = phone;
        this.creditcard = creditcard;
        this.balance = balance;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public int getBalance() {
        return balance;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSsn() {
        return ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", ssn=" + ssn + ", phone=" + phone + ", creditcard=" + creditcard + ", balance=" + balance + '}';
    }
    
    
}
