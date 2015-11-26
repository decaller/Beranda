package jaki.toko;

import java.util.ArrayList;

/** Kelas GUdag digunakan untuk membentuk objek dari gudang
 * Created by HarridiIlman on 25/11/2015.
 */
public class Gudang {
    
    //Menyimpan alamat gudang
    String alamatGudang;
    
    //Menyimpan telpon gudang
    String telponGudang;
    
    //Menyimpan stok barang yang terdiri dari {@link #barang}
    ArrayList<Barang> stok;

    //Menginisiasi Gudang {@link #alamatGudang}, {@link #telponGudang}
    //Men-'generate' isi gudang
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

    //Mengambil {@link #stok}
    public ArrayList<Barang> getStok() {
        return stok;
    }
    
    //Mencari barang yang tepat dan mengurangi jumlah nya.
    public void kurangiStok(String nomorBarang, int jumlah){
        for(Barang barang : stok){
            if(barang.getNama().equalsIgnoreCase(nomorBarang)){
                barang.kurangiJumlah(jumlah);
            }
        }
    }

    //Mengambil {@link #TelponGudang}
    public String getTelponGudang() {
        return telponGudang;
    }

    //Mengambil {@link #AlamatGudang}
    public String getAlamatGudang() {
        return alamatGudang;
    }
}
