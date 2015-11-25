package jaki.toko;


import java.util.ArrayList;
import java.util.Scanner;

/** Kelas Beranda digunakan untuk melyaani pelanggan dan menjadi inti dari program
 *
 * @author Harridi Ilman Tovid
 * @version 0.1 Built Nov 11, 2015.
 */


public class Main{ //Beranda

    //helper
    Scanner inKata = new Scanner(System.in);
    Scanner inAngka = new Scanner(System.in);
    int pilihan = 0;

    //variabel yang akan dipakai kemudian
    ArrayList<Pelanggan> daftarPelanggan;
    Gudang gudang;
    ArrayList<Barang> keranjang;

    /** Program inti
     * Program inti menjalankan program beranda dimana dimulai dari menu untuk mengaktifkan beranda
     */
    public void main(String[] args) {

        do{
            makeGudang();
            int pilihan = choiceMenuAdmin();
            switch (pilihan){
                case 1 : startJualan();
                    break;
                case 2 : cekStok();
                    break;
                case 3 : cekOrder();
                    break;
                case 4 : tutupBeranda();
                    break;
            }
        } while(!(pilihan == 4));

    }

    //METHOD UNTUK ADMIN

    private void makeGudang(){
        System.out.println("Masukkan alamat gudang:");
        String alamatGudang = inKata.nextLine();
        System.out.println("Masukkan nomor telepon gudang:");
        String telponGudang = inKata.nextLine();
        gudang = new Gudang(alamatGudang,telponGudang);
    }

    private int choiceMenuAdmin(){
        System.out.println("Selamat datang di sistem Beranda!");
        System.out.println("------------- MENU -------------");
        System.out.println("1 - Mulai jualan!");
        System.out.println("2 - Cek Stok Barang");
        System.out.println("3 - Cek Orderan");
        System.out.println("4 - Matikan program Beranda");

        return inAngka.nextInt();

    }

    private void cekStok(){
        System.out.println("Stok barang di gudang :");
        ArrayList<Barang> stokBarang = gudang.getStok();
        for (Barang barang : stokBarang){
            System.out.println(barang.getNama() + " " + barang.getJumlah() + " unit");
        }
        System.out.println("Jumlah barang : " + stokBarang.size() + " macam");
    }

    private static void cekOrder() {
    }

    private void tutupBeranda(){
        System.out.println("Program Beranda dimatikan");
    }


    //METHOD UNTUK PELANGGAN
    private void startJualan(){
        do{
            addPelanggan();
            pilihan = choiceMenuPelanggan();
            switch (pilihan){
                case 1 : cekJualan();
                    break;
                case 2 : cekKeranjang();
                    break;
                case 3 : beli();
                    break;
                case 4 : checkOut();
                    break;
            }

        } while(!(pilihan == 4));

    }

    private void addPelanggan(){
        System.out.println("Selamat datang di Beranda TOKO PAK ZAKI!");
        System.out.println("Berikut data gudang kami : ");
        System.out.println(gudang.getInfo());
        System.out.println("");
        System.out.println("Silahkan masukkan data Anda :");
        System.out.print("Nama : ");
        String namaPelanggan = inKata.nextLine();
        System.out.print("Nomor Telepon : ");
        String telponPelanggan = inKata.nextLine();
        System.out.print("Alamat Pengiriman : ");
        String alamatPelanggan = inKata.nextLine();

        Pelanggan pelanggan = new Pelanggan(namaPelanggan, telponPelanggan, alamatPelanggan);
        daftarPelanggan.add(pelanggan);

        System.out.println("Terima kasih, data anda telah masuk.");
        System.out.println("Selamat datang, " + namaPelanggan);
        System.out.println("Selamat berbelanja di TOKO PAK ZAKI!");
    }

    private int choiceMenuPelanggan(){
        System.out.println("------------- MENU -------------");
        System.out.println("1 - Lihat Daftar Produk");
        System.out.println("2 - Lihat Keranjang");
        System.out.println("3 - Beli Produk");
        System.out.println("4 - Selesai belanja");

        return inAngka.nextInt();
    }

    private void cekJualan(){


    }

    private void cekKeranjang(){
        if(keranjang.size() == 0){
            System.out.println("Anda belum membeli barang apapun.");
            return;
        }
        System.out.println("Isi keranjang belanja anda :");
        int totalBelanja = 0;
        for (Barang barang : keranjang){
            System.out.println(barang.getNama() + " " + barang.getJumlah() + " unit");
            int hargaTotalBarang = barang.getHarga() * barang.getJumlah();
            System.out.println("Harga: " + barang.getHarga() + " Total: " + hargaTotalBarang);
            totalBelanja += hargaTotalBarang;
        }
        System.out.println("Jumlah barang : " + keranjang.size() + " macam");
        System.out.println("Total Belanja : " + totalBelanja + " rupiah");
    }

    private void beli(){
        System.out.println("Masukkan nama barang:");
    }

    private void checkOut(){

    }

}