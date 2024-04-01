
import java.security.SecureRandom;
import java.util.Scanner;

public class Admin extends User{
    String adminUsername;
    String adminPassword;
    private String[] studentList;
    private String[] book;

    void displayStudents() {
        for (String data : userStudent) {
                studentList = data.split("-");
                System.out.println("Nama: " + studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2] + "\nProgram:" + studentList[3] + "\n");
            }
            Main.menuAdmin();
     }
        
    void addStudent() {
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan nama Mahasiswa : ");
            String nama = input.nextLine();
            System.out.print("Masukkan nim Mahasiswa : ");
            String nim = input.nextLine();
            while (nim.length() != 15) {
                System.out.println("NIM harus 15 Digit !!!");
                System.out.print("Masukkan nim Mahasiswa : ");
                nim = input.nextLine();
            }
            System.out.print("Masukkan fakultas Mahasiswa : ");
            String fakultas = input.nextLine();
            System.out.print("Masukkan jurusan Mahasiswa : ");
            String jurusan = input.nextLine();
        
            userStudent.add(nama + "-" + fakultas + "-" + nim + "-" + jurusan);
        
            Main.menuAdmin();
            input.close();
        }
      void displayBook() {
            System.out.println("===================================================================================");
            System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Stock ||");
            System.out.println("===================================================================================");

            for (int i = 0; i < bookList.size(); i++) {
                book = bookList.get(i).split("\\*");
                System.out.println("|| " + (i + 1) + " || " + book[0] + "\t ||" +book[1] + "\t || " +book[2] + "\t ||" + book[3] + "\t || ");
            }
                System.out.println("===================================================================================");
                Main.menuAdmin();
            }
            
     void inputBook() {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter book title : ");
                String title = input.nextLine();
                System.out.print("Enter author : ");
                String author = input.nextLine();
                System.out.print("Enter the stock : ");
                int stock = input.nextInt();
            
                bookList.add(generateId()+"*"+title + "*" + author + "*" + stock );
                System.out.println(bookList);
            
                Main.menuAdmin();
                input.close();
            }


    // DONE BARU
    boolean isAdmin(String userAdmin, String passAdmin){
        if (userAdmin.equalsIgnoreCase("admin") && passAdmin.equalsIgnoreCase("admin")) {
            return true;        
        } else {
            return false;
        }
    }

    public String generateId(){
         SecureRandom secureRandom = new SecureRandom();
    byte[] randomBytes = new byte[10];
    secureRandom.nextBytes(randomBytes);

    String randomString = "";
    for (byte b : randomBytes) {
    randomString += String.format("%02x", b);
}
    return randomString.substring(0, 4)  +"-"+ randomString.substring(2, 6)+"-"+randomString.substring(4, 8);
    }
}
