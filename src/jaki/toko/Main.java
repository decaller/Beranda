package jaki.toko;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/** Kelas Main sebagai Beranda digunakan untuk melayani pelanggan dan menjadi inti dari program
 *
 * @author Harridi Ilman Tovid
 * @version 0.1 Built Nov 11, 2015.
 */


public class Main{

    //VAR SCANNER
    Scanner inKata = new Scanner(System.in);
    Scanner inAngka = new Scanner(System.in);
    
    

    //VAR HELPER
    
    // Membuat objek gudang yang nanti akan diinisiasi oleh admin.
    Gudang gudang;
    
    // Menyimpan daftar pelanggan yang telah menggunakan beranda.
    ArrayList<Pelanggan> daftarPelanggan;
    
    // Menyimpan pelanggan yang sedang aktif menggunakan beranda dan akan dimasukkan ke {@link #daftarPelangan}.
    Pelanggan activePelanggan;
    
    // Membuat keranjang berupa daftar barang yang akan digunakan {@link #activePelanggan}.
    ArrayList<Barang> keranjang;


    /** MAIN METHOD
     * Menginisialisasi {@link #gudang}
     * Menampilkan menu untuk admin {@link #choiceMenuAdmin}.
     *  menu 1 memulai method {@link #startJualan} untuk menjalankan beranda dan membuka toko.
     *  menu 2 memulai method {@link #cekStok} untuk menampilkan stok barang di gudang.
     *  menu 3 memulai method {@link #cekOrder} untuk menampilkan order beranda.
     *  menu 4 memulai method {@link #tutupBeranda} untuk menutup beranda.
     */
    public void main(String[] args) {
        int pilihanAdmin = 0;
        do{
            makeGudang();
            pilihanAdmin = choiceMenuAdmin();
            switch (pilihanAdmin){
                case 1 : startJualan();
                    break;
                case 2 : cekStok();
                    break;
                case 3 : cekOrder();
                    break;
                case 4 : tutupBeranda();
                    break;
            }
        } while(!(pilihanAdmin == 4));

    }

    //HELPER METHOD
    /* Mencetak harga barang dan jumlah nya dari sebuah objek {@link #barang}
     * Menghitung harga dikali dengan jumlahnya dan mencetak harga barangnya.
     * Mengembalikan nilai harga Total barang tadi.
     */
    private int printdanhargaBarang(Barang barang){
        System.out.println(barang.getNama() + " " + barang.getJumlah() + " unit");
        int hargaTotalBarang = barang.getHarga() * barang.getJumlah();
        System.out.println("Harga: " + barang.getHarga() + " Total: " + hargaTotalBarang);
        return hargaTotalBarang;
    }


    //ADMIN METHOD
    /* Bertanya kepada admin alamat dan telepon gudang.
     * Menginisiasi {@link #gudang} dengan alamat dan telepon sebelumnya.
     */
    private void makeGudang(){
        System.out.println("Masukkan alamat gudang:");
        String alamatGudang = inKata.nextLine();
        System.out.println("Masukkan nomor telepon gudang:");
        String telponGudang = inKata.nextLine();
        gudang = new Gudang(alamatGudang,telponGudang);
    }
    
    /* Mencetak menu admin. 
     * Mengembalikan nilai pilihan.
     */
    private int choiceMenuAdmin(){
        System.out.println("Selamat datang di sistem Beranda!");
        System.out.println("------------- MENU -------------");
        System.out.println("1 - Mulai jualan!");
        System.out.println("2 - Cek Stok Barang");
        System.out.println("3 - Cek Orderan");
        System.out.println("4 - Matikan program Beranda");

        return inAngka.nextInt();

    }
    /* Memulai jualan dengan memanggil method {@link #startJualan}
     */
    private void startJualan() {
        int pilihanAdmin = 0;
        do {
            menuJualan();
            System.out.print("Ketik 0 untuk melanjutkan ke pelanggan selanjutnya (-1 untuk berhenti jualan) : ");
        } while (!(pilihanAdmin == -1));
    }
    /* Mencetak stok barang dari {@link #gudang}
     */
    private void cekStok(){
        System.out.println("Stok barang di gudang :");
        ArrayList<Barang> stokBarang = gudang.getStok();
        for (Barang barang : stokBarang){
            System.out.println(barang.getNama() + " " + barang.getJumlah() + " unit");
        }
    }

