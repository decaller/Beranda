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
}
