package jaki.toko;

/**
 * Created by HarridiIlman on 25/11/2015.
 */
public class Barang {
    String jenis;
    String merek;
    String nomorSeri;
    String warna;
    String deskripsi;
    int harga;
    int jumlah;

    public Barang(String jenis, String merek, String nomorSeri, String warna, String deskripsi, int harga) {
        this.jenis = jenis;
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.warna = warna;
        this.deskripsi = deskripsi;
        this.harga = harga;

        jumlah = 0;
    }

    public String getNama() {
        return jenis + merek + nomorSeri;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getJenis() {
        return jenis;
    }

    public String getMerek() {
        return merek;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public String getWarna() {
        return warna;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


}
