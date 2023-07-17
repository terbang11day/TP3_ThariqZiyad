public class Rak {
    private int ukuran;
    private Obat[] daftarObat;
    private String kategoriRak;

    public Rak(int ukuran, String kategoriRak) {
        this.ukuran = ukuran;
        this.kategoriRak = kategoriRak;
        daftarObat = new Obat[ukuran];
    }

    public String getKategoriRak() {
        return kategoriRak;
    }

    public void tambahObat(Obat obat, int index) {
        if (index >= 0 && index < ukuran) {
            daftarObat[index] = obat;
            System.out.println("Obat berhasil ditambahkan");
        } else {
            System.out.println("Indeks rak tidak valid");
        }
    }

    public void printRak() {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] == null) {
                System.out.print("| kosong ");
            } else {
                System.out.print("| " + daftarObat[i].getNama() + " (stok: " + daftarObat[i].getStok() + ")");
            }
        }
        System.out.println();
    }

    public boolean containsObat(Obat obat) {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] != null && daftarObat[i].getNama().equals(obat.getNama())) {
                return true;
            }
        }
        return false;
    }

    public boolean beliObat(Obat obat, int jumlah) {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] != null && daftarObat[i].getNama().equals(obat.getNama())) {
                if (daftarObat[i].getStok() >= jumlah) {
                    daftarObat[i].setStok(daftarObat[i].getStok() - jumlah);
                    return true;
                }
            }
        }
        return false;
    }

    public Obat searchObat(String namaObat) {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] != null && daftarObat[i].getNama().equals(namaObat)) {
                return daftarObat[i];
            }
        }
        return null;
    }

    public Obat[] getListObat() {
        return daftarObat;
    }
}
