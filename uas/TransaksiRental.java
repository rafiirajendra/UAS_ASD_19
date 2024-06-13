package uas;

public class TransaksiRental {
    int kodeTransaksi;
    String namaPeminjam;
    int lamaPinjam;
    double totalBiaya;

    BarangRental br = new BarangRental(namaPeminjam, namaPeminjam, namaPeminjam, lamaPinjam, kodeTransaksi);
    TransaksiRental(int kodeTransaksi, String namaPeminjam, int lamaPinjam, double totalBiaya){
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.totalBiaya = totalBiaya;
    }

    
}
