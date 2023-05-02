import java.util.Scanner;

public class Factorials{
    public static void main(String args[]){
        int num1, fact = 1;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number to get its factorial");
        num1 = in.nextInt();
                for(int i = 1; i <= num1; i++){
                    fact = fact * i;
                }
                System.out.println("Number Factorial");
                System.out.println(num1 + "          " + fact);

    }
}