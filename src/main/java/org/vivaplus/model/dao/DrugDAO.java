package org.vivaplus.model.dao;

import org.vivaplus.database.DatabaseConnection;
import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.bean.User;
import org.vivaplus.model.enums.Prescription;
import org.vivaplus.model.enums.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DrugDAO {

    public boolean create(Drug drug) {
        String sql = "INSERT INTO products (product_id, product_name, product_quantity, product_price, product_prescription, product_batch, product_batch_expiration, last_modified_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, drug.getId());
            stmt.setString(2, drug.getProduct());
            stmt.setInt(3, drug.getQuantity());
            stmt.setDouble(4, drug.getPrice());
            stmt.setString(5, drug.getPrescription().name());
            stmt.setString(6, drug.getBatch());
            stmt.setDate(7, new java.sql.Date(drug.getExpiration_date().getTime()));

            if (drug.getUser() != null && drug.getUser().getId() != null) {
                stmt.setString(8, drug.getUser().getId());
            } else {
                stmt.setNull(8, java.sql.Types.VARCHAR);
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Drug read(String productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Drug(
                        rs.getString("product_id"),
                        rs.getString("product_name"),
                        rs.getInt("product_quantity"),
                        rs.getDouble("product_price"),
                        rs.getString("product_prescription") != null
                                ? Prescription.valueOf(rs.getString("product_prescription"))
                                : null,
                        rs.getString("product_batch"),
                        rs.getDate("product_batch_expiration"),
                        0,
                        null
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Drug> getAll() {
        String sql = "SELECT p.product_id, p.product_name, p.product_quantity, p.product_price, " +
                "p.product_prescription, p.product_batch, p.product_batch_expiration, " +
                "p.last_modified_by, u.name, u.cip, u.password, u.role " +
                "FROM products p LEFT JOIN users u ON p.last_modified_by = u.id";
        List<Drug> drugs = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = null;
                if (rs.getInt("last_modified_by") != 0) {
                    user = new User();
                    user.setId(String.valueOf(rs.getInt("last_modified_by")));
                    user.setName(rs.getString("name"));
                    user.setCip(rs.getString("cip"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(Roles.valueOf(rs.getString("role")));
                }

                Drug drug = new Drug(
                        String.valueOf(rs.getInt("product_id")),
                        rs.getString("product_name"),
                        rs.getInt("product_quantity"),
                        rs.getDouble("product_price"),
                        Prescription.valueOf(rs.getString("product_prescription")),
                        rs.getString("product_batch"),
                        rs.getDate("product_batch_expiration"),
                        0, // last_modified não está no banco
                        user
                );
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    public boolean update(Drug drug) {
        StringBuilder sql = new StringBuilder("UPDATE products SET ");
        List<Object> parameters = new ArrayList<>();

        if (drug.getProduct() != null) {
            sql.append("product_name = ?, ");
            parameters.add(drug.getProduct());
        }
        if (drug.getQuantity() != 0) {
            sql.append("product_quantity = ?, ");
            parameters.add(drug.getQuantity());
        }
        if (drug.getPrice() != null) { // Verifica se o preço não é nulo
            sql.append("product_price = ?, ");
            parameters.add(drug.getPrice());
        }
        if (drug.getPrescription() != null) {
            sql.append("product_prescription = ?, ");
            parameters.add(drug.getPrescription().name());
        }
        if (drug.getBatch() != null) {
            sql.append("product_batch = ?, ");
            parameters.add(drug.getBatch());
        }
        if (drug.getExpiration_date() != null) {
            sql.append("product_batch_expiration = ?, ");
            parameters.add(new java.sql.Date(drug.getExpiration_date().getTime()));
        }
        if (drug.getUser() != null && drug.getUser().getId() != null) {
            sql.append("last_modified_by = ?, ");
            parameters.add(Integer.parseInt(drug.getUser().getId()));
        }

        // Remove a última vírgula e espaço
        if (parameters.isEmpty()) {
            return false; // Nenhum campo para atualizar
        }
        sql.setLength(sql.length() - 2);
        sql.append(" WHERE product_id = ?");
        parameters.add(Integer.parseInt(drug.getId()));

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                stmt.setObject(i + 1, parameters.get(i));
            }

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}