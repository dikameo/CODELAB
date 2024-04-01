import java.util.ArrayList;

public class User {
         static ArrayList<String> userStudent = new ArrayList<>();
         static ArrayList<String> bookList = new ArrayList<>();    
         static ArrayList<String> userBorrowed = new ArrayList<>();    

         
         String[] book;

        public void addBook(){
            bookList.add("ED90-2BE3-DA44*title*author*Sejarah*3");
            bookList.add("JK91-VSE3-QAW9*title2*author2*Komedi*4");
            bookList.add("E1P1-W8E3-DBH5*title3*author3*Komedi*2");
        }


        void displayBook() {
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
}
