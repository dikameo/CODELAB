package com.main.data;

import java.security.SecureRandom;
import java.util.Scanner;

import com.main.books.Book;
import com.main.exception.custom.illegalAdminAccess;
import com.main.util.Imenu;
import com.main.util.Main;

public class Adminnew extends User implements Imenu{
    String adminUsername;
    String adminPassword;
    String kategori;
    private String[] studentList;
    private String nim;

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNim(){
        return this.nim;
    }

    public void displayStudents() {
        for (String data : userStudent) {
                studentList = data.split("\\*");
                System.out.println("Nama: " + studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2] + "\nProgram:" + studentList[3] + "\n");
            }
            Main.menuAdmin();
     }
        
    public void addStudent() {
            Student maba = new Student();
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan nama Mahasiswa : ");
            String nama = input.nextLine();
            maba.setName(nama);
            System.out.print("Masukkan nim Mahasiswa : ");
            String kirimNim =input.nextLine();
            maba.setNim(kirimNim);
            while (kirimNim.length() != 15) {
                System.out.println("NIM harus 15 Digit !!!");
                System.out.print("Masukkan nim Mahasiswa : ");
                kirimNim = input.nextLine();
                maba.setNim(kirimNim);
            }
            System.out.print("Masukkan fakultas Mahasiswa : ");
            String fakultas = input.nextLine();
            maba.setFaculty(fakultas);
            System.out.print("Masukkan jurusan Mahasiswa : ");
            String jurusan = input.nextLine();
            maba.setProgramStudi(jurusan);
            userStudent.add(maba.getName() + "*" + maba.getFaculty() + "*" + maba.getNim() + "*" + maba.getProgramStudi());
            System.out.println(userStudent);
            userBorrowed.addAll(userStudent);
        
            Main.menuAdmin();
            input.close();
        }

            
     public void inputBook() {
        Book buku = new Book();
         Scanner input = new Scanner(System.in);
         System.out.println("Select book category : ");
         System.out.println("1. Story Book ");
         System.out.println("2. History Book ");
         System.out.println("3. Text Book ");
         System.out.print("Choose category (1-3): ");
         String pil = input.nextLine();
         switch (pil) {
            case "1":
                buku.setCategory("Cerita");
                break;
                case "2":
                buku.setCategory("Sejarah");
                break;
                case "3":
                buku.setCategory("Novel");
                break;
            default:
                break;
         }
                System.out.print("Enter book title : ");
                String title = input.nextLine();
                buku.setTitle(title);
                System.out.print("Enter author : ");
                String author = input.nextLine();
                buku.setAuthor(author);
                System.out.print("Enter the stock : ");
                int stock = input.nextInt();
                buku.setStock(stock);
                buku.setBookId(generateId());
                bookList.add(buku.getBookId()+"*"+buku.getTitle() + "*" + buku.getAuthor() + "*" +buku.getCategory()+"*"+ buku.getStock()+"*");
                System.out.println(bookList);
                Main.menuAdmin();
                input.close();
            }



    @Override
    public void displayBook() {
        System.out.println("===================================================================================");
        System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Stock ||");
        System.out.println("===================================================================================");

        for (int i = 0; i < bookList.size(); i++) {
            book = bookList.get(i).split("\\*");
            System.out.println("|| " + (i + 1) + " || " + book[0] + "\t ||" +book[1] + "\t || " +book[2] + "\t ||" + book[3] + "\t || "+ book[4] + "\t ||");
        }
            System.out.println("===================================================================================");
            Main.menuAdmin();
        }
    // DONE BARU
     public boolean isAdmin(String userAdmin, String passAdmin) throws illegalAdminAccess{
        if (userAdmin.equalsIgnoreCase("admin") && passAdmin.equalsIgnoreCase("admin")) {
            return true;        
        } else {
            throw new illegalAdminAccess("Invalid credentials");
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

    @Override
    public void menu(String nim) {
    }

    @Override
    public void menu() {
        Scanner input = new Scanner(System.in);
        int pil = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("===== Admin Menu =====");
                System.out.println("1. Add Student");
                System.out.println("2. Add Book");
                System.out.println("3. Display Registered Student");
                System.out.println("4. Display Available");
                System.out.println("5. Logout");
                System.out.print("Choose option (1-5): ");
                pil = input.nextInt();

                if (pil < 1 || pil > 5) {
                    throw new IllegalArgumentException("Pilihan tidak valid. Silakan pilih antara 1 dan 5.");
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                input.nextLine(); 
            }
        }

        Adminnew tmpAdmin = new Adminnew();

        switch (pil) {
            case 1:
                tmpAdmin.addStudent();
               break;
            case 2:
                tmpAdmin.inputBook();
                break;
            case 3:
                tmpAdmin.displayStudents();
                break;
            case 4:
                tmpAdmin.displayBook();
                break;
            case 5:
                Main.menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
        }
    }

