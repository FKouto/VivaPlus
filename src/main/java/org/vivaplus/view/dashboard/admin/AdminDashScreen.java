package org.vivaplus.view.dashboard.admin;

import org.vivaplus.model.bean.User;
import org.vivaplus.model.dao.UserDAO;
import org.vivaplus.model.enums.Roles;
import org.vivaplus.view.LoginScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author couto
 */
public class AdminDashScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnDeleteProfile;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdateRole;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JTextField txtID;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    public AdminDashScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Admin");
        background.setBackgroundPanel("images/background-admin.svg", 600, 600);

        userTable.setFont(new Font("Arial", Font.PLAIN, 14));
        userTable.setRowHeight(30);
        userTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        userTable.setBackground(Color.WHITE);
        userTable.setForeground(Color.BLACK);
        userTable.setSelectionBackground(new Color(184, 207, 229));
        userTable.setSelectionForeground(Color.BLACK);
        userTable.getTableHeader().setBackground(new Color(70, 130, 180));
        userTable.getTableHeader().setForeground(Color.WHITE);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        userTable.getColumnModel().getColumn(0).setCellRenderer(centralizado);

        btnUpdateRole.setContentAreaFilled(false);
        btnUpdateRole.setBorderPainted(false);
        btnUpdateRole.setOpaque(false);
        btnUpdateRole.setForeground(new Color(0, 0, 0, 0));
        btnUpdateRole.setFocusPainted(false);

        btnDeleteProfile.setContentAreaFilled(false);
        btnDeleteProfile.setBorderPainted(false);
        btnDeleteProfile.setOpaque(false);
        btnDeleteProfile.setForeground(new Color(0, 0, 0, 0));
        btnDeleteProfile.setFocusPainted(false);

        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setOpaque(false);
        btnLogout.setForeground(new Color(0, 0, 0, 0));
        btnLogout.setFocusPainted(false);

        txtID.setOpaque(false);
        txtID.setBorder(null);

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"BASIC", "MANAGER", "ADMIN"}));

        loadUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        btnUpdateRole = new javax.swing.JButton();
        btnDeleteProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        roleComboBox = new javax.swing.JComboBox<>();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(userTable);

        jPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 56, 584, 478));
        jPanel.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 550, 89, 33));

        btnUpdateRole.setText("Atualizar Role");
        btnUpdateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoleActionPerformed(evt);
            }
        });
        jPanel.add(btnUpdateRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 550, 142, 33));

        btnDeleteProfile.setText("Excluir Perfil");
        btnDeleteProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProfileActionPerformed(evt);
            }
        });
        jPanel.add(btnDeleteProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 550, 133, 33));

        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 16, 75, 32));

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel.add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 121, 33));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

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

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        LoginScreen goLogin = new LoginScreen();
        goLogin.setVisible(true);
        this.dispose();
    }

    private void btnUpdateRoleActionPerformed(java.awt.event.ActionEvent evt) {
        updateUserRole();
    }

    private void btnDeleteProfileActionPerformed(java.awt.event.ActionEvent evt) {
        deleteUserProfile();
    }

    private void loadUsers() {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "CIP", "Nome", "Role"}, 0);
        for (User user : users) {
            model.addRow(new Object[]{user.getId(), user.getCip(), user.getName(), user.getRole()});
        }
        userTable.setModel(model);
    }

    private void updateUserRole() {
        try {
            int userId = Integer.parseInt(txtID.getText());
            String selectedRoleStr = roleComboBox.getSelectedItem().toString();
            Roles newRole = Roles.valueOf(selectedRoleStr);

            UserDAO userDAO = new UserDAO();
            boolean success = userDAO.updateUserRole(userId, newRole);

            if (success) {
                JOptionPane.showMessageDialog(this, "Role atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                loadUsers();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar a role.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do usuário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteUserProfile() {
        try {
            int userId = Integer.parseInt(txtID.getText());

            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o perfil do usuário com ID: " + userId + "?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                UserDAO userDAO = new UserDAO();
                boolean success = userDAO.deleteUser(userId);

                if (success) {
                    JOptionPane.showMessageDialog(this, "Perfil excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    loadUsers();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir o perfil.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID do usuário inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
