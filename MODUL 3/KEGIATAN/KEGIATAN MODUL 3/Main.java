
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    menu();
    }

    static void menu() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Library system =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        pil = input.nextInt();
        // Admin cek = new Admin();
        Adminnew tmpAdmin = new Adminnew();
        switch (pil) {
            case 1:
                System.out.println("Student");
                inputNim();
                break;
            case 2:
            System.out.println("Admin");
            System.out.print("Enter Your Username (admin): ");
            String userAdmin = input.next();
            System.out.print("Enter Your Password (admin): ");
            String passAdmin = input.next();
            if (tmpAdmin.isAdmin(userAdmin,passAdmin)) {
                System.out.println("Successful Login as Admin");
                Main.menuAdmin();
            }else{
                System.out.println("Invalid creditial for admin");
                Main.menu();
            }
                break;
            case 3:
                System.out.println("Thankyou Exiting Program");
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }

    static void inputNim() {
        Scanner input = new Scanner(System.in);
        String nim;
        boolean continueInput = true;
        int i = 99;
        while (continueInput) {
            System.out.print("Enter your NIM (input " + i + " for back): ");
            nim = input.next();
            if (checkNim(nim) == 1) {
                System.out.println("benar");
                menuStudent(nim);
                continueInput = false;
            } else if (i == 0) {
                System.out.println("Input NIM gagal");
                continueInput = false;
            } else {
                i--;
            }
        }
        input.close();
    }

    static int checkNim(String nim) {
        if (nim.length() == 15) {
            return 1;
        } else {
            return 0;
        }
    }

    static void menuStudent(String nim) {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Student Menu =====");
        System.out.println("1. Buku Terpinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Kembalikan Buku");
        System.out.println("4. Pinjam Buku atau Logout");
        System.out.println("5. Data user");
        System.out.println("6. Logout");
        System.out.print("Choose option (1-6): ");
        pil = input.nextInt();

        Student menu = new Student();

        switch (pil) {
            case 1:
                System.out.println("Buku Terpinjam");
                menu.showBorrowedBooks(nim);
                break;
            case 2:
                System.out.println("Pinjam Buku");
                menu.displayBooks(nim);
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
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }

    static void menuAdmin() {
        int pil;
        Scanner input = new Scanner(System.in);
        System.out.println("===== Admin Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Book");
        System.out.println("3. Display Registered Student");
        System.out.println("4. Display Available");
        System.out.println("5. Logout");
        System.out.print("Choose option (1-5): ");
        pil = input.nextInt();

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
                menu();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                menu();
                break;
        }
        input.close();
    }
}