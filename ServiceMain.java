public class ServiceMain {
    public ServiceNode head;

    public ServiceMain() {
        this.head = null;
    }

    public void Banner() {
        System.out.println("PENCATATAN JASA SERVIS ELEKTRONIK");
        System.out.println("=================================");
    
        System.out.println("1. Cari data Servis");
        System.out.println("2. Tampilkan Semua data Servis");
        System.out.println("3. Filter data Servis");
        System.out.println("4. Tambah data Servis");
        System.out.println("5. Ubah data Servis");
        System.out.println("6. Hapus data Servis");
        System.out.println("7. Keluar");

        System.out.println("================================= \n");

        // input pilihan dari pengguna
        // di sini bisa ditambahkan metode untuk menangani input untuk setiap opsi
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = -1;

        try {
            System.out.print("Silakan pilih opsi (1-7): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Input tidak valid. Harus angka 1-7.");
                scanner.next(); // Buang input yang salah
                return;
            }

            switch (choice) {
                case 1:
                    System.out.println("Fitur Cari data Servis belum diimplementasikan.");
                    break;
                case 2:
                    System.out.println("Fitur Tampilkan Semua data Servis belum diimplementasikan.");
                    break;
                case 3:
                    System.out.println("Fitur Filter data Servis belum diimplementasikan.");
                    break;
                case 4:
                    System.out.println("Fitur Tambah data Servis belum diimplementasikan.");
                    break;
                case 5:
                    System.out.println("Fitur Ubah data Servis belum diimplementasikan.");
                    break;
                case 6:
                    System.out.println("Fitur Hapus data Servis belum diimplementasikan.");
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-7.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input: " + e.getMessage());
        }
    scanner.close(); 
    }
}