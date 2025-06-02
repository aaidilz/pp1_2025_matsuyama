import java.util.Scanner;

public class ServiceMain {
    private ServiceLinkedList serviceList;
    private Scanner scanner;
    private int loggedInUserId = 1; // Default user ID, bisa diubah setelah login berhasil

    public ServiceMain() {
        this.serviceList = new ServiceLinkedList();
        this.scanner = new Scanner(System.in);
    }

    public void setLoggedInUserId(int userId) {
        this.loggedInUserId = userId;
        // Juga set user ID ke ServiceLinkedList
        serviceList.setLoggedInUserId(userId);
    }

    public void Banner() {
        boolean running = true;

        while (running) {
            System.out.println("\nPENCATATAN JASA SERVIS ELEKTRONIK");
            System.out.println("=================================");
            System.out.println("1. Cari data Servis");
            System.out.println("2. Tampilkan Semua data Servis");
            System.out.println("3. Filter data Servis");
            System.out.println("4. Tambah data Servis");
            System.out.println("5. Ubah data Servis");
            System.out.println("6. Hapus data Servis");
            System.out.println("7. Simpan data ke Database");
            System.out.println("8. Keluar");
            System.out.println("================================= \n");

            System.out.print("Silakan pilih opsi (1-8): ");
            int choice = -1;

            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                } else {
                    System.out.println("Input tidak valid. Harus angka 1-8.");
                    scanner.nextLine(); // Membersihkan buffer
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.println("Fitur Cari data Servis belum diimplementasikan.");
                        break;
                    case 2:
                        // Menampilkan semua data servis
                        serviceList.tampilkanDataSementara();
                        break;
                    case 3:
                        System.out.println("Fitur Filter data Servis belum diimplementasikan.");
                        break;
                    case 4:
                        // Tambah data servis
                        serviceList.tambahData(scanner);
                        break;
                    case 5:
                        System.out.println("Fitur Ubah data Servis belum diimplementasikan.");
                        break;
                    case 6:
                        // Hapus data servis
                        serviceList.hapusData(scanner);
                        break;
                    case 7:
                        // Simpan data ke database
                        serviceList.simpanKeDatabase();
                        break;
                    case 8:
                        System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                        running = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-8.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input: " + e.getMessage());
                scanner.nextLine(); // Membersihkan buffer
            }
        }
    }

    // Method untuk menutup scanner ketika aplikasi selesai
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
