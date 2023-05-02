import java.util.Scanner;
public class Power{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int flag;
        do {
            System.out.print("Enter Base: ");
            double base = scan.nextDouble();
            System.out.print("Enter Exponent: ");
            int exponent = scan.nextInt();
            double result = powerFunction(base, exponent);

            System.out.println(base + " raised to the power of " + exponent + " = " + result);
            System.out.print("Do you wish to proceed? Press[1], Press[2] to end: ");
            flag = scan.nextInt();
        } while(flag != 2);
    }

    static double powerFunction(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result = base * result;
        }
        return (double) result;
    }
}