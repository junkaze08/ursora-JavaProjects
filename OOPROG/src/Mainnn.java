import java.util.Scanner;

public class Mainnn{
    final static Scanner sc = new Scanner(System.in);
    final static Calculate cal = new Calculate();
    public static void main(String[] args){
        int n1 = -1, n2 = -1, n3 = -1, n4 = -1;

        boolean check = true;

        do{
            if(check) {
                System.out.print("Enter 1st number: ");
                n1 = sc.nextInt();
            }
            if(n1 < 0) {
                System.out.print("Please enter a number that is greater than 0: ");
                n1 = sc.nextInt();
                check = false;
            }
        }while(n1 < 0);

        check = true;

        do {
            if(check) {
                System.out.print("\nEnter 2nd number: ");
                n2 = sc.nextInt();
            }
            if(n2 < 0) {
                System.out.print("Please enter a number that is greater than 0: ");
                n2 = sc.nextInt();
                check = false;
            }
        }while(n2 < 0);

        check = true;

        do {
            if(check) {
                System.out.print("\nEnter 3rd number: ");
                n3 = sc.nextInt();
            }
            if(n3 < 0) {
                System.out.print("Please enter a number that is greater than 0: ");
                n3 = sc.nextInt();
                check = false;
            }
        }while(n3 < 0);

        check = true;

        do {
            if(check) {
                System.out.print("\nEnter 4th number: ");
                n4 = sc.nextInt();
            }
            if(n4 < 0) {
                System.out.print("Enter a number that is greater than 0: ");
                n4 = sc.nextInt();
                check = false;
            }
        }while(n4 < 0);
        Calculate cals = new Calculate(n1, n2, n3, n4);
        cal.setNum1(n1);
        cal.setNum2(n2);
        cal.setNum3(n3);
        cal.setNum4(n4);

        System.out.println("\nSmallest number: " + cal.displaysmallest());
        System.out.println("\nLargest number: " + cal.displaylargest());
        cal.displaysquare();
        cal.displayfactorial();
        cal.displaysummation();
        cal.displayperfectandprime();
    }

    public static String perfect(int n){
        int sum = 0;
        for(int i = 1 ; i < n ; i++){
            if(n % i == 0)  {
                sum = sum + i;
            }
        }

        if (sum == n)
            return "a perfect number!";
        else
            return "not a perfect number!";
    }

    public static String prime(int n){
        boolean flag = false;
        for (int i = 2; i <= n / 2; ++i){
            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return "this is prime number!";
        else
            return "this is not prime number!";
    }

    public static long factorial(int n){
        long fact = 1;
        if(n == 0)
            return 1;
        else {
            for(int i = 2; i <= n; i++){
                fact = fact * i;
            }
        }
        return fact;
    }

    public static int summation(int n){
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += i;
        }
        return total;
    }
}