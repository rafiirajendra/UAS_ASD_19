package uas;

public class Transaksi {
        private String noTNKB;
        private String namaKendaraan;
        private String namaPeminjam;
        private int lamaPinjam;
        private int totalBiaya;
        private boolean member;
    
        public Transaksi(String noTNKB, String namaKendaraan, String namaPeminjam, int lamaPinjam, int totalBiaya, boolean member) {
            this.noTNKB = noTNKB;
            this.namaKendaraan = namaKendaraan;
            this.namaPeminjam = namaPeminjam;
            this.lamaPinjam = lamaPinjam;
            this.totalBiaya = totalBiaya;
            this.member = member;
        }
    
        public String getNoTNKB() {
            return noTNKB;
        }
    
        public String getNamaKendaraan() {
            return namaKendaraan;
        }
    
        public String getNamaPeminjam() {
            return namaPeminjam;
        }
    
        public int getLamaPinjam() {
            return lamaPinjam;
        }
    
        public int getTotalBiaya() {
            return totalBiaya;
        }
    
        public boolean isMember() {
            return member;
        }
    }
