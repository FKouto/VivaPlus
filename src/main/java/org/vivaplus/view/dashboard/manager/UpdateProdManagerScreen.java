package org.vivaplus.view.dashboard.manager;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.dao.DrugDAO;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @author couto
 */
public class UpdateProdManagerScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> comboPrescription;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField txtBatch;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    // End of variables declaration//GEN-END:variables

    public UpdateProdManagerScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProdManagerScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Manager | Update Product");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        background.setBackgroundPanel("images/background-update-product-manager.svg", 500, 400);

        btnAlterar.setContentAreaFilled(false);
        btnAlterar.setBorderPainted(false);
        btnAlterar.setOpaque(false);
        btnAlterar.setForeground(new Color(0, 0, 0, 0));
        btnAlterar.setFocusPainted(false);

        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setOpaque(false);
        btnBuscar.setForeground(new Color(0, 0, 0, 0));
        btnBuscar.setFocusPainted(false);

        txtProductId.setOpaque(false);
        txtProductId.setBorder(null);

        txtProductName.setOpaque(false);
        txtProductName.setBorder(null);

        txtProductQuantity.setOpaque(false);
        txtProductQuantity.setBorder(null);

        txtProductPrice.setOpaque(false);
        txtProductPrice.setBorder(null);

        txtBatch.setOpaque(false);
        txtBatch.setBorder(null);

        txtExpirationDate.setOpaque(false);
        txtExpirationDate.setBorder(null);

        comboPrescription.setOpaque(false);
        comboPrescription.setBorder(null);
        comboPrescription.setBackground(new Color(0, 0, 0, 0));
        comboPrescription.setForeground(new Color(0, 0, 0, 0));
        comboPrescription.setFocusable(false);
        comboPrescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"YES", "NO"}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        txtProductId = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtProductQuantity = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        txtBatch = new javax.swing.JTextField();
        txtExpirationDate = new javax.swing.JTextField();
        comboPrescription = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel.add(txtProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 83, 232, 35));
        jPanel.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 83, 232, 35));
        jPanel.add(txtProductQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 150, 232, 35));
        jPanel.add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 232, 35));
        jPanel.add(txtBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 217, 232, 35));
        jPanel.add(txtExpirationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 217, 232, 35));

        comboPrescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel.add(comboPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 284, 484, 35));

        btnBuscar.setText("Buscar Produto");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 341, 234, 40));

        btnAlterar.setText("Atualizar Produto");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 341, 234, 40));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        fetchProduct();
    }

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        updateProduct();
    }

    private void fetchProduct() {
        String productId = txtProductId.getText();
        if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O ID do produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DrugDAO drugDAO = new DrugDAO();
        Drug drug = drugDAO.read(productId);

        if (drug != null) {
            txtProductName.setText(drug.getProduct());
            txtProductQuantity.setText(String.valueOf(drug.getQuantity()));
            txtProductPrice.setText(String.valueOf(drug.getPrice()));
            txtBatch.setText(drug.getBatch());
            txtExpirationDate.setText(drug.getExpiration_date().toString());
            comboPrescription.setSelectedItem(drug.getPrescription().name());
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateProduct() {
        try {
            String productId = txtProductId.getText();
            if (productId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O ID do produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String productName = txtProductName.getText();
            int productQuantity = Integer.parseInt(txtProductQuantity.getText());
            double productPrice = Double.parseDouble(txtProductPrice.getText());
            String batch = txtBatch.getText();
            Date expirationDate = java.sql.Date.valueOf(txtExpirationDate.getText());
            String prescription = (String) comboPrescription.getSelectedItem();

            Drug drug = new Drug(productId, productName, productQuantity, productPrice,
                    org.vivaplus.model.enums.Prescription.valueOf(prescription),
                    batch, expirationDate, 0, null);

            DrugDAO drugDAO = new DrugDAO();
            boolean success = drugDAO.update(drug);

            if (success) {
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dados inválidos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
