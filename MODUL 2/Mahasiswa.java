import java.util.ArrayList;
import java.util.Scanner;
class Mahasiswa {
    static ArrayList<String> arrNama = new ArrayList<>();
    static ArrayList<String> arrNim = new ArrayList<>();
    static ArrayList<String> arrJurusan = new ArrayList<>();

    static String tampilUniversitas() {
        String nama;
        String nim;
        String jurusan;

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama Mahasiswa : ");
        nama = input.nextLine();
        System.out.print("Masukkan nim Mahasiswa : ");
        nim = input.nextLine();
        while(nim.length()!=15){
            System.out.println("NIM harus 15 Digit !!!");
            System.out.print("Masukkan nim Mahasiswa : ");
            nim = input.nextLine();
        }
        System.out.print("Masukkan jurusan Mahasiswa : ");
        jurusan = input.nextLine();
        
        arrNama.add(nama);
        arrNim.add(nim);
        arrJurusan.add(jurusan);

        return "Mahasiswa berhasil ditambahkan";
        
    }
    public String tampilkanDataMahasiswa() {
        StringBuilder data = new StringBuilder("Universitas Muhammadiyah Malang\n");
        for (int i = 0; i < arrNama.size(); i++) {
            data.append("Nama: ").append(arrNama.get(i)).append(", NIM: ").append(arrNim.get(i)).append(", Jurusan: ").append(arrJurusan.get(i)).append("\n");
        }
        return data.toString();
    }
    
}
