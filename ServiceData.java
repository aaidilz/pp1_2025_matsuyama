import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceData {
    private ServiceNode head;

    // Tambah data ke linked list (input dari Scanner)
    public void tambahData(Scanner scanner) {
        System.out.println("Masukkan nama pelanggan:");
        String nama = scanner.nextLine();

        System.out.println("Masukkan jenis perangkat:");
        String perangkat = scanner.nextLine();

        System.out.println("Masukkan deskripsi masalah:");
        String masalah = scanner.nextLine();

        System.out.println("Masukkan biaya servis:");
        double biaya = 0;
        while(true) {
            try {
                biaya = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka valid untuk biaya servis:");
            }
        }

        // Buat node baru
        ServiceNode newNode = new ServiceNode(nama, perangkat, masalah, biaya);
        newNode.id = generateNewId();

        // Tambahkan node ke akhir linked list
        if (head == null) {
            head = newNode;
        } else {
            ServiceNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        System.out.println("✅ Data servis berhasil ditambahkan ke daftar sementara.");
    }

    // Generate ID incremental dari linked list
    private int generateNewId() {
        int maxId = 0;
        ServiceNode current = head;
        while (current != null) {
            if (current.id > maxId) maxId = current.id;
            current = current.next;
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
            conn.setAutoCommit(false);  // agar batch transaction

            String sql = "INSERT INTO services (customer_name, device_type, problem_description, service_date, cost, status, user_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ServiceNode current = head;
            while (current != null) {
                stmt.setString(1, current.customerName);
                stmt.setString(2, current.deviceType);
                stmt.setString(3, current.problemDescription);
                stmt.setDate(4, Date.valueOf(current.serviceDate));
                stmt.setDouble(5, current.cost);
                stmt.setString(6, current.status);
                stmt.setInt(7, current.userId);

                stmt.addBatch();
                current = current.next;
            }

            int[] results = stmt.executeBatch();
            conn.commit();

            System.out.println("✅ Berhasil menyimpan " + results.length + " data servis ke database.");

            // Kosongkan linked list setelah simpan
            head = null;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("❌ Gagal menyimpan data ke database.");
        }
    }

    // Method tambahan untuk testing: tampilkan data di linked list
    public void tampilkanDataSementara() {
        if (head == null) {
            System.out.println("Tidak ada data sementara.");
            return;
        }

        ServiceNode current = head;
        System.out.println("Data sementara di linked list:");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
