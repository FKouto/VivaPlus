package view;

import java.awt.Color;

public class SignUpForm extends javax.swing.JFrame {

    public SignUpForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        // Configuração do background
        backgroundFrame.setBackgroundFrame("images/background-signup.svg", 660, 450);

        // Configuração do botão de retorno ao login
        btnReturnLogin.setContentAreaFilled(false);
        btnReturnLogin.setBorderPainted(false);
        btnReturnLogin.setOpaque(false);
        btnReturnLogin.setForeground(new Color(0, 0, 0, 0));
        btnReturnLogin.setFocusPainted(false);

        // Configuração do botão de registro
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.setBorderPainted(false);
        btnSignUp.setOpaque(false);
        btnSignUp.setForeground(new Color(0, 0, 0, 0));
        btnSignUp.setFocusPainted(false);

        // Configuração do campo de texto de nome de usuário
        txtUsername.setOpaque(false);
        txtUsername.setBorder(null);
        txtUsername.setFocusable(true);
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

        // Configuração dos campos de senha
        txtAdminPassword.setOpaque(false);
        txtAdminPassword.setBorder(null);
        txtUserPassword.setOpaque(false);
        txtUserPassword.setBorder(null);
        txtCheckPassword.setOpaque(false);
        txtCheckPassword.setBorder(null);
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

        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReturnLogin.setText("Fazer Login");
        btnReturnLogin.setPreferredSize(new java.awt.Dimension(119, 33));
        btnReturnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnLoginActionPerformed(evt);
            }
        });
        pnPanel.add(btnReturnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 398, -1, -1));

        btnSignUp.setText("Registrar-se");
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

    private void btnReturnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnLoginActionPerformed
        LoginForm goToLoginForm = new LoginForm();
        goToLoginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReturnLoginActionPerformed

    public static void main(String args[]) {
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
