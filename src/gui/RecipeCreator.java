
package gui;

import models.ProductModel;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

import recipemanager.*;

/**
 *
 * @author Dmitrijs Juškovs
 */
public class RecipeCreator extends javax.swing.JFrame {

    DefaultTableModel productsModel;
    DefaultListModel<String> lstModel;
    DefaultComboBoxModel<String> typeModel;
    
    ArrayList<ProductModel> recipePoducts;
    
    public RecipeCreator() {
        initComponents();
       // RecipeProvider.DatebaseConnect();
        lstModel = new DefaultListModel<>();
        lstProducts.setModel(lstModel);
        
        typeModel = new DefaultComboBoxModel<>();
        cmbRecipeType.setModel(typeModel);
        
        String[] columns = {"Product", "Information"};
        productsModel = new DefaultTableModel(columns, 0);        
        tblProducts.setModel(productsModel);
        
        recipePoducts = new ArrayList<>();
        
        
        
        updateRecipeTypeList();
        updateProductList();
        updateRecipeProductsTable();
    }

    
    
    
    
    
    private ArrayList<ProductModel> getProductList(String filter)
    {
        if(filter.isEmpty())
        {
            return RecipeProvider.GetProductList();
        }
        else
        {
            ArrayList<ProductModel> products = RecipeProvider.GetProductList();
            ArrayList<ProductModel> retValue = new ArrayList<>();
            
            for(ProductModel p : products)
                if(p.getName().toLowerCase().contains(filter.toLowerCase()))
                        retValue.add(p);
            
            return retValue;
        }
    }
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRecipename = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        cmbRecipeType = new javax.swing.JComboBox<>();
        txtRecipe = new java.awt.TextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        txtProdInfo = new javax.swing.JTextField();
        btnAddproduct = new javax.swing.JButton();
        btnAddRecipe = new javax.swing.JButton();
        txtRecypeType = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Name");

        jLabel2.setText("Type");

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblProducts);

        cmbRecipeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRecipeTypeActionPerformed(evt);
            }
        });

        jLabel3.setText("Recipe");

        jLabel4.setText("Products");

        jLabel5.setText("Product");

        txtProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdNameActionPerformed(evt);
            }
        });
        txtProdName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProdNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProdNameKeyReleased(evt);
            }
        });

        lstProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProductsMouseClicked(evt);
            }
        });
        lstProducts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProductsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstProducts);

        jLabel6.setText("Information");

        btnAddproduct.setText("Add");
        btnAddproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddproductActionPerformed(evt);
            }
        });

        btnAddRecipe.setText("Add recipe");
        btnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecipeActionPerformed(evt);
            }
        });

        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtRecipename, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRecypeType, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRecipeType, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1))
                                    .addComponent(txtProdName)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProdInfo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(btnAddRecipe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRecipename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbRecipeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRecypeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(btnAddproduct)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnAddRecipe)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstProductsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProductsValueChanged
        // TODO add your handling code here:      
    }//GEN-LAST:event_lstProductsValueChanged

    private void txtProdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdNameActionPerformed
     
    }//GEN-LAST:event_txtProdNameActionPerformed

    private void txtProdNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdNameKeyPressed
    
    }//GEN-LAST:event_txtProdNameKeyPressed

    private void txtProdNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdNameKeyReleased
        updateProductList();
    }//GEN-LAST:event_txtProdNameKeyReleased

    private void btnAddproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddproductActionPerformed
        if(txtProdName.getText().isEmpty())
            return;
        String productName = txtProdName.getText();
        String productInfo = txtProdInfo.getText();
        
        ProductModel product = RecipeProvider.GetProductByName(productName);
        if(product == null)
        {
            RecipeProvider.AddProduct(productName, "");
            product = RecipeProvider.GetProductByName(productName);
        }
        
        product.setComment(productInfo);
        recipePoducts.add(product);        
        
        
        txtProdName.setText("");
        txtProdInfo.setText("");
        updateProductList();
        updateRecipeProductsTable();
    }//GEN-LAST:event_btnAddproductActionPerformed

    private void lstProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProductsMouseClicked
          txtProdName.setText(lstProducts.getSelectedValue());
    }//GEN-LAST:event_lstProductsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = tblProducts.getSelectedRow();        
        if(productsModel.getRowCount() > 0)
        {
            productsModel.removeRow(index);            
           recipePoducts.remove(index);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecipeActionPerformed
        
        if(txtRecipename.getText().isEmpty())return;
        
        RecipeProvider.AddRecipe(txtRecipename.getText(),
                txtRecypeType.getText(), 
                recipePoducts, 
                txtRecipe.getText());
        
        resetForm();
    }//GEN-LAST:event_btnAddRecipeActionPerformed

    private void cmbRecipeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRecipeTypeActionPerformed
        Object s = cmbRecipeType.getSelectedItem();
        if(s!=null)
            txtRecypeType.setText(s.toString());
    }//GEN-LAST:event_cmbRecipeTypeActionPerformed

    
    private void resetForm()
    {
        txtProdInfo.setText("");
        txtProdName.setText("");
        txtRecipe.setText("");
        txtRecipename.setText("");
        txtRecypeType.setText("");
        
        recipePoducts.clear();
        
        updateProductList();
        updateRecipeProductsTable();
        updateRecipeTypeList();
    }
    
    private void updateRecipeTypeList()
    {
        typeModel.removeAllElements();
        ArrayList<String> groups = RecipeProvider.GetGroupList();
        for(String g: groups)
        {
            typeModel.addElement(g);
        }
    }
    
    private void updateRecipeProductsTable() {
        productsModel.setRowCount(0);
        for(ProductModel p : recipePoducts)
        {
            Object[] o = {p.getName(),p.getComment()};
            productsModel.addRow(o);
        }
    }
    
    private void updateProductList()
    {
        lstModel.clear();
        for(ProductModel p : getProductList(txtProdName.getText()))
        {
            lstModel.addElement(p.getName());
        }
    }
  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecipeCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecipeCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecipeCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipeCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipeCreator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecipe;
    private javax.swing.JButton btnAddproduct;
    private javax.swing.JComboBox<String> cmbRecipeType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstProducts;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtProdInfo;
    private javax.swing.JTextField txtProdName;
    private java.awt.TextArea txtRecipe;
    private javax.swing.JTextField txtRecipename;
    private javax.swing.JTextField txtRecypeType;
    // End of variables declaration//GEN-END:variables

    
}
