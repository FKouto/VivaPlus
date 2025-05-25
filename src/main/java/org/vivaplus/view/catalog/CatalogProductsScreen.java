package org.vivaplus.view.catalog;

import org.vivaplus.model.bean.Drug;
import org.vivaplus.model.dao.DrugDAO;
import org.vivaplus.model.enums.Prescription;
import org.vivaplus.view.LoginScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author couto
 */
public class CatalogProductsScreen extends javax.swing.JFrame {

    private final List<Drug> sacola = new ArrayList<>();

    private TableRowSorter<DefaultTableModel> sorter;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.vivaplus.view.BackgroundLoad background;
    private javax.swing.JButton btnAddMed;
    private javax.swing.JButton btnAddSacola;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnViewBag;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCatalog;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public CatalogProductsScreen() {
        initComponents();
        settingsComponents();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatalogProductsScreen().setVisible(true);
            }
        });
    }

    public void settingsComponents() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Viva+ Drogaria | Catálogo de Produtos");
        background.setBackgroundPanel("images/background-catalog.svg", 1920, 1080);

        btnAddMed.setContentAreaFilled(false);
        btnAddMed.setBorderPainted(false);
        btnAddMed.setOpaque(false);
        btnAddMed.setForeground(new Color(0, 0, 0, 0));
        btnAddMed.setFocusPainted(false);

        btnAddSacola.setContentAreaFilled(false);
        btnAddSacola.setBorderPainted(false);
        btnAddSacola.setOpaque(false);
        btnAddSacola.setForeground(new Color(0, 0, 0, 0));
        btnAddSacola.setFocusPainted(false);

        btnViewBag.setContentAreaFilled(false);
        btnViewBag.setBorderPainted(false);
        btnViewBag.setOpaque(false);
        btnViewBag.setForeground(new Color(0, 0, 0, 0));
        btnViewBag.setFocusPainted(false);

        btnSair.setContentAreaFilled(false);
        btnSair.setBorderPainted(false);
        btnSair.setOpaque(false);
        btnSair.setForeground(new Color(0, 0, 0, 0));
        btnSair.setFocusPainted(false);

        txtSearch.setOpaque(false);
        txtSearch.setBorder(null);

        tbCatalog.setFont(new Font("Arial", Font.PLAIN, 14));
        tbCatalog.setRowHeight(30);
        tbCatalog.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        tbCatalog.setBackground(Color.WHITE);
        tbCatalog.setForeground(Color.BLACK);
        tbCatalog.setSelectionBackground(new Color(184, 207, 229));
        tbCatalog.setSelectionForeground(Color.BLACK);
        tbCatalog.getTableHeader().setBackground(new Color(70, 130, 180));
        tbCatalog.getTableHeader().setForeground(Color.WHITE);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbCatalog.getColumnModel().getColumn(0).setCellRenderer(centralizado);

        carregarTabelaProdutos();
        configurarFiltroPesquisa();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCatalog = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnAddMed = new javax.swing.JButton();
        btnViewBag = new javax.swing.JButton();
        btnAddSacola = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        background = new org.vivaplus.view.BackgroundLoad();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCatalog.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        tbCatalog.setEnabled(false);
        jScrollPane1.setViewportView(tbCatalog);

        jPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 95, 1856, 920));
        jPanel.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1476, 39, 313, 34));

        btnAddMed.setText("Adicionar Medicamento");
        btnAddMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedActionPerformed(evt);
            }
        });
        jPanel.add(btnAddMed, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 36, 209, 40));

        btnViewBag.setText("Visualizar Sacola");
        btnViewBag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBagActionPerformed(evt);
            }
        });
        jPanel.add(btnViewBag, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 36, 172, 40));

        btnAddSacola.setText("Adicionar a sacola");
        btnAddSacola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSacolaActionPerformed(evt);
            }
        });
        jPanel.add(btnAddSacola, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 36, 172, 40));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(1813, 36, 75, 40));

        background.setText("background");
        jPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMedActionPerformed(java.awt.event.ActionEvent evt) {
        AddNewProductScreen addNewProductScreen = new AddNewProductScreen();

        addNewProductScreen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                carregarTabelaProdutos();
            }
        });

        addNewProductScreen.setVisible(true);
    }

    private void btnAddSacolaActionPerformed(java.awt.event.ActionEvent evt) {
        String inputId = JOptionPane.showInputDialog(this, "Digite o ID do medicamento:", "Adicionar à Sacola", JOptionPane.QUESTION_MESSAGE);

        if (inputId == null || inputId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID não informado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tbCatalog.getModel();
        boolean itemEncontrado = false;
        DrugDAO drugDAO = new DrugDAO();

        for (int i = 0; i < model.getRowCount(); i++) {
            String itemId = model.getValueAt(i, 0).toString().trim();

            if (itemId.equals(inputId.trim())) {
                int currentQuantity = (Integer) model.getValueAt(i, 2);
                if (currentQuantity <= 0) {
                    JOptionPane.showMessageDialog(this, "Produto sem estoque suficiente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Drug medicamento = new Drug();
                medicamento.setId(itemId);
                medicamento.setProduct(model.getValueAt(i, 1).toString());
                medicamento.setQuantity(1);

                String precoStr = model.getValueAt(i, 3).toString()
                        .replaceAll("[^\\d,]", "")
                        .replace(",", ".");
                try {
                    double preco = Double.parseDouble(precoStr);
                    medicamento.setPrice(preco);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Erro ao converter preço: " + precoStr, "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                medicamento.setPrescription(Prescription.valueOf(model.getValueAt(i, 4).toString()));
                medicamento.setBatch(model.getValueAt(i, 5).toString());
                medicamento.setExpiration_date((java.util.Date) model.getValueAt(i, 6));

                sacola.add(medicamento);
                JOptionPane.showMessageDialog(this, "Medicamento adicionado à sacola com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Sacola agora contém " + sacola.size() + " itens.");

                int newQuantity = currentQuantity - 1;
                model.setValueAt(newQuantity, i, 2);

                Drug updatedDrug = new Drug();
                updatedDrug.setId(itemId);
                updatedDrug.setQuantity(newQuantity);
                if (!drugDAO.update(updatedDrug)) {
                    System.err.println("Falha ao atualizar a quantidade do produto " + itemId + " no banco de dados.");
                }

                itemEncontrado = true;
                break;
            }
        }

        if (!itemEncontrado) {
            JOptionPane.showMessageDialog(this, "Medicamento com ID " + inputId + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnViewBagActionPerformed(java.awt.event.ActionEvent evt) {
        if (sacola.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A sacola está vazia.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] colunas = {"ID", "Nome", "Quantidade", "Preço"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Drug medicamento : sacola) {
            Object[] linha = {
                    medicamento.getId(),
                    medicamento.getProduct(),
                    medicamento.getQuantity(),
                    medicamento.getPrice()
            };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        tabela.setFillsViewportHeight(true);

        JOptionPane.showMessageDialog(this, scrollPane, "Itens na sacola", JOptionPane.INFORMATION_MESSAGE);
    }

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
        this.dispose();
    }

    private void carregarTabelaProdutos() {
        String[] colunas = {"ID", "Nome", "Quantidade", "Preço", "Prescrição", "Lote", "Validade"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        DrugDAO drugDAO = new DrugDAO();
        List<Drug> produtos = drugDAO.getAll();

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for (Drug produto : produtos) {
            Object[] linha = {
                    produto.getId(),
                    produto.getProduct(),
                    produto.getQuantity(),
                    formatoMoeda.format(produto.getPrice()),
                    produto.getPrescription(),
                    produto.getBatch(),
                    produto.getExpiration_date()
            };
            modelo.addRow(linha);
        }

        tbCatalog.setModel(modelo);

        sorter = new TableRowSorter<>(modelo);
        tbCatalog.setRowSorter(sorter);
    }

    private void configurarFiltroPesquisa() {
        DefaultTableModel modelo = (DefaultTableModel) tbCatalog.getModel();
        sorter = new TableRowSorter<>(modelo);
        tbCatalog.setRowSorter(sorter);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String texto = txtSearch.getText();
                if (texto.trim().isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });
    }
}