    /* Mencetak pelanggan.
     * Jika ada maka dilakukan loop untuk mengeluarkan isi {@link #daftarPelanggan}
     * Menanyakan detail pelanggan yang ingin diambil.
     * Menampilkan detail pelanggan serta belanjaannya.
     */
    private void cekOrder() {
        if (daftarPelanggan.size() == 0){
            System.out.println("Belum ada pelanggan pada sesi ini.");
            return;
        }
        int choice = 0;
        do {
            System.out.print("Daftar pelanggan : ");
            int i = 1;
            for (Pelanggan pelanggan : daftarPelanggan) {
                System.out.println(i + " " + pelanggan.getNama());
                i++;
            }
            System.out.print("Silahkan pilih nomor pelanggan (-1 untuk keluar): ");
            choice = inAngka.nextInt()-1;
            Pelanggan pelanggan = daftarPelanggan.get(choice);
            System.out.println(pelanggan.getNama() + "dengan info :");
            System.out.println("Alamat :" + pelanggan.getAlamat());
            System.out.println("Alamat :" + pelanggan.getTelpon());
            System.out.println("telah membeli :");
            int totalBelanja = 0;
            for (Barang barang : pelanggan.getBelanjaan()){
                totalBelanja += printdanhargaBarang(barang);
            }
            System.out.println("Total Belanja : " + totalBelanja + " rupiah");
            //TODO get metode bayar
            
            System.out.print("-1 untuk keluar : ");
            choice = inAngka.nextInt();

        }while (!(choice == -1));

    }

    /* Mencetak kalimat bahwa beranda dimatikan.
     */
    private void tutupBeranda(){
        System.out.println("Program Beranda dimatikan");
    }


    //METHOD UNTUK PELANGGAN
    /* Mengambil dan menambahkan data pelanggan dengan {@link #addPelanggan}
     * Menampilkan menu untuk pelanggan {choiceMenuPelanggan}
     *  menu 1 memulai method {@link #cekJualan} untuk menampilkan jualan
     *  menu 2 memulai method {@link #cekKeranjang} untuk menampilkan isi keranjang
     *  menu 3 memulai method {@link #beli} untuk membeli barang
     *  menu 4 memulai method {@link #checkout} untuk menyelesaikan belanja
     */
    private void menuJualan(){
        int pilihanPelanggan = 0;
        do{
            addPelanggan();
            pilihanPelanggan = choiceMenuPelanggan();
            switch (pilihanPelanggan){
                case 1 : cekJualan();
                    break;
                case 2 : cekKeranjang();
                    break;
                case 3 : beli();
                    break;
                case 4 : checkOut();
                    break;
            }

        } while(!(pilihanPelanggan == 4));
    }
    
    /* Menanyakan alamat dan telpon pelanggan
     * Memasukkan pelanggan menjadi {@link #activePelanggan}. 
     */
    private void addPelanggan(){
        System.out.println("Selamat datang di Beranda TOKO PAK ZAKI!");
        System.out.println("Berikut data gudang kami : ");
        System.out.println("Telepon : " + gudang.getTelponGudang());
        System.out.println("Alamat : " + gudang.getAlamatGudang());
        System.out.println("");
        System.out.println("Silahkan masukkan data Anda :");
        System.out.print("Nama : ");
        String namaPelanggan = inKata.nextLine();
        System.out.print("Nomor Telepon : ");
        String telponPelanggan = inKata.nextLine();
        System.out.print("Alamat Pengiriman : ");
        String alamatPelanggan = inKata.nextLine();

        activePelanggan = new Pelanggan(namaPelanggan, telponPelanggan, alamatPelanggan);

        System.out.println("Terima kasih, data anda telah masuk.");
        System.out.println("Selamat datang, " + namaPelanggan);
        System.out.println("Selamat berbelanja di TOKO PAK ZAKI!");
    }

    /* Mencetak menu pelanggan.
     * Mengembalikan nilai pilihan pelanggan.
     */
    private int choiceMenuPelanggan(){
        System.out.println("------------- MENU -------------");
        System.out.println("1 - Lihat Daftar Produk");
        System.out.println("2 - Lihat Keranjang");
        System.out.println("3 - Beli Produk");
        System.out.println("4 - Selesai belanja");

        return inAngka.nextInt();
    }

    /* Mengambil stok barang.
     * Mengurutkan barang sesuai kategori kemudian merek.
     * Menanyakan kategori dan membuat arraylist barang pilihan.
     * Menampilkan detail barang pilihan {@link #listFiltered}.
     */
    private void cekJualan(){

        ArrayList<Barang> stokBarang = gudang.getStok();
        Collections.sort(stokBarang, new Comparator<Barang>() {
            @Override
            public int compare(Barang b1, Barang b2) {
                String j1 = ((Barang) b1).getJenis();
                String j2 = ((Barang) b2).getJenis();
                int stringComp = j1.compareTo(j2);

                if (stringComp != 0) {
                    return stringComp;
                } else {
                    String m1 = ((Barang) b1).getMerek();
                    String m2 = ((Barang) b2).getMerek();
                    return m1.compareTo(m2);
                }

            }
        });
        do {
            System.out.println("Kategori barang :");
            System.out.println("1 - Kamera");
            System.out.println("2 - Handphone");
            System.out.println("3 - Smartphone");
            System.out.println("4 - Laptop");
            System.out.println("");
            System.out.println("0 - Untuk menampilkan semua barang");

            System.out.println("Masukkan nomor pilihan  :");
            int choose = inAngka.nextInt();
            String filter = null;
            switch (choose){
                case 1 : filter = "kamera";
                    break;
                case 2 : filter = "handphone";
                    break;
                case 3 : filter = "smartphone";
                    break;
                case 4 : filter = "laptop";
                    break;

                case 0 : filter = "all";
                    break;
            }
            ArrayList<Barang> filtered = null;
            if (!filter.equalsIgnoreCase("all")){
                System.out.println("Produk " + filter + " :");
                for (Barang barang : stokBarang){
                    if (barang.getJenis().equalsIgnoreCase(filter)){
                        filtered.add(barang);
                    }
                }
            } else {
                System.out.println("Menampilkan semua produk :");
                filtered = stokBarang;
            }

            listFiltered(filtered);

            System.out.print("Ketik -1 untuk kembali ke menu, 0 untuk melihat kategori lain : ");

        } while (!(inAngka.nextInt() == -1));
    }

    /* Menampilkan daftar barang dari filter yang telah ditentukan.
     * Menampilkan detil dari barang pilihan.
     */
    private void listFiltered(ArrayList<Barang> filtered){
        do {
            int i = 0;
            for (Barang barang : filtered){
                System.out.println(i+1 + " - " + barang.getNama() + " " + barang.getJumlah() + " unit");
                i++;
            }

            System.out.println("Pilih barang untuk detail :");
            Barang barangPilihan = filtered.get(inAngka.nextInt());
            System.out.println("Jenis :" + barangPilihan.getJenis());
            System.out.println("Merek :" + barangPilihan.getMerek());
            System.out.println("Nomor Seri :" + barangPilihan.getNomorSeri());
            System.out.println("Warna :" + barangPilihan.getWarna());
            System.out.println("Deskripsi :" + barangPilihan.getDeskripsi());
            System.out.println("Harga :" + barangPilihan.getHarga());
            if (barangPilihan.getJumlah() == 0){
                System.out.println("Barang sedang habis");
            } else {
                System.out.println("Barang tersedia");
            }
            System.out.print("Ketik -1 untuk kembali, 0 untuk melihat barang lain : ");

        } while (!(inAngka.nextInt() == -1));

    }

    /* Jika keranjang kosong, tampilkan bahwa kosong.
     * Tampilkan isi keranjang
     * Tampilkan menu
     *  menu 1 - tampilkan isi dengan {@link #listFiltered}
     *  menu 2 - menghapus barang dengan {@link #deleteBelanjaan}
     */
    private void cekKeranjang(){
        if(keranjang.size() == 0){
            System.out.println("Anda belum membeli barang apapun.");
            return;
        }
        int choose;
        do {
            System.out.println("Isi keranjang belanja anda :");
            int totalBelanja = 0;
            for (Barang barang : keranjang){
                totalBelanja += printdanhargaBarang(barang);
            }
            System.out.println("Jumlah barang : " + keranjang.size() + " macam");
            System.out.println("Total Belanja : " + totalBelanja + " rupiah");

            System.out.println("1 - cek detail barang di keranjang");
            System.out.println("2 - hapus barang di keranjang");
            System.out.print("Masukkan nomor pilihan (-1 untuk kembali ke menu) : ");
            choose = inAngka.nextInt(); 
            switch (choose){
                case 1 : listFiltered(keranjang);
                      break;
                case 2 : keranjang = deleteBelanjaan(keranjang);
                      break;
            }

        } while (!(choose == -1));

    }

    /* Menampilkan barang dengan bentuk list.
     * Menghapus barang pilihan.
     */
    private ArrayList<Barang> deleteBelanjaan(ArrayList<Barang> daftarBarang) {
        int i = 0;
        do {
            System.out.println("Daftar barang :");
            for (Barang barang : daftarBarang){
                System.out.println(i+1 + " - " + barang.getNama() + " " + barang.getJumlah() + " unit");
                i++;
            }
            System.out.print("Masukkan nomor yang ingin dihapus :");
            daftarBarang.remove(inAngka.nextInt()-1);

            System.out.print("Ketik -1 untuk kembali, 0 untuk menghapus barang lain : ");

        } while (!(inAngka.nextInt() == -1));
        return daftarBarang;
    }

    /* Menanyakan nomor seri barang.
     * Menampilkan barang dan menanyakan untuk dimasukkan ke keranjang.
     * Cek ada/tidak dengan {@link #cekEksis} ,
     * Cek sudah habis/belum dengan {@link #cekSedia},
     * Cek sudah ada di keranjang/belum dengan {@link #cekBandingKeranjang},
     * Cek jumlah lebih/tidak dengan {@link #cekBanyakPesanan}.
     */
    private void beli() {
        int pilihan = 0;
        do {
            System.out.println("Masukkan nomor seri barang :");
            String nomorBarang = inKata.nextLine();

            Barang barangPilihan = cekEksis(nomorBarang);
            if (barangPilihan == null) {
                System.out.print("Barang tidak ditemukan");
                System.out.println();
                continue;
            }

            if (cekSedia(barangPilihan)) {
                System.out.println("Barang " + barangPilihan.getNama() + "sudah habis");
                System.out.println();
                continue;
            }

            if (cekBandingKeranjang(barangPilihan)) {
                System.out.println("Barang " + barangPilihan.getNama() + "sudah ada di keranjang.");
                System.out.println("Silahkan hapus barang di menu keranjang.");
                System.out.println();
                continue;
            }

            System.out.println("Nama Barang : " + barangPilihan.getNama() + " " + barangPilihan.getHarga());
            System.out.println("Masukkan jumlah yang ingin anda beli : ");
            int jumlahBarang = inAngka.nextInt();

            if (cekBanyakPesanan(barangPilihan, jumlahBarang)) {
                System.out.println("Barang tidak cukup, silahkan masukkan jumlah lain :");
                System.out.println();
                continue;
            }

            barangPilihan.setJumlah(jumlahBarang);
            keranjang.add(barangPilihan);
            System.out.println(barangPilihan.getNomorSeri() + " berhasil dimasukkan keranjang sebanyak " + barangPilihan.getJumlah() + " unit");

            System.out.println();
            System.out.println("Ketik 0 untuk membeli barang lain, ketik -1 untuk kembali :");

            pilihan = inAngka.nextInt();

        } while (!(pilihan == -1));
    }

