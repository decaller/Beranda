package jaki.toko;

import java.util.ArrayList;

/**
 * Created by HarridiIlman on 25/11/2015.
 */
public class Pelanggan {

    String namaPelanggan;
    String telponPelanggan;
    String alamatPelanggan;

    ArrayList<Barang> belanjaan;
    int metodeBayar;

    public Pelanggan(String namaPelanggan, String telponPelanggan, String alamatPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.telponPelanggan = telponPelanggan;
        this.alamatPelanggan = alamatPelanggan;


    }

    public String getNama() {
        return namaPelanggan;
    }

    public String getAlamat() {
        return alamatPelanggan;
    }

    public String getTelpon() {
        return telponPelanggan;
    }

    public void addBelanjaan(Barang barang){
        belanjaan.add(barang);
    }

    public ArrayList<Barang> getBelanjaan() {
        return belanjaan;
    }
    
    public void setMetodeBayar(metodeBayar){
        this.metodeBayar = metodeBayar;
    }
}
