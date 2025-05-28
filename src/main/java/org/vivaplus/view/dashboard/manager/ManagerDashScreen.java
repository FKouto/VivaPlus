package org.vivaplus.view.dashboard.manager;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.bean.User;
import org.vivaplus.model.dao.DrugDAO;
import org.vivaplus.model.dao.UserDAO;
import org.vivaplus.model.enums.Roles;
import org.vivaplus.view.LoginScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author couto
 */
public class ManagerDashScreen extends javax.swing.JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnDeleteProfile;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdateMed;
    private javax.swing.JButton btnUpdateRole;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productTable;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JTextField txtID;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    public ManagerDashScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Viva+ | Manager");
        background.setBackgroundPanel("images/background-update-med-manager.svg", 900, 600);

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

        btnUpdateMed.setContentAreaFilled(false);
        btnUpdateMed.setBorderPainted(false);
        btnUpdateMed.setOpaque(false);
        btnUpdateMed.setForeground(new Color(0, 0, 0, 0));
        btnUpdateMed.setFocusPainted(false);

        txtID.setOpaque(false);
        txtID.setBorder(null);
        txtID.setBackground(new Color(0, 0, 0, 0));

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"BASIC","MANAGER"}));

        loadUsers();
        loadProducts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        roleComboBox = new javax.swing.JComboBox<>();
        btnUpdateRole = new javax.swing.JButton();
        btnDeleteProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnUpdateMed = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 259, 90, 33));

        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jPanel.add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 259, 121, 33));

        btnUpdateRole.setText("Atualizar Role");
        btnUpdateRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoleActionPerformed(evt);
            }
        });
        jPanel.add(btnUpdateRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 259, 142, 33));

        btnDeleteProfile.setText("Excluir Perfil");
        btnDeleteProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProfileActionPerformed(evt);
            }
        });
        jPanel.add(btnDeleteProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 260, 133, 33));

        btnLogout.setText("Sair");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, 16, 75, 33));

        btnUpdateMed.setText("Atualizar Medicamento");
        btnUpdateMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMedActionPerformed(evt);
            }
        });
        jPanel.add(btnUpdateMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 550, 856, 33));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(productTable);

        jPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 312, 856, 226));

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
        jScrollPane2.setViewportView(userTable);

        jPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 60, 856, 179));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

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

    private void btnUpdateRoleActionPerformed(java.awt.event.ActionEvent evt) {
        updateUserRole();
    }

    private void btnDeleteProfileActionPerformed(java.awt.event.ActionEvent evt) {
        deleteUserProfile();
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        LoginScreen goLogin = new LoginScreen();
        goLogin.setVisible(true);
        this.dispose();
    }

    private void btnUpdateMedActionPerformed(java.awt.event.ActionEvent evt) {
        UpdateProdManagerScreen updateProdManager = new UpdateProdManagerScreen();
        updateProdManager.setVisible(true);
        updateProdManager.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadProducts();
            }
        });
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

    private void loadProducts() {
        DrugDAO drugDAO = new DrugDAO();
        List<Drug> drugs = drugDAO.getAll();

        DefaultTableModel productModel = new DefaultTableModel(new String[]{"ID", "Nome", "Quantidade", "Preço"}, 0);
        for (Drug drug : drugs) {
            productModel.addRow(new Object[]{drug.getId(), drug.getProduct(), drug.getQuantity(), drug.getPrice()});
        }
        productTable.setModel(productModel);
    }
}
