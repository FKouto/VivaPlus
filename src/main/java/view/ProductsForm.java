package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ProductsForm extends javax.swing.JFrame {
    
    DefaultTableModel tableModel = new DefaultTableModel();
   
    public ProductsForm() {
        // Inicializa os componentes da interface gráfica
        initComponents();
        
        // Centraliza a janela na tela
        this.setExtendedState(MAXIMIZED_BOTH);

        // Impede que a janela seja redimensionada
        this.setResizable(false);

        // Define que o layout será manual (sem layout manager)
        this.setLayout(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        labelCode = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelQuantity = new javax.swing.JLabel();
        labelPrice = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnRead = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        labelReturn = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        labelPrescription = new javax.swing.JLabel();
        comboPrescription = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExit.setText("Sair");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        labelCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCode.setText("Código:");

        labelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelName.setText("Nome:");

        labelQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelQuantity.setText("Quantidade:");

        labelPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrice.setText("Preço:");

        txtCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnRead.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRead.setText("Listar produtos");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCreate.setText("Incluir");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Alterar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        labelReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jScrollPane2.setViewportView(tableProducts);

        labelPrescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelPrescription.setText("Receita?");

        comboPrescription.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPrescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(labelReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                .addComponent(labelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                .addComponent(txtName)
                                .addComponent(txtQuantity)
                                .addComponent(txtPrice)
                                .addComponent(comboPrescription, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(btnCreate)
                            .addGap(51, 51, 51)
                            .addComponent(btnUpdate)
                            .addGap(43, 43, 43)
                            .addComponent(btnDelete)
                            .addGap(29, 29, 29)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExit)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCode)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelQuantity)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPrescription)
                            .addComponent(comboPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addComponent(labelReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRead)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        LoginForm goToLoginForm = new LoginForm();
        goToLoginForm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";   //caminho do servidor do BD
            String mydatabase = "mydb"; //nome do seu banco de dados 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "1234";
            Class.forName(driverName);
            Connection con;
            System.out.println(" URL  " + url);
            System.out.println(" usuario  " + usuario);
            System.out.println(" senha " + senha);
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("con " + con);
            java.sql.Statement st = con.createStatement();

            //int codigo = Integer.parseInt(txtCode.getText());
            String nome = txtName.getText();
            String quantidade = txtQuantity.getText();
            double preco = Double.parseDouble(txtQuantity.getText());
            String receita = comboPrescription.getSelectedItem().toString();

            String comando = ("INSERT INTO mydb.products ( `product_name`, `product_quantity`, `product_price`, `product_prescription`) VALUES "
                    + "('" + nome + "'," + quantidade + "," + preco + ",'" + receita + "');");
            System.out.println(comando);
            st.executeUpdate(comando);
            labelReturn.setText("Inclusão na Tabela com sucesso.");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            System.out.println("Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";   //caminho do servidor do BD
            String mydatabase = "mydb"; //nome do seu banco de dados 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "1234";
            Class.forName(driverName);
            Connection con;
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("con " + con);

            String codigo = txtCode.getText();
            String nome = txtName.getText();
            String quantidade = txtQuantity.getText();
            String preco = txtPrice.getText();
            String receita = comboPrescription.getSelectedItem().toString();

            Statement st = con.createStatement();
            String comando = ("UPDATE mydb.products SET product_name = '" + nome + "', product_quantity = " + quantidade 
                    + ", product_price =" + preco + ", product_prescription ='" + receita + "' WHERE product_id = " + codigo + ";");
            st.executeUpdate(comando);
            labelReturn.setText("Alteração na Tabela com sucesso.");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            labelReturn.setText("UPDATE Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";   //caminho do servidor do BD
            String mydatabase = "mydb"; //nome do seu banco de dados 
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "1234";
            Class.forName(driverName);
            Connection con;
            con = DriverManager.getConnection(url, usuario, senha);

            String codigo = txtCode.getText();

            Statement st = con.createStatement();
            String comando = ("DELETE FROM mydb.products WHERE product_id = " + codigo + ";");
            st.executeUpdate(comando);
            labelReturn.setText("Exclusão com sucesso.");

            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(" e " + e);
            labelReturn.setText("DELETE - Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            String serverName = "localhost:3306";
            String mydatabase = "mydb";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String usuario = "root";
            String senha = "1234";

            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, usuario, senha);
            Statement st = con.createStatement();

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
            tableProducts.setVisible(true);

            labelReturn.setText("Listagem da Tabela com sucesso.");

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
            labelReturn.setText("LISTAR - Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \nRecompile e execute novamente.");
        }

    }//GEN-LAST:event_btnReadActionPerformed

    private void comboPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPrescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPrescriptionActionPerformed

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
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboPrescription;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCode;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPrescription;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JLabel labelQuantity;
    private javax.swing.JLabel labelReturn;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
