public class Lemari {
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    // Kemungkinan dikerjakan mhs
    public void print(){
        for (int i = 0; i < this.ukuran; i++) {
            System.out.println(this.rak[i].getKategoriRak());
            System.out.println("==================");
            this.rak[i].printRak();
            System.out.println("==================");
            System.out.println();
        }
    }

    // Kemungkinan dikerjakan mhs
    public boolean beliObat(Obat obat, int jumlah) {
        if (obat.getStok() >= jumlah) {
            obat.setStok(obat.getStok() - jumlah);
            return true;
        } else {
            return false;
        }  
    }

    // Kemungkinan dikerjakan mhs
    public Obat searchObat(String namaObat) {
        for (Rak r : this.rak) {
            for (Obat obat : r.getListObat()){
                if (obat == null) continue;
                if (obat.getNama().equals(namaObat)) return obat;
            }
        }
        return null;
    }

    public Rak getRak(int i) {
        return this.rak[i];
    }
}
