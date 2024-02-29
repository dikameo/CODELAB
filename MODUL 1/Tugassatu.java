import java.util.Scanner;

public class Tugassatu {
    public static void main(String[] args) {
        // dicoba
        Scanner input = new Scanner(System.in);
        int pil;
        String useradmin,passadmin,nim;
        System.out.println("===== Library System =====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3):");
        pil = input.nextInt();

        switch (pil) {
            case 1:
                // System.out.println("Pilihan 1");
                System.out.print("Enter Your NIM : ");
                nim = input.next();
                if (nim.length()==15) {
                    System.out.println("Successful Login as Student");
                }else{
                    System.out.println("User Not Found");
                }
                Tugassatu.main(null);
                break;
            case 2:
                // System.out.println("Pilihan 2");
                System.out.print("Enter Your Username (admin) : ");
                useradmin = input.next();
                System.out.print("Enter Your NIM (admin) : ");
                passadmin = input.next();
                    // System.out.println(useradmin.compareToIgnoreCase("admin"));
                    if (useradmin.equalsIgnoreCase("admin") && passadmin.equalsIgnoreCase("admin")) {
                        System.out.println("Successful Login as Admin");
                    }else{
                        System.out.println("Admin User Not Found !!!");
                    }
            
                Tugassatu.main(null);
                break;
            case 3:
                System.out.println("Adios");
                break;
        
            default:
                System.out.println("INVALID INPUT MASZEH !!");
                Tugassatu.main(null);
                break;   
        }
        input.close();
    }
}