    // Memeriksa apakah barang dijual
    private Barang cekEksis(String nomorBarang){
        Barang barangPilihan = null;
        for (Barang barang : gudang.getStok()) {
            if (barang.getNomorSeri().equalsIgnoreCase(nomorBarang)) {
                barangPilihan = barang;
            }
        }
        return barangPilihan;
    }

    // Memeriksa ketersediaan barang
    private boolean cekSedia(Barang barangPilihan){
        for (Barang barangStok : gudang.getStok()){
            if (barangStok.getNomorSeri().equalsIgnoreCase(barangPilihan.getNomorSeri())){
                if (barangStok.getJumlah() > 0){
                    return true;
                }
            }
        }
        return false;
    }

    // Memeriksa apakah sudah dikeranjang
    private boolean cekBandingKeranjang(Barang barangPilihan){
        for (Barang barangKeranjang : keranjang){
            if (barangKeranjang.getNomorSeri().equalsIgnoreCase(barangPilihan.getNomorSeri())){
                return true;
            }
        }
        return false;
    }

    // Memeriksa apakah pesanan cukup dari stok yang ada
    private boolean cekBanyakPesanan(Barang barangPilihan, int jumlahBarang){
        for (Barang barangStok : gudang.getStok()){
            if (barangStok.getNomorSeri().equalsIgnoreCase(barangPilihan.getNomorSeri())){
                if (barangStok.getJumlah() >= jumlahBarang){
                    return true;
                }
            }
        }
        return false;
    }

    /* Menghitung belnajaan 
     * Menambahkan {@link #activePelanggan} ke {@link #daftarPelanggan}
     */
    private void checkOut(){
        System.out.println("Berikut belanjaan anda :");
        int total = hitungAkhir(keranjang);
        System.out.println("Total belanjaan anda : " + total);
        System.out.print("Pilih metode pembayaran (1 - Tunai, 2 - Kredit) :");
        int metodeBayar = inAngka.nextInt();
        if (metodeBayar == 1){
            System.out.println("Silahkan untuk membayar langsung di kasir.");
        } else {
            System.out.println("Petugas kami akan segera menghubungi anda melalui telepon.");
        }

        activePelanggan.setMetodeBayar(metodeBayar);
        
        daftarPelanggan.add(activePelanggan);
        System.out.println("Terima kasih telah berbelanja di TOKO PAK ZAKI.");
        System.out.println("");
        System.out.println("Silahkan untuk memberikan kesempatan kepada pelanggan lainnya.");
        
        System.out.println("");System.out.println("");System.out.println("");System.out.println("");
    }
    
    /* Menghitung keranjang secara rekursif.
     * Menampilkan barang.
     * Mengurangi stok barang di gudang.
     * Menambahkan barang ke belanjaan {@link #activePelanggan}.
     * Menghapus item yang sudah dihitung.
     */
    private int hitungAkhir(ArrayList<Barang> keranjang){
        if (this.keranjang.size() == 0){
            return 0;
        }
        Barang barang = keranjang.get(0);
        int harga = printdanhargaBarang(barang);
        gudang.kurangiStok(barang.getNomorSeri(), barang.getJumlah());
        activePelanggan.addBelanjaan(barang);
        keranjang.remove(0);
        return harga + hitungAkhir(keranjang);
    }


}