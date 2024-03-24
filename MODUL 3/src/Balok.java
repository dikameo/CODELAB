import java.util.Scanner;

public class Balok extends BangunRuang{
    Scanner scanner = new Scanner(System.in);
    private double panjang,lebar,tinggi;


        // Wahyu Andika
    // 202310370311075
    // 2B
    Balok(String nameBangun) {
        super(nameBangun);
    }

    
    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input panjang: ");
        panjang = scanner.nextDouble();
        System.out.print("Input lebar: ");
        lebar = scanner.nextDouble();
        System.out.print("Input tinggi: ");
        tinggi = scanner.nextDouble();
    }

    @Override
    public void luasPermukaan(){
        double hasil = 2 * ((panjang * tinggi) + (panjang * lebar) + (tinggi * lebar));
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }

    @Override
    public void volume(){
        double hasil = panjang * lebar * tinggi ;
        super.volume();
        System.out.println("Hasil volume: " + hasil);
    }
}

