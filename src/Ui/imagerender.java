/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ui;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author youssef
 */
public class imagerender extends DefaultTableCellRenderer {
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
