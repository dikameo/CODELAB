package com.main.data;

import java.util.Scanner;

import com.main.util.Imenu;
import com.main.util.Main;

public class Student extends User implements Imenu{
    private String name;
    private String nim;
    private String faculty;
    private String programStudi;
    private String[] studentList;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setNim(String nim){
        this.nim = nim;
    }
    public String getNim(){
        return this.nim;
    }
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    public String getFaculty(){
        return this.faculty;
    }
    public void setProgramStudi(String programStudi){
        this.programStudi = programStudi;
    }
    public String getProgramStudi(){
        return this.programStudi;
    }

    // overloading
    public Student (){
        this.name = "";
        this.nim = "";
        this.faculty = "";
        this.programStudi = "";
    }


    public Student (String name, String nim, String faculty, String programStudi){
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    
    public void Logout(String nim){
        Scanner input = new Scanner(System.in);
        String pil;
        System.out.println("Apakah kamu yakin untuk Meminjam semua buku tersebut");
        System.out.println("Input Y(iya) atau T (tidak)");
        pil = input.next();
        if (pil.equalsIgnoreCase("y")) {
            System.out.println("Peminjaman buku berhasil dilakukan");
            System.out.println("Terima kasih");
            Main.menu();
        }else{
            menu(nim);
        }

        input.close();
    }

    public void displayInfo(String nim){

        for (String data : userStudent) {
            studentList = data.split("\\*");
            if (studentList[2].equals(nim)) {
                System.out.print("Nama: " + studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2] + "\nProgram:" + studentList[3] + "\n");
            }
        }
        
        menu(nim);
    }
    public void choiceBooks(String nim) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("===================================================================================");
        System.out.println("|| No.  || Id buku  ||Nama Buku|| Author  || Category|| Stock ||");
        System.out.println("===================================================================================");
    
        for (int i = 0; i < bookList.size(); i++) {
            String[] book = bookList.get(i).split("\\*");
            System.out.println("|| " + (i + 1) + " || " + book[0] + "  ||" + book[1] + " || " + book[2] + "  || " + book[3] + " || " + book[4] + " ||");
        }
        System.out.println("===================================================================================");
    
        System.out.println("Input Id Buku yang Ingin dipinjam (input 99 untuk kembali ke menu sebelumnya)");
        System.out.print("Input: ");
        String id = input.nextLine();
    
        if (id.equals("99")) {
            menu(nim);
        }
    
        boolean bookFound = false;
        for (int i = 0; i < bookList.size(); i++) {
            String[] book = bookList.get(i).split("\\*");
            if (id.equals(book[0])) {
                bookFound = true;
                System.out.println("Buku dapat dipinjam");
                System.out.println("Berapa lama anda ingin meminjam buku ?");
                System.out.print("Input lama hari :");
                int durasi = input.nextInt();
                input.nextLine();
    
                userBorrowed.add(book[0] +"*"+book[1]+"*"+book[2]+"*"+book[3]+"*" + durasi + "*" + nim);

                int stock = Integer.parseInt(book[4]);
                stock--;
                book[4] = String.valueOf(stock);
                bookList.set(i, String.join("*", book));
    
                System.out.println("Buku berhasil dipinjam!");
                break;
            }
        }
    
        if (!bookFound) {
            System.out.println("Id tidak ditemukan. Input 99 untuk kembali ke menu sebelumnya.");
        }
    
