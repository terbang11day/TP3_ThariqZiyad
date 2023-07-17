public class Lemari {
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran) {
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    public void addRak(Rak rak, int index) {
        this.rak[index] = rak;
    }

    public void print() {
        System.out.println("Rak obat hari ini berukuran ");
        for (int i = 0; i < ukuran; i++) {
            System.out.println(rak[i].getKategoriRak());
            System.out.println("==================");
            rak[i].printRak();
            System.out.println("==================");
        }
    }

    public boolean beliObat(Obat obat, int jumlah) {
        Rak rakObat = null;
        for (Rak rak : rak) {
            if (rak.containsObat(obat)) {
                rakObat = rak;
                break;
            }
        }
        if (rakObat != null) {
            return rakObat.beliObat(obat, jumlah);
        }
        return false;
    }

    public Obat searchObat(String namaObat) {
        for (Rak rak : rak) {
            Obat obat = rak.searchObat(namaObat);
            if (obat != null) {
                return obat;
            }
        }
        return null;
    }

    public Rak getRak(int i) {
        return rak[i];
    }
}
