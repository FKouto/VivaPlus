package view.joao;

import dao.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

public class AddUserScreen extends JFrame {
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JComboBox<String> comboRole;
    private JButton btnAdd;
    private JButton btnCancel;
    
    public AddUserScreen() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Adicionar Novo Usuário");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblUsername = new JLabel("Usuário:");
        txtUsername = new JTextField(15);
        
        JLabel lblPassword = new JLabel("Senha:");
        txtPassword = new JPasswordField(15);
        
        JLabel lblRole = new JLabel("Tipo de Usuário:");
        String[] roles = {"PHARMACEUTICAL", "MANAGER"};
        comboRole = new JComboBox<>(roles);
        
        btnAdd = new JButton("Adicionar");
        btnCancel = new JButton("Cancelar");
        
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblRole);
        panel.add(comboRole);
        panel.add(btnCancel);
        panel.add(btnAdd);
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        add(panel);
    }
    
    private void addUser() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String role = comboRole.getSelectedItem().toString();
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }
        
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.createUser(newUser);
        
        if (success) {
            dispose();
        }
    }
}