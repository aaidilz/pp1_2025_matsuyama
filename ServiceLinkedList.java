import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceLinkedList {
    private ServiceNode head;
    private int loggedInUserId = 1; // Default user ID

    // Setter untuk user ID
    public void setLoggedInUserId(int userId) {
        this.loggedInUserId = userId;
    }

    // Tambah data ke linked list (input dari Scanner)
    public void tambahData(Scanner scanner) {
        System.out.println("\n======= Tambah data Servis =======");
        System.out.println("Masukkan nama pelanggan:");
        String nama = scanner.nextLine();

        System.out.println("Masukkan jenis perangkat:");
        String perangkat = scanner.nextLine();

        System.out.println("Masukkan deskripsi masalah:");
        String masalah = scanner.nextLine();

        System.out.println("Masukkan biaya servis:");
        double biaya = 0;
        while (true) {
            try {
                biaya = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka valid untuk biaya servis:");
            }
        }

        // Buat node baru
        ServiceNode newNode = new ServiceNode(nama, perangkat, masalah, biaya);
        newNode.setId(generateNewId());
        newNode.setUserId(loggedInUserId); // Set user ID dari user yang login

        // Tambahkan node ke akhir linked list
        if (head == null) {
            head = newNode;
        } else {
            ServiceNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        System.out.println("✅ Data servis berhasil ditambahkan ke daftar sementara.");
    }

    // Generate ID incremental dari linked list
    private int generateNewId() {
        int maxId = 0;
        ServiceNode current = head;
        while (current != null) {
            if (current.getId() > maxId)
                maxId = current.getId();
            current = current.getNext();
        }
        return maxId + 1;
    }

    // Simpan seluruh linked list ke database (batch insert)
    public void simpanKeDatabase() {
        if (head == null) {
            System.out.println("⚠️ Tidak ada data untuk disimpan.");
            return;
        }

        try (Connection conn = Connecter.getConnection()) {
            if (conn == null) {
                System.out.println("❌ Tidak dapat terhubung ke database.");
                return;
            }

            conn.setAutoCommit(false); // agar batch transaction

            String sql = "INSERT INTO services (customer_name, device_type, problem_description, service_date, cost, status, user_id) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ServiceNode current = head;
            int count = 0;

            while (current != null) {
                stmt.setString(1, current.getCustomerName());
                stmt.setString(2, current.getDeviceType());
                stmt.setString(3, current.getProblemDescription());
                stmt.setDate(4, Date.valueOf(current.getServiceDate()));
                stmt.setDouble(5, current.getCost());
                stmt.setString(6, current.getStatus());
                stmt.setInt(7, current.getUserId());

                stmt.addBatch();
                current = current.getNext();
                count++;
            }

            int[] results = stmt.executeBatch();
            conn.commit();

            System.out.println("✅ Berhasil menyimpan " + count + " data servis ke database.");

            // Kosongkan linked list setelah simpan
            head = null;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Gagal menyimpan data ke database: " + e.getMessage());
        }
    }

    // Method tambahan untuk testing: tampilkan data di linked list
    public void tampilkanDataSementara() {
        if (head == null) {
            System.out.println("Tidak ada data sementara.");
            return;
        }

        ServiceNode current = head;
        System.out.println("\n======= Data Servis Sementara =======");
        int count = 0;
        while (current != null) {
            count++;
            System.out.println("Data #" + count);
            System.out.println(current);
            System.out.println("-----------------------------------");
            current = current.getNext();
        }
        System.out.println("Total: " + count + " data");
    }

    // Method untuk menghapus data berdasarkan pilihan user
    public void hapusData(Scanner scanner) {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        System.out.println("\n======= Hapus data Servis =======");
        System.out.println("1. Hapus berdasarkan ID");
        System.out.println("2. Hapus semua");
        System.out.print("Pilih (1/2): ");
        String pilihan = scanner.nextLine();

        if (pilihan.equals("1")) {
            hapusAtIndex(scanner);
        } else if (pilihan.equals("2")) {
            head = null;
            System.out.println("Semua data berhasil dihapus.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Method untuk menghapus data berdasarkan index
    public void hapusAtIndex(Scanner scanner) {
        int total = size();
        if (total == 0) {
            System.out.println("Tidak ada data.");
            return;
        }

        tampilkanDataSementara();
        System.out.print("Masukkan ID data yang ingin dihapus (1 - " + total + "): ");

        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (id < 1 || id > total) {
                System.out.println("ID tidak valid.");
                return;
            }

            if (id == 1) {
                ServiceNode deleted = head;
                head = head.getNext();
                System.out.println("Data '" + deleted.getCustomerName() + "' berhasil dihapus.");
            } else {
                ServiceNode current = head;
                for (int i = 0; i < id - 2; i++) {
                    current = current.getNext();
                }
                ServiceNode deleted = current.getNext();
                current.setNext(current.getNext().getNext());
                System.out.println("Data '" + deleted.getCustomerName() + "' berhasil dihapus.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka.");
        }
    }

    // Method untuk menghitung ukuran linked list
    public int size() {
        int count = 0;
        ServiceNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
