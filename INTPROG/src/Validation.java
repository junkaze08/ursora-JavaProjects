import java.util.Scanner;

public class Validation {

    public int checkNumber(Scanner scanner, String errorMessage, String question) {
        while(true) {
            try {
                return scanner.nextInt();
            } catch (Exception e){
                System.out.println(errorMessage);
                System.out.print(question);
                scanner.next();
            }
        }
    }
    public String checkString(Scanner scanner,String errorMessage, String question) {
        while (true) {
            try {
                String input = scanner.nextLine();
                if (input.matches(".*\\d.*"))
                    throw new Exception("String contains Digit");
                return input;
            } catch (Exception e) {
                System.out.println(errorMessage);
                System.out.print(question);
            }
        }
    }
    public String checkGender(Scanner scanner, String errorMessage, String question){
        while (true) {
            try {
                String input = checkString(scanner, "Gender Contains Number","Gender: ");
                if (input.equalsIgnoreCase("male") || input.equalsIgnoreCase("female"))
                    return input;
                else
                    throw new Exception("Gender must be specified");
            } catch (Exception e) {
                System.out.println(errorMessage);
                System.out.print(question);
            }
        }
    }

}
