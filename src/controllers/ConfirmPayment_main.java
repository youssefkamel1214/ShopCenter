/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.DbConnection;
import shopcenter.models.User;

/**
 *
 * @author youss
 */
public class ConfirmPayment_main implements ConfirmPayment{

    DbConnection conn = DbConnection.getInstance();;
    @Override
    public boolean Confirm(User user, int TotalPrice) {
        int newbalance = user.getBalance() - TotalPrice;
        user.setBalance(newbalance);
        
        //update userbalance
        conn.updateUserBalance(user.getId(), newbalance);    
        return true;
    }
    
}
