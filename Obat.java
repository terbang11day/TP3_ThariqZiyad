public class Obat {
    private String kategori;
    private String nama;
    private int harga;
    private int stok;

    public Obat(String nama, int stok){
        this.nama = nama;
        this.stok = stok;
    }

    public void print(){
        System.out.println("Nama obat: " + this.nama);
        System.out.println("Harga obat: " + this.harga);
        System.out.println("Stok obat: " + this.stok);
    }

    public String getKategori(){
        return this.kategori;
    }

    public String getNama(){
        return this.nama;
    }

    public int getHarga(){
        return this.harga;
    }

    public int getStok(){
        return this.stok;
    }
    
    public void setKategori(String kategori){
        this.kategori = kategori;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

}
