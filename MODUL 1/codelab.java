import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;
public class codelab{
    public static void main(String[] args) {

        // Nama : Wahyu andika
        // NIM : 202310370311075
        // KELAS : B
        Scanner input = new Scanner(System.in);
        String nama;
        String jkel;
        String tgl;

        System.out.print("Nama :");
        nama = input.nextLine();

        System.out.print("Jenis Kelamin(L/P) :");
        jkel = input.nextLine();

        System.out.print("Tanggal lahir (yyyy-mm-dd) : ");
        tgl = input.nextLine();

        LocalDate tgllahir = LocalDate.parse(tgl); // memecah
        LocalDate hariIni = LocalDate.now(); // tanggal hari ini

        Period umur = Period.between(tgllahir, hariIni);  // untuk melihat selang
        int tahun = umur.getYears();
        int bulan = umur.getMonths();

        
        System.out.println("\nNama : " + nama);
        if (jkel.equalsIgnoreCase("P")) {
            System.out.println("Jenis Kelamin : Perempuan");
        }else if (jkel.equalsIgnoreCase("L")){
            System.out.println("Jenis Kelamin : Laki - Laki");
        }else{
            System.out.println("Tidak ditemukan");
        }

        System.out.print("Umur Anda : " + tahun + " tahun "+ bulan +" bulan");
        input.close();
    }
}