import java.util.Scanner;
import java.lang.Math.*;
public class EmailApplication {
    private String firstName;
    private String lastName;
    private String password;
    private String dep;
    private String email;
    private int mailboxCap = 500;
    private int defaultPasswordLength = 10;
    private String emailAlt;
    private String companySuffix = "wfu.edu";

    public EmailApplication (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.dep = setDepartment();

        this.password = passwordGenerator(defaultPasswordLength);
            System.out.println("Password: " + this.password);

            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + dep + "." + companySuffix;
    }

    private String setDepartment() {
        System.out.println("Email created: " + firstName + " " + lastName + "\nDepartment Codes:\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none\nEnter your department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "accounting"; }
        else if (depChoice == 3) { return "development"; }
                else { return ""; }
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
        public void setMailboxCapacity(int capacity) {
            this.mailboxCap = capacity;
        }
        public void setAlternativeEmail(String altEmail) {
            this.emailAlt = altEmail;
        }
        public void changePassword(String password) {
            this.password = password;
        }
        public int getMailboxCapacity() { return mailboxCap; }
        public String getAlternativeEmail() { return emailAlt; }
        public String getPassword() { return password; }

        public String showInfo() {
            return "Display Name: " + firstName + " " + lastName +
                    "\nCompany Email: " + email +
                    "\nMailbox Capacity: " + mailboxCap + "Mb";
        }
}
