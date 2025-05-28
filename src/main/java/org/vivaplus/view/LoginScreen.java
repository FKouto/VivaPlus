package org.vivaplus.view;

import org.vivaplus.model.dao.LoginDAO;
import org.vivaplus.view.catalog.CatalogProductsScreen;

import java.awt.*;

/**
 * @author couto
 */
public class LoginScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField txtCip;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    public LoginScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Login");
        background.setBackgroundPanel("images/background-login.svg", 660, 450);

        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(false);
        btnLogin.setForeground(new Color(0, 0, 0, 0));
        btnLogin.setFocusPainted(false);

        btnRegister.setContentAreaFilled(false);
        btnRegister.setBorderPainted(false);
        btnRegister.setOpaque(false);
        btnRegister.setForeground(new Color(0, 0, 0, 0));
        btnRegister.setFocusPainted(false);

        txtCip.setOpaque(false);
        txtCip.setBorder(null);

        txtPassword.setOpaque(false);
        txtPassword.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        txtCip = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCip.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCip.setToolTipText("");
        txtCip.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel.add(txtCip, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 159, 360, 35));
        jPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 235, 360, 35));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 284, 78, 33));

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 385, 102, 33));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String cip = txtCip.getText();
        String password = new String(txtPassword.getPassword());

        if (cip.isEmpty() || password.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        org.vivaplus.model.bean.User user = new org.vivaplus.model.bean.User();
        user.setCip(cip);
        user.setPassword(password);

        LoginDAO loginDAO = new LoginDAO();
        boolean isAuthenticated = loginDAO.login(user);

        // Exemplo de alteração na chamada após a autenticação no método btnLoginActionPerformed em LoginScreen.java
        if (isAuthenticated) {
            org.vivaplus.model.enums.Roles userRole = user.getRole();

            if (userRole == org.vivaplus.model.enums.Roles.ADMIN || userRole == org.vivaplus.model.enums.Roles.MANAGER) {
                new ChoiceView(user).setVisible(true); // usa o construtor que recebe o usuário
                this.dispose();
            } else if (userRole == org.vivaplus.model.enums.Roles.BASIC) {
                new CatalogProductsScreen().setVisible(true);
                this.dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "CIP ou senha inválidos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        RegisterScreen registerScreen = new RegisterScreen();
        registerScreen.setVisible(true);
        this.dispose();
    }
}
