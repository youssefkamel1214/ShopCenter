/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import controllers.UiFactoryController;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import shopcenter.DbConnection;
import shopcenter.models.Category;
import shopcenter.models.Product;

/**
 *
 * @author youssef
 */
public class Home extends javax.swing.JFrame implements Ui{

    /**
     * Creates new form Home
     */
    int userid;
    public Home(int Uid) {
        userid = Uid;
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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int indx = jTable1.getSelectedRow();
        if(indx == -1)
        {
           //tl3 message
        }
        else if (indx == 0)
        {
            UiFactoryController F = new UiFactoryController();
            F.getuiParametrized("ProductDescription","Jackets",userid).showui();
            this.dispose();
        }
        else if (indx == 1)
        {
            UiFactoryController F = new UiFactoryController();
            F.getuiParametrized("ProductDescription","Pants",userid).showui();
            this.dispose();
        }
        else if (indx == 2)
        {
            UiFactoryController F = new UiFactoryController();
            F.getuiParametrized("ProductDescription","TShirts",userid).showui();
            this.dispose();

        }
        else if (indx == 3)
        {
            UiFactoryController F = new UiFactoryController();
            F.getuiParametrized("ProductDescription","Shoes",userid).showui();
            this.dispose();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    @Override
    public void showui() {
        initComponents();
        setVisible(true);
        showCategories();
    }
    
    private void showCategories()
    {
        DbConnection db = DbConnection.getInstance();
        List<Category> category = db.getAllCategory();
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
        for(Category C : category)
        {
            
            D.addRow(new Object[]{
                C.getTitle(),
                C.getImage()
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

    
    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
