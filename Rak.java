public class Rak {
    private int size;
    private String kategori;
    private Obat[] daftarObat;

    public Rak(int size, String kategori){
        this.kategori = kategori;
        this.daftarObat = new Obat[size];
        this.size = size;
    }

    public String getKategoriRak() {
        return this.kategori;
    }

    public String getDaftarObatClass() {
        return this.daftarObat.getClass().getSimpleName();
    }

    public void tambahObat(Obat obat, int index) {
        this.daftarObat[index] = obat;
    }
    
    // Kemungkinan dikerjakan mhs
    public void printRak(){
        for (int i = 0; i < this.size; i++) {
            String result = daftarObat[i] == null ?  "| " + "kosong " : "| " + daftarObat[i].getNama() + " (stock: " + daftarObat[i].getStok() + ")"; 
            System.out.print(result);
        }
        System.out.println();
    }

    public Obat[] getListObat() {
        return this.daftarObat;
    }
    
}
