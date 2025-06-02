import java.util.Scanner;

public class ServiceApp {

    public static void main(String[] args) {
        LoginMain loginMain = new LoginMain();
        ServiceMain serviceMain = new ServiceMain();

        // Proses login
        boolean loginSuccess = loginMain.login();

        // Jika login berhasil, tampilkan menu utama
        if (loginSuccess) {
            // Set user ID yang login ke ServiceMain
            int userId = loginMain.getLoggedInUserId();
            serviceMain.setLoggedInUserId(userId);

            // Tampilkan menu utama
            serviceMain.Banner();
            serviceMain.closeScanner(); // Tutup scanner setelah selesai
        } else {
            System.out.println("Program berhenti karena login gagal.");
        }
    }
}
