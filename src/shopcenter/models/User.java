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
    private int ssn;
    private String phone;
    private String userType;
    private String creditcard;
    private int balance;

    public User(String name, String email, String password, int ssn, String phone, String userType,String creditcard,int balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ssn = ssn;
        this.phone = phone;
        this.userType = userType;
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

    public int getSsn() {
        return ssn;
    }

    public String getPhone() {
        return phone;
    }

    public String getUserType() {
        return userType;
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

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", ssn=" + ssn + ", phone=" + phone + ", userType=" + userType + ", creditcard=" + creditcard + ", balance=" + balance + '}';
    }
    
    
}
