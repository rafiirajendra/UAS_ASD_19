package uas;
public class BarangRental {
    String noTNKB, namaKendaraan, jenisKendaraan;
    int tahun, biayaSewa;

    BarangRental(String noTNKB, String namaKendaraan, String enisKendaraan, int tahun, int biayaSewa){
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = enisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
    }
}