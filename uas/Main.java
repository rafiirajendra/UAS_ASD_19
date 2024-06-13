package uas;

import java.util.Scanner;

public class Main {
    public static BarangRental[] daftarBarangRental = {
            new BarangRental("S 4567 YV", "Honda Beat", "Motor", 2017, 10000),
            new BarangRental("N 4511 VS", "Honda Vario", "Motor", 2018, 10000),
            new BarangRental("N 1543 AA", "Toyota Yaris", "Mobil", 2022, 30000),
            new BarangRental("AB 4321 A", "Toyota Innova", "Mobil", 2019, 60000),
            new BarangRental("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 25000)
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampilkan Seluruh transaksi");
            System.out.println("4. Urutkan Transaksi urut no TNKB");
            System.out.println("5. Keluar");

            System.out.print("Pilih(1-5): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanKendaraan();
                    break;
                case 2:
                    peminjaman();
                    break;
                case 3:

                    break;
                case 4:

                    break;

                case 5:
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
        System.out.printf("%-15s %-25s %-10s %-5s %s\n", "No TNKB", "Nama Kendaraan", "Jenis", "Tahun", "Biaya");
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
        scanner.nextLine();
        System.out.print("Masukkan No TNKB: ");
        scanner.nextLine();
        System.out.print("Masukkan lama pinjam: ");
        scanner.nextInt();
        System.out.print("Apakah member (ya/tidak): ");
        scanner.next();

        System.out.printf("%-5s %-15s %-25s %-25s %-10s %-15s\n", "Kode", "No TNKB", "Nama Barang", "Nama Peminjam", "Lama Pinjam", "Total Biaya");
        
        System.out.printf("%-5s %-15s %-25s %-25s %-10d %-15d\n", 0, scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextInt());
        
        
    }
}
