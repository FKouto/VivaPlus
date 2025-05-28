package org.vivaplus.view;

import org.vivaplus.model.bean.User;
import org.vivaplus.model.enums.Roles;
import org.vivaplus.view.catalog.CatalogProductsScreen;
import org.vivaplus.view.dashboard.admin.AdminDashScreen;
import org.vivaplus.view.dashboard.manager.ManagerDashScreen;

import javax.swing.*;
import java.awt.*;

/**
 * @author couto
 */
public class ChoiceView extends javax.swing.JFrame {

    private User user;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnCatalog;
    private javax.swing.JButton btnPrivAccess;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables

    public ChoiceView() {
        initComponents();
        settingComponents();
    }

    public ChoiceView(User user) {
        this.user = user;
        initComponents();
        showPersonalizedBackground(user);
        settingComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                User user = new User();
                new ChoiceView().setVisible(true);
            }
        });
    }

    public void settingComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Visualizar");

        btnCatalog.setContentAreaFilled(false);
        btnCatalog.setBorderPainted(false);
        btnCatalog.setOpaque(false);
        btnCatalog.setForeground(new Color(0, 0, 0, 0));
        btnCatalog.setFocusPainted(false);

        btnPrivAccess.setContentAreaFilled(false);
        btnPrivAccess.setBorderPainted(false);
        btnPrivAccess.setOpaque(false);
        btnPrivAccess.setForeground(new Color(0, 0, 0, 0));
        btnPrivAccess.setFocusPainted(false);

        btnSair.setContentAreaFilled(false);
        btnSair.setBorderPainted(false);
        btnSair.setOpaque(false);
        btnSair.setForeground(new Color(0, 0, 0, 0));
        btnSair.setFocusPainted(false);
    }

    private void showPersonalizedBackground(User user) {
        if (user != null) {
            // Comparação utilizando o enum diretamente
            if (user.getRole() == Roles.ADMIN) {
                background.setBackgroundPanel("images/background-choice-admin.svg", 600, 227);
            } else if (user.getRole() == Roles.MANAGER) {
                background.setBackgroundPanel("images/background-choice-manager.svg", 600, 227);
            } else {
                // Placeholder para outras roles ou background padrão
                JOptionPane.showMessageDialog(this, "Role sem background personalizado.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void openDashRole(User user) {
        System.out.println("Chamo 1");
        if (user != null) {
            // Comparação utilizando o enum diretamente
            if (user.getRole() == Roles.ADMIN) {
                System.out.println("Chamo ADMIN");
                AdminDashScreen adminDash = new AdminDashScreen();
                adminDash.setVisible(true);
                this.dispose();
            }
            if (user.getRole() == Roles.MANAGER) {
                System.out.println("Chamo MANAGER");
                ManagerDashScreen managerDash = new ManagerDashScreen();
                managerDash.setVisible(true);
                this.dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        btnCatalog = new javax.swing.JButton();
        btnPrivAccess = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCatalog.setText("jButton1");
        btnCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogActionPerformed(evt);
            }
        });
        jPanel.add(btnCatalog, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 56, 284, 163));

        btnPrivAccess.setText("jButton2");
        btnPrivAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrivAccessActionPerformed(evt);
            }
        });
        jPanel.add(btnPrivAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 56, 284, 163));

        btnSair.setText("Sair");
        jPanel.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 16, 75, 33));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 227));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogActionPerformed
        CatalogProductsScreen catalog = new CatalogProductsScreen();
        catalog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCatalogActionPerformed

    private void btnPrivAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrivAccessActionPerformed
        openDashRole(user);
        System.out.println("Entrou no botão de acesso privado");
    }//GEN-LAST:event_btnPrivAccessActionPerformed
}
