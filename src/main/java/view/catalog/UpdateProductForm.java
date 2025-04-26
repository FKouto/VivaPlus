package view.catalog;

import java.awt.Color;
import java.sql.*;

public class UpdateProductForm extends javax.swing.JFrame {

    public UpdateProductForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        // Configuração do fundo
        backgroundFrame.setBackgroundFrame("images/background-updateproduct.svg", 660, 450);

        // Configuração do botão Salvar
        btnSaveProduct.setContentAreaFilled(false);
        btnSaveProduct.setBorderPainted(false);
        btnSaveProduct.setOpaque(false);
        btnSaveProduct.setForeground(new Color(0, 0, 0, 0));
        btnSaveProduct.setFocusPainted(false);

        // Configuração do botão Cancelar
        btnCancel.setContentAreaFilled(false);
        btnCancel.setBorderPainted(false);
        btnCancel.setOpaque(false);
        btnCancel.setForeground(new Color(0, 0, 0, 0));
        btnCancel.setFocusPainted(false);

        // Configuração do campo ID do produto
        txtIdProduct.setOpaque(false);
        txtIdProduct.setBorder(null);
        txtIdProduct.setFocusable(true);

        // Configuração do campo Nome do produto
        txtNameProduct.setOpaque(false);
        txtNameProduct.setBorder(null);
        txtNameProduct.setFocusable(true);

        // Configuração do campo Quantidade do produto
        txtQuantityProduct.setOpaque(false);
        txtQuantityProduct.setBorder(null);
        txtQuantityProduct.setFocusable(true);

        // Configuração do campo Preço do produto
        txtPriceProduct.setOpaque(false);
        txtPriceProduct.setBorder(null);
        txtPriceProduct.setFocusable(true);

        cBoxPrescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPanel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnSaveProduct = new javax.swing.JButton();
        cBoxPrescription = new javax.swing.JComboBox<>();
        txtIdProduct = new javax.swing.JTextField();
        txtPriceProduct = new javax.swing.JTextField();
        txtQuantityProduct = new javax.swing.JTextField();
        txtNameProduct = new javax.swing.JTextField();
        backgroundFrame = new view.SvgFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancel.setText("Cancelar");
        btnCancel.setPreferredSize(new java.awt.Dimension(109, 40));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnPanel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 356, -1, -1));

        btnSaveProduct.setText("Salvar");
        btnSaveProduct.setPreferredSize(new java.awt.Dimension(91, 40));
        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSaveProductActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        pnPanel.add(btnSaveProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 356, -1, -1));

        cBoxPrescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxPrescription.setBorder(null);
        cBoxPrescription.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(cBoxPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 340, -1));

        txtIdProduct.setBorder(null);
        txtIdProduct.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtIdProduct.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtIdProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 81, 340, -1));

        txtPriceProduct.setBorder(null);
        txtPriceProduct.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtPriceProduct.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 309, 340, -1));

        txtQuantityProduct.setBorder(null);
        txtQuantityProduct.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtQuantityProduct.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtQuantityProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 233, 340, -1));

        txtNameProduct.setBorder(null);
        txtNameProduct.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtNameProduct.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtNameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 157, 340, -1));
        pnPanel.add(backgroundFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveProductActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_btnSaveProductActionPerformed
        try (Connection con = conectar();
             PreparedStatement pst = con.prepareStatement(
                 "UPDATE mydb.products SET product_name = ?, product_quantity = ?, product_price = ?, product_prescription = ? WHERE product_id = ?")) {

            String codigo = txtIdProduct.getText();
            String nome = txtNameProduct.getText();
            int quantidade = Integer.parseInt(txtQuantityProduct.getText());
            double preco = Double.parseDouble(txtPriceProduct.getText().replace(",", "."));
            String receita = cBoxPrescription.getSelectedItem().toString();

            // Configurando os parâmetros da consulta
            pst.setString(1, nome);
            pst.setInt(2, quantidade);
            pst.setDouble(3, preco);
            pst.setString(4, receita);
            pst.setString(5, codigo);

            System.out.println("Executando comando: " + pst.toString());
            pst.executeUpdate();

        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveProductActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProductForm().setVisible(true);
            }
        });
    }

    private Connection conectar() throws Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String serverName = "localhost:3306";
        String mydatabase = "mydb";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String usuario = "root";
        String senha = "root";
        Class.forName(driverName);
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.SvgFrame backgroundFrame;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveProduct;
    private javax.swing.JComboBox<String> cBoxPrescription;
    private javax.swing.JPanel pnPanel;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtPriceProduct;
    private javax.swing.JTextField txtQuantityProduct;
    // End of variables declaration//GEN-END:variables
}
