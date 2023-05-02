import java.util.Scanner;

public class MainInterface {

    static Scanner input = new Scanner(System.in);
    static Operations operations = new Operations();

    public static void main(String [] args) {
        input();
    }

    static void input() {
        while(true) {
            System.out.println("\nPhonebook Directory");
            System.out.println("I - Add new contact");
            System.out.println("D - delete existing contact");
            System.out.println("V - view contact");
            System.out.println("M - modify specific contact");
            System.out.println("X - Exit\n");
            System.out.print("Command> ");
            String input = MainInterface.input.nextLine();

            String tempName1="", tempName2="", number="";
            int counter = 0;
            char command = input.charAt(0);
            char[] totalList = input.toCharArray();

            for(int x=2; x<totalList.length; x++) {
                if(Character.isDigit(totalList[x])) {
                    number += String.valueOf(totalList[x]);
                } else if(Character.isLetter(totalList[x])) {
                    tempName1 += String.valueOf(totalList[x]);
                }
            }
            tempName1 = "";

            for(int x=0; x<totalList.length; x++) {
                if (Character.isWhitespace(totalList[x]))
                    counter++;
                else if (counter == 1)
                    tempName1 += String.valueOf(totalList[x]);
            }
            counter = 0;

            for(int x=0; x<totalList.length; x++) {
                if (Character.isWhitespace(totalList[x]))
                    counter++;
                else if (counter == 2)
                    tempName2 += String.valueOf(totalList[x]);
            }

            if(command == 'I' || command == 'i') {
                MainInterface.operations.add(tempName1, number);
                System.out.println("Remarks: New Contact has been added");
            } else if (command == 'V' || command == 'v') {
                if (tempName1.equals(""))
                    MainInterface.operations.printList();
                else
                    MainInterface.operations.searchTargetName(tempName1);
            } else if (command == 'M' || command == 'm') {
                MainInterface.operations.updateName(tempName1,tempName2);
                System.out.println("Remarks: "+tempName1+" is updated");
            } else if (command == 'X' || command == 'x') {
                System.out.println("Program terminated!");
                break;
            }
            else
                System.out.println("Invalid Input!");

        }
    }
}