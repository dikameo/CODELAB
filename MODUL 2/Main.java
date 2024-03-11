import java.util.Scanner;
public class Main {
      static void menu(){
            int pil;
            Scanner input = new Scanner(System.in);
            Mahasiswa maba = new Mahasiswa();
    
            System.out.println("\nMenu: ");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan : ");
            pil = input.nextInt();
    
            switch (pil) {
                case 1:
                    Mahasiswa.tampilUniversitas();//static
                    main(null);
                    break;
                case 2:
                    System.out.println(maba.tampilkanDataMahasiswa());//non - static
                    main(null);
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    main(null);
            }
    
            input.close();
        }

    public static void main(String[]args){

        /* 
         * Nama: Wahyu Andika 
         * Nim : 202310370311075
         * Kelas : 2B
         * Modul : CODELAB MODUL 2 
         * 
         */
        Main.menu();
    }
    
}

