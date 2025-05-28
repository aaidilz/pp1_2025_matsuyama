public class ServiceNode {
    private String namaPelanggan, namaBarang, kerusakan, status;
    private double biaya;
    private ServiceNode next;

    public ServiceNode(String namaPelanggan, String namaBarang, String kerusakan, double biaya) {
        setNamaPelanggan(namaPelanggan);
        setNamaBarang(namaBarang);
        setKerusakan(kerusakan);
        this.status = "Pending";
        setBiaya(biaya);
    }

    public ServiceNode(String namaPelanggan , String namaBarang, String kerusakan, double biaya, String status) {
        setNamaPelanggan(namaPelanggan);
        setNamaBarang(namaBarang);
        setKerusakan(kerusakan);
        setStatus(status);
        setBiaya(biaya);
    }

    public String getNama() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
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

    public ServiceNode getNext() {
        return next;
    }

    public void setNext(ServiceNode next) {
        this.next = next;
    }

}