import java.util.Scanner;
public class ContainsInRange {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int x, start, end, flag;
        boolean flag1, flag2;
        do {
            System.out.print("Enter the array size: ");
            int arrsize = scan.nextInt();
            int[] a = new int[arrsize];
            for(int i = 0; i <= a.length-1; i++){
                System.out.print("Enter numbers as a choice: ");
                a[i] = scan.nextInt();
            }
            System.out.print("Enter number to be searched: ");
            x = scan.nextInt();
            do {
                System.out.print("Enter start number: ");
                start = scan.nextInt();
                if (start >= x) {
                    System.out.println("Starting number must not be less than or equal to the number to be searched!");
                    flag1 = true;
                } else {
                    flag1 = false;
                }
            } while (flag1);

            do {
                System.out.print("Enter end number: ");
                end = scan.nextInt();
                if (end < start) {
                    System.out.println("Ending number must not be greater than the starting number!");
                    flag2 = true;
                } else {
                    flag2 = false;
                }
            } while (flag2);

            System.out.print(Contains.contains(a, x, start, end));
            System.out.print("\nDo you wish to proceed? Press[1], Press[2] to end: ");
            flag = scan.nextInt();
            System.out.print("\n");
        } while (flag != 2);
    }

    static class Contains {
        static boolean contains(int[] a, int x, int start, int end) {
            int occ = 0;
            boolean flag = false;
            for (int i = 0;  i<a.length; i++) {
                if (i == x && occ >= start && occ < end) {

                    flag = true;
                    System.out.println("Number is found!");
                    System.out.print("Boolean validation is: ");
                    break;
                }

                occ++;

                if (occ == a.length && occ != x) {
                    System.out.println("Number is not found!");
                    System.out.print("Boolean validation is: ");
                }
            }
            return flag;

        }
    }
}
