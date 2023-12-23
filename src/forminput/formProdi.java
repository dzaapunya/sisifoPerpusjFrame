/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forminput;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class formProdi extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection conn = koneksi.koneksidatabase.Konek();
    /**
     * Creates new form formProdi
     */
    public formProdi() {
        initComponents();
        table();
    }
    
    public void table(){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM program_studi");
            
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Kode");
            tbl.addColumn("Nama Jurusan");
            
            
            tbl.getDataVector().removeAllElements();
            tbl.fireTableDataChanged();
            tbl.setRowCount(0);
            
            while(rs.next()){
                Object[] data = {
                    rs.getString("kode_jurusan"),
                    rs.getString("nama"),
                };
                tbl.addRow(data);
                jTable1.setModel(tbl);
                
            }
        } catch (Exception e) {
        }
    }
    private void clear(){
        kdProdi.setText(null);
        namaProdi.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kdProdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaProdi = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("INPUT PRODI");

        jLabel2.setText("Kode Prodi");

        jLabel3.setText("Nama Prodi");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(67, 67, 67)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(namaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kdProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSimpan)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEdit)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnHapus)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kdProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(namaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = conn.createStatement();
            if(kdProdi.getText().equals("") || namaProdi.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                rs = st.executeQuery("SELECT * FROM program_studi where kode_jurusan = '" + kdProdi.getText() + "'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Prodi Sudah Ada!", "Data Duplikat", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                    String input = "INSERT INTO program_studi VALUES (NULL, '" + kdProdi.getText() + "', '" + namaProdi.getText() + "')";
                //st.executeUpdate(input);
                PreparedStatement pst = conn.prepareStatement(input);
                pst.execute();
                JOptionPane.showMessageDialog(this, "Data Telah Terinput", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace to the console
            JOptionPane.showMessageDialog(this, "Gagal Menyimpan: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        table();
        clear();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE program_studi set kode_jurusan = '" + kdProdi.getText() + 
                    "', nama='" + namaProdi.getText() + "' WHERE kode_jurusan = '" + kdProdi.getText() + "'";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(this, "BERHASIL DI UPDATE", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            table();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "GAGAL DI UPDATE", "UPDATE", JOptionPane.WARNING_MESSAGE);

        }
        clear();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(kdProdi.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih data yang ingin dihapus!");
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Yakin Ingin Menghapus?", "KONFIRMASI", JOptionPane.YES_NO_OPTION);
            
            if (jawab == 0) {
                try {
                    st = conn.createStatement();
                    String sql = "DELETE FROM program_studi WHERE kode_jurusan='"+ kdProdi.getText() + "'";
                    st.executeUpdate(sql);
                    /**PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();**/

                    JOptionPane.showMessageDialog(this, "BERHASIL DIHAPUS", "HAPUS", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "GAGAL DIHAPUS", "HAPUS", JOptionPane.WARNING_MESSAGE);
                }
                table();
                clear();
            }
        }          
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        String kode = jTable1.getValueAt(baris, 0).toString();
        kdProdi.setText(kode);
        String nama = jTable1.getValueAt(baris, 1).toString();
        namaProdi.setText(nama);
        kdProdi.setEditable(false);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(formProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formProdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formProdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kdProdi;
    private javax.swing.JTextField namaProdi;
    // End of variables declaration//GEN-END:variables
}
