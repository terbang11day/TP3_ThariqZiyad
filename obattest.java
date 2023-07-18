import org.junit.Assert;
import org.junit.Test;

public class obattest {

    @Test
    public void testConstructorAndGetters() {
        String nama = "Paracetamol";
        int stok = 50;
        String kategori = "Antipiretik";
        Obat obat = new Obat(nama, stok, kategori);

        Assert.assertEquals(nama, obat.getNama());
        Assert.assertEquals(stok, obat.getStok());
        Assert.assertEquals(kategori, obat.getKategori());
    }

    @Test
    public void testGetHarga() {
        Obat obat = new Obat("Paracetamol", 50, "Antipiretik");

        // Harga pada posisi (1, 1)
        int hargaPosisi1_1 = 5000;
        Assert.assertEquals(hargaPosisi1_1, obat.getHarga(1, 1));

        // Harga pada posisi (3, 3)
        int hargaPosisi2_3 = 15000;
        Assert.assertEquals(hargaPosisi2_3, obat.getHarga(3, 3));
    }

    @Test
    public void testSetters() {
        Obat obat = new Obat("Paracetamol", 50, "Antipiretik");

        // Mengubah kategori obat
        String newKategori = "Analgesik";
        obat.setKategori(newKategori);
        Assert.assertEquals(newKategori, obat.getKategori());

        // Mengubah stok obat
        int newStok = 100;
        obat.setStok(newStok);
        Assert.assertEquals(newStok, obat.getStok());

        // Mengubah harga obat
        int newHarga = 5000;
        obat.setHarga(newHarga);
        Assert.assertEquals(newHarga, obat.getHarga(1, 1));
    }
}
