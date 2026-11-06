/**
 * Node Doubly Linked List riwayat kunjungan.
 * Setiap node menyimpan data kunjungan dan dua pointer: prev dan next.
 */
public class NodeKunjungan {
    int nomor;              // nomor urut kunjungan
    String catatan;         // isi catatan rekam medis
    NodeKunjungan prev;     // pointer ke kunjungan sebelumnya
    NodeKunjungan next;     // pointer ke kunjungan berikutnya

    public NodeKunjungan(int nomor, String catatan) {
        this.nomor = nomor;
        this.catatan = catatan;
        this.prev = null;
        this.next = null;
    }
}
