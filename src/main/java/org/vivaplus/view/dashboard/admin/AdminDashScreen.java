package org.vivaplus.view.dashboard.admin;

import org.vivaplus.model.bean.User;
import org.vivaplus.model.dao.UserDAO;
import org.vivaplus.model.enums.Roles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AdminDashScreen extends JFrame {
    private JTable userTable;
    private JTextField txtUserId;
    private JComboBox<Roles> roleComboBox;
    private JButton btnUpdateRole, btnDeleteProfile;

    public AdminDashScreen() {
        setTitle("Admin Dashboard");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Tabela de usuários
        userTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(userTable);
        panel.add(scrollPane);

        // Campo para ID do usuário
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID do Usuário:"));
        txtUserId = new JTextField(10);
        inputPanel.add(txtUserId);

        // ComboBox para selecionar a nova role
        inputPanel.add(new JLabel("Nova Role:"));
        roleComboBox = new JComboBox<>(Roles.values());
        inputPanel.add(roleComboBox);

        // Botão para atualizar a role
        btnUpdateRole = new JButton("Atualizar Role");
        inputPanel.add(btnUpdateRole);

        // Botão para excluir o perfil
        btnDeleteProfile = new JButton("Excluir Perfil");
        inputPanel.add(btnDeleteProfile);

        panel.add(inputPanel);

        // Adiciona ações aos botões
        btnUpdateRole.addActionListener(e -> updateUserRole());
        btnDeleteProfile.addActionListener(e -> deleteUserProfile());

        add(panel);

        // Carrega os usuários na tabela
        loadUsers();
    }

    private void loadUsers() {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        // Configura o modelo da tabela
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "CIP", "Nome", "Role"}, 0);
        for (User user : users) {
            model.addRow(new Object[]{user.getId(), user.getCip(), user.getName(), user.getRole()});
        }
        userTable.setModel(model);
    }

    private void updateUserRole() {
        try {
            int userId = Integer.parseInt(txtUserId.getText());
            Roles newRole = (Roles) roleComboBox.getSelectedItem();

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
            int userId = Integer.parseInt(txtUserId.getText());

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminDashScreen().setVisible(true));
    }
}