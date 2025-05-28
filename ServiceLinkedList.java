public class ServiceLinkedList {
    public ServiceNode head;

    public ServiceLinkedList() {
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

        System.out.println("Silakan pilih opsi (1-7):");

        // input pilihan dari pengguna
        // di sini bisa ditambahkan metode untuk menangani input untuk setiap opsi
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Implementasi untuk mencari data servis
                System.out.println("Fitur Cari data Servis belum diimplementasikan.");
                break;
            case 2:
                // Implementasi untuk menampilkan semua data servis
                System.out.println("Fitur Tampilkan Semua data Servis belum diimplementasikan.");
                break;
            case 3:
                // Implementasi untuk memfilter data servis
                System.out.println("Fitur Filter data Servis belum diimplementasikan.");
                break;
            case 4: 
                // Implementasi untuk menambah data servis
                System.out.println("Fitur Tambah data Servis belum diimplementasikan.");
                break;
            case 5:
                // Implementasi untuk mengubah data servis
                System.out.println("Fitur Ubah data Servis belum diimplementasikan.");
                break;
            case 6:
                // Implementasi untuk menghapus data servis
                System.out.println("Fitur Hapus data Servis belum diimplementasikan.");
                break;
            case 7:
                // Implementasi untuk keluar dari program
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-7.");
                break;
        }
        scanner.close();
    }
}
