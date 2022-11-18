import java.util.Scanner;
import java.lang.Math.*;
public class EmailApplication {
    private String firstName;
    private String lastName;
    private String password;
    private String dep;
    private int mailboxCap;
    private String emailAlt;

    public EmailApplication (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email successfully created: " + this.firstName + this.lastName);

        this.dep = setDepartment();
        System.out.println("Department: " + this.dep);
    }

    private String setDepartment() {
        System.out.println("Department Codes\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none\n Enter your department code: );
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "accounting"; }
        else if (depChoice == 3) { return "development"; }
                else { return ""; }
    }


        this.password = passwordGenerator(defaultPasswordLength); {
        System.out.println("Password: " + this.password);
    }

    private String passwordGenerator(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    }
}