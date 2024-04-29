import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            Email email = new Email(input);
            email.validateEmail();
            sc.close();
            System.out.println("true");
            System.out.println("Email validated.");
        } catch(InvalidEmailException | InvalidDomainException e){
            System.out.println(e.getClass().getName()+"! "+e.getMessage());
            System.out.println("Email string error!");
        } catch(Exception e){
            System.out.println(e.getClass().getName());
            System.out.println("Email string error!");
        } finally {
            System.out.println("Operation finished.");
        }
}
}