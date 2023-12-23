/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forminput;

import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class formBuku extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection conn = koneksi.koneksidatabase.Konek();
    String filename;
    /**
     * Creates new form formProdi
     */
    public formBuku() {
        initComponents();
        table();
        LoadDataKategori();
    }
    
    public void table(){
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT buku.*, kategori_buku.nama AS nama_kategori FROM buku INNER JOIN kategori_buku ON buku.kode_kategori = kategori_buku.kode;");
            
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("Kode Buku");
            tbl.addColumn("Kategori");
            tbl.addColumn("Judul");
            tbl.addColumn("Stok");
            tbl.addColumn("Pengarang");
            tbl.addColumn("Penerbit");
            tbl.addColumn("Tahun Terbit");
            tbl.addColumn("Tahun Pengadaan");
            tbl.addColumn("Sumber");
            tbl.addColumn("Rak");
            tbl.addColumn("ISBN");
            tbl.addColumn("Foto Buku");
            tbl.addColumn("Last Update");
            
            
            tbl.getDataVector().removeAllElements();
            tbl.fireTableDataChanged();
            tbl.setRowCount(0);
            
            while(rs.next()){
                Object[] data = {
                    rs.getString("kode"),
                    rs.getString("nama_kategori"),
                    rs.getString("judul"),
                    rs.getString("stock"),
                    rs.getString("pengarang"),
                    rs.getString("penerbit"),
                    rs.getString("tahun_terbit"),
                    rs.getString("tahun_pengadaan"),
                    rs.getString("sumber"),
                    rs.getString("rak"),
                    rs.getString("isbn"),
                    rs.getString("foto_buku"),
                    rs.getString("last_update"),
                };
                tbl.addRow(data);
                jTable1.setModel(tbl);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void clear(){
        kdBuku.setText(null);
        cmbKategori.setSelectedItem("PILIH");
        namaKategori.setText(null);
        txtJudul.setText(null);
        txtStok.setText(null);
        txtPengarang.setText(null);
        txtPenerbit.setText(null);
        txtTahunTerbit.setText(null);
        txtTahunPengadaan.setText(null);
        txtSumber.setText(null);
        txtRak.setText(null);
        txtISBN.setText(null);
        txtFileName.setText(null);
    }
private void LoadDataKategori(){
        cmbKategori.removeAllItems();
        try{ 
            st = conn.createStatement(); 
            String Sql = "select * from kategori_buku"; 
            rs=st.executeQuery(Sql); 
            cmbKategori.addItem("PILIH");
           while(rs.next()) { 
                cmbKategori.addItem(rs.getString("kode")); 
           }
            cmbKategori.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            String selectedKode = cmbKategori.getSelectedItem().toString();
                            rs = st.executeQuery("SELECT * FROM kategori_buku where kode = '" + selectedKode + "'");
                            if(selectedKode.equals("PILIH")){
                                namaKategori.setText("");
                            }else{
                                if (rs.next()) {
                                    // Assuming "nama_jurusan" is the column name for the name of the program study
                                    String namaKat= rs.getString("nama");
                                    namaKategori.setText(namaKat);
                                }
                            }
                        } catch (SQLException ex) {
                            System.out.println("Query Execution Error: " + ex.toString());
                        }
                    }
                }
            });
        } catch(SQLException e){ 
        System.out.println("Koneksi Gagal"+e.toString()); 
        }
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
        kdBuku = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaKategori = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cmbKategori = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPengarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPenerbit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTahunTerbit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTahunPengadaan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtRak = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        labelImage = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        txtFileName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT BUKU");

        jLabel2.setText("Kode Buku");

        jLabel3.setText("Kategori Buku");

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

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Judul Buku");

        jLabel6.setText("Stok");

        jLabel7.setText("Pengarang");

        jLabel8.setText("Penerbit");

        jLabel9.setText("Tahun Terbit");

        jLabel10.setText("Tahun Pengadaan");

        jLabel11.setText("Sumber");

        jLabel12.setText("Rak");

        jLabel13.setText("ISBN");

        jLabel14.setText("Foto");

        labelImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnUpload.setText("Upload Foto");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(namaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(kdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTahunPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSumber, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRak, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtISBN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpload)))
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(405, 405, 405))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(kdBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(namaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnUpload)
                                        .addGap(68, 68, 68))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(txtPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan)
                                    .addComponent(btnEdit)
                                    .addComponent(btnHapus)
                                    .addComponent(btnExit))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtTahunPengadaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtSumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = conn.createStatement();
            if(kdBuku.getText().equals("") || cmbKategori.getSelectedItem().equals("PILIH")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                rs = st.executeQuery("SELECT * FROM buku where kode = '" + kdBuku.getText() + "'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Buku Sudah Ada!", "Data Duplikat", JOptionPane.WARNING_MESSAGE);
                    
                }else{
                     // Dapatkan waktu sekarang
                    java.util.Date LastUpdate = new java.util.Date();
                    // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
                    SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                    // Format waktu sekarang sesuai dengan pola yang telah ditentukan
                    String formattedLastUpdate = formatLastUpdate.format(LastUpdate);
                    
                    String input = "INSERT INTO buku VALUES (NULL, '" + kdBuku.getText() + "', '" + cmbKategori.getSelectedItem() +"', '" + txtJudul.getText()+"', '" + txtStok.getText()+ "', '" + txtPengarang.getText()+"', '" + txtPenerbit.getText()+"', '" + txtTahunTerbit.getText()+"', '" + txtTahunPengadaan.getText()+"', '" + txtSumber.getText()+"', '" + txtRak.getText()+"', '" + txtISBN.getText()+"', '" + txtFileName.getText()+"', '" + formattedLastUpdate+"', '" + "Admin"+"')";
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
             // Dapatkan waktu sekarang
                    java.util.Date LastUpdate = new java.util.Date();
                    // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
                    SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
                    // Format waktu sekarang sesuai dengan pola yang telah ditentukan
                    String formattedLastUpdate = formatLastUpdate.format(LastUpdate);
                String sql  = "UPDATE buku SET " +
                "kode = '" + kdBuku.getText() + "', " +
                "kode_kategori = '" + cmbKategori.getSelectedItem() + "', " +
                "judul = '" + txtJudul.getText() + "', " +
                "stock = '" + txtStok.getText() + "', " +
                "pengarang = '" + txtPengarang.getText() + "', " +
                "penerbit = '" + txtPenerbit.getText() + "', " +
                "tahun_terbit = '" + txtTahunTerbit.getText() + "', " +
                "tahun_pengadaan = '" + txtTahunPengadaan.getText() + "', " +
                "sumber = '" + txtSumber.getText() + "', " +
                "rak = '" + txtRak.getText() + "', " +
                "isbn = '" + txtISBN.getText() + "', " +
                "foto_buku = '" + txtFileName.getText() + "', " +
                "last_update = '" + formattedLastUpdate + "', " +
                "userid = '" + "Admin" + "' " +
                "WHERE kode = '" + kdBuku.getText() + "'";

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
        if(kdBuku.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan Pilih data yang ingin dihapus!");
        }else{
            int jawab = JOptionPane.showConfirmDialog(this, "Yakin Ingin Menghapus?", "KONFIRMASI", JOptionPane.YES_NO_OPTION);
            
            if (jawab == 0) {
                try {
                    st = conn.createStatement();
                    String sql = "DELETE FROM buku WHERE kode='"+ kdBuku.getText() + "'";
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
        kdBuku.setText(kode);
         try {
            String Sql = "SELECT * FROM buku WHERE kode='" + kdBuku.getText() + "'";
            st = conn.createStatement();
            rs = st.executeQuery(Sql);

            if (rs.next()) {
                
                btnSimpan.setEnabled(false);
                txtJudul.setText(rs.getString("judul"));
                txtStok.setText(rs.getString("stock"));
                
                
                txtPengarang.setText(rs.getString("pengarang"));
                txtPenerbit.setText(rs.getString("penerbit"));
                txtTahunTerbit.setText(rs.getString("tahun_terbit"));
                txtTahunPengadaan.setText(rs.getString("tahun_pengadaan"));
                txtSumber.setText(rs.getString("sumber"));
                txtRak.setText(rs.getString("rak"));
                txtISBN.setText(rs.getString("isbn"));
                txtFileName.setText(rs.getString("foto_buku"));
                String jk = rs.getString("kode_kategori");
                cmbKategori.setSelectedItem(jk);
            } else {
                
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal " + e.toString());
        } 

        
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();

            if (f != null) { // Pastikan file terpilih
                ImageIcon icon = new ImageIcon(f.toString()); 
                Image image = icon.getImage().getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon ic = new ImageIcon(image);
                labelImage.setIcon(ic);

                filename = f.getAbsolutePath();
                txtFileName.setText(filename);

                String newpath = "src/Upload/profile/";
                File directory = new File(newpath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                File sourceFile = new File(filename);
                String extension = filename.substring(filename.lastIndexOf('.') + 1);

                // Menggunakan LocalDateTime untuk mendapatkan timestamp
                LocalDateTime timestamp = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String tanggal = timestamp.format(formatter);

                File destinationFile = new File(newpath + "/newImage" + tanggal + "." + extension);

                Files.copy(sourceFile.toPath(), destinationFile.toPath());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Upload Error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnUploadActionPerformed

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
            java.util.logging.Logger.getLogger(formBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new formBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kdBuku;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField namaKategori;
    private javax.swing.JTextField txtFileName;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtRak;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtSumber;
    private javax.swing.JTextField txtTahunPengadaan;
    private javax.swing.JTextField txtTahunTerbit;
    // End of variables declaration//GEN-END:variables
}
