import java.util.Scanner;

public class EventEntryLoop {
    public static void main(String args[]){
        int num;
        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Enter a number: ");
            num = scan.nextInt();
            if (num % 2 == 0) {
                System.out.println("Good Job!");
            } else {
                System.out.println("Odd Number Detected, Input Again!");
            }
        } while (num == 999);

    }
}
