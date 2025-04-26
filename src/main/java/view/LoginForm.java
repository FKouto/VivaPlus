package view;

import view.catalog.Catalog;
import java.awt.Color;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        // Configuração do frame de fundo
        backgroundFrame.setBackgroundFrame("images/background-login.svg", 660, 450);

        // Configuração do botão de login
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setOpaque(false);
        btnLogin.setForeground(new Color(0, 0, 0, 0));
        btnLogin.setFocusPainted(false);

        // Configuração do botão de registro
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setOpaque(false);
        btnRegistrar.setForeground(new Color(0, 0, 0, 0));
        btnRegistrar.setFocusPainted(false);

        // Configuração do campo de texto de nome de usuário
        txtUsername.setOpaque(false);
        txtUsername.setBorder(null);
        txtUsername.setFocusable(true);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        // Configuração do campo de senha
        txtSenha.setOpaque(false);
        txtSenha.setBorder(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        backgroundFrame = new view.SvgFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBorder(null);
        txtUsername.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtUsername.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 162, -1, -1));

        txtSenha.setBorder(null);
        txtSenha.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 238, -1, -1));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLogin.setPreferredSize(new java.awt.Dimension(78, 33));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 284, -1, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setPreferredSize(new java.awt.Dimension(102, 33));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnPanel.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 385, -1, -1));
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

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {
        if (txtUsername.getText().equals("Nome de usuário")) {
            txtUsername.setText("");
        }
    }

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("Nome de usuário");
        }
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Catalog goToProducts = new Catalog();
        goToProducts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        SignUpForm goToSignUp = new SignUpForm();
        goToSignUp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.SvgFrame backgroundFrame;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel pnPanel;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
