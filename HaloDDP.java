import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);
        List<String> transactionHistory = new ArrayList<>();

        System.out.println("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
        String masukan = input.next();
        char a = masukan.charAt(0);
        char b = masukan.charAt(2);
        int rows = Character.getNumericValue(a);
        int colms= Character.getNumericValue(b);
        String [][] mylist = new String[rows][colms];
        String [] mylist2 = new String[rows+1];
        if (rows < 1 || colms < 1 || rows > 5) {
            System.out.println("Ukuran lemari tidak valid!");
            System.exit(0);
        }
        Lemari lemari = new Lemari(colms);
        // TODO : Implementasi validasi input ukuran lemari

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan

        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        // TODO : Implementasi input kategori rak\
        for (int i = 1; i <= rows; i++) {
            System.out.print("Rak ke-"+i+": ");
            String kategori = input.next();
            if (kategori.equals(mylist2[i-1])){
                System.out.println("Kategori rak tidak valid");
                i--;
            }
            else {
                mylist2[i] = kategori; 
                System.out.println("Rak ke-"+i+" adalah rak obat "+ kategori);
                lemari.addRak(new Rak(colms, kategori), i-1); 
            }       
        }
        lemari.print();

        while (true) {
            Scanner input3 = new Scanner(System.in);
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input3.nextLine();

            if (menu.equals("1")) {
                // TODO : Implementasi input obat
                Scanner input2 = new Scanner(System.in);
                System.out.print("Masukkan nama obat: ");
                String namaobat = input.next();
                System.out.print("Masukkan kategori obat: ");
                String kategoriobat = input.next();
                int rakIndex = -1;
                for (int i = 1; i <= rows; i++) {
                    if (mylist2[i].equals(kategoriobat)) {
                        System.out.println("Kategori obat valid");
                        rakIndex = i-1;
                        break;
                    }
                }
                if (rakIndex == -1) {
                    System.out.println("Kategori obat tidak valid");
                    continue;
                }
                System.out.print("Masukkan posisi obat: ");
                String posisi = input.next();
                String[] size = posisi.split(",");
                int depan = Integer.parseInt(size[0]);
                int belakang = Integer.parseInt(size[1]);
                if (depan > rows || belakang > colms) {
                    System.out.println("Posisi tidak ada di lemari");
                    continue;
                }
                int index = 0;
                for (int i = 1; i<=mylist2.length; i++){
                    if(mylist2[i].equals(kategoriobat)){
                        index = i;
                        break;
                    }
                }
                System.out.println(index);
                if (depan != index ){
                    System.out.println("Rak bukan untuk kategori obat " + kategoriobat);
                    break;
                }
                System.out.print("Masukkan stock obat: ");
                int stock = input2.nextInt();
                Obat obat = new Obat(namaobat, stock, kategoriobat);
                lemari.getRak(rakIndex).tambahObat(obat, belakang-1);

            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat
                lemari.print();
            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
                Scanner input4 = new Scanner(System.in);
                System.out.print("Obat apa yang ingin dibeli? ");
                String namaObat = input4.nextLine();
                Obat obat = lemari.searchObat(namaObat);
                if (obat == null) {
                    System.out.println("Obat tidak ditemukan");
                    continue;
                }
                System.out.print("Ingin beli berapa banyak? ");
                int sum = input4.nextInt();
                boolean success = lemari.beliObat(obat, sum);
                if (success) {
                    int totalHarga = obat.getHarga() * sum;
                    String transaction = obat.getNama() + " - " + sum + " - " + totalHarga;
                    transactionHistory.add(transaction);
                    System.out.println("Berhasil membeli obat");
                } else {
                    System.out.println("stock obat tidak mencukupi");
                }
            } else if (menu.equals("99")){
                // TODO : Implementasi keluar
                System.out.println("Riwayat transaksi hari ini\n");
                System.out.println("No. Nama - sum - Total Harga");
                for (int i = 0; i < transactionHistory.size(); i++) {
                    System.out.println((i + 1) + ". " + transactionHistory.get(i));
                }
                break;
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
}