/**********************************************************************
 * @file Email.java
 * @brief None.
 * @author Nick Kozlov
 * @date: 11/18/22
 * @acknowledgement: N/A
 ***********************************************************************/
public class Email {

    public static void main(String[] args) {
        EmailApplication em1 = new EmailApplication("John", "Doe");
        System.out.println(em1.showInfo());
    }
}
