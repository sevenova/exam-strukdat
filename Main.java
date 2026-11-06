/** Simulasi navigasi riwayat kunjungan pasien. */
public class Main {
    public static void main(String[] args) {
        RiwayatKunjungan riwayat = new RiwayatKunjungan();
        System.out.println("=== SIMULASI RIWAYAT KUNJUNGAN PASIEN: Budi Santoso ===\n");

        String[] data = {
            "05-01-2026 | Demam & batuk | Resep: Paracetamol 500mg",
            "12-02-2026 | Kontrol batuk | Resep: Ambroxol 30mg",
            "20-03-2026 | Nyeri lambung | Resep: Omeprazole 20mg",
            "15-04-2026 | Cek tekanan darah | 130/85 mmHg, edukasi diet"
        };

        // 1) Tambah 4 kunjungan
        for (int i = 0; i < data.length; i++) {
            System.out.println("[Langkah " + (i + 1) + "] tambahKunjungan()");
            riwayat.tambahKunjungan(data[i]);
            riwayat.tampilkanSaatIni();
            riwayat.tampilkanSemua();
            System.out.println();
        }

        // 2) Navigasi mundur 2 kali
        for (int i = 1; i <= 2; i++) {
            System.out.println("[Langkah " + (4 + i) + "] sebelumnya()  - mundur ke-" + i);
            riwayat.sebelumnya();
            riwayat.tampilkanSaatIni();
            riwayat.tampilkanSemua();
            System.out.println();
        }

        // 3) Navigasi maju 1 kali
        System.out.println("[Langkah 7] berikutnya()  - maju 1 kali");
        riwayat.berikutnya();
        riwayat.tampilkanSaatIni();
        riwayat.tampilkanSemua();
        System.out.println();

        // Uji batas dan demonstrasi hapus node tengah
        System.out.println("=== Uji batas & hapus node tengah ===\n");
        System.out.println("[Ekstra 1] hapusSaatIni() - kunjungan #3 dianggap salah input");
        riwayat.hapusSaatIni();
        riwayat.tampilkanSaatIni();
        riwayat.tampilkanSemua();
        System.out.println();

        System.out.println("[Ekstra 2] berikutnya() di kunjungan terakhir");
        riwayat.berikutnya();
        riwayat.tampilkanSaatIni();
    }
}
