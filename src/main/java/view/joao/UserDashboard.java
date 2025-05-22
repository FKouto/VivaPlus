package view.joao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.User;

public class UserDashboard extends JFrame {
    
    private User loggedUser;
    private JLabel lblWelcome;
    private JButton btnLogout;
    
    public UserDashboard(User user) {
        this.loggedUser = user;
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Dashboard do Farmacêutico");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        lblWelcome = new JLabel("Bem-vindo, " + loggedUser.getUsername() + "!");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 18));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        
        JLabel lblInfo = new JLabel("Você está logado como cliente");
        
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
        centerPanel.add(new JLabel("")); // Espaço vazio
        centerPanel.add(btnLogout);
        
        panel.add(lblWelcome, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        add(panel);
    }
}
