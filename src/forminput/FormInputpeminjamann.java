/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forminput;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author muham
 */
public final class FormInputpeminjamann extends javax.swing.JFrame {

    Statement st;
    ResultSet rs;
    String sql;
    Connection conn = koneksi.koneksidatabase.Konek();
    DefaultTableModel dtm;
    
    private DefaultTableModel model;
    
    public FormInputpeminjamann() {
        initComponents();
        LoadDataBiodataMhs();
        LoadDataBuku();
        TampilDataPeminjamanPadaTabel();
    }
    
    void KosongkanObjek(){
        nomoraggota.setText("");
        kodebuku.setText("");
        combokdbuku.setSelectedIndex(0);
        tglpinjam.setDate(null);
        tglkembali.setDate(null);
        kodepinjam.setText("");
    }
    
    public void LoadDataBiodataMhs() {
        String kd="";
        try{
            
            st = conn.createStatement();
            sql = "select * from anggota_perpustakaan";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                combonoanggota.addItem(rs.getString("nomor"));
            }
            
        } catch (SQLException e) {
            System.out.println("Koneksi gagal" + e.toString());
        }
    }
    
    public void LoadDataBuku() {
        String kd="";
        try{
            
            st = conn.createStatement();
            sql = "select * from buku";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                combokdbuku.addItem(rs.getString("kode"));
            }
            
        } catch (SQLException e) {
            System.out.println("Koneksi gagal" + e.toString());
        }
    }
    
    private void AturJTable(JTable Lihat, int Lebar[]){
        try{
            Lihat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int banyak = Lihat.getColumnCount(); 
            for (int i = 0; i < banyak; i++) {
                TableColumn Kolom = Lihat.getColumnModel().getColumn(i);
                Kolom.setPreferredWidth(Lebar[i]);
                Lihat.setRowHeight(20);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah"+e);
        } 
    }
    
    private void TampilModelJTabel(){
        try {
            String[]kolom={"Kode Pinjam","Nomor Anggota","Kode Buku","Tanggal Peminjaman",
            "Tanggal Pengembalian"};
            dtm = new DefaultTableModel(null, kolom){
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            tabel.setModel(dtm);
            AturJTable(tabel, new int []{100,100,200,200,90,90} );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "salah"+e);
        }
    }
    
    void TampilDataPeminjamanPadaTabel() {
    try {
        
        st = conn.createStatement();
        TampilModelJTabel();

        try {
            sql = "SELECT peminjaman_buku.kode_pinjam AS KodePinjam, biodata_mahasiswa.nim AS Nim, buku.judul AS NamaBuku, peminjaman_buku.tanggal_peminjaman AS TanggalPeminjaman, " +
                  "peminjaman_buku.tanggal_pengembalian AS TanggalPengembalian " +
                  "FROM peminjaman_buku " +
                  "LEFT OUTER JOIN biodata_mahasiswa ON peminjaman_buku.nomor_anggota = biodata_mahasiswa.nim " +
                  "LEFT OUTER JOIN buku ON peminjaman_buku.kode_buku = buku.kode";

            rs = st.executeQuery(sql);

            while (rs.next()) {
                dtm.addRow(new Object[]{
                        rs.getString("KodePinjam"),
                        rs.getString("Nim"),
                        rs.getString("NamaBuku"),
                        rs.getString("TanggalPeminjaman"),
                        rs.getString("TanggalPengembalian"),
                });
            }

            tabel.setModel(dtm); // Pindahkan tabel.setModel(dtm) ke luar loop while

        } catch (SQLException e) {
            System.out.println("Ada Kesalahan " + e.toString());
        }

    } catch (SQLException e) {
        System.out.println("koneksi gagal " + e.toString());
    } finally {
        try {
            if (rs != null) rs.close();
            if (st != null) st.close();
        } catch (SQLException ex) {
            System.out.println("Tutup Statement atau ResultSet Gagal " + ex.toString());
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combonoanggota = new javax.swing.JComboBox<>();
        combokdbuku = new javax.swing.JComboBox<>();
        tglpinjam = new com.toedter.calendar.JDateChooser();
        tglkembali = new com.toedter.calendar.JDateChooser();
        nomoraggota = new javax.swing.JTextField();
        kodebuku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnedit = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        kodepinjam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORM INPUT PEMINJAMAN");

        jLabel2.setText("KODE BUKU");

        jLabel3.setText("KODE PINJAM");

        jLabel4.setText("TANGGAL PEMINJAMAN");

        jLabel5.setText("TANGGAL PENGEMBALIAN");

        jLabel7.setText("CARI");

        combonoanggota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        combonoanggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonoanggotaActionPerformed(evt);
            }
        });

        combokdbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        combokdbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokdbukuActionPerformed(evt);
            }
        });

        nomoraggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomoraggotaActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btnedit.setText("EDIT");
        btnedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditMouseClicked(evt);
            }
        });
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnsimpan.setText("SIMPAN");
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
        });
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("NOMOR ANGGOTA");

        kodepinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodepinjamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7)
                        .addGap(35, 35, 35)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(combokdbuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(kodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(combonoanggota, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(nomoraggota, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(kodepinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsimpan)
                                .addGap(32, 32, 32)
                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kodepinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combonoanggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomoraggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combokdbuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodebuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(tglpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tglkembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnedit)
                    .addComponent(btnhapus)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(775, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
 
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat Fm = new SimpleDateFormat(Tampilan);
        String tgllpinjam = String.valueOf(Fm.format(tglpinjam.getDate()));
        String tgllkembali = String.valueOf(Fm.format(tglkembali.getDate()));

        try {
            
            st = null;
            sql = "update peminjaman_buku set nomor_anggota = '" + combonoanggota.getSelectedItem() + "', "
                    + "kode_pinjam = '" + kodepinjam.getText() + "', kode_buku = '" + combokdbuku.getSelectedItem() + "' , tanggal_peminjaman = '" + tgllpinjam + "', "
                    + "last_update = NOW(), userid = 'ADMIN' where nomor_anggota = '" + combonoanggota.getSelectedItem() + "' ";

            st = conn.createStatement();
            int AdaPerubahanRecord = st.executeUpdate(sql);

            TampilDataPeminjamanPadaTabel();

            if (AdaPerubahanRecord > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                btnsimpan.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }

            st.close();
            KosongkanObjek();
            combonoanggota.setSelectedIndex(0);
            combokdbuku.setSelectedIndex(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi Gagal " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        
    }//GEN-LAST:event_btneditActionPerformed

    private void btneditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditMouseClicked
        // TODO add your handling code here:
//        if (nomoranggota.getText().equals("")||kodebuku.getText().equals("")||tglpinjam.getDate().equals(null)||tglpinjam.getDate().equals(null)||denda.getText().equals("")||userid.getText().equals("")){
//            JOptionPane.showMessageDialog(this,"Data Belum Lengkap", "Perhatian", JOptionPane.WARNING_MESSAGE);
//        } else {
//            try {
//                Connection c = koneksi.getkoneksi();
//                Statement st = (Statement)c.createStatement();
//                
//                String sql = "update peminjaman_buku set nama='"+txtnama.getText()+"',jurusan='"+txtjurusan.getSelectedItem().toString()+"',jenis_kelamin='"+jk+"',umur='"+txtumur.getValue()+"' where nim = '"+txtnim.getText()+"'";
//                st.executeUpdate(sql);
//                JOptionPane.showMessageDialog(this,"Data Berhasil Diubah"); 
//                hapus();
//                st.close();
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(rootPane,e);
//            } finally {
//                LoadDataPeminjaman();
//            }
//        }
    }//GEN-LAST:event_btneditMouseClicked

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        // TODO add your handling code here:
        if (kodepinjam.getText().equals("") || nomoraggota.getText().equals("") || kodebuku.getText().equals("") || tglpinjam.getDate() == null || tglkembali.getDate() == null ) {
        JOptionPane.showMessageDialog(this, "Data Belum Lengkap", "Perhatian", JOptionPane.WARNING_MESSAGE);
        } else {
        String Tampilan="yyyy-MM-dd";
            SimpleDateFormat Fm = new SimpleDateFormat(Tampilan);
            String TanggalPeminjaman = String.valueOf(Fm.format(tglpinjam.getDate()));
            String TanggalPengembalian = String.valueOf(Fm.format(tglkembali.getDate()));
                try {
                
                st = null;
                sql = "INSERT INTO peminjaman_buku (id, kode_pinjam, nomor_anggota, kode_buku, tanggal_peminjaman, tanggal_pengembalian, last_update, userid) " +
                        "VALUES (NULL, '" + kodepinjam.getText() + "', '" + combonoanggota.getSelectedItem() + "', '" + combokdbuku.getSelectedItem() + "', '" +
                        TanggalPeminjaman + "', '" + TanggalPengembalian + "', NOW(), 'ADMIN')";
                st = conn.createStatement();
                int AdaPenambahanRecord = st.executeUpdate(sql);
                TampilDataPeminjamanPadaTabel(); 
                if (AdaPenambahanRecord>0){
                    JOptionPane.showMessageDialog(this,"Data Berhasil Tersimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,"Data Gagal Tersimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
                st.close();
                KosongkanObjek();
                combonoanggota.setSelectedIndex(0);
                combokdbuku.setSelectedIndex(0);
            } catch (SQLException e){
                System.out.println("Koneksi Gagal " +e.toString());
            } 
        }
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        if (kodepinjam.getText().equals("") || combonoanggota.getSelectedIndex() == 0 || combokdbuku.getSelectedIndex() == 0 ||
        tglpinjam.getDate() == null || tglkembali.getDate() == null) {
        
            JOptionPane.showMessageDialog(this, "Data belum lengkap. Harap isi semua kolom.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        
    } else {
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat Fm = new SimpleDateFormat(Tampilan);
        String TanggalPinjam = Fm.format(tglpinjam.getDate());
        String TanggalKembali = Fm.format(tglkembali.getDate());

        try {
            
            st = conn.createStatement();
            TampilDataPeminjamanPadaTabel();

            sql = "INSERT INTO peminjaman_buku (id, nomor_anggota, kode_buku, tanggal_peminjaman, tanggal_pengembalian, last_update, userid) " +
                    "VALUES (NULL, '" + kodepinjam.getText() + "', '" + combonoanggota.getSelectedItem() + "', '" + combokdbuku.getSelectedItem() + "', '" +
                    TanggalPinjam + "', '" + TanggalKembali + "', NOW(), 'ADMIN')";

            int AdaPenambahanRecord = st.executeUpdate(sql);

            if (AdaPenambahanRecord > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }

            st.close();
            KosongkanObjek();
            combonoanggota.setSelectedIndex(0);
            combokdbuku.setSelectedIndex(0);
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal " + e.toString());
        } 
    }

    }//GEN-LAST:event_btnsimpanActionPerformed

    private void combokdbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokdbukuActionPerformed
        // TODO add your handling code here:
        String Kode="";
        try{
            
            st = conn.createStatement();
            sql = "select * from buku where kode='" +combokdbuku.getSelectedItem().toString()+"'";
            rs = st.executeQuery(sql);

            while(rs.next()) {
                Kode = rs.getString("judul");
            }
            kodebuku.setText(Kode);
        } catch(SQLException e){
            System.out.println("koneksi gagal"+e.toString());
        }
    }//GEN-LAST:event_combokdbukuActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        try {
            
            st = conn.createStatement();
            TampilModelJTabel();

            String searchText = cari.getText().trim();

            sql = "SELECT peminjaman_buku.kode_pinjam AS KodePinjam, " +
                         "biodata_mahasiswa.nim AS Nim, " +
                         "buku.kode AS KodeBuku, "+
                         "peminjaman_buku.tanggal_peminjaman AS TanggalPeminjaman, "+
                         "peminjaman_buku.tanggal_pengembalian AS TanggalPengembalian, "+
                         "FROM peminjaman_buku " +
                         "LEFT OUTER JOIN biodata_mahasiswa ON peminjaman_buku.nomor_anggota = biodata_mahasiswa.nim " +
                         "LEFT OUTER JOIN buku ON peminjaman_buku.kode_buku = buku.kode " +
                         "WHERE peminjaman_buku.nomor_anggota LIKE '%" + searchText + "%'";

            rs = st.executeQuery(sql); 

            while(rs.next()){
                dtm.addRow(new Object[]{
                        rs.getString("KodePinjam"),
                        rs.getString("Nim"),
                        rs.getString("KodeBuku"),
                        rs.getString("TanggalPeminjaman"),
                        rs.getString("TanggalPengembalian"),
                });
            }

            tabel.setModel(dtm);

        } catch(SQLException e) {
            System.out.println("Ada Kesalahan " + e.toString());
        } finally {
            // Close resources if needed
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException ex) {
                System.out.println("Tutup Statement atau ResultSet Gagal " + ex.toString());
            }
        }
    }//GEN-LAST:event_cariKeyReleased

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            
            st = null;
            sql = "delete from peminjaman_buku where nomor_anggota = '"+combonoanggota.getSelectedItem().toString()+"' ";
            
            st = conn.createStatement();
            int AdaPerubahanRecord = st.executeUpdate(sql);
            
            TampilDataPeminjamanPadaTabel(); 
            
            if (AdaPerubahanRecord>0){
                JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            btnsimpan.setEnabled(true);
            }else {
                JOptionPane.showMessageDialog(this,"Data Gagal Di Hapus", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            combonoanggota.setSelectedIndex(0);
            KosongkanObjek();
            } catch (SQLException e){
                System.out.println("Koneksi Gagal " +e.toString());
            }     
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        String[] listno = {"222227", "222224", "222222", "222232", "222230"};
        String[] listkd = {"BK01", "BK02", "BK03", "BK04", "BK05", "BK06", "BK07"};
        int baris = tabel.rowAtPoint (evt.getPoint());      
        
        String kode_pinjam = tabel.getValueAt(baris, 0).toString();
        kodepinjam.setText(kode_pinjam);
        
        try {
            String Sql = "SELECT * FROM peminjaman_buku WHERE kode_pinjam='" + kodepinjam.getText() + "'";
            st = conn.createStatement();
            rs = st.executeQuery(Sql);

            if (rs.next()) {
                combonoanggota.setSelectedItem(rs.getString("nomor_anggota"));      
            } 
        } catch (SQLException e) {
            System.out.println("Koneksi gagal " + e.toString());
        } 
        
           try {
            String Sql = "SELECT * FROM peminjaman_buku WHERE kode_pinjam='" + kodepinjam.getText() + "'";
            st = conn.createStatement();
            rs = st.executeQuery(Sql);

            if (rs.next()) {
                combokdbuku.setSelectedItem(rs.getString("kode_buku"));
            } 
        } catch (SQLException e) {
            System.out.println("Koneksi gagal " + e.toString());
        } 
        
        
        String tanggalpinjam = tabel.getValueAt(baris, 3).toString();
        tglpinjam.setDate(java.sql.Date.valueOf(tanggalpinjam));
        
        String tanggalkembali = tabel.getValueAt(baris, 4).toString();
        tglkembali.setDate(java.sql.Date.valueOf(tanggalkembali));
        
    }//GEN-LAST:event_tabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combonoanggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonoanggotaActionPerformed
        // TODO add your handling code here:
        String Kode="";
        try{
            
            st = conn.createStatement();
            sql = "select * from biodata_mahasiswa where nim='" +combonoanggota.getSelectedItem().toString()+"'";
            rs = st.executeQuery(sql);

            while(rs.next()) {
                Kode = rs.getString("nama");
            }
            nomoraggota.setText(Kode);
        } catch(SQLException e){
            System.out.println("koneksi gagal"+e.toString());
        }
    }//GEN-LAST:event_combonoanggotaActionPerformed

    private void nomoraggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomoraggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomoraggotaActionPerformed

    private void kodepinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodepinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodepinjamActionPerformed

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
            java.util.logging.Logger.getLogger(FormInputpeminjamann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInputpeminjamann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInputpeminjamann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInputpeminjamann.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInputpeminjamann().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> combokdbuku;
    private javax.swing.JComboBox<String> combonoanggota;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kodebuku;
    private javax.swing.JTextField kodepinjam;
    private javax.swing.JTextField nomoraggota;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tglkembali;
    private com.toedter.calendar.JDateChooser tglpinjam;
    // End of variables declaration//GEN-END:variables
}
