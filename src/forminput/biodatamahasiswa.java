package forminput;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.SimpleDateFormat;  
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane; 
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class biodatamahasiswa extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    Connection conn = koneksi.koneksidatabase.Konek();
    DefaultTableModel Dtm;
    
    public biodatamahasiswa() {
        initComponents();
        LoadDataProdi();
        LoadDataAgama();
        LoadDataProvinsi();
        LoadJenisKelamin();
        LoadTahunMasuk();
        txtStambuk.requestFocus();
        TampilDataMhsPadaTabel();
        cmbCari.removeAllItems();
        cmbCari.addItem("nim");
        cmbCari.addItem("nama");
    }
    
    private void LoadDataProdi() {
    kdProdi.removeAllItems();
    String kd = "";

    try {
        st = conn.createStatement();
        String Sql = "select * from program_studi";
        rs = st.executeQuery(Sql);
        kdProdi.addItem("PILIH");
        while (rs.next()) {
            kdProdi.addItem(rs.getString("kode_jurusan"));
        }
        // Display the name of the selected program study in namaProdi text field
        kdProdi.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String selectedKode = kdProdi.getSelectedItem().toString();
                        rs = st.executeQuery("SELECT * FROM program_studi where kode_jurusan = '" + selectedKode + "'");
                        if(selectedKode.equals("PILIH")){
                           namaProdi.setText("");
                        }else{
                        if (rs.next()) {
                            // Assuming "nama_jurusan" is the column name for the name of the program study
                            String namaJurusan = rs.getString("nama");
                            namaProdi.setText(namaJurusan);
                        }
                        }
                    } catch (SQLException ex) {
                        System.out.println("Query Execution Error: " + ex.toString());
                    }
                }
            }
        });

    } catch (SQLException e) {
        System.out.println("Koneksi Gagal" + e.toString());
    }
}

    void bersihkan(){
    txtStambuk.setText(null);
        txtNama.setText(null);
        kdProdi.setSelectedItem("PILIH");
        kdAgama.setSelectedItem("PILIH");
        t4Lahir.setText(null);
        tglLahir.setDate(null);
        kdKelamin.setSelectedItem("PILIH");
        txtAlamat.setText(null);
        txtKota.setText(null);
        kdProvinsi.setSelectedItem("PILIH");
        kdPos.setText(null);
        txtTelepon.setText(null);
        txtHandphone.setText(null);
        txtHobi.setText(null);
        txtWali.setText(null);
        txtAlamatWali.setText(null);
        txtTeleponWali.setText(null);
        tahunMasuk.setSelectedItem("PILIH");
    }
    private void LoadDataAgama(){
        kdAgama.removeAllItems();
        try{ 
            st = conn.createStatement(); 
            String Sql = "select * from agama"; 
            rs=st.executeQuery(Sql);
            kdAgama.addItem("PILIH");
           while(rs.next()) { 
                kdAgama.addItem(rs.getString("kode")); 
            }
           // Display the name of the selected program study in namaProdi text field
            kdAgama.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            String selectedKode = kdAgama.getSelectedItem().toString();
                            if(selectedKode.equals("PILIH")){
                                namaAgama.setText("");
                            }else{
                            rs = st.executeQuery("SELECT * FROM agama where kode = '" + selectedKode + "'");

                            if (rs.next()) {
                                // Assuming "nama_jurusan" is the column name for the name of the program study
                                String namaagama = rs.getString("nama");
                                namaAgama.setText(namaagama);
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
    private void LoadDataProvinsi(){
        kdProvinsi.removeAllItems();
        try{ 
            st = conn.createStatement(); 
            String Sql = "select * from provinsi"; 
            rs=st.executeQuery(Sql); 
            kdProvinsi.addItem("PILIH");
           while(rs.next()) { 
                kdProvinsi.addItem(rs.getString("kode")); 
           }
            kdProvinsi.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        try {
                            String selectedKode = kdProvinsi.getSelectedItem().toString();
                            rs = st.executeQuery("SELECT * FROM provinsi where kode = '" + selectedKode + "'");
                            if(selectedKode.equals("PILIH")){
                                namaProvinsi.setText("");
                            }else{
                                

                                if (rs.next()) {
                                    // Assuming "nama_jurusan" is the column name for the name of the program study
                                    String namaProv= rs.getString("nama");
                                    namaProvinsi.setText(namaProv);
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
    
    public void LoadJenisKelamin(){
        kdKelamin.removeAllItems();
        kdKelamin.addItem("PILIH");
        kdKelamin.addItem("P");
        kdKelamin.addItem("W");
        kdKelamin.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                      
                            String selectedKode = kdKelamin.getSelectedItem().toString();
                            if(selectedKode.equals("PILIH")){
                                jenisKelamin.setText("");
                            }else{
                                if (selectedKode.equals("P")) {
                                    // Assuming "nama_jurusan" is the column name for the name of the program study
                                    jenisKelamin.setText("Pria");
                                }else{
                                    jenisKelamin.setText("Wanita");
                                }
                            }
                    }
                }
            });
        if (kdKelamin.getSelectedItem().toString().equals("P")) {
            jenisKelamin.setText("Pria");
        }else if(kdKelamin.getSelectedItem().toString().equals("W")){
            jenisKelamin.setText("Wanita");
        }
    }
    
    public void LoadTahunMasuk(){
        tahunMasuk.removeAllItems();
        tahunMasuk.addItem("PILIH");
        tahunMasuk.addItem("2016");
        tahunMasuk.addItem("2017");
        tahunMasuk.addItem("2018");
        tahunMasuk.addItem("2019");
        tahunMasuk.addItem("2020");
        tahunMasuk.addItem("2021");
        tahunMasuk.addItem("2022");
        tahunMasuk.addItem("2023");
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
            String[]kolom={"Stambuk","Nama Mahasiswa","Program Studi", 
            "Agama","Tempat Lahir","Tgl Lahir","Jenis Kelamin","Alamat","Kota", 
            "Provinsi","Kode Pos", "Telepon","Hanphone","Hobi","Wali","Alamat Wali", 
            "Telepon Wali","Tahun Masuk"}; 
            Dtm = new DefaultTableModel(null, kolom){ 
                public boolean isCellEdijTable1(int rowIndex, int columnIndex) { 
                    return false; 
                } 
            }; 
                tabelMhs.setModel(Dtm); 
                AturJTable(tabelMhs, new int[]{100,300,300,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90}); 
         } catch (Exception e) { 
         JOptionPane.showMessageDialog(null, "salah"+e); 
         } 
    }
    void TampilDataMhsPadaTabel(){ 
        try { 
           st = conn.createStatement(); 
           TampilModelJTabel(); 
            try{ 

            String sql = "SELECT " +
        "biodata_mahasiswa.nim, " +
        "biodata_mahasiswa.nama AS NamaMahasiswa, " +
        "program_studi.nama AS ProgramStudi, " +
        "agama.nama AS NamaAgama, " +
        "biodata_mahasiswa.tempat_lahir AS TempatLahir, " +
        "biodata_mahasiswa.tanggal_lahir AS TanggalLahir, " +
        "biodata_mahasiswa.jenis_kelamin AS JenisKelamin, " +
        "biodata_mahasiswa.alamat AS Alamat, " +
        "biodata_mahasiswa.kota AS Kota, " +
        "provinsi.nama AS NamaProvinsi, " +
        "biodata_mahasiswa.kode_pos AS KodePos, " +
        "biodata_mahasiswa.telpon AS Telpon, " +
        "biodata_mahasiswa.handphone AS HandPhone, " +
        "biodata_mahasiswa.hobi AS Hobi, " +
        "biodata_mahasiswa.wali AS Wali, " +
        "biodata_mahasiswa.alamat_wali AS AlamatWali, " +
        "biodata_mahasiswa.telpon_wali AS TelponWali, " +
        "biodata_mahasiswa.tahun_masuk AS TahunMasuk " +
        "FROM " +
        "biodata_mahasiswa " +
        "LEFT OUTER JOIN program_studi ON (biodata_mahasiswa.kode_program_studi = program_studi.kode_jurusan) " +
        "LEFT OUTER JOIN agama ON (biodata_mahasiswa.kode_agama = agama.kode) " +
        "LEFT OUTER JOIN provinsi ON (biodata_mahasiswa.kode_propinsi = provinsi.kode)";

            rs = st.executeQuery(sql); 
            while(rs.next()){ 
            Dtm.addRow(new Object[]{ 
                rs.getString("nim"), 
                rs.getString("NamaMahasiswa"), 
                rs.getString("ProgramStudi"), 
                rs.getString("NamaAgama"), 
                rs.getString("TempatLahir"), 
                rs.getString("TanggalLahir"), 
                rs.getString("JenisKelamin"), 
                rs.getString("Alamat"), 
                rs.getString("Kota"), 
                rs.getString("NamaProvinsi"), 
                rs.getString("KodePos"), 
                rs.getString("Telpon"), 
                rs.getString("Handphone"), 
                rs.getString("Hobi"), 
                rs.getString("Wali"), 
                rs.getString("AlamatWali"), 
                rs.getString("TelponWali"), 
                rs.getString("TahunMasuk"),
            }); 
             tabelMhs.setModel(Dtm); 
             } 
             }catch(Exception e){ 
             System.out.println("Ada Kesalahan " + e.toString()); 
             } 
         }catch (SQLException e){ 
         System.out.println("koneksi gagal " + e.toString()); 
         } 
    }
    
    void CariDataMhs() {
    try {

        st = conn.createStatement();
        TampilModelJTabel();
        try {
            String Sql = "SELECT biodata_mahasiswa.nim, " +
                    "biodata_mahasiswa.nama AS NamaMahasiswa, " +
                    "program_studi.nama AS ProgramStudi, " +
                    "agama.nama AS NamaAgama, " +
                    "biodata_mahasiswa.tempat_lahir AS TempatLahir, " +
                    "biodata_mahasiswa.tanggal_lahir AS TanggalLahir, " +
                    "biodata_mahasiswa.jenis_kelamin AS JenisKelamin, " +
                    "biodata_mahasiswa.alamat AS Alamat, " +
                    "biodata_mahasiswa.kota AS Kota, " +
                    "provinsi.nama AS NamaProvinsi, " +
                    "biodata_mahasiswa.kode_pos AS KodePos, " +
                    "biodata_mahasiswa.telpon AS Telpon, " +
                    "biodata_mahasiswa.handphone AS HandPhone, " +
                    "biodata_mahasiswa.hobi AS Hobi, " +
                    "biodata_mahasiswa.wali AS Wali, " +
                    "biodata_mahasiswa.alamat_wali AS AlamatWali, " +
                    "biodata_mahasiswa.telpon_wali AS TelponWali, " +
                    "biodata_mahasiswa.tahun_masuk AS TahunMasuk " +
                    " FROM " +
                    " biodata_mahasiswa " +
                    " LEFT OUTER JOIN program_studi ON(biodata_mahasiswa.kode_program_studi=program_studi.kode_jurusan) " +
                    " LEFT OUTER JOIN agama ON(biodata_mahasiswa.kode_agama=agama.kode) " +
                    " LEFT OUTER JOIN provinsi ON(biodata_mahasiswa.kode_propinsi=provinsi.kode) " +
                    " where biodata_mahasiswa." + cmbCari.getSelectedItem() + " LIKE '%" + txtCari.getText() + "%' ";

            System.out.println(cmbCari.getSelectedItem());
            rs = st.executeQuery(Sql);
            Dtm.setRowCount(0); // Hapus semua baris sebelum menambah yang baru

            while (rs.next()) {
                Dtm.addRow(new Object[]{
                        rs.getString("nim"),
                        rs.getString("NamaMahasiswa"),
                        rs.getString("ProgramStudi"),
                        rs.getString("NamaAgama"),
                        rs.getString("TempatLahir"),
                        rs.getString("TanggalLahir"),
                        rs.getString("JenisKelamin"),
                        rs.getString("Alamat"),
                        rs.getString("Kota"),
                        rs.getString("NamaProvinsi"),
                        rs.getString("KodePos"),
                        rs.getString("Telpon"),
                        rs.getString("Handphone"),
                        rs.getString("Hobi"),
                        rs.getString("Wali"),
                        rs.getString("AlamatWali"),
                        rs.getString("TelponWali"),
                        rs.getString("TahunMasuk"),
                });
            }

            tabelMhs.setModel(Dtm);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ada Kesalahan " + e.toString());
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("koneksi gagal " + e.toString());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStambuk = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        kdProdi = new javax.swing.JComboBox<>();
        namaProdi = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        kdAgama = new javax.swing.JComboBox<>();
        namaAgama = new javax.swing.JTextField();
        t4Lahir = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        kdKelamin = new javax.swing.JComboBox<>();
        jenisKelamin = new javax.swing.JTextField();
        tglLahir = new com.toedter.calendar.JDateChooser();
        txtKota = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        kdProvinsi = new javax.swing.JComboBox<>();
        namaProvinsi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        kdPos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtHandphone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtHobi = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtWali = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTeleponWali = new javax.swing.JTextField();
        txtAlamatWali = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tahunMasuk = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMhs = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama");

        jLabel2.setText("Stambuk");

        jLabel3.setText("Kode Prodi");

        jLabel4.setText("Kode Agama");

        jLabel5.setText("T4 Lahir");

        jLabel6.setText("Tanggal Lahir");

        jLabel7.setText("Jenis Kelamin");

        jLabel8.setText("Alamat");

        jLabel9.setText("Kota");

        txtStambuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStambukActionPerformed(evt);
            }
        });

        kdProdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

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

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        kdAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        kdKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Kode Provinsi");

        kdProvinsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Kode Pos");

        jLabel12.setText("Telepon");

        jLabel13.setText("Handphone");

        jLabel14.setText("Hobi");

        jLabel15.setText("Wali");

        jLabel16.setText("Alamat Wali");

        jLabel17.setText("Telepon Wali");

        jLabel18.setText("Tahun Masuk");

        tahunMasuk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Cari");

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tabelMhs.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMhs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton6)
                        .addGap(31, 31, 31)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(73, 73, 73)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(kdAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(namaAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(kdProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(namaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtNama)
                                            .addComponent(txtStambuk))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(67, 67, 67)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(kdKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tglLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtKota)
                                        .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t4Lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(kdProvinsi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(namaProvinsi))
                                                .addComponent(kdPos, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHandphone, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHobi, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtWali, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTeleponWali, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAlamatWali, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tahunMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel18)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSimpan)
                            .addGap(29, 29, 29)
                            .addComponent(btnEdit)
                            .addGap(43, 43, 43)
                            .addComponent(btnHapus)
                            .addGap(50, 50, 50)
                            .addComponent(btnBatal)
                            .addGap(50, 50, 50)
                            .addComponent(jButton5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(jButton5))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtStambuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(kdProvinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namaProvinsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(kdPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kdProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(namaProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kdAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(namaAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(txtHandphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(txtHobi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtWali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtAlamatWali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtTeleponWali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tahunMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t4Lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(tglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(kdKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String stb = txtStambuk.getText();
        String nm = txtNama.getText();
        String kodeProgramStudi = kdProdi.getSelectedItem().toString();
        String kodeAgama = kdAgama.getSelectedItem().toString();
        String tempatlahir = t4Lahir.getText();
        Date selectedDate = tglLahir.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);
        String jk = jenisKelamin.getText();
        String alamat = txtAlamat.getText();
        String kota = txtKota.getText();
        String kodeprovinsi = kdProvinsi.getSelectedItem().toString();
        String kodepos = kdPos.getText();
        String nomortelepon = txtTelepon.getText();
        String nomorhp = txtHandphone.getText();
        String hobimhs = txtHobi.getText();
        String walimhs = txtWali.getText();
        String alamatWali = txtAlamatWali.getText();
        String teleponWali = txtTeleponWali.getText();
        String tahunmasuk = tahunMasuk.getSelectedItem().toString();
        // Dapatkan waktu sekarang
        Date LastUpdate = new Date();
        // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
        SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        // Format waktu sekarang sesuai dengan pola yang telah ditentukan
        String formattedLastUpdate = formatLastUpdate.format(LastUpdate);
        String admin = "Admin";
        
         try {
            st = conn.createStatement();
            if(txtStambuk.getText().equals("") || txtNama.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                rs = st.executeQuery("SELECT * FROM biodata_mahasiswa where nim = '" + txtStambuk.getText() + "'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Prodi Sudah Ada!", "Data Duplikat", JOptionPane.WARNING_MESSAGE);                   
                }else{
                     String input = "INSERT INTO `biodata_mahasiswa` (`id`, `nim`, `nama`, `kode_program_studi`, "
                    + "`kode_agama`, `tempat_lahir`, `tanggal_lahir`, `jenis_kelamin`, "
                    + "`alamat`, `kota`, `kode_propinsi`, `kode_pos`, `telpon`, `handphone`, `hobi`, "
                    + "`wali`, `alamat_wali`, `telpon_wali`, `tahun_masuk`, `last_update`, `userid`) "
                    + "VALUES(NULL, '" + stb + "', '" + nm + "', '" + kodeProgramStudi + "', '"
                    + kodeAgama + "', '" + tempatlahir + "', '" + formattedDate + "', '" + jk + "', '"
                    + alamat + "', '" + kota + "', '" + kodeprovinsi + "', '" + kodepos + "', '" + nomortelepon + "', '"
                    + nomorhp + "', '" + hobimhs + "', '" + walimhs + "', '" + alamatWali + "', '" + teleponWali + "', '"
                    + tahunmasuk + "', '" + formattedLastUpdate + "', '" + admin + "')";
                    //st.executeUpdate(input);
                    PreparedStatement pst = conn.prepareStatement(input);
                    pst.execute();
                    JOptionPane.showMessageDialog(this, "Data Telah Terinput", "Info", JOptionPane.INFORMATION_MESSAGE);
                    TampilDataMhsPadaTabel();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace to the console
            JOptionPane.showMessageDialog(this, "Gagal Menyimpan: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        txtStambuk.setText(null);
        txtNama.setText(null);
        kdProdi.setSelectedItem("PILIH");
        kdAgama.setSelectedItem("PILIH");
        t4Lahir.setText(null);
        tglLahir.setDate(null);
        kdKelamin.setSelectedItem("PILIH");
        txtAlamat.setText(null);
        txtKota.setText(null);
        kdProvinsi.setSelectedItem("PILIH");
        kdPos.setText(null);
        txtTelepon.setText(null);
        txtHandphone.setText(null);
        txtHobi.setText(null);
        txtWali.setText(null);
        txtAlamatWali.setText(null);
        txtTeleponWali.setText(null);
        tahunMasuk.setSelectedItem("PILIH");
        namaProdi.setText(null);
        namaProvinsi.setText(null);
        jenisKelamin.setText(null);
        namaAgama.setText(null);
        btnSimpan.setEnabled(true);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtStambukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStambukActionPerformed
        // TODO add your handling code here:
        try {
            String Sql = "SELECT * FROM biodata_mahasiswa WHERE nim='" + txtStambuk.getText() + "'";
            st = conn.createStatement();
            rs = st.executeQuery(Sql);

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Stambuk Tersebut Sudah Ada. Silahkan Input STb Lain Atau Data Mau Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                String jk = rs.getString("jenis_kelamin");
                if (jk.equals("Pria")) {
                    jk = "P";
                }else{
                    jk="W";
                }

                String agama = rs.getString("kode_agama");
                String provinsi = rs.getString("kode_propinsi");
                btnSimpan.setEnabled(false);
                txtNama.setText(rs.getString("nama"));
                t4Lahir.setText(rs.getString("tempat_lahir"));
                tglLahir.setDate(rs.getDate("tanggal_lahir"));
                kdKelamin.setSelectedItem(jk);
                txtAlamat.setText(rs.getString("alamat"));
                txtKota.setText(rs.getString("kota"));
                kdPos.setText(rs.getString("kode_pos"));
                txtTelepon.setText(rs.getString("telpon"));
                txtHandphone.setText(rs.getString("handphone"));
                txtHobi.setText(rs.getString("hobi"));
                txtWali.setText(rs.getString("wali"));
                txtAlamatWali.setText(rs.getString("alamat_wali"));
                txtTeleponWali.setText(rs.getString("telpon_wali"));
                tahunMasuk.setSelectedItem(rs.getString("tahun_masuk"));
                kdProdi.setSelectedItem(rs.getString("kode_program_studi"));
                kdAgama.setSelectedItem(agama);
                kdProvinsi.setSelectedItem(provinsi);
            } else {
                btnSimpan.setEnabled(true);
                txtNama.requestFocus();
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal " + e.toString());
        } 
    }//GEN-LAST:event_txtStambukActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        CariDataMhs();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        TampilDataMhsPadaTabel();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        String stb = txtStambuk.getText();
        String nm = txtNama.getText();
        String kodeProgramStudi = kdProdi.getSelectedItem().toString();
        String kodeAgama = kdAgama.getSelectedItem().toString();
        String tempatlahir = t4Lahir.getText();
        Date selectedDate = tglLahir.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);
        String jk = jenisKelamin.getText();
        String alamat = txtAlamat.getText();
        String kota = txtKota.getText();
        String kodeprovinsi = kdProvinsi.getSelectedItem().toString();
        String kodepos = kdPos.getText();
        String nomortelepon = txtTelepon.getText();
        String nomorhp = txtHandphone.getText();
        String hobimhs = txtHobi.getText();
        String walimhs = txtWali.getText();
        String alamatWali = txtAlamatWali.getText();
        String teleponWali = txtTeleponWali.getText();
        String tahunmasuk = tahunMasuk.getSelectedItem().toString();
        // Dapatkan waktu sekarang
        Date LastUpdate = new Date();
        // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
        SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        // Format waktu sekarang sesuai dengan pola yang telah ditentukan
        String formattedLastUpdate = dateFormat.format(LastUpdate);
        String admin = "Admin";

        try {
            
            st = conn.createStatement();

            String Sql = "UPDATE biodata_mahasiswa SET "
                    + "nama = '" + nm + "', "
                    + "kode_program_studi = '" + kodeProgramStudi + "', "
                    + "kode_agama = '" + kodeAgama + "', "
                    + "tempat_lahir = '" + tempatlahir + "', "
                    + "tanggal_lahir = '" + formattedDate + "', "
                    + "jenis_kelamin = '" + jk + "', "
                    + "alamat = '" + alamat + "', "
                    + "kota = '" + kota + "', "
                    + "kode_propinsi = '" + kodeprovinsi + "', "
                    + "kode_pos = '" + kodepos + "', "
                    + "telpon = '" + nomortelepon + "', "
                    + "handphone = '" + nomorhp + "', "
                    + "hobi = '" + hobimhs + "', "
                    + "wali = '" + walimhs + "', "
                    + "alamat_wali = '" + alamatWali + "', "
                    + "telpon_wali = '" + teleponWali + "', "
                    + "tahun_masuk = '" + tahunmasuk + "', "
                    + "last_update = '" + formattedLastUpdate + "', "
                    + "userid = '" + admin + "' "
                    + "WHERE nim = '" + stb + "'";

            int AdaPerubahanRecord = st.executeUpdate(Sql);
            TampilDataMhsPadaTabel();

            
            if (AdaPerubahanRecord > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                btnHapus.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
    
           bersihkan();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi Gagal " + e.toString());
        }

        
    }//GEN-LAST:event_btnEditActionPerformed

    private void tabelMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMhsMouseClicked
        // TODO add your handling code here:  
        
        int baris = tabelMhs.rowAtPoint (evt.getPoint());
        String nim = tabelMhs.getValueAt(baris, 0).toString();
        txtStambuk.setText(nim);
        try {
            String Sql = "SELECT * FROM biodata_mahasiswa WHERE nim='" + txtStambuk.getText() + "'";
            st = conn.createStatement();
            rs = st.executeQuery(Sql);

            if (rs.next()) {
                String jk = rs.getString("jenis_kelamin");
                if (jk.equals("Pria")) {
                    jk = "P";
                }else{
                    jk="W";
                }

                String agama = rs.getString("kode_agama");
                String provinsi = rs.getString("kode_propinsi");
                btnSimpan.setEnabled(false);
                txtNama.setText(rs.getString("nama"));
                t4Lahir.setText(rs.getString("tempat_lahir"));
                tglLahir.setDate(rs.getDate("tanggal_lahir"));
                kdKelamin.setSelectedItem(jk);
                txtAlamat.setText(rs.getString("alamat"));
                txtKota.setText(rs.getString("kota"));
                kdPos.setText(rs.getString("kode_pos"));
                txtTelepon.setText(rs.getString("telpon"));
                txtHandphone.setText(rs.getString("handphone"));
                txtHobi.setText(rs.getString("hobi"));
                txtWali.setText(rs.getString("wali"));
                txtAlamatWali.setText(rs.getString("alamat_wali"));
                txtTeleponWali.setText(rs.getString("telpon_wali"));
                tahunMasuk.setSelectedItem(rs.getString("tahun_masuk"));
                kdProdi.setSelectedItem(rs.getString("kode_program_studi"));
                kdAgama.setSelectedItem(agama);
                kdProvinsi.setSelectedItem(provinsi);
            } else {
                btnSimpan.setEnabled(true);
                txtNama.requestFocus();
            }
        } catch (SQLException e) {
            System.out.println("Koneksi gagal " + e.toString());
        } 

    }//GEN-LAST:event_tabelMhsMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String stb = txtStambuk.getText();
        String nm = txtNama.getText();
        String kodeProgramStudi = kdProdi.getSelectedItem().toString();
        String kodeAgama = kdAgama.getSelectedItem().toString();
        String tempatlahir = t4Lahir.getText();
        Date selectedDate = tglLahir.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);
        String jk = jenisKelamin.getText();
        String alamat = txtAlamat.getText();
        String kota = txtKota.getText();
        String kodeprovinsi = kdProvinsi.getSelectedItem().toString();
        String kodepos = kdPos.getText();
        String nomortelepon = txtTelepon.getText();
        String nomorhp = txtHandphone.getText();
        String hobimhs = txtHobi.getText();
        String walimhs = txtWali.getText();
        String alamatWali = txtAlamatWali.getText();
        String teleponWali = txtTeleponWali.getText();
        String tahunmasuk = tahunMasuk.getSelectedItem().toString();
        // Dapatkan waktu sekarang
        Date LastUpdate = new Date();
        // Buat objek SimpleDateFormat dengan pola "yyyy-MM-dd HH:mm:ss.SSSSSS"
        SimpleDateFormat formatLastUpdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        // Format waktu sekarang sesuai dengan pola yang telah ditentukan
        String formattedLastUpdate = dateFormat.format(LastUpdate);
        String admin = "Admin";

        try {
            
            st = conn.createStatement();

            String Sql = "delete from biodata_mahasiswa WHERE nim = '" + stb + "'";

            int AdaPerubahanRecord = st.executeUpdate(Sql);
            TampilDataMhsPadaTabel();

            
            if (AdaPerubahanRecord > 0) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Hapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Di Edit", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
    
           bersihkan();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi Gagal " + e.toString());
        }

        
    }//GEN-LAST:event_btnHapusActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(biodatamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(biodatamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(biodatamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(biodatamahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new biodatamahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenisKelamin;
    private javax.swing.JComboBox<String> kdAgama;
    private javax.swing.JComboBox<String> kdKelamin;
    private javax.swing.JTextField kdPos;
    private javax.swing.JComboBox<String> kdProdi;
    private javax.swing.JComboBox<String> kdProvinsi;
    private javax.swing.JTextField namaAgama;
    private javax.swing.JTextField namaProdi;
    private javax.swing.JTextField namaProvinsi;
    private javax.swing.JTextField t4Lahir;
    private javax.swing.JTable tabelMhs;
    private javax.swing.JComboBox<String> tahunMasuk;
    private com.toedter.calendar.JDateChooser tglLahir;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtAlamatWali;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHandphone;
    private javax.swing.JTextField txtHobi;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStambuk;
    private javax.swing.JTextField txtTelepon;
    private javax.swing.JTextField txtTeleponWali;
    private javax.swing.JTextField txtWali;
    // End of variables declaration//GEN-END:variables
}
