import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        ServiceData serviceData = new ServiceData();

        boolean isLoggedIn = false;

        System.out.println("=================================");
        System.out.println("    SISTEM JASA SERVIS ELEKTRONIK");
        System.out.println("=================================\n");

        // Mekanisme login
        while (!isLoggedIn) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();

            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            isLoggedIn = login.authenticate(username, password);

            if (!isLoggedIn) {
                System.out.println("Login gagal. Coba lagi atau tekan 'q' untuk keluar.");
                System.out.print("Input: ");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Keluar dari sistem.");
                    scanner.close();
                    return;
                }
            }
        }

        System.out.println("Login berhasil. Selamat datang di sistem servis!\n");

        // Menu utama setelah login
        while (true) {
            System.out.println("PENCATATAN JASA SERVIS ELEKTRONIK");
            System.out.println("=================================");
            System.out.println("1. Cari data Servis");
            System.out.println("2. Tampilkan Semua data Servis");
            System.out.println("3. Filter data Servis");
            System.out.println("4. Tambah data Servis");
            System.out.println("5. Ubah data Servis");
            System.out.println("6. Hapus data Servis");
            System.out.println("=================================");
            System.out.println("7. Tampilkan data Servis yang belum disimpan");
            System.out.println("8. Save semua perubahan ke database");
            System.out.println("=================================");
            System.out.println("9. Keluar");
            System.out.println("=================================");
            System.out.print("Pilih menu: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("⚠️ Masukkan angka yang valid!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("Fitur cari belum diimplementasi.");
                    break;
                case 2:
                    System.out.println("Fitur tampil semua belum diimplementasi.");
                    break;
                case 3:
                    System.out.println("Fitur filter belum diimplementasi.");
                    break;
                case 4:
                    serviceData.tambahData(scanner);
                    break;
                case 5:
                    System.out.println("Fitur ubah belum diimplementasi.");
                    break;
                case 6:
                    System.out.println("Fitur hapus belum diimplementasi.");
                    break;
                case 7:
                    serviceData.tampilkanDataSementara();
                    break;
                case 8:
                    serviceData.simpanKeDatabase();
                    break;
                case 9:
                    System.out.println("Sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

            System.out.println("\nTekan Enter untuk melanjutkan...");
            scanner.nextLine();
        }
    }
}
