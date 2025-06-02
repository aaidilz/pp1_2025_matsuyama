import java.time.LocalDate;

public class ServiceNode {
    private int id;
    private String customerName;
    private String deviceType;
    private String problemDescription;
    private LocalDate serviceDate;
    private double cost;
    private String status; // 'pending', 'on_going', 'completed'
    private int userId;
    private ServiceNode next;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ServiceNode getNext() {
        return next;
    }

    public void setNext(ServiceNode next) {
        this.next = next;
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
