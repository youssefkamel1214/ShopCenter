/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import controllers.ConfirmPayment_proxy;
import controllers.DbConnection;
import controllers.UiFactoryController;
import java.awt.Component;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import shopcenter.models.Product;
import shopcenter.models.Shopcard;
import shopcenter.models.User;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import shopcenter.models.Sale;

/**
 *
 * @author youssef
 */
public class Payment extends javax.swing.JFrame implements Ui{

    /**
     * Creates new form Payment
     */
    DbConnection conn ;
    int userId;
    float OrderPrice = 0;
    List<Shopcard> shopcards ;
    List<Product> products;
    User currentUser ;

    
    public Payment(int userId) {
        this.userId = userId;
        GetInfo();
    }
    
    
    private void GetInfo(){
        conn = DbConnection.getInstance();
        shopcards = conn.getShopcardsbyUserid(userId);
        currentUser = conn.getUserbyid(userId);
        products = new ArrayList<Product>();
        
        for(int i = 0 ; i < shopcards.size();i++){
            int productid = shopcards.get(i).getId();
            products.add(conn.getproductbyid(productid));
        }
    }
    
    private void showCategories()
    {
      
        DefaultTableModel D;
        D = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
                        }  
        };
        D.addColumn("Title");
        D.addColumn("Image");
        D.addColumn("Price");
        D.addColumn("Count");
        D.addColumn("Total Price");
        
        for(int i = 0 ; i < products.size();i++){
            int totalPrice = (int)(products.get(i).getPrice()) * shopcards.get(i).getCount();
            OrderPrice += totalPrice;
            
             D.addRow(new Object[]{
                products.get(i).getTitle(),   
                products.get(i).getImage(),
                products.get(i).getPrice(),
                shopcards.get(i).getCount(),
                totalPrice
                
            } );
        }
       totalprice.setText((String.valueOf(OrderPrice)));
       
       jTable1.setModel(D);
       jTable1.setRowHeight(100);
       jTable1.getTableHeader().setReorderingAllowed(false); 
       Payment.imagerender R = new Payment.imagerender();     
       jTable1.getColumnModel().getColumn(1).setCellRenderer(R);
    }
    
    private class imagerender extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            byte[] image = (byte[]) value;
            ImageIcon img = new ImageIcon(new ImageIcon(image).getImage().
              getScaledInstance(200, 100, Image.SCALE_SMOOTH ));
            JLabel L = new JLabel();
            L.setIcon(img);
            return L;
        }
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        totalprice = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Buy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total Price");

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("-");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        totalprice.setText("jLabel2");

        jButton4.setText("Back_to_home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(totalprice))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jButton4)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(totalprice)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Buy Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //Check Proxy
        ConfirmPayment_proxy confirmPayment = new ConfirmPayment_proxy();
        boolean confirm = confirmPayment.Confirm(currentUser, (int)OrderPrice);
        
        if(confirm){
            //confirmed
            
            //Delete table
            DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
            int count = dm.getRowCount();
            System.out.println(count);
            for(int i = 0; i < count; i++){
                dm.removeRow(0);
            }
            //Add to sale 
            DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
            String CurrentDate = dateFormat.format(Calendar.getInstance().getTime());
            Sale sale = new Sale();
            
            sale.setDate(CurrentDate);
            for(int i = 0; i < shopcards.size(); i++){
                sale.setProductid(shopcards.get(i).getProductid());
                sale.setUserid(shopcards.get(i).getUserid());
                sale.setCount(shopcards.get(i).getCount());   
                conn.insertSale(sale);
            }
            conn.deleteallShopcard();
            JOptionPane.showMessageDialog(this,"confirmed");
        }else{
            //go to update info
            JOptionPane.showMessageDialog(this,"please check your credit card in user info");
            UiFactoryController f=new UiFactoryController();
            f.getuiParametrized("Userinfo",userId).showui();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // ++ Button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: ++
        int idx = jTable1.getSelectedRow();
        int shopcardID = shopcards.get(idx).getId();
        //count in table
        int count = (int)jTable1.getModel().getValueAt(idx, 3);
        int maxQuantity = products.get(idx).getQauntity();
        
        if(idx == -1)
            return;
        
        if(count == maxQuantity)
            return;
        
        //change in table ++
        jTable1.getModel().setValueAt(count+1, idx, 3);
        //change in DB ++
        conn.updateShopcardCount(shopcardID, count + 1);
        // item price
        float Price = (float)jTable1.getModel().getValueAt(idx, 2);
        // current totalprice
        int totalPrice = (int)jTable1.getModel().getValueAt(idx, 4);
        // new totalprice in table
        jTable1.getModel().setValueAt(totalPrice + (int)Price, idx, 4);
        // new totalprice
        totalprice.setText(String.valueOf(totalPrice + (int)Price));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int idx = jTable1.getSelectedRow();
        int shopcardID = shopcards.get(idx).getId();
        //count in table
        int count = (int)jTable1.getModel().getValueAt(idx, 3);
        
        if(idx == -1)
            return;

        if(count == 0)
            return;
        
        //change in table --
        jTable1.getModel().setValueAt(count-1, idx, 3);
        //change in DB --
        conn.updateShopcardCount(shopcardID, count - 1);
        // item price
        float Price = (float)jTable1.getModel().getValueAt(idx, 2);
        // current totalprice
        int totalPrice = (int)jTable1.getModel().getValueAt(idx, 4);
        // new totalprice in table
        jTable1.getModel().setValueAt(totalPrice - (int)Price, idx, 4);
        // new totalprice
        totalprice.setText(String.valueOf(totalPrice + (int)Price));
        // add to totalprice
    }//GEN-LAST:event_jButton3ActionPerformed
    //Back to home button
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         UiFactoryController F = new UiFactoryController();
         F.getuiParametrized("Home", userId).showui();
         dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
    // Delete Button
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // idx in table
        int idx = jTable1.getSelectedRow();
        int itemid = shopcards.get(idx).getId();
        // delete in DB
        conn.deleteShopcardById(itemid);
        //Delete in list
        shopcards.remove(idx);

        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        //Delete in table
        dm.removeRow(idx);
    }//GEN-LAST:event_jButton5ActionPerformed

    @Override
    public void showui() {
        initComponents();
        setVisible(true);
        showCategories();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel totalprice;
    // End of variables declaration//GEN-END:variables
}
//youssef@gmail.com