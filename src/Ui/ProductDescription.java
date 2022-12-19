/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ui;

import controllers.UiFactoryController;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controllers.DbConnection;
import shopcenter.models.Category;
import shopcenter.models.Product;
import shopcenter.models.Shopcard;

/**
 *
 * @author youssef
 */
public class ProductDescription extends javax.swing.JFrame implements Ui{


    String type;
    DbConnection db;  
    List<Product> products; 
    int Userid;
    public ProductDescription(String type, int Userid) {
       this.type = type;
       this.Userid = Userid;
       db = DbConnection.getInstance();
       products = db.getProductsbyCategory(type); 
    }
   
    private void showShoppingcart() {
        List<Shopcard> L = db.getAllShopcards();
        if(L == null)
        {
          return;   
        }
        else
        {
             for(Shopcard S : L)
             {
                 Product P = db.getproductbyid( S.getProductid());
                 String T = P.getTitle();
                 jComboBox1.addItem(T);
             }
            
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 890, 470));

        jButton1.setText("Add to Shopping cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, 190, -1));

        jButton2.setText("Add Feedback");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 220, -1));

        jButton3.setText("Back to home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 210, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 200, 30));

        jLabel1.setText("My Shopping Cart");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 200, 30));

        jLabel2.setText("Enter the amount u want");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, 20));

        jButton4.setText("Empty Shopping cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 190, -1));

        jButton5.setText("Cancel Item");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 400, 190, -1));

        jButton6.setText("Confirm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, 190, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
int idx = 0;
ArrayList<Integer> V = new ArrayList<Integer>();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int idx = jTable1.getSelectedRow();
        String temp = jTextField1.getText();
        if(idx != -1 && !temp.isEmpty())
        {
            jComboBox1.addItem(products.get(idx).getTitle());
            int temp1 = Integer.parseInt(temp);
            if(temp1 > products.get(idx).getQauntity())
            {
                int amount = products.get(idx).getQauntity();
                JOptionPane.showMessageDialog(this, "There is only available: " + amount + " Items");
                return;
            }
            else
            {
               V.add(temp1);    
               Shopcard shopcard = new Shopcard(Userid,products.get(idx).getId(),temp1);
               db.insertShopcard(shopcard);
               JOptionPane.showMessageDialog(this, "Item added to Shopping cart");
            }
              
        }
        
        else {
            JOptionPane.showMessageDialog(this, "Please Select the item and enter a count");
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UiFactoryController F = new UiFactoryController();
        int idx = jTable1.getSelectedRow();
        if(idx == -1)
        {
           JOptionPane.showMessageDialog(this, "Please Select a product");  
        }
        else
        {
        int productId = products.get(idx).getId();
        F.getuiParametrized("Feedback",Userid,productId).showui();
        this.dispose(); 
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UiFactoryController F = new UiFactoryController();
        F.getuiParametrized("Home",Userid).showui();
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int idx = jComboBox1.getSelectedIndex();
        String S = jComboBox1.getItemAt(idx);
        Product P = db.getproductbyTitle(S);
        db.deleteShopcard(P.getId());
        jComboBox1.removeItemAt(idx);
        V.remove(idx);            
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          db.deleteallShopcard();
          jComboBox1.removeAllItems();
          V.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       int count = db.getShopcardbyid();
        System.out.println();
       if(count == -1 || count == 0)
       {
         JOptionPane.showMessageDialog(this, "Please Enter items in Shoppint cart");
         return;
       }
       else
       {
        UiFactoryController F = new UiFactoryController();
        F.getuiParametrized("Payment", Userid).showui();
        this.dispose();
       }
    }//GEN-LAST:event_jButton6ActionPerformed

   
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
        for(Product P : products)
        {
            
            D.addRow(new Object[]{
                P.getTitle(),   
                P.getImage(),
                P.getPrice()
            } );
        }
       jTable1.setModel(D);
       jTable1.setRowHeight(100);
       jTable1.getTableHeader().setReorderingAllowed(false); 
        imagerender R = new imagerender();     
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
    
     @Override
     public void showui() {
        initComponents();
        setVisible(true);
        showCategories();
        showShoppingcart();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
