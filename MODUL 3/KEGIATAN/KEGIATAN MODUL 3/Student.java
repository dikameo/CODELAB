import java.util.Scanner;

public class Student extends User{
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

    
    void Logout(String nim){
        Scanner input = new Scanner(System.in);
        String pil;
        System.out.println("Apakah kamu yakin untuk Meminjam semua buku tersebut");
        System.out.println("Input Y(iya) atau T (tidak)");
        pil = input.next();
        switch (pil) {
            case "Y":
                System.out.println("Peminjaman buku berhasil dilakukan");
                System.out.println("Terima kasih");
                Main.menuStudent(nim);;
                break;
        
            default:
                break;
        }
        input.close();
    }

    void displayInfo(String nim){

        for (String data : userStudent) {
            studentList = data.split("\\*");
            if (studentList[2].equals(nim)) {
                System.out.print("Nama: " + studentList[0] + "\nFakultas: " + studentList[1] + "\nNIM: " + studentList[2] + "\nProgram:" + studentList[3] + "\n");
            }
        }
        
        Main.menuStudent(nim);
    }
    void displayBooks(String nim) {
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
            Main.menuStudent(nim);
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
    
        Main.menuStudent(nim);
        input.close();
    }
    
    void showBorrowedBooks(String nim){

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
    
        Main.menuStudent(nim);
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
        Main.menuStudent(nim);
    }

    void returnBooks(String nim){
    System.out.println("kembalikan buku");
}
}


// void returnBooks(String nim){

// }