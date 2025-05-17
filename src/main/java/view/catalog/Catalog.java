package view.catalog;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import view.LoginForm;
import view.catalog.NewProductForm;
import view.catalog.UpdateProductForm;

public class Catalog extends javax.swing.JFrame {
    
    DefaultTableModel tableModel = new DefaultTableModel();
   
    public Catalog() {
        // Inicializa os componentes da interface gráfica
        initComponents();
        // Centraliza a janela na tela
        this.setExtendedState(MAXIMIZED_BOTH);
        // Impede que a janela seja redimensionada
        this.setResizable(false);
        // Define que o layout será manual (sem layout manager)
        this.setLayout(null);
        backgroundFrame.setBackgroundFrame("images/background-catalogo.svg", 1920, 1080);
        // Configurando Layout Buttons
        btnLoad.setContentAreaFilled(false);
        btnLoad.setBorderPainted(false);
        btnLoad.setOpaque(false);
        btnLoad.setForeground(new Color(0, 0, 0, 0));
        btnLoad.setFocusPainted(false);
        btnNewProduct.setContentAreaFilled(false);
        btnNewProduct.setBorderPainted(false);
        btnNewProduct.setOpaque(false);
        btnNewProduct.setForeground(new Color(0, 0, 0, 0));
        btnNewProduct.setFocusPainted(false);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.setBorderPainted(false);
        btnUpdate.setOpaque(false);
        btnUpdate.setForeground(new Color(0, 0, 0, 0));
        btnUpdate.setFocusPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setBorderPainted(false);
        btnExit.setOpaque(false);
        btnExit.setForeground(new Color(0, 0, 0, 0));
        btnExit.setFocusPainted(false);
        
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnNewProduct = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        labelReturn = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        backgroundFrame = new view.SvgFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));

        pnPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        pnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setText("Sair");
        btnExit.setBorder(null);
        btnExit.setPreferredSize(new java.awt.Dimension(75, 40));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1813, 32, -1, -1));

        btnNewProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNewProduct.setText("Adicionar");
        btnNewProduct.setBorder(null);
        btnNewProduct.setPreferredSize(new java.awt.Dimension(209, 40));
        btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductActionPerformed(evt);
            }
        });
        pnPanel.add(btnNewProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 32, -1, -1));

        btnLoad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLoad.setText("Carregar");
        btnLoad.setBorder(null);
        btnLoad.setPreferredSize(new java.awt.Dimension(173, 40));
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });
        pnPanel.add(btnLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 32, -1, -1));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Alterar");
        btnUpdate.setBorder(null);
        btnUpdate.setPreferredSize(new java.awt.Dimension(173, 40));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 32, -1, -1));

        labelReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnPanel.add(labelReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1856, 920));

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableProducts.setMaximumSize(new java.awt.Dimension(1856, 920));
        jScrollPane2.setViewportView(tableProducts);

        pnPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 80, -1, -1));

        backgroundFrame.setPreferredSize(new java.awt.Dimension(97, 48));
        pnPanel.add(backgroundFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        LoginForm goToLoginForm = new LoginForm();
        goToLoginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try (Connection con = conectar();
             Statement st = con.createStatement();){

            ResultSet rs = st.executeQuery("SELECT * FROM mydb.products;");

            DefaultTableModel tableModel = new DefaultTableModel(
                    new Object[]{"ID", "Nome", "Quantidade", "Preço", "Receita?"}, 0
            );

            while (rs.next()) {
                int id = rs.getInt("product_id");
                String nome = rs.getString("product_name");
                int quantidade = rs.getInt("product_quantity");
                double preco = rs.getDouble("product_price");
                String receita = rs.getString("product_prescription");

                Object[] row = {id, nome, quantidade, preco, receita};
                tableModel.addRow(row);
            }

            tableProducts.setModel(tableModel);
            tableProducts.revalidate();
            tableProducts.repaint();

            labelReturn.setText("Listagem da Tabela com sucesso.");

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            labelReturn.setText("LISTAR - Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        UpdateProductForm goToUpdateProductForm = new UpdateProductForm();
        goToUpdateProductForm.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
        NewProductForm goToNewProductForm = new NewProductForm();
        goToNewProductForm.setVisible(true);
    }//GEN-LAST:event_btnNewProductActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Catalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalog().setVisible(true);
            }
        });
    }

    private Connection conectar() throws Exception {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String serverName = "localhost:3306";
        String mydatabase = "mydb";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String usuario = "root";
        String senha = "root";
        Class.forName(driverName);
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.SvgFrame backgroundFrame;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelReturn;
    private javax.swing.JPanel pnPanel;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables
}
