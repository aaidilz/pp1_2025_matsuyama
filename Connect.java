
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    public static void main(String[] args) {
    final String DB_URL = "jdbc:mysql://pongo.kencang.com/academyc_tubes_pp";
    final String username = "academyc_root_pp";
    final String password = "Langkahpemula1#";

    Connection conn= null;
    Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, username, password);
            conn.setAutoCommit(false); // Disable auto-commit mode
            System.out.println("Koneksi Berhasil");

            // stmt = conn.createStatement();
            // String sql ="INSERT INTO users (id_user, nama, pass)"
            //             +"VALUES ('00001', 'admin', 'admin')";
            //  stmt.executeUpdate(sql);
            //  conn.commit(); // Commit the transaction
            // System.out.println("Data berhasil ditambahkan ke tabel users");
        } catch (Exception e) {
            // if (conn != null) {
            //     try {
            //         conn.rollback(); // Rollback the transaction on error
            //         System.out.println("Transaksi dibatalkan");
            //     } catch (Exception rollbackEx) {
            //         rollbackEx.printStackTrace();
            //     }
            // }
            e.printStackTrace();
        }

        try {
            if (stmt != null) 
                stmt.close();
            if (conn != null) 
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
