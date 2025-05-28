package org.vivaplus.view;

import java.awt.*;

/**
 * @author couto
 */
public class RegisterScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JTextField txtCip;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordConfirm;
    // End of variables declaration//GEN-END:variables

    public RegisterScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Cadastro");
        background.setBackgroundPanel("images/background-register.svg", 660, 450);

        txtName.setOpaque(false);
        txtName.setBorder(null);

        txtCip.setOpaque(false);
        txtCip.setBorder(null);

        txtPassword.setOpaque(false);
        txtPassword.setBorder(null);

        txtPasswordConfirm.setOpaque(false);
        txtPasswordConfirm.setBorder(null);

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtCip = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtPasswordConfirm = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 84, 360, 35));
        getContentPane().add(txtCip, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 160, 360, 35));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 236, 360, 35));
        getContentPane().add(txtPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 312, 360, 35));

        btnLogin.setText("Voltar Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 361, 119, 33));

        btnRegister.setText("Registrar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 361, 124, 33));

        background.setText("background");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String name = txtName.getText();
        String cip = txtCip.getText();
        String password = new String(txtPassword.getPassword());
        String passwordConfirm = new String(txtPasswordConfirm.getPassword());

        if (name.isEmpty() || cip.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(passwordConfirm)) {
            javax.swing.JOptionPane.showMessageDialog(this, "As senhas não coincidem.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        org.vivaplus.model.bean.User user = new org.vivaplus.model.bean.User();
        user.setName(name);
        user.setCip(cip);
        user.setPassword(password);
        user.setRole(org.vivaplus.model.enums.Roles.BASIC);

        org.vivaplus.model.dao.UserDAO userDAO = new org.vivaplus.model.dao.UserDAO();
        boolean isRegistered = userDAO.register(user);

        if (isRegistered) {
            javax.swing.JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.setVisible(true);
            this.dispose(); // Fecha a tela de registro
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao registrar o usuário.", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.dispose(); // Fecha a tela de registro
    }//GEN-LAST:event_btnLoginActionPerformed
}
