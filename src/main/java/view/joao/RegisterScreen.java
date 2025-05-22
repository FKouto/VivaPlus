package view.joao;

import dao.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

public class RegisterScreen extends JFrame {
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JButton btnRegister;
    private JButton btnBack;
    
    public RegisterScreen() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Registro de Novo Usuário");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblUsername = new JLabel("Usuário:");
        txtUsername = new JTextField(15);
        
        JLabel lblPassword = new JLabel("Senha:");
        txtPassword = new JPasswordField(15);
        
        JLabel lblConfirmPassword = new JLabel("Confirmar Senha:");
        txtConfirmPassword = new JPasswordField(15);
        
        btnRegister = new JButton("Registrar");
        btnBack = new JButton("Voltar");
        
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(lblConfirmPassword);
        panel.add(txtConfirmPassword);
        panel.add(btnBack);
        panel.add(btnRegister);
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreen login = new LoginScreen();
                login.setVisible(true);
                dispose();
            }
        });
        
        add(panel);
    }
    
    private void register() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "As senhas não conferem!");
            return;
        }
        
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole("PHARMACEUTICAL"); // Default role
        
        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.createUser(newUser);
        
        if (success) {
            LoginScreen login = new LoginScreen();
            login.setVisible(true);
            dispose();
        }
    }
}