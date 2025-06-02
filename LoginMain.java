import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginMain {
    private int loggedInUserId = -1;

    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        boolean loginSuccess = false;
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS && !loginSuccess) {
            System.out.println("\n===== LOGIN SISTEM =====");
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            loginSuccess = loginInput(username, password);

            if (loginSuccess) {
                System.out.println("Login berhasil!");
            } else {
                attempts++;
                System.out.println("Login gagal. Username atau password salah.");
                System.out.println("Percobaan ke-" + attempts + " dari " + MAX_ATTEMPTS);

                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Silakan coba lagi.");
                }
            }
        }

        return loginSuccess;
    }

    public boolean loginInput(String usernameInput, String passwordInput) {
        try {
            Connection conn = Connecter.getConnection();

            if (conn == null) {
                System.out.println("Tidak dapat terhubung ke database.");
                return false;
            }

            String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usernameInput);
            stmt.setString(2, passwordInput);

            ResultSet rs = stmt.executeQuery();

            boolean success = rs.next(); // true jika user ditemukan

            if (success) {
                loggedInUserId = rs.getInt("id");
            }

            rs.close();
            stmt.close();
            conn.close(); // selalu tutup koneksi

            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getLoggedInUserId() {
        return loggedInUserId;
    }
}
