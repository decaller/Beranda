package jaki.toko;

import java.util.ArrayList;

/**
 * Created by HarridiIlman on 25/11/2015.
 */
public class Gudang {

    String alamatGudang;
    String telponGudang;

    ArrayList<Barang> stok;

    public Gudang(String alamatGudang, String telponGudang) {
        this.alamatGudang = alamatGudang;
        this.telponGudang = telponGudang;

        RandomGenerator generator = new RandomGenerator();

        ArrayList<Integer> jumlah = generator.getJumlahBarang();
        stok = generator.getListBarang();

        for(int i = 0; i < stok.size(); i++){
            stok.get(i).setJumlah(jumlah.get(i));
        }

    }

    public ArrayList<Barang> getStok() {
        return stok;
    }


    public String getTelponGudang() {
        return telponGudang;
    }

    public String getAlamatGudang() {
        return alamatGudang;
    }
}
