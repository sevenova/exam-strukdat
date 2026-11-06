/**
 * Riwayat kunjungan pasien berbasis Doubly Linked List buatan sendiri.
 */
public class RiwayatKunjungan {
    private NodeKunjungan head;     // kunjungan paling awal
    private NodeKunjungan tail;     // kunjungan paling akhir
    private NodeKunjungan saatIni;  // kunjungan yang sedang ditinjau dokter
    private int jumlah;             // banyaknya kunjungan

    public RiwayatKunjungan() {
        head = tail = saatIni = null;
        jumlah = 0;
    }

    /** Menambah kunjungan baru di akhir dan memindahkan pointer saatIni ke sana. O(1). */
    public void tambahKunjungan(String catatan) {
        NodeKunjungan baru = new NodeKunjungan(jumlah + 1, catatan);
        if (head == null) {            // list masih kosong
            head = tail = baru;
        } else {                       // sambungkan di belakang tail
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        saatIni = baru;
        jumlah++;
    }

    /** Mundur ke kunjungan sebelumnya. O(1). Mengembalikan false jika sudah di awal. */
    public boolean sebelumnya() {
        if (saatIni == null || saatIni.prev == null) {
            System.out.println("   (Tidak ada kunjungan sebelumnya - sudah di kunjungan pertama)");
            return false;
        }
        saatIni = saatIni.prev;
        return true;
    }

    /** Maju ke kunjungan berikutnya. O(1). Mengembalikan false jika sudah di akhir. */
    public boolean berikutnya() {
        if (saatIni == null || saatIni.next == null) {
            System.out.println("   (Tidak ada kunjungan berikutnya - sudah di kunjungan terakhir)");
            return false;
        }
        saatIni = saatIni.next;
        return true;
    }

    /** Menampilkan kunjungan yang sedang ditinjau. O(1). */
    public void tampilkanSaatIni() {
        if (saatIni == null) {
            System.out.println("   Riwayat kosong.");
            return;
        }
        String kiri  = (saatIni.prev == null) ? "-" : "#" + saatIni.prev.nomor;
        String kanan = (saatIni.next == null) ? "-" : "#" + saatIni.next.nomor;
        System.out.println("   Saat ini : Kunjungan #" + saatIni.nomor + " -> " + saatIni.catatan);
        System.out.println("   Navigasi : [sebelumnya: " + kiri + "] [berikutnya: " + kanan + "]");
    }

    /**
     * Menghapus node yang sedang ditinjau (salah input). O(1).
     * Pointer saatIni pindah ke node berikutnya, atau ke sebelumnya jika yang dihapus adalah tail.
     */
    public void hapusSaatIni() {
        NodeKunjungan target = saatIni;
        if (target == null) return;

        if (target.prev != null) target.prev.next = target.next; // sambung prev -> next
        else head = target.next;                                   // target adalah head

        if (target.next != null) target.next.prev = target.prev; // sambung next -> prev
        else tail = target.prev;                                   // target adalah tail

        saatIni = (target.next != null) ? target.next : target.prev;
        target.prev = target.next = null;                          // putus referensi lama
        jumlah--;
    }

    /** Menampilkan seluruh riwayat dari head ke tail (kronologis). O(n). */
    public void tampilkanSemua() {
        StringBuilder sb = new StringBuilder("   head");
        for (NodeKunjungan p = head; p != null; p = p.next) {
            sb.append(" <-> [#").append(p.nomor).append(p == saatIni ? "*" : "").append("]");
        }
        sb.append(" <-> null   (jumlah = ").append(jumlah).append(", * = saat ini)");
        System.out.println(sb);
    }
}
