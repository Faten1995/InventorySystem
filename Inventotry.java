/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author faten
 */
public class Inventotry extends javax.swing.JPanel {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    String ImgPath=null;
    public Inventotry() {
        initComponents();
        Show_Products_In_JTable();
    }
    //Resize image
    public ImageIcon ResizeImage(String imagePath, byte[] pic){
        ImageIcon myImage = null;
        
        if(imagePath != null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(img_label.getWidth(), img_label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        
        return image;
    }
   
    //Check Input Fields
    
    public boolean checkInputs(){
        if( txt_name.getText() == null || txt_price.getText() == null || txt_cat.getText() == null){
            return false;
        }
        else{
            try{
                Double.parseDouble(txt_price.getText());
                Integer.parseInt(txt_q.getText());
                return true;
            }catch(Exception ex)
            {
                return false;
            }
        }
     
    }
    
    //Display Data in JTable:
    //      1- Fill ArrayList With The Data
    
    public ArrayList<Product> getProductList(){
        
        ArrayList<Product> productList = new ArrayList<Product>();
        conn = MysqlConnect.ConnectDB();
        String sql = "SELECT * FROM inventory";
        
        try {
            
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            Product product;
            
            while(rs.next())
            {
               product = new Product(rs.getInt("itemID"),rs.getString("itemName"),rs.getInt("quantity"),Double.parseDouble(rs.getString("price")),rs.getString("category"),rs.getBytes("image"));
               productList.add(product);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Inventotry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }
    
    
    //      2- Populate The JTable
    
    public void Show_Products_In_JTable(){
        
        ArrayList<Product> list = getProductList();
        DefaultTableModel model = (DefaultTableModel)JTable_Products.getModel();
        //clear JTable contents
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        for(int i = 0; i < list.size() ;i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getPrice();
            row[4] = list.get(i).getCategory();
            
            model.addRow(row);
            
        }
        
    }
    
    
    public void showItem(int index){
      
        txt_id.setText(Integer.toString(getProductList().get(index).getId()));
        txt_name.setText(getProductList().get(index).getName());
        txt_price.setText(Double.toString(getProductList().get(index).getPrice()));
        txt_cat.setText(getProductList().get(index).getCategory());
        txt_q.setText(Integer.toString(getProductList().get(index).getQuantity()));
        
        img_label.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_id1 = new javax.swing.JTextField();
        img_button3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_q = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_cat = new javax.swing.JTextField();
        img_label = new javax.swing.JLabel();
        insert_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        img_button = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        back_btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("itemID:");

        img_button3.setBackground(new java.awt.Color(0, 51, 51));
        img_button3.setForeground(new java.awt.Color(255, 255, 255));
        img_button3.setText("Insert");
        img_button3.setBorderPainted(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Alen's Store Inventory");

        JTable_Products.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "item ID", "Name", "quantity", "price", "category"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Price:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantity:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category:");

        img_label.setBackground(new java.awt.Color(153, 153, 153));
        img_label.setOpaque(true);

        insert_btn.setBackground(new java.awt.Color(0, 51, 51));
        insert_btn.setForeground(new java.awt.Color(255, 255, 255));
        insert_btn.setText("Insert");
        insert_btn.setBorderPainted(false);
        insert_btn.setOpaque(true);
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        update_btn.setBackground(new java.awt.Color(0, 51, 51));
        update_btn.setForeground(new java.awt.Color(255, 255, 255));
        update_btn.setText("Update");
        update_btn.setBorderPainted(false);
        update_btn.setOpaque(true);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setBackground(new java.awt.Color(0, 51, 51));
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setText("Delete");
        delete_btn.setBorderPainted(false);
        delete_btn.setOpaque(true);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("item Name:");

        img_button.setBackground(new java.awt.Color(0, 51, 51));
        img_button.setForeground(new java.awt.Color(255, 255, 255));
        img_button.setText("Choose image");
        img_button.setBorderPainted(false);
        img_button.setOpaque(true);
        img_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                img_buttonActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID:");

        back_btn.setBackground(new java.awt.Color(0, 51, 51));
        back_btn.setForeground(new java.awt.Color(255, 255, 255));
        back_btn.setText("Back");
        back_btn.setBorderPainted(false);
        back_btn.setOpaque(true);
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(insert_btn)
                                        .addGap(38, 38, 38)
                                        .addComponent(update_btn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_q, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51)))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(delete_btn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(img_button, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(img_label, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back_btn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txt_q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insert_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(img_button, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img_label, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void img_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_img_buttonActionPerformed
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            img_label.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }else{
          JOptionPane.showMessageDialog(null, "No File Selected","Error",JOptionPane.ERROR_MESSAGE);

        }
        
    
       
       
    }//GEN-LAST:event_img_buttonActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        
        if(checkInputs() && ImgPath != null){
            String sql = "insert into inventory(itemID,itemName,quantity,price,category,image) values(?,?,?,?,?,?)";
            
                conn = MysqlConnect.ConnectDB();
            try {
                pst=conn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(txt_id.getText()));
                pst.setString(2, txt_name.getText());
                pst.setInt(3, Integer.parseInt(txt_q.getText()));
                pst.setDouble(4, Double.parseDouble(txt_price.getText()));
                pst.setString(5, txt_cat.getText());
                
                InputStream img = new FileInputStream(new File(ImgPath));
                pst.setBlob(6, img);
                pst.executeUpdate();
                Show_Products_In_JTable();
                
                JOptionPane.showMessageDialog(null, "Data Added");
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }    
        }else{
          JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_insert_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        Finalproject fp = new Finalproject();
                fp.changePanel(2);
    }//GEN-LAST:event_back_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        
        if(checkInputs() && txt_id.getText() != null){
            String UpdateQuery = null;
            conn = MysqlConnect.ConnectDB();
            
            //update withput image
            if(ImgPath == null){
                
                try {
                    
                  UpdateQuery = "UPDATE inventory SET itemName = ? ,quantity = ?,price = ?,category = ? WHERE itemID = ? ";
                  pst = conn.prepareStatement(UpdateQuery);
                  pst.setString(1, txt_name.getText());
                  pst.setInt(2, Integer.parseInt(txt_q.getText()));
                  pst.setDouble(3, Double.parseDouble(txt_price.getText()));
                  pst.setString(4, txt_cat.getText());
                  pst.setInt(5, Integer.parseInt(txt_id.getText()));
                  
                  pst.executeUpdate();
                  Show_Products_In_JTable();
                 
                  JOptionPane.showMessageDialog(null, "Data Updated");

                  
                } catch (SQLException ex) {
                    Logger.getLogger(Inventotry.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //update with image
            else{
                try {
                    InputStream img = new FileInputStream(new File(ImgPath));
                    
                    
                    UpdateQuery = "UPDATE inventory SET itemName = ? ,quantity = ?,price = ?,category = ?"
                            +", image = ? WHERE itemID = ? ";
                    pst = conn.prepareStatement(UpdateQuery);
                    pst.setString(1, txt_name.getText());
                    pst.setInt(2, Integer.parseInt(txt_q.getText()));
                    pst.setDouble(3, Double.parseDouble(txt_price.getText()));
                    pst.setString(4, txt_cat.getText());
                    
                    pst.setBlob(5, img);
                    
                    pst.setInt(6, Integer.parseInt(txt_id.getText()));   
                    
                    pst.executeUpdate();
                    Show_Products_In_JTable();
                    JOptionPane.showMessageDialog(null, "Data Updated");

                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        }else {
            JOptionPane.showMessageDialog(null, "One or More Fields Are Empty or Worng","Error",JOptionPane.ERROR_MESSAGE);
        }
        
     
        
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        
        
        if(!txt_id.getText().equals("")){
         
            try {
                conn = MysqlConnect.ConnectDB();
                pst = conn.prepareStatement("DELETE FROM inventory WHERE itemID = ? ");
                int id = Integer.parseInt(txt_id.getText());
                pst.setInt(1, id);
                pst.executeUpdate();
                Show_Products_In_JTable();
                JOptionPane.showMessageDialog(null, "Product Deleted");
            } catch (SQLException ex) {
                Logger.getLogger(Inventotry.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product NOT Deleted","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Product NOT Deleted : Enter The Product ID","Error",JOptionPane.ERROR_MESSAGE);

        }
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        
        int index = JTable_Products.getSelectedRow();
        showItem(index);
        
        
    }//GEN-LAST:event_JTable_ProductsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_Products;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton img_button;
    private javax.swing.JButton img_button3;
    private javax.swing.JLabel img_label;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cat;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_id1;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_q;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
