import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static final String DB_URL = "jdbc:mysql://pongo.kencang.com/academyc_tubes_pp";
    private static final String username = "academyc_root_pp";
    private static final String password = "Langkahpemula1#";
   
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Koneksi berhasil!");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Koneksi gagal!");
            return null;
        }
    }
}
