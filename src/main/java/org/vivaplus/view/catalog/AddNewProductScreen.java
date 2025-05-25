package org.vivaplus.view.catalog;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.dao.DrugDAO;
import org.vivaplus.model.enums.Prescription;

import javax.swing.*;
import java.awt.*;

/**
 * @author couto
 */
public class AddNewProductScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboPresc;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField txtBatch;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuant;
    // End of variables declaration//GEN-END:variables

    public AddNewProductScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewProductScreen().setVisible(true);
            }
        });
    }

    private void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Novo Produto");
        background.setBackgroundPanel("images/new-product.svg", 660, 450);

        txtName.setOpaque(false);
        txtName.setBorder(null);

        txtQuant.setOpaque(false);
        txtQuant.setBorder(null);

        txtBatch.setOpaque(false);
        txtBatch.setBorder(null);

        txtPrice.setOpaque(false);
        txtPrice.setBorder(null);

        txtDate.setOpaque(false);
        txtDate.setBorder(null);

        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setOpaque(false);
        btnCancelar.setForeground(new Color(0, 0, 0, 0));
        btnCancelar.setFocusPainted(false);

        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setBorderPainted(false);
        btnSalvar.setOpaque(false);
        btnSalvar.setForeground(new Color(0, 0, 0, 0));
        btnSalvar.setFocusPainted(false);

        comboPresc.setOpaque(false);
        comboPresc.setBorder(null);
        comboPresc.setFocusable(false);
        comboPresc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"YES", "NO"}));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        txtBatch = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        comboPresc = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setPreferredSize(new java.awt.Dimension(660, 450));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 85, 360, 35));
        jPanel.add(txtQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 157, 360, 35));
        jPanel.add(txtBatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 229, 170, 35));
        jPanel.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 229, 170, 35));
        jPanel.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 301, 170, 35));

        comboPresc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel.add(comboPresc, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 301, 177, 35));

        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 352, 91, 40));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 352, 109, 40));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = txtName.getText();
        String quantidadeStr = txtQuant.getText();
        String lote = txtBatch.getText();
        String validade = txtDate.getText();
        String precoStr = txtPrice.getText();
        String prescricao = (String) comboPresc.getSelectedItem();

        if (nome.isEmpty() || quantidadeStr.isEmpty() || lote.isEmpty() || validade.isEmpty() || precoStr.isEmpty() || prescricao == null) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantidade = Integer.parseInt(quantidadeStr);
            double preco = Double.parseDouble(precoStr);
            java.util.Date dataValidade = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(validade);

            if (quantidade <= 0 || preco <= 0) {
                throw new NumberFormatException("Valores negativos ou zero não são permitidos.");
            }

            Drug novoProduto = new Drug();
            novoProduto.setProduct(nome);
            novoProduto.setQuantity(quantidade);
            novoProduto.setPrice(preco);
            novoProduto.setBatch(lote);
            novoProduto.setExpiration_date(dataValidade);
            novoProduto.setPrescription(Prescription.valueOf(prescricao.toUpperCase()));

            DrugDAO drugDAO = new DrugDAO();
            boolean sucesso = drugDAO.create(novoProduto);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao adicionar o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade ou preço inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(this, "Data de validade inválida. Use o formato yyyy-MM-dd.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Prescrição inválida. Use valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