        menu(nim);
        input.close();
    }
    
    public void showBorrowedBooks(String nim){

        boolean borrowedBooksExist = false; 

        for (int i = 0; i < userBorrowed.size(); i++) {
            String[] book = userBorrowed.get(i).split("\\*");
            
            if(book[5].equals(nim)){
                tampilkan(nim);
            }
        }
    
        if (!borrowedBooksExist) {
            System.out.println("Belum meminjam buku");
        }
    
        menu(nim);
    }
    

    void tampilkan(String nim){
        System.out.println("===================================================================================");
        System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Durasi ||");
        System.out.println("===================================================================================");
    
   
    
        for (int i = 0; i < userBorrowed.size(); i++) {
            String[] book = userBorrowed.get(i).split("\\*");
            
            if(book[5].equals(nim)){
                System.out.println("|| " + (i + 1) + " || " + book[0] + "  ||" + book[1] + " || " + book[2] + "  || " + book[3] + " || " + book[4] + " ||");
                // borrowedBooksExist = true; 
            }
        }
        System.out.println("===================================================================================");
        menu(nim);
    }
    
    public void returnBooks(String nim){
        System.out.println("===================================================================================");
        System.out.println("|| No. || Id buku \t ||Nama Buku\t|| Author\t|| Category\t|| Durasi ||");
        System.out.println("===================================================================================");

        Scanner input = new Scanner(System.in);
        boolean borrowedBooksExist = false; 

        for (int i = 0; i < userBorrowed.size(); i++) {
            String[] book = userBorrowed.get(i).split("\\*");
            
            if(book[5].equals(nim)){
                System.out.println("|| " + (i + 1) + " || " + book[0] + "  ||" + book[1] + " || " + book[2] + "  || " + book[3] + " || " + book[4] + " ||");
                // borrowedBooksExist = true; 
            }
        }
        
        System.out.println("===================================================================================");
        if (!borrowedBooksExist) {
            System.out.println("Belum meminjam buku");
        }

    System.out.println("Masukkan ID buku yang ingin Anda kembalikan (input 99 untuk kembali ke menu sebelumnya):");
    System.out.print("Input: ");
    String idToReturn = input.nextLine();

    if (idToReturn.equals("99")) {
        menu(nim);
        input.close();
        return;
    }

    boolean bookReturned = false;
    for (int i = 0; i < userBorrowed.size(); i++) {
        String[] book = userBorrowed.get(i).split("\\*");
        if (book[5].equals(nim) && book[0].equals(idToReturn)) {
            // Hapus buku dari daftar yang dipinjam oleh pengguna
            userBorrowed.remove(i);

            // Temukan buku dalam daftar buku perpustakaan dan tambahkan kembali stoknya
            for (int j = 0; j < bookList.size(); j++) {
                String[] libraryBook = bookList.get(j).split("\\*");
                if (libraryBook[0].equals(idToReturn)) {
                    int stock = Integer.parseInt(libraryBook[4]);
                    stock++;
                    libraryBook[4] = String.valueOf(stock);
                    bookList.set(j, String.join("*", libraryBook));
                    bookReturned = true;
                    break;
                }
            }
            System.out.println("Buku berhasil dikembalikan.");
            break;
        }
    }

    if (!bookReturned) {
        System.out.println("Buku dengan ID tersebut tidak ditemukan dalam daftar buku yang Anda pinjam.");
    }

    menu(nim);
    input.close();
    }



    // Baru
    @Override
    public void menu(String nim) {
        Scanner input = new Scanner(System.in);
        int pil = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("===== Student Menu =====");
                System.out.println("1. Buku Terpinjam");
                System.out.println("2. Pinjam Buku");
                System.out.println("3. Kembalikan Buku");
                System.out.println("4. Pinjam Buku atau Logout");
                System.out.println("5. Data user");
                System.out.println("6. Logout");
                System.out.print("Choose option (1-6): ");
                pil = input.nextInt();

                if (pil < 1 || pil > 6) {
                    throw new IllegalArgumentException("Pilihan tidak valid. Silakan pilih antara 1 dan 6.");
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

        Student menu = new Student();

        switch (pil) {
            case 1:
                System.out.println("Buku Terpinjam");
                menu.showBorrowedBooks(nim);
                break;
            case 2:
                System.out.println("Pinjam Buku");
                menu.choiceBooks(nim);
                break;
            case 3:
                System.out.println("Kembalikan Buku");
                menu.returnBooks(nim);
                break;
            case 4:
                System.out.println("Pinjam Buku atau Logout");
                menu.Logout(nim);
                break;
            case 5:
                System.out.println("Info Pribadi");
                menu.displayInfo(nim);
                break;
            case 6:
                menu.Logout(nim);
                break;
            default:
                // This should never be reached because of the validation in the while loop
                System.out.println("Pilihan Tidak Valid");
                break;
        }
        input.close();
    }
    @Override
    public void menu() {
        // throw new UnsupportedOperationException("Unimplemented method 'menu'");
    }

}


