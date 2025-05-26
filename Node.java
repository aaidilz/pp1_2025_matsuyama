public class Node {
    private String nama, nama_barang, kerusakan, status;
    private double biaya;
    private Node next;

    public Node(String nama, String nama_barang, String kerusakan, double biaya) {
        this.nama = nama;
        this.nama_barang = nama_barang;
        this.kerusakan = kerusakan;
        this.status = "Pending";
        this.biaya = biaya;
    }

    public Node(String nama, String nama_barang, String kerusakan, double biaya, String status) {
        this.nama = nama;
        this.nama_barang = nama_barang;
        this.kerusakan = kerusakan;
        this.status = status;
        this.biaya = biaya;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getKerusakan() {
        return kerusakan;
    }

    public void setKerusakan(String kerusakan) {
        this.kerusakan = kerusakan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}