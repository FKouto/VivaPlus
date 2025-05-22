package view.joao;

import dao.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

public class LoginScreen extends JFrame {
    
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegister;
    
    public LoginScreen() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel lblUsername = new JLabel("Usuário:");
        txtUsername = new JTextField(15);
        
        JLabel lblPassword = new JLabel("Senha:");
        txtPassword = new JPasswordField(15);
        
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Registrar");
        
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnRegister);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterScreen register = new RegisterScreen();
                register.setVisible(true);
                dispose();
            }
        });
        
        add(panel);
    }
    
    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }
        
        UserDAO userDAO = new UserDAO();
        boolean checkUser = userDAO.checkLogin(username, password);
        
        if (checkUser) {
            User loggedUser = userDAO.getUser(username);
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            
            // Verifica o tipo de usuário e redireciona para a tela adequada
            if (loggedUser.getRole().equals("MANAGER")) {
                AdminDashboard admin = new AdminDashboard(loggedUser);
                admin.setVisible(true);
            } else {
                UserDashboard user = new UserDashboard(loggedUser);
                user.setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos!");
        }
    }
    
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}