package MODUL5;

import java.util.ArrayList;
import java.util.Scanner;

public class Codelab {

    static void inputData(ArrayList<String> nama, int count) throws IllegalArgumentException {
        Scanner input = new Scanner(System.in);
        boolean isRun = true;
        
        while (isRun) {
            System.out.printf("Masukkan Nama ke-%d: ", count += 1);
            String masuk = input.nextLine().trim();
            
            if (masuk.isEmpty()) {
                throw new IllegalArgumentException("Nama tidak boleh kosong !!");
            }
            
            if (masuk.equalsIgnoreCase("selesai")) {
                System.out.println("Daftar Mahasiswa yang diinputkan:");
                for (String name : nama) {
                    System.out.println("- " + name);
                }
                isRun = false;
            } else {
                nama.add(masuk);
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        boolean validInput = false;
        ArrayList<String> nama = new ArrayList<String>();
        int count = 0;

        while (!validInput) {
            try {
                inputData(nama, count);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                count = nama.size(); 
            }
        }


    }
}
