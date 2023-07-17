import java.util.ArrayList;
import java.util.List;

/**
 * Mewakili sebuah Lemari yang berisi kumpulan Rak obat.
 */
public class Lemari {
    private int ukuran;
    private Rak[] rak;

    /**
     * Membangun objek Lemari dengan ukuran yang ditentukan.
     * @param ukuran ukuran Lemari
     */
    public Lemari(int ukuran) {
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }

    /**
     * Menambahkan sebuah Rak ke Lemari pada indeks yang ditentukan.
     * @param rak Rak yang akan ditambahkan
     * @param index indeks di mana Rak akan ditambahkan
     */
    public void addRak(Rak rak, int index) {
        this.rak[index] = rak;
    }

    /**
     * Mencetak isi Lemari.
     */
    public void print() {
        System.out.println("Rak obat hari ini berukuran ");
        for (int i = 0; i < ukuran; i++) {
            System.out.println(rak[i].getKategoriRak());
            System.out.println("==================");
            rak[i].printRak();
            System.out.println("==================");
        }
    }

    /**
     * Membeli jumlah tertentu dari sebuah Obat dari Rak yang tersedia di Lemari.
     * @param obat Obat yang akan dibeli
     * @param jumlah jumlah yang akan dibeli
     * @return true jika pembelian berhasil, false jika tidak
     */
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

    /**
     * Mencari Obat dengan nama tertentu di dalam Rak yang tersedia di Lemari.
     * @param namaObat nama Obat yang akan dicari
     * @return objek Obat yang ditemukan, atau null jika tidak ditemukan
     */
    public Obat searchObat(String namaObat) {
        for (Rak rak : rak) {
            Obat obat = rak.searchObat(namaObat);
            if (obat != null) {
                return obat;
            }
        }
        return null;
    }

    /**
     * Mengambil Rak pada indeks tertentu dalam Lemari.
     * @param i indeks Rak yang akan diambil
     * @return objek Rak yang diambil
     */
    public Rak getRak(int i) {
        return rak[i];
    }
    
    /**
     * Mencari posisi Obat dalam Lemari.
     * @param obat Obat yang akan dicari posisinya
     * @return array 2D berisi posisi Obat yang ditemukan
     */
    public int[][] cariPosisiObat(Obat obat) {
        List<int[]> posisiObat = new ArrayList<>();
        for (int i = 0; i < ukuran; i++) {
            Rak rak = getRak(i);
            Obat[] daftarObat = rak.getListObat();
            for (int j = 0; j < rak.getukuran(); j++) {
                if (daftarObat[j] != null && daftarObat[j].equals(obat)) {
                    int[] posisi = {i, j};
                    posisiObat.add(posisi);
                }
            }
        }
        return posisiObat.toArray(new int[0][]);
    }
}
