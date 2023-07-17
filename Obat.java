public class Obat {
    private String kategori;
    private String nama;
    private int harga;
    private int stok;

    public Obat(String nama, int stok, String kategori) {
        this.nama = nama;
        this.stok = stok;
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
