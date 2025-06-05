package org.vivaplus.model.dao;

import org.vivaplus.database.DatabaseConnection;
import org.vivaplus.model.bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean login(User user) {
        String sql = "SELECT id, name, role FROM users WHERE cip = ? AND password = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, user.getCip());
            stmt.setString(2, user.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Popula os dados do usuário autenticado
                    user.setId(String.valueOf(rs.getInt("id")));
                    user.setName(rs.getString("name"));
                    user.setRole(org.vivaplus.model.enums.Roles.valueOf(rs.getString("role")));
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
}