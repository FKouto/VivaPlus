package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.User;

public class UserDAO {
    
    public boolean checkLogin(String username, String password) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                check = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar login: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        
        return check;
    }
    
    public User getUser(String username) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        
        return user;
    }
    
    public boolean createUser(User user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            // Verifica se o usuário já existe
            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM users WHERE username = ?");
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Nome de usuário já existe!");
                return false;
            }
            
            stmt = con.prepareStatement("INSERT INTO users (username, password, role) VALUES (?, ?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            
            stmt.executeUpdate();
            success = true;
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        
        return success;
    }
    
    public boolean updateUser(User user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            stmt = con.prepareStatement("UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());
            stmt.setInt(4, user.getId());
            
            stmt.executeUpdate();
            success = true;
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        
        return success;
    }
    
    public boolean deleteUser(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        boolean success = false;
        
        try {
            stmt = con.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            success = true;
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con);
        }
        
        return success;
    }
}