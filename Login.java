import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public boolean authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = Connecter.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Login berhasil untuk user: " + username);
                    return true;
                } else {
                    System.out.println("Username atau password salah.");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat login.");
            return false;
        }
    }
}
