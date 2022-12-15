/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashMap;
import java.util.Map;
import shopcenter.models.Product;

/**
 *
 * @author youssef
 */
public class ProductRegistry {
    Map<String,Product> registry;

    public ProductRegistry() {
        registry=new HashMap<>();
    }
    public Product getproduct(String category) throws CloneNotSupportedException{
       if(!registry.containsKey(category)){
             Product p=new Product();
             p.setCategory(category);
             registry.put(category, p);
       }
       return  (Product)registry.get(category).clone();
    }
    
}
