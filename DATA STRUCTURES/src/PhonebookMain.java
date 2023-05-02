import java.util.Scanner;

public class PhonebookMain{

    static Scanner myInput = new Scanner(System.in);

    public static void main(String[] args){
        PhonebookList list = new PhonebookList();

        String string, command = "";

        do{
            System.out.println("Phonebook Directory");
            System.out.println("I - Add new contact");
            System.out.println("D - delete existing contact");
            System.out.println("V - view contact");
            System.out.println("M - modify specific contact");
            System.out.println("X - Exit\n");
            System.out.print("Command> ");
            string = myInput.nextLine();
            Scanner sc = new Scanner(string);

            if(sc.hasNext()){
                command = sc.next();
            }

            switch (command.toUpperCase()) {
                case "I" -> list.addContact(string);
                case "D" -> list.deleteContact(string);
                case "V" -> list.viewContact(string);
                case "M" -> list.modifyContact(string);
                case "X" -> System.out.println("Remarks: Program ended.");
                default -> System.out.println("Remarks: Invalid Command.");
            }


        }while(!(command.equalsIgnoreCase("X")));


    }
}