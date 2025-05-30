import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class Connecter {
     private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASS = dotenv.get("DB_PASS");
   
    // Fungsi static yang mengembalikan objek Connection
    public static Connection getConnection() {
        try {
            // Mencoba membuka koneksi ke database menggunakan DriverManager
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Koneksi berhasil!");
            return conn; // Mengembalikan objek Connection jika sukses
        } catch (Exception e) {
            // Menangani error jika koneksi gagal
            e.printStackTrace();
            System.out.println("Koneksi gagal!");
            return null; // Mengembalikan null jika gagal
        }
    }
}
