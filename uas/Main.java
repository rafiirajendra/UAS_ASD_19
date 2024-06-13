package uas;

import java.util.Scanner;

public class Main {
    public static BarangRental[] daftarBarangRental = {
            new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 25000),
            new BarangRental("N 4511 VS", "Honda Vario", "Motor", 2018, 25000),
            new BarangRental("N 1543 AA", "Toyota Yaris", "Mobil", 2022, 40000),
            new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 40000),
            new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 40000)
    };

    public static Transaksi[] daftarTransaksi = new Transaksi[100]; 

    public static int jumlahTransaksi = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampilkan Seluruh transaksi");
            System.out.println("4. Keluar");

            System.out.print("Pilih(1-4): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanKendaraan();
                    break;
                case 2:
                    peminjaman();
                    break;
                case 3:
                    tampilkanTransaksi();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }

    public static void tampilkanKendaraan() {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Kendaraan Rental Serba Serbi");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.printf("%-15s %-25s %-10s %-5s %s\n", "No TNKB", "Nama Kendaraan", "Jenis", "Tahun", "Biaya/jam");
        for (int i = 0; i < daftarBarangRental.length; i++) {
            System.out.printf("%-15s %-25s %-10s %-5d %d\n", daftarBarangRental[i].getNoTNKB(), daftarBarangRental[i].getNamaKendaraan(),
                    daftarBarangRental[i].getJenisKendaraan(), daftarBarangRental[i].getTahun(), daftarBarangRental[i].getBiayaSewa());
        }
    }

    public static void peminjaman() {
        System.out.println("---------------------");
        System.out.println("Masukkan Data Pinjam");
        System.out.println("---------------------");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Peminjam: ");
        String namaPeminjam = scanner.nextLine();
        System.out.print("Masukkan No TNKB: ");
        String noTNKB = scanner.nextLine();

        BarangRental barangDipinjam = null;
        for (BarangRental barang : daftarBarangRental) {
            if (barang.getNoTNKB().equalsIgnoreCase(noTNKB)) {
                barangDipinjam = barang;
                break;
            }
        }

        if (barangDipinjam == null) {
            System.out.println("Kendaraan dengan No TNKB tersebut tidak ditemukan.");
            return;
        }

        if (barangDipinjam.isSedangDipinjam()) {
            System.out.println("Kendaraan ini sedang dipinjam oleh orang lain.");
            return;
        }

        System.out.print("Masukkan lama pinjam (jam): ");
        int lamaPinjam = scanner.nextInt();

        int biayaPerJam = barangDipinjam.getBiayaSewa();
        int totalBiaya = biayaPerJam * lamaPinjam;

        System.out.print("Apakah member (ya/tidak): ");
        String memberInput = scanner.next();
        boolean isMember;
        if (memberInput.equalsIgnoreCase("ya")) {
            isMember = true;
            totalBiaya -= 25000; 
        }

        if (lamaPinjam >= 48 && lamaPinjam <= 78) {
            totalBiaya -= (0.1 * totalBiaya); 
        } else if (lamaPinjam > 78) {
            totalBiaya -= (0.2 * totalBiaya);
        }

        Transaksi transaksi = new Transaksi(noTNKB, barangDipinjam.getNamaKendaraan(), namaPeminjam, lamaPinjam, totalBiaya, isMember);

        barangDipinjam.setSedangDipinjam(true);

        daftarTransaksi[jumlahTransaksi] = transaksi;
        jumlahTransaksi++;

        System.out.println("\nData Peminjaman Telah Disimpan:");
        System.out.println("------------------------------");
        System.out.printf("%-15s %-25s %-20s %-15s %-10s %s\n", "No TNKB", "Nama Kendaraan", "Nama Peminjam", "Lama Pinjam", "Total Biaya", "Member");
        System.out.printf("%-15s %-25s %-20s %-15d %d %s\n", transaksi.getNoTNKB(), transaksi.getNamaKendaraan(),
                transaksi.getNamaPeminjam(), transaksi.getLamaPinjam(), transaksi.getTotalBiaya(), transaksi.isMember() ? "Ya" : "Tidak");
    }

    public static void tampilkanTransaksi() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Seluruh Transaksi Peminjaman Kendaraan");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("%-15s %-25s %-20s %-15s %-10s %s\n", "No TNKB", "Nama Kendaraan", "Nama Peminjam", "Lama Pinjam", "Total Biaya", "Member");
        for (int i = 0; i < jumlahTransaksi; i++) {
            Transaksi transaksi = daftarTransaksi[i];
            System.out.printf("%-15s %-25s %-20s %-15d %d %s\n", transaksi.getNoTNKB(), transaksi.getNamaKendaraan(),
                    transaksi.getNamaPeminjam(), transaksi.getLamaPinjam(), transaksi.getTotalBiaya(), transaksi.isMember() ? "Ya" : "Tidak");
        }
    }
}
