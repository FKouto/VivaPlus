package view;

public class SignUpForm extends javax.swing.JFrame {

    public SignUpForm() {
        initComponents();
        // Centraliza a janela na tela
        this.setLocationRelativeTo(null);
        // Impede que a janela seja redimensionada
        this.setResizable(false);
        // Define que o layout será manual, sem o uso de um layout manager
        this.setLayout(null);
        // Define o fundo do componente 'backgroundFrame' com uma imagem e tamanho especificado
        backgroundFrame.setBackgroundFrame("images/background-signup.svg", 660, 450);
        // Configura o botão para não ter preenchimento de área interna
        btnReturnLogin.setContentAreaFilled(false);
        // Remove a borda do botão
        btnReturnLogin.setBorderPainted(false);
        // Define que o botão será transparente
        btnReturnLogin.setOpaque(false);
        // Configura o botão para não ter preenchimento de área interna
        btnSignUp.setContentAreaFilled(false);
        // Remove a borda do botão
        btnSignUp.setBorderPainted(false);
        // Define que o botão será transparente
        btnSignUp.setOpaque(false);
        // Configura o campo de texto para o nome de usuário
        txtUsername.setOpaque(false);  // Remove a opacidade de fundo
        txtUsername.setBorder(null);   // Remove a borda (opcional)
        txtUsername.setFocusable(true); // Permite que o campo receba foco
        // Adiciona listener para eventos de foco no campo de texto
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt); // Ação ao ganhar foco
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt); // Ação ao perder foco
            }
        });
        // Configura o campo de texto para o senha Admin
        txtAdminPassword.setOpaque(false);  // Remove a opacidade de fundo
        txtAdminPassword.setBorder(null);   // Remove a borda (opcional)
        // Configura o campo de texto para o senha User Password
        txtUserPassword.setOpaque(false);  // Remove a opacidade de fundo
        txtUserPassword.setBorder(null);   // Remove a borda (opcional)
        // Configura o campo de texto para o senha User Password Check
        txtCheckPassword.setOpaque(false);  // Remove a opacidade de fundo
        txtCheckPassword.setBorder(null);   // Remove a borda (opcional)
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPanel = new javax.swing.JPanel();
        btnReturnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtAdminPassword = new javax.swing.JPasswordField();
        txtUserPassword = new javax.swing.JPasswordField();
        txtCheckPassword = new javax.swing.JPasswordField();
        cBoxSelectRole = new javax.swing.JComboBox<>();
        backgroundFrame = new view.SvgFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnPanel.setBackground(new java.awt.Color(255, 255, 255));
        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnReturnLogin.setPreferredSize(new java.awt.Dimension(119, 33));
        btnReturnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnLoginActionPerformed(evt);
            }
        });
        pnPanel.add(btnReturnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 398, -1, -1));

        btnSignUp.setBackground(new java.awt.Color(204, 204, 255));
        btnSignUp.setBorder(null);
        btnSignUp.setPreferredSize(new java.awt.Dimension(124, 33));
        pnPanel.add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 398, -1, -1));

        txtUsername.setBorder(null);
        txtUsername.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 48, -1, -1));

        txtAdminPassword.setBorder(null);
        txtAdminPassword.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtAdminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        txtUserPassword.setBorder(null);
        txtUserPassword.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 276, -1, -1));

        txtCheckPassword.setBorder(null);
        txtCheckPassword.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtCheckPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 352, -1, -1));

        cBoxSelectRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxSelectRole.setBorder(null);
        cBoxSelectRole.setPreferredSize(new java.awt.Dimension(353, 30));
        cBoxSelectRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxSelectRoleActionPerformed(evt);
            }
        });
        pnPanel.add(cBoxSelectRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 124, -1, -1));
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

    // Username
    // Evento disparado quando o campo de texto ganha foco
    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {
        // Se o texto atual for o texto de placeholder, limpa o campo
        if (txtUsername.getText().equals("Nome de usuário")) {
            txtUsername.setText("");
        }
    }

    // Evento disparado quando o campo de texto perde o foco
    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {
        // Se o campo estiver vazio ao perder o foco, restaura o texto de placeholder
        if (txtUsername.getText().equals("")) {
            txtUsername.setText("Nome de usuário");
        }
    }


    private void btnReturnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnLoginActionPerformed
        LoginForm goToLoginForm = new LoginForm();
        goToLoginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnLoginActionPerformed

    private void cBoxSelectRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxSelectRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBoxSelectRoleActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.SvgFrame backgroundFrame;
    private javax.swing.JButton btnReturnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JComboBox<String> cBoxSelectRole;
    private javax.swing.JPanel pnPanel;
    private javax.swing.JPasswordField txtAdminPassword;
    private javax.swing.JPasswordField txtCheckPassword;
    private javax.swing.JPasswordField txtUserPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
