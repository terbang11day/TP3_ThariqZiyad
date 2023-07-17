/**
 * Kelas Obat digunakan untuk merepresentasikan obat dalam sistem.
 */
public class Obat {
    private String kategori;
    private String nama;
    private int harga;
    private int stok;

    /**
     * Konstruktor Obat.
     * @param nama Nama obat.
     * @param stok Jumlah stok obat.
     * @param kategori Kategori obat.
     */
    public Obat(String nama, int stok, String kategori) {
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    /**
     * Mendapatkan kategori obat.
     * @return Kategori obat.
     */
    public String getKategori() {
        return kategori;
    }

    /**
     * Mendapatkan nama obat.
     * @return Nama obat.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan harga obat berdasarkan posisi baris dan kolom dalam lemari.
     * @param baris Posisi baris obat dalam lemari.
     * @param kolom Posisi kolom obat dalam lemari.
     * @return Harga obat.
     */
    public int getHarga(int baris, int kolom) {
        return 5000 + (baris - 1) * 10000 + (kolom - 1) * 5000;
    }

    /**
     * Mendapatkan stok obat.
     * @return Jumlah stok obat.
     */
    public int getStok() {
        return stok;
    }

    /**
     * Mengatur kategori obat.
     * @param kategori Kategori obat yang baru.
     */
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    /**
     * Mengatur jumlah stok obat.
     * @param stok Jumlah stok obat yang baru.
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * Mengatur harga obat.
     * @param harga Harga obat yang baru.
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
