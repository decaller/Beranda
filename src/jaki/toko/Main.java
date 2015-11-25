package jaki.toko;


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
    Arraylist<Pelanggan> daftarPelanggan;
    Gudang gudang;
    Arraylist<Barang> keranjang;

    /** Program inti
     * Program inti menjalankan program beranda dimana dimulai dari menu untuk mengaktifkan beranda
     */
    public static void main(String[] args) {

        do{
            makeGudang();
            pilihan = choiceMenuAdmin();
            case pilihan
                1 : startJualan();
                2 : cekStok();
                3 : cekOrder();
                4 : tutupBeranda();

        } while(!pilihan = 4);

    }


    //METHOD UNTUK ADMIN

    public void makeGudang(){
        System.out.println("Masukkan alamat gudang:");
        String alamatGudang = inKata.nextLine();
        System.out.println("Masukkan nomor telepon gudang:");
        String telponGudang = inKata.nextLine();
        gudang = new Gudang(alamatGudang,telponGudang);
    }

    public int choiceMenuAdmin(){
        System.out.println("Selamat datang di sistem Beranda!");
        System.out.println("------------- MENU -------------")
        System.out.println("1 - Mulai jualan!");
        System.out.println("2 - Cek Stok Barang");
        System.out.println("3 - Cek Orderan");
        System.out.println("4 - Matikan program Beranda");

        return inAngka.nextInt();

    }

    public void cekStok(){
        System.out.println("Stok barang di gudang :");
        Arraylist<Barang> stokBarang = gudang.getStok();
        for (Barang barang : stokBarang){
            System.out.println(barang.getNama() + " " + barang.getJumlah() + " unit");
        }
        System.out.println("Jumlah barang : " + stokBarang.length() + " macam");
    }

    public void tutupBeranda(){
        System.out.println("Program Beranda dimatikan")
    }


    //METHOD UNTUK PELANGGAN
    public void startJualan(){
        do{
            addPelanggan();
            pilihan = choiceMenuPelanggan();
            case pilihan
                1 : cekJualan();
                2 : cekKeranjang();
                3 : beli();
                4 : checkOut();

        } while(!pilihan = 4);

    }

    public void addPelanggan(){
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

        Pelanggan pelanggan = new Pelanggan(namaPelanggan, telponPelanggan, alamatPelanggan)
        daftarPelanggan.add(pelanggan);

        System.out.println("Terima kasih, data anda telah masuk.");
        System.out.println("Selamat datang, " + namaPelanggan);
        System.out.println("Selamat berbelanja di TOKO PAK ZAKI!");
    }

    public int choiceMenuPelanggan(){
        System.out.println("------------- MENU -------------")
        System.out.println("1 - Lihat Daftar Produk");
        System.out.println("2 - Lihat Keranjang");
        System.out.println("3 - Beli Produk");
        System.out.println("4 - Selesai belanja");

        return inAngka.nextInt();
    }

    public void cekJualan(){


    }

    public void cekKeranjang(){
        if(keranjang){
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
        System.out.println("Jumlah barang : " + keranjang.length() + " macam");
    }

    public void beli(){
        System.out.println("Masukkan nama barang:");
    }

    public void checkOut(){

    }

}