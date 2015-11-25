package jaki.toko;

import java.util.ArrayList;




/** Kelas RandomGenerator digunakan untuk generate data list data Barang dan list jumlah stoknya secara random.
 *
 * @author Ramot Stephanus
 * @version 1.0 Built Mar 18, 2015.
 */
public class RandomGenerator {

    /** Daftar jumlah barang random yang di generate saat inisialisasi kelas ini.
     * Posisi jumlah barang bersesuaian dengan list barangnya di {@link #listBarang}.
     * Harap diingat bahwa anda tidak dapat mengakses variabel ini secara langsung dari kelas lain karena deklarasinya private.
     */
    private ArrayList<Integer> jumlahBarang;

    /** List barang random yang di generate saat insialisasi kelas ini.
     * Posisi list barang bersesuaian dengan jumlah barangnya di {@link #jumlahBarang}.
     * Harap diingat bahwa anda tidak dapat mengakses variabel ini secara langsung dari kelas lain karena deklarasinya private.
     */
    private ArrayList<Barang> listBarang;

    /** Mengisi variabel {@link #listBarang} dengan daftar Barang random serta variabel {@link #jumlahBarang} dengan daftar jumlah random.
     * Keduanya mempunyai hubungan posisi yang sama. Jadi misalnya barang pertama di dalam {@link #listBarang} adalah Kamera, maka jumlah pertama di dalam {@link #jumlahBarang} adalah jumlah Kamera tersebut.
     */
    public RandomGenerator() {
        String [] jenis = {"Kamera", "Handphone", "Smartphone", "Laptop"};
        String [] warna = {"Brave Red", "Calm Blue", "Bright White", "Mystery Black"};
        String [][] merek = {{"Samsung","Nikon","Canon","Olympus","Sony"},{"Samsung", "LG", "Motorola", "Sony", "Nokia"},{"LG", "Sony", "Samsung", "Nokia", "Motorola"},{"Samsung", "Lenovo", "Asus", "Sony", "Acer"}};
        String [][] deskripsi = new String[4][5];
        int [][] harga = new int[4][5];
        String [] resolusi = {"1366 x 768", "3840 x 2160", "1920 x 1080"};
        String [] tipeKam = {"Prosumer", "DSLR", "Mirrorless"};
        int [] memori = {2, 4, 8};

        for (int a = 0; a < 5; a++) {
            deskripsi[0][a] = "Sensor " + (int)(Math.random()*9+12) + " megapixel \n Tipe " + tipeKam[(int)(Math.random()*3)] + " \n Zoom " + (int)(Math.random()*11+10)+ "x";
            deskripsi[1][a] = "Layar " + (int)(Math.random()*3 +2) + " inchi \n Processor " + (int)(Math.random()*2+1) + " core \n Baterai " + ((((int)(Math.random()*8))*100) + 800) + " mAh";
            deskripsi[2][a] = "Layar " + (int)(Math.random()*3 +4) + " inchi \n Processor " + (int)(Math.random()*3+2) + " core \n Baterai " + ((((int)(Math.random()*9))*100) + 1700) + " mAh";;
            deskripsi[3][a] = "Layar " + (int)(Math.random()*5 +12) + " inchi \n Resolusi " + resolusi [(int)(Math.random()*3)] + " \n RAM " + memori[(int)(Math.random()*3)] + " GB";

            harga[0][a] = (((int)(Math.random()*401))*10000) + 3000000;
            harga[1][a] = (((int)(Math.random()*151))*10000) + 500000;
            harga[2][a] = (((int)(Math.random()*501))*10000) + 2000000;
            harga[3][a] = (((int)(Math.random()*701))*10000) + 5000000;
        }

        listBarang = new ArrayList<Barang>();
        jumlahBarang = new ArrayList<Integer>();
        int i = (int) (Math.random()*10 + 1);
        for (int j = 0; j<i; j++) {
            int k = (int) (Math.random()*4);
            int l = (int) (Math.random()*4);
            String nomorSeri = jenis[k].substring(0, 3).toUpperCase() + (int) (Math.random()*1000) + merek[k][l].substring(0, 2).toUpperCase();
            Barang barang = new Barang(jenis[k], merek[k][l], nomorSeri, warna[k], deskripsi[k][l], harga [k][l]);
            listBarang.add(barang);
            jumlahBarang.add((int)(Math.random()*10));
        }
    }

    /** Return jumlah barang random yang di generate, berurutan sesuai dengan posisi list barang.
     * @return jumlah barang random yang di generate, berurutan sesuai dengan posisi list barang.
     * @see #RandomGenerator()
     */
    public ArrayList<Integer> getJumlahBarang() {
        return jumlahBarang;
    }

    /** Return list barang random yang di generate.
     * @return list barang random yang di generate.
     * @see #RandomGenerator()
     */
    public ArrayList<Barang> getListBarang() {
        return listBarang;
    }
}
