package view.joao;

import dao.UserDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

public class AdminDashboard extends JFrame {
    
    private User loggedUser;
    private JLabel lblWelcome;
    private JButton btnLogout;
    private JButton btnAddUser;
    private JButton btnManageUsers;
    
    public AdminDashboard(User user) {
        this.loggedUser = user;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Dashboard do Gerente");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        lblWelcome = new JLabel("Bem-vindo, Gerente " + loggedUser.getUsername() + "!");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        
        JLabel lblInfo = new JLabel("Você está logado como gerente");
        
        btnAddUser = new JButton("Adicionar Novo Usuário");
        btnAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tela para adicionar usuário como admin
                AddUserScreen addUser = new AddUserScreen();
                addUser.setVisible(true);
            }
        });
        
        btnManageUsers = new JButton("Gerenciar Usuários");
        btnManageUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tela para gerenciar usuários
                JOptionPane.showMessageDialog(null, "Função para gerenciar usuários a ser implementada!");
            }
        });
        
        btnLogout = new JButton("Sair");
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginScreen login = new LoginScreen();
                login.setVisible(true);
                dispose();
            }
        });
        
        centerPanel.add(lblInfo);
        centerPanel.add(btnAddUser);
        centerPanel.add(btnManageUsers);
        centerPanel.add(btnLogout);
        
        panel.add(lblWelcome, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        add(panel);
    }
}