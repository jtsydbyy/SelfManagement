/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.PlatformTradeRole;

import Business.FundProduct.FundProduct;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yangyun
 */
public class CompareJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CompareJPanel
     */
    JPanel userProcessContainer;
    ArrayList<FundProduct> list;
    public CompareJPanel(JPanel userProcessContainer, ArrayList<FundProduct> list) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.list = list;
        
        if(list.size() == 2){
            populateTable1();
            populateTable2();
        }
        if(list.size() == 3){
            populateTable1();
            populateTable2();
            populateTable3();
        }
        if(list.size() == 4){
            populateTable1();
            populateTable2();
            populateTable3();
            populateTable4();
        }
    }
    
    private void populateTable1() {
        FundProduct fp = list.get(0);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        Object[] row1 = new Object[1];
        row1[0] = "Name: "+fp.getName();
        model.addRow(row1);
        
        Object[] row2 = new Object[1];
        row2[0] = "ID: "+fp.getId();
        model.addRow(row2);
        
        Object[] row3 = new Object[1];
        row3[0] = "Doc: "+fp.getDescription();
        model.addRow(row3);
        
        Object[] row4 = new Object[1];
        row4[0] = "Type: "+fp.getFundType();
        model.addRow(row4);
        
        Object[] row5 = new Object[1];
        row5[0] = "DoP: "+fp.getPurchaseDate();
        model.addRow(row5);
        
        Object[] row6 = new Object[1];
        row6[0] = "DoR: "+fp.getRedemptionDate();
        model.addRow(row6);
        
        Object[] row7 = new Object[1];
        row7[0] = "PoP: "+fp.getPurchasePrice();
        model.addRow(row7);
        
        Object[] row8 = new Object[1];
        row8[0] = "PoR: "+fp.getRedemptionPrice();
        model.addRow(row8);
        
        Object[] row9 = new Object[1];
        row9[0] = "Quantity: "+fp.getQuantity();
        model.addRow(row9);
 }
    
    private void populateTable2() {
        FundProduct fp = list.get(1);
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        Object[] row1 = new Object[1];
        row1[0] = "Name: "+fp.getName();
        model.addRow(row1);
        
        Object[] row2 = new Object[1];
        row2[0] = "ID: "+fp.getId();
        model.addRow(row2);
        
        Object[] row3 = new Object[1];
        row3[0] = "Doc: "+fp.getDescription();
        model.addRow(row3);
        
        Object[] row4 = new Object[1];
        row4[0] = "Type: "+fp.getFundType();
        model.addRow(row4);
        
        Object[] row5 = new Object[1];
        row5[0] = "DoP: "+fp.getPurchaseDate();
        model.addRow(row5);
        
        Object[] row6 = new Object[1];
        row6[0] = "DoR: "+fp.getRedemptionDate();
        model.addRow(row6);
        
        Object[] row7 = new Object[1];
        row7[0] = "PoP: "+fp.getPurchasePrice();
        model.addRow(row7);
        
        Object[] row8 = new Object[1];
        row8[0] = "PoR: "+fp.getRedemptionPrice();
        model.addRow(row8);
        
        Object[] row9 = new Object[1];
        row9[0] = "Quantity: "+fp.getQuantity();
        model.addRow(row9);
 }

    private void populateTable3() {
        FundProduct fp = list.get(2);
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        
        Object[] row1 = new Object[1];
        row1[0] = "Name: "+fp.getName();
        model.addRow(row1);
        
        Object[] row2 = new Object[1];
        row2[0] = "ID: "+fp.getId();
        model.addRow(row2);
        
        Object[] row3 = new Object[1];
        row3[0] = "Doc: "+fp.getDescription();
        model.addRow(row3);
        
        Object[] row4 = new Object[1];
        row4[0] = "Type: "+fp.getFundType();
        model.addRow(row4);
        
        Object[] row5 = new Object[1];
        row5[0] = "DoP: "+fp.getPurchaseDate();
        model.addRow(row5);
        
        Object[] row6 = new Object[1];
        row6[0] = "DoR: "+fp.getRedemptionDate();
        model.addRow(row6);
        
        Object[] row7 = new Object[1];
        row7[0] = "PoP: "+fp.getPurchasePrice();
        model.addRow(row7);
        
        Object[] row8 = new Object[1];
        row8[0] = "PoR: "+fp.getRedemptionPrice();
        model.addRow(row8);
        
        Object[] row9 = new Object[1];
        row9[0] = "Quantity: "+fp.getQuantity();
        model.addRow(row9);
 }
    
    private void populateTable4() {
        FundProduct fp = list.get(3);
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        
        Object[] row1 = new Object[1];
        row1[0] = "Name: "+fp.getName();
        model.addRow(row1);
        
        Object[] row2 = new Object[1];
        row2[0] = "ID: "+fp.getId();
        model.addRow(row2);
        
        Object[] row3 = new Object[1];
        row3[0] = "Doc: "+fp.getDescription();
        model.addRow(row3);
        
        Object[] row4 = new Object[1];
        row4[0] = "Type: "+fp.getFundType();
        model.addRow(row4);
        
        Object[] row5 = new Object[1];
        row5[0] = "DoP: "+fp.getPurchaseDate();
        model.addRow(row5);
        
        Object[] row6 = new Object[1];
        row6[0] = "DoR: "+fp.getRedemptionDate();
        model.addRow(row6);
        
        Object[] row7 = new Object[1];
        row7[0] = "PoP: "+fp.getPurchasePrice();
        model.addRow(row7);
        
        Object[] row8 = new Object[1];
        row8[0] = "PoR: "+fp.getRedemptionPrice();
        model.addRow(row8);
        
        Object[] row9 = new Object[1];
        row9[0] = "Quantity: "+fp.getQuantity();
        model.addRow(row9);
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Compare Fund Products");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fund Product A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fund Product B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fund Product D"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setResizable(false);
        }

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fund Product C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
