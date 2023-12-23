/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forminput;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class formAnggotaPerpus extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection conn = koneksi.koneksidatabase.Konek();
    /**
     * Creates new form formProdi
     */
    public formAnggotaPerpus() {
        initComponents();
        table();
    }
    
    public void table(){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM anggota_perpustakaan");
            
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Nomor");
            tbl.addColumn("Tanggal Masuk");
            tbl.addColumn("last Update");
            
            
            tbl.getDataVector().removeAllElements();
            tbl.fireTableDataChanged();
            tbl.setRowCount(0);
            
            while(rs.next()){
                Object[] data = {
                    rs.getString("nomor"),
                    rs.getString("tanggal_masuk"),
                    rs.getString("last_update")
                };
                tbl.addRow(data);
                jTable1.setModel(tbl);
                
            }
        } catch (Exception e) {
        }
    }
    private void clear(){
        txtNomor.setText(null);
        tglMasuk.setDate(null);
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
        txtNomor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tglMasuk = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT ANGGOTA PERPUS");

        jLabel2.setText("Nomor/Satmbuk");

        jLabel3.setText("Tanggal Masuk");

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
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNomor, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(tglMasuk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tglMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
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
            if(txtNomor.getText().equals("") || tglMasuk.getDate().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                rs = st.executeQuery("SELECT * FROM anggota_perpustakaan where nomor = '" + txtNomor.getText() + "'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Prodi Sudah Ada!", "Data Duplikat", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                    Date selectedDate = tglMasuk.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);
                     // Dapatkan waktu sekarang
                    Date LastUpdate = new Date();
                    // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
                    SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                    // Format waktu sekarang sesuai dengan pola yang telah ditentukan
                    String formattedLastUpdate = formatLastUpdate.format(LastUpdate);
                    String admin = "Admin";
                    String input = "INSERT INTO anggota_perpustakaan VALUES (NULL, '" + txtNomor.getText() + "', '" + formattedDate + "', '" + formattedLastUpdate + "', '" + admin + "')";
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
             Date selectedDate = tglMasuk.getDate();
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             String formattedDate = dateFormat.format(selectedDate);
             // Dapatkan waktu sekarang
             Date LastUpdate = new Date();
             // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
              SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
              // Format waktu sekarang sesuai dengan pola yang telah ditentukan
              String formattedLastUpdate = formatLastUpdate.format(LastUpdate);
              String admin = "Admin";
            String sql = "UPDATE anggota_perpustakaan SET " +
                "tanggal_masuk = '" + formattedDate + "', " +
                "last_update = '" + formattedLastUpdate + "', " +
                "userid = '" + admin + "' " +
                "WHERE nomor = '" + txtNomor.getText() + "'";
            
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
        if(txtNomor.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih data yang ingin dihapus!");
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Yakin Ingin Menghapus?", "KONFIRMASI", JOptionPane.YES_NO_OPTION);
            
            if (jawab == 0) {
                try {
                    st = conn.createStatement();
                    String sql = "DELETE FROM anggota_perpustakaan WHERE nomor='"+ txtNomor.getText() + "'";
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
        String nomor = jTable1.getValueAt(baris, 0).toString();
        txtNomor.setText(nomor);
        Object tanggalMasukObject = jTable1.getValueAt(baris, 1).toString();
       
            
        try {
            Date tanggalMasuk;
            tanggalMasuk = (tanggalMasukObject instanceof Date) ?
                    (Date) tanggalMasukObject :
                    new SimpleDateFormat("yyyy-MM-dd").parse(tanggalMasukObject.toString());
            tglMasuk.setDate(tanggalMasuk);
        } catch (ParseException ex) {
            Logger.getLogger(formAnggotaPerpus.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        txtNomor.setEditable(false);
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
            java.util.logging.Logger.getLogger(formAnggotaPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formAnggotaPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formAnggotaPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formAnggotaPerpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formAnggotaPerpus().setVisible(true);
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
    private com.toedter.calendar.JDateChooser tglMasuk;
    private javax.swing.JTextField txtNomor;
    // End of variables declaration//GEN-END:variables
}
