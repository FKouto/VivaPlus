package view;

public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        // Inicializa os componentes da interface gráfica
        initComponents();

        // Centraliza a janela na tela
        this.setLocationRelativeTo(null);

        // Impede que a janela seja redimensionada
        this.setResizable(false);

        // Define que o layout será manual (sem layout manager)
        this.setLayout(null);

        // Define o fundo do componente 'backgroundFrame' com uma imagem e tamanho especificado
        backgroundFrame.setBackgroundFrame("images/background-login.svg", 660, 450);

        // Configura o botão de login
        btnLogin.setContentAreaFilled(false); // Remove o preenchimento interno
        btnLogin.setBorderPainted(false);     // Remove a borda
        btnLogin.setOpaque(false);            // Torna o botão transparente

        // Configura o botão de registro
        btnRegistrar.setContentAreaFilled(false); // Remove o preenchimento interno
        btnRegistrar.setBorderPainted(false);     // Remove a borda
        btnRegistrar.setOpaque(false);            // Torna o botão transparente

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
        
        // Configura o campo de texto para o senha
        txtSenha.setOpaque(false);  // Remove a opacidade de fundo
        txtSenha.setBorder(null);   // Remove a borda (opcional)
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

        pnPanel.setBackground(new java.awt.Color(255, 255, 255));
        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsername.setBorder(null);
        txtUsername.setMargin(new java.awt.Insets(8, 8, 8, 8));
        txtUsername.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 162, -1, -1));

        txtSenha.setBorder(null);
        txtSenha.setPreferredSize(new java.awt.Dimension(353, 30));
        pnPanel.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 238, -1, -1));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnLogin.setPreferredSize(new java.awt.Dimension(78, 33));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnPanel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 284, -1, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0));
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
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        ProductsForm goToProducts = new ProductsForm();
        goToProducts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        SignUpForm goToSignUp = new SignUpForm();
        goToSignUp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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
