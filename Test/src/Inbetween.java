//Coder: Junester Ursora II - BSIT 3A
//Coded by: Junester Ursora II - BSIT 3A
import java.util.Scanner;
public class Inbetween {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int first = s.nextInt();

        System.out.print("Enter the second integer: ");
        int second = s.nextInt();

        int small = Math.min(first, second);
        int big = Math.max(first, second);

        System.out.print("Answer : ");

        if(first < second) {
            for (int i = small + 1; i <= big - 1; i++)
                System.out.print(i + " ");
        }else {
            for (int i = big - 1; i >= small + 1; i--)
                System.out.print(i + " ");
        }
    }
}
