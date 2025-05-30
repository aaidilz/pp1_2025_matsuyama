import java.time.LocalDate;

public class ServiceNode {
    public int id;
    public String customerName;
    public String deviceType;
    public String problemDescription;
    public LocalDate serviceDate;
    public double cost;
    public String status; // 'pending', 'on_going', 'completed'
    public int userId;
    public ServiceNode next;

    // Constructor for new service (without ID)
    public ServiceNode(String customerName, String deviceType, String problemDescription, double cost) {
        this.customerName = customerName;
        this.deviceType = deviceType;
        this.problemDescription = problemDescription;
        this.cost = cost;
        this.status = "pending"; // Default status
        this.serviceDate = LocalDate.now(); // Set current date
        this.userId = 1; // Default user ID, bisa disesuaikan
    }

    // Constructor with all parameters (for loading from database)
    public ServiceNode(int id, String customerName, String deviceType, String problemDescription,
            LocalDate serviceDate, double cost, String status, int userId) {
        this.id = id;
        this.customerName = customerName;
        this.deviceType = deviceType;
        this.problemDescription = problemDescription;
        this.serviceDate = serviceDate;
        this.cost = cost;
        this.status = status;
        this.userId = userId;
    }

    // Constructor with status parameter (for updates)
    public ServiceNode(String customerName, String deviceType, String problemDescription,
            double cost, String status) {
        this.customerName = customerName;
        this.deviceType = deviceType;
        this.problemDescription = problemDescription;
        this.cost = cost;
        this.status = status;
        this.serviceDate = LocalDate.now();
        this.userId = 1; // Default user ID
    }

    public String toString() {
        return "ID: " + id + "\n" +
                "Nama: " + customerName + "\n" +
                "Perangkat: " + deviceType + "\n" +
                "Masalah: " + problemDescription + "\n" +
                "Tanggal: " + serviceDate + "\n" +
                "Biaya: Rp" + cost + "\n" +
                "Status: " + status + "\n";
    }
}
