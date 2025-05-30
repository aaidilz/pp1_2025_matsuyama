import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginMain {

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        boolean isLoggedIn = loginInput(username, password);

        if (isLoggedIn) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }

    public static boolean loginInput(String usernameInput, String passwordInput) {
        try {
            Connection conn = Connecter.getConnection();

            if (conn == null) {
                System.out.println("Tidak dapat terhubung ke database.");
                return false;
            }

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usernameInput);
            stmt.setString(2, passwordInput);

            ResultSet rs = stmt.executeQuery();

            boolean success = rs.next(); // true jika user ditemukan

            rs.close();
            stmt.close();
            conn.close(); // selalu tutup koneksi

            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
