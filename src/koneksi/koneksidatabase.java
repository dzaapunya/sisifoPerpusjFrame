package koneksi;
import java.sql.*;
import javax.swing.JOptionPane;

public class koneksidatabase {
    Connection conn;
    public static Connection Konek(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/database_perpustakaan", "root", "");
           // JOptionPane.showMessageDialog(null, "Koneksi Berhasil!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!", "Warning", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}