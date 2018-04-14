/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.FundInventoryRole;

import Business.Enterprise.FundCompany;
import Business.FundProduct.FundProduct;
import Business.FundProduct.FundProduct.FundType;
import Business.FundProduct.FundProductDirectory;
import static Interface.FundInventoryRole.FundTradeWorkArea.UPDATE_Fund;
import Util.Validation;
import static Util.Validation.IsDigit;
import static Util.Validation.IsLegalString;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tuantuan
 */
public class UpdateFundProductJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateFundProductJPanel
     */
    JPanel userProcessContainer;
    FundProduct fp;
    FundProductDirectory fundProductDirectory;
     FundCompany enterprise;
    public UpdateFundProductJPanel(JPanel userProcessContainer,FundCompany enterprise, FundProduct fp) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.fp = fp;
        this.fundProductDirectory =fundProductDirectory;
        this.enterprise = enterprise;
        populateFundDetails();
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);

        txtDescription.setEnabled(false);
        txtName.setEnabled(false);
        txtPurchaseDate.setEnabled(false);
        txtRedemptionDate.setEnabled(false);
        txtPurchasePrice.setEnabled(false);
        txtRedemptionPrice.setEnabled(false);
        comboType.setEnabled(false);
        txtQuantity.setEnabled(false);
        
    }

    private void populateFundDetails() {
        txtDescription.setText(fp.getDescription());
        txtName.setText(fp.getName());
        txtPurchaseDate.setText(fp.getPurchaseDate());
        txtRedemptionDate.setText(fp.getRedemptionDate());
        txtPurchasePrice.setText(Double.toString(fp.getPurchasePrice()));
        txtRedemptionPrice.setText(Double.toString(fp.getRedemptionPrice()));
        txtQuantity.setText(Integer.toString(fp.getQuantity()));
       // comboType.getSelectedItem();
         comboType.setModel(new javax.swing.DefaultComboBoxModel<>(FundType.values()));
        comboType.setSelectedItem(fp.getFundType());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPurchaseDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRedemptionDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPurchasePrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRedemptionPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Description:");

        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        jLabel4.setText("Purchase Date:");

        txtPurchaseDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPurchaseDateActionPerformed(evt);
            }
        });

        jLabel5.setText("Redemption Date:");

        txtRedemptionDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedemptionDateActionPerformed(evt);
            }
        });

        jLabel6.setText("Type:");

        comboType.setBackground(new java.awt.Color(255, 255, 255));
        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Stock Fund", "Bond Fund", "Money Market Fund", "Commingled Fund", " " }));

        jLabel1.setText("Update Fund Product");

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Purchase Price:");

        txtPurchasePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPurchasePriceActionPerformed(evt);
            }
        });

        jLabel8.setText("Redemption Price:");

        txtRedemptionPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRedemptionPriceActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantity:");

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancel)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtQuantity)
                        .addComponent(comboType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                        .addComponent(txtPurchaseDate)
                        .addComponent(txtRedemptionDate)
                        .addComponent(txtPurchasePrice)
                        .addComponent(txtRedemptionPrice)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPurchaseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRedemptionDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRedemptionPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void txtPurchaseDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPurchaseDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPurchaseDateActionPerformed

    private void txtRedemptionDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedemptionDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRedemptionDateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        txtDescription.setEnabled(true);
        txtName.setEnabled(true);
        txtPurchaseDate.setEnabled(true);
        txtRedemptionDate.setEnabled(true);
        txtRedemptionPrice.setEnabled(true);
        txtPurchasePrice.setEnabled(true);
        txtQuantity.setEnabled(true);
        comboType.setEnabled(true);
      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (IsLegalString(txtDescription.getText())
                && IsLegalString(txtName.getText())
                && IsLegalString(txtPurchaseDate.getText())
                && IsLegalString(txtRedemptionDate.getText())
                && IsLegalString(txtRedemptionPrice.getText())
                && IsLegalString(txtPurchasePrice.getText())
                && IsLegalString(txtQuantity.getText()) && IsDigit(txtPurchasePrice.getText())
                && IsDigit(txtRedemptionPrice.getText()) && IsDigit(txtQuantity.getText())) {
            btnUpdate.setEnabled(true);
            btnSave.setEnabled(false);
            txtDescription.setEnabled(false);
            txtName.setEnabled(false);
            txtPurchaseDate.setEnabled(false);
            txtRedemptionDate.setEnabled(false);
            txtPurchasePrice.setEnabled(false);
            txtRedemptionPrice.setEnabled(false);
            comboType.setEnabled(false);
            txtQuantity.setEnabled(false);
        
            fp.setDescription(txtDescription.getText());
            fp.setName(txtName.getText());
            fp.setPurchaseDate(txtPurchaseDate.getText());
            fp.setRedemptionDate(txtRedemptionDate.getText());
            fp.setPurchasePrice(Double.valueOf(txtPurchasePrice.getText()));
            fp.setRedemptionPrice(Double.valueOf(txtRedemptionPrice.getText()));
            fp.setFundType((FundProduct.FundType)comboType.getSelectedItem());
            fp.setQuantity(Integer.valueOf(txtQuantity.getText()));

            userProcessContainer.firePropertyChange(UPDATE_Fund, false, true);
        } else {
  JOptionPane.showMessageDialog(null, "Invalid Input!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtPurchasePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPurchasePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPurchasePriceActionPerformed

    private void txtRedemptionPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRedemptionPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRedemptionPriceActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPurchaseDate;
    private javax.swing.JTextField txtPurchasePrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtRedemptionDate;
    private javax.swing.JTextField txtRedemptionPrice;
    // End of variables declaration//GEN-END:variables
}
