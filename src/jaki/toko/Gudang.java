package jaki.toko;

import java.util.ArrayList;

/**
 * Created by HarridiIlman on 25/11/2015.
 */
public class Gudang {

    String alamatGudang;
    String telponGudang;

    public Gudang(String alamatGudang, String telponGudang) {
        this.alamatGudang = alamatGudang;
        this.telponGudang = telponGudang;

    }

    public ArrayList<Barang> getStok() {
        return stok;
    }

    public String getInfo() {
        return info;
    }
}
