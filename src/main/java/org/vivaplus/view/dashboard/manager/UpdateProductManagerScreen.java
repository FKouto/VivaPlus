package org.vivaplus.view.dashboard.manager;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.dao.DrugDAO;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class UpdateProductManagerScreen extends JFrame {
    private JTextField txtProductId, txtProductName, txtProductQuantity, txtProductPrice, txtBatch;
    private JTextField txtExpirationDate;
    private JComboBox<String> comboPrescription;
    private JButton btnFetchProduct, btnUpdateProduct;

    public UpdateProductManagerScreen() {
        setTitle("Atualizar Produto");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de entrada
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID do Produto:"), gbc);
        txtProductId = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtProductId, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Nome:"), gbc);
        txtProductName = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtProductName, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Quantidade:"), gbc);
        txtProductQuantity = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtProductQuantity, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Preço:"), gbc);
        txtProductPrice = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtProductPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Lote:"), gbc);
        txtBatch = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtBatch, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Data de Validade (yyyy-MM-dd):"), gbc);
        txtExpirationDate = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(txtExpirationDate, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.weightx = 0;
        panel.add(new JLabel("Prescrição:"), gbc);
        comboPrescription = new JComboBox<>(new String[]{"YES", "NO"});
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(comboPrescription, gbc);

        // Botões
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        btnFetchProduct = new JButton("Buscar Produto");
        panel.add(btnFetchProduct, gbc);

        gbc.gridx = 1;
        btnUpdateProduct = new JButton("Atualizar Produto");
        panel.add(btnUpdateProduct, gbc);

        add(panel);

        // Ações dos botões
        btnFetchProduct.addActionListener(e -> fetchProduct());
        btnUpdateProduct.addActionListener(e -> updateProduct());
    }

    private void fetchProduct() {
        String productId = txtProductId.getText();
        if (productId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O ID do produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DrugDAO drugDAO = new DrugDAO();
        Drug drug = drugDAO.read(productId);

        if (drug != null) {
            txtProductName.setText(drug.getProduct());
            txtProductQuantity.setText(String.valueOf(drug.getQuantity()));
            txtProductPrice.setText(String.valueOf(drug.getPrice()));
            txtBatch.setText(drug.getBatch());
            txtExpirationDate.setText(drug.getExpiration_date().toString());
            comboPrescription.setSelectedItem(drug.getPrescription().name());
        } else {
            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateProduct() {
        try {
            String productId = txtProductId.getText();
            if (productId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "O ID do produto é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String productName = txtProductName.getText();
            int productQuantity = Integer.parseInt(txtProductQuantity.getText());
            double productPrice = Double.parseDouble(txtProductPrice.getText());
            String batch = txtBatch.getText();
            Date expirationDate = java.sql.Date.valueOf(txtExpirationDate.getText());
            String prescription = (String) comboPrescription.getSelectedItem();

            Drug drug = new Drug(productId, productName, productQuantity, productPrice,
                    org.vivaplus.model.enums.Prescription.valueOf(prescription),
                    batch, expirationDate, 0, null);

            DrugDAO drugDAO = new DrugDAO();
            boolean success = drugDAO.update(drug);

            if (success) {
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dados inválidos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UpdateProductManagerScreen().setVisible(true));
    }
}