/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import shopcenter.models.User;

/**
 *
 * @author youss
 */
public interface ConfirmPayment {
    abstract boolean Confirm(User user, int TotalPrice);
}
