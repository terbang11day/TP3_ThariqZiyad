import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int BASE_PRICE = 5000;

        String[] validKategori;

        // array untuk menyimpan daftar transaksi
        Struk[] transaksi = new Struk[100];
        int counterPembelian = 0;
        
        Scanner input = new Scanner(System.in);

        // Format: Row x Column

        System.out.print("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
        String ukuranLemari = input.nextLine();

        String[] ukuranLemariSplit = ukuranLemari.split("x");
        int row = 0;
        int column = 0;
        try {
            row = Integer.parseInt(ukuranLemariSplit[0]);
            column = Integer.parseInt(ukuranLemariSplit[1]);

            if (row <= 0 || column <= 0) {
                System.out.println("Ukuran lemari tidak bisa < 1");
                input.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
            input.close();
            return;
        }

        Lemari lemari = new Lemari(row);
        validKategori = new String[row];

        System.out.println("Rak obat hari ini berukuran " + row + "x" + column);
        System.out.println();
        // Tentukan untuk setiap row kategori obat apa

        int counter = 0;
        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        while (counter < row) {
            System.out.print("Rak ke-" + (counter + 1) + ": ");
            String kategoriRak = input.nextLine();

            if (isValid(kategoriRak, validKategori)) {
                System.out.println("Rak ke-" + (counter + 1) + " adalah rak obat " + kategoriRak);
                lemari.addRak(new Rak(column, kategoriRak), counter);

                validKategori[counter] = kategoriRak;
                counter++;
            } else {
                System.out.println("Kategori rak tidak valid");
            }
        }

        System.out.println("Rak obat hari ini:");
        lemari.print();

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.nextLine();

            if (menu.equals("1")) {
                System.out.print("Masukkan nama obat: ");
                String namaObat = input.nextLine();
                
                System.out.print("Masukkan kategori obat: ");
                String kategoriObat = input.nextLine();

                if (isValidObat(kategoriObat, validKategori)) {
                    System.out.println("Kategori obat valid");
                } else {
                    System.out.println("Kategori obat tidak valid");
                    continue;
                }

                // format: rak, kolom
                System.out.print("Masukkan posisi obat: ");

                String posisiObat = input.nextLine();
                String[] posisiObatSplit = posisiObat.split(","); // e.g: 5,5
                
                int i = 0;
                int j = 0;
                try {
                    i = Integer.parseInt(posisiObatSplit[0]) - 1;
                    j = Integer.parseInt(posisiObatSplit[1]) - 1;
                } catch (Exception e) {
                    System.out.println("Posisi tidak valid");
                    continue;
                }

                // cek rak valid apa ga
                if (i > row || j > row || i < 0 || j < 0) {
                    System.out.println("Posisi tidak ada di lemari");
                    continue;
                }

                // cek udah ada obat atau belum di rak tersebut
                if (lemari.getRak(i).getListObat()[j] != null) {
                    System.out.println("Rak sudah terisi obat");
                    continue;
                }

                // cek posisi obat ga sesuai kategori rak
                if (!lemari.getRak(i).getKategoriRak().equals(kategoriObat)) {
                    System.out.println("Rak bukan untuk kategori obat " + kategoriObat);
                    continue;
                }

                System.out.print("Masukkan stok obat:  ");
                int stokObat = input.nextInt();
                input.nextLine();

                // Cek stok ga valid
                if (stokObat < 1) continue;

                int hargaObat = BASE_PRICE + i*10000 + j*5000;

                Obat obat = new Obat(namaObat, stokObat);
                obat.setHarga(hargaObat);
                lemari.getRak(i).tambahObat(obat, j);

                System.out.println("Obat berhasil ditambahkan");

            } else if (menu.equals("2")) {
                lemari.print();
            } else if (menu.equals("3")) {
                System.out.print("Obat apa yang ingin dibeli? ");
                String namaObat = input.next();

                System.out.print("Ingin beli berapa banyak? ");
                int jumlahBeli = Integer.parseInt(input.next());
                input.nextLine();

                Obat obat = lemari.searchObat(namaObat);
                if (obat == null) {
                    System.out.println("Obat tidak ada di apotek");
                    continue;
                }

                //cek stok
                if (!lemari.beliObat(obat, jumlahBeli)) {
                    System.out.println("Stok obat tidak cukup");
                    continue;
                }

                Struk strukBeli = new Struk(obat, jumlahBeli);
                transaksi[counterPembelian] = strukBeli;
                counterPembelian++;

                System.out.println("Berhasil membeli obat");

            } else if (menu.equals("99")){
                if (transaksi[0] == null) {
                    System.out.println("Tetap semangat. Besok pasti akan jauh lebih baik!");
                } else {
                    System.out.println("Riwayat transaksi hari ini");
                    System.out.println();
                    System.out.println("No. Nama - Jumlah - Total Harga");
                    int counterStruk = 1;
                    for (Struk s : transaksi) {
                        if (s == null) break;
                        System.out.println(counterStruk + ". " + s);
                        counterStruk++;
                    }
                    System.out.println();
                }
                break;
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }

    public static Boolean isValid(String namaKategori, String[] kategori) {
        if (kategori.length == 0) return true;
        for (String k : kategori) {
            if (k == null) continue;
            if (k.equals(namaKategori)) return false;
        }
        return true;
        
    }

    public static Boolean isValidObat(String namaKategori, String[] kategori) {
        for (String k : kategori) {
            if (k.equals(namaKategori)) return true;
        }
        return false;
        
    }

}
