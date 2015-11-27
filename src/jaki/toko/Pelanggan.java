package jaki.toko;

import java.util.ArrayList;

/** Kelas Pelanggan digunakan untuk membentuk objek dari pelanggan
 * Created by HarridiIlman on 25/11/2015.
 */
public class Pelanggan {

    //Menyimpan nama pelanggan (U don't say!)
    String namaPelanggan;
    
    //Menyimpan telpon pelanggan (U don't say!)
    String telponPelanggan;
    
    //Menyimpan alamat pelanggan (U don't say!)
    String alamatPelanggan;

    //Menyimpan belanjaan pelanggan yang teridir dari {@link #barang}
    ArrayList<Barang> belanjaan;
    
    //Menyimpan metode bayar pelanggan (1 -Tunai, 2 - Kredit)
    int metodeBayar;
    
    //Menginisiasi Pelanggan {@link #namaPelanggan}, {@link #telponPelanggan}, {@link #alamatPelanggan}
    public Pelanggan(String namaPelanggan, String telponPelanggan, String alamatPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.telponPelanggan = telponPelanggan;
        this.alamatPelanggan = alamatPelanggan;

    }

    //Mengambil {@link #namaPelanggan}
    public String getNama() {
        return namaPelanggan;
    }

    //Mengambil {@link #alamatPelanggan}
    public String getAlamat() {
        return alamatPelanggan;
    }

    //Mengambil {@link #telponPelanggan}
    public String getTelpon() {
        return telponPelanggan;
    }

    //Menambahkan {@link #barang} ke {@link #belanjaan}
    public void addBelanjaan(Barang barang){
        belanjaan.add(barang);
    }

    //Mengambil {@link #belanjaan}
    public ArrayList<Barang> getBelanjaan() {
        return belanjaan;
    }
    
    //Memasukkan {@link #metodeBayar}
    public void setMetodeBayar(int metodeBayar){
        this.metodeBayar = metodeBayar;
    }
}
