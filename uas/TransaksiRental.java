package uas;

public class TransaksiRental {
    private static int counter = 1;

    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private BarangRental barangRental;

    public TransaksiRental(String namaPeminjam, int lamaPinjam, BarangRental barangRental) {
        this.kodeTransaksi = counter++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.barangRental = barangRental;
        this.totalBiaya = hitungTotalBiaya();
    }

    private double hitungTotalBiaya() {
        return lamaPinjam * barangRental.getBiayaSewa();
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public BarangRental getBarangRental() {
        return barangRental;
    }
}
