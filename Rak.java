/**
 * Mewakili sebuah Rak di sebuah toko yang dapat menampung kumpulan objek Obat.
 */
public class Rak {
    private int ukuran;
    private Obat[] daftarObat;
    private String kategoriRak;

    /**
     * Membangun objek Rak dengan ukuran dan kategori yang ditentukan.
     * @param ukuran ukuran (kapasitas) Rak
     * @param kategoriRak kategori Rak
     */
    public Rak(int ukuran, String kategoriRak) {
        this.ukuran = ukuran;
        this.kategoriRak = kategoriRak;
        daftarObat = new Obat[ukuran];
    }

    /**
     * Mengambil kategori Rak.
     * @return kategori Rak
     */
    public String getKategoriRak() {
        return kategoriRak;
    }

    /**
     * Menambahkan sebuah Obat ke Rak pada indeks yang ditentukan.
     * @param obat Obat yang akan ditambahkan
     * @param index indeks di mana Obat akan ditambahkan
     */
    public void tambahObat(Obat obat, int index) {
        if (index >= 0 && index < ukuran) {
            daftarObat[index] = obat;
            System.out.println("Obat berhasil ditambahkan");
        } else {
            System.out.println("Indeks rak tidak valid");
        }
    }

    /**
     * Mencetak isi dari Rak.
     */
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

    /**
     * Memeriksa apakah Rak mengandung Obat tertentu.
     * @param obat Obat yang akan diperiksa
     * @return true jika Obat ditemukan di Rak, false jika tidak
     */
    public boolean containsObat(Obat obat) {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] != null && daftarObat[i].getNama().equals(obat.getNama())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Membeli jumlah tertentu dari sebuah Obat dari Rak.
     * @param obat Obat yang akan dibeli
     * @param jumlah jumlah yang akan dibeli
     * @return true jika pembelian berhasil, false jika tidak
     */
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

    /**
     * Mencari Obat dengan nama tertentu di dalam Rak.
     * @param namaObat nama Obat yang akan dicari
     * @return objek Obat yang ditemukan, atau null jika tidak ditemukan
     */
    public Obat searchObat(String namaObat) {
        for (int i = 0; i < ukuran; i++) {
            if (daftarObat[i] != null && daftarObat[i].getNama().equals(namaObat)) {
                return daftarObat[i];
            }
        }
        return null;
    }

    /**
     * Mengembalikan array dari objek Obat yang ada di dalam Rak.
     * @return array objek Obat
     */
    public Obat[] getListObat() {
        return daftarObat;
    }

    /**
     * Mengembalikan ukuran Rak.
     * @return ukuran Rak
     */
    public int getukuran() {
        return ukuran;
    }
    
    /**
     * Mencari indeks kolom dari Obat dengan nama tertentu dalam tata letak 2D Rak.
     * @param colms jumlah kolom dalam tata letak
     * @param rows jumlah baris dalam tata letak
     * @param namaObat nama Obat yang akan dicari
     * @return indeks kolom dari Obat yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int searchcolomObat(int colms, int rows, String namaObat) {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < colms; j++) {
                if (daftarObat[i] != null && daftarObat[i].getNama().equals(namaObat)) {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * Mencari indeks baris dari Obat dengan nama tertentu dalam tata letak 2D Rak.
     * @param colms jumlah kolom dalam tata letak
     * @param rows jumlah baris dalam tata letak
     * @param namaObat nama Obat yang akan dicari
     * @return indeks baris dari Obat yang ditemukan, atau -1 jika tidak ditemukan
     */
    public int searchrowsobar(int colms, int rows, String namaObat) {
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < colms; j++) {
                if (daftarObat[i] != null && daftarObat[i].getNama().equals(namaObat)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
