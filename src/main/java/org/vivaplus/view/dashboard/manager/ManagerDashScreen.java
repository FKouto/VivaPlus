package org.vivaplus.view.dashboard.manager;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.bean.User;
import org.vivaplus.model.dao.DrugDAO;
import org.vivaplus.model.dao.UserDAO;
import org.vivaplus.model.enums.Roles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ManagerDashScreen extends JFrame {
    private JTable userTable, productTable;
    private JTextField txtUserId, txtProductId;
    private JComboBox<Roles> roleComboBox;
    private JButton btnUpdateRole, btnDeleteProfile, btnOpenUpdateProductScreen;

    public ManagerDashScreen() {
        setTitle("Manager Dashboard");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Tabela de usuários
        userTable = new JTable();
        JScrollPane userScrollPane = new JScrollPane(userTable);
        userScrollPane.setPreferredSize(new Dimension(400, 200)); // Define tamanho preferido
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.5; // Aumenta o peso vertical
        panel.add(new JLabel("Usuários:"), gbc);
        gbc.gridy++;
        panel.add(userScrollPane, gbc);

        // Campos e botões para usuários
        JPanel userInputPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        userInputPanel.add(new JLabel("ID do Usuário:"));
        txtUserId = new JTextField();
        userInputPanel.add(txtUserId);

        userInputPanel.add(new JLabel("Nova Role:"));
        roleComboBox = new JComboBox<>(Roles.values());
        userInputPanel.add(roleComboBox);

        btnUpdateRole = new JButton("Atualizar Role");
        userInputPanel.add(btnUpdateRole);

        btnDeleteProfile = new JButton("Excluir Perfil");
        userInputPanel.add(btnDeleteProfile);

        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        panel.add(userInputPanel, gbc);

        // Tabela de produtos
        productTable = new JTable();
        JScrollPane productScrollPane = new JScrollPane(productTable);
        productScrollPane.setPreferredSize(new Dimension(400, 200)); // Define tamanho preferido
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.5; // Aumenta o peso vertical
        panel.add(new JLabel("Produtos:"), gbc);
        gbc.gridy++;
        panel.add(productScrollPane, gbc);

        // Botão para abrir a tela de atualização de medicamentos
        btnOpenUpdateProductScreen = new JButton("Atualiza um medicamento");
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        panel.add(btnOpenUpdateProductScreen, gbc);

        // Adiciona ações aos botões
        btnUpdateRole.addActionListener(e -> updateUserRole());
        btnDeleteProfile.addActionListener(e -> deleteUserProfile());
        btnOpenUpdateProductScreen.addActionListener(e -> {
            UpdateProductManagerScreen updateScreen = new UpdateProductManagerScreen();
            updateScreen.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    loadProducts(); // Atualiza a tabela de produtos
                }
            });
            updateScreen.setVisible(true);
        });
        add(panel);

        // Carrega os dados nas tabelas
        loadUsers();
        loadProducts();
    }

    private void loadUsers() {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers();

        DefaultTableModel userModel = new DefaultTableModel(new String[]{"ID", "CIP", "Nome", "Role"}, 0);
        for (User user : users) {
            userModel.addRow(new Object[]{user.getId(), user.getCip(), user.getName(), user.getRole()});
        }
        userTable.setModel(userModel);
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
        SwingUtilities.invokeLater(() -> new ManagerDashScreen().setVisible(true));
    }
}