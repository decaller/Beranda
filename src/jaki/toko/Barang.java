package jaki.toko;

/**
 * Created by HarridiIlman on 25/11/2015.
 */
 
 //Kelas barang digunakan untuk membentuk objek dari barang
public class Barang {
    
    //Menyimpan jenis barang
    String jenis;
    
    //Menyimpan merek barang
    String merek;
    
    //Menyimpan nomor seri barang
    String nomorSeri;
    
    //menyimpan warna barang
    String warna;
    
    //menyimpan deskripsi barang
    String deskripsi;
    
    //menyimpan harga barang
    int harga;
    
    //menyimpan jumlah barang
    int jumlah;

//Menginisiasi Barang {@link #jenis}, {@link #merek}, {@link #nomorSeri}, {@link #warna}, {@link #deskripsi}, {@link #harga}
    public Barang(String jenis, String merek, String nomorSeri, String warna, String deskripsi, int harga) {
        this.jenis = jenis;
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.warna = warna;
        this.deskripsi = deskripsi;
        this.harga = harga;

        jumlah = 0;
    }
    //Mengambil {@link #jenis}, {@link #merek}, {@Link #nomorSeri}
    public String getNama() {
        return jenis + " " + merek + " " + nomorSeri + " ";
    }
    
    //Mengambil {@link #jumlah}
    public int getJumlah() {
        return jumlah;
    }

    //Mengambil  {@link #harga}
    public int getHarga() {
        return harga;
    }

    //Memasukkan  {@link #jumlah}
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    //Mengurangi {@link #jumlah}
    public void kurangiJumlah(int jumlah){
        this.jumlah -= jumlah;
    }

    //Mengambil  {@link #jenis}
    public String getJenis() {
        return jenis;
    }

    //Mengambil  {@link #merek}
    public String getMerek() {
        return merek;
    }

    //Mengambil {@link #nomorSeri}
    public String getNomorSeri() {
        return nomorSeri;
    }

    //Mengambil {@link #warna}
    public String getWarna() {
        return warna;
    }

    //Mengambil {@link #deskripsi}
    public String getDeskripsi() {
        return deskripsi;
    }


}
