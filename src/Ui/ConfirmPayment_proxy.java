/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ui;

import shopcenter.models.User;

/**
 *
 * @author youss
 */
public class ConfirmPayment_proxy implements ConfirmPayment{

    ConfirmPayment_main confirmPaymentMain = new ConfirmPayment_main();
    @Override
    public boolean Confirm(User user, int TotalPrice) {
        
        if(user.getCreditcard() == "" || user.getCreditcard() == null)
            return false;
        
        if(user.getBalance() < TotalPrice)
             return false;
        
        return confirmPaymentMain.Confirm(user, TotalPrice);
    }
    
}
