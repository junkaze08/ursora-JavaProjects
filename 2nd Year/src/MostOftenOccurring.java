import java.util.Scanner;
public class MostOftenOccurring {
        public static void main(String[]args){
            Scanner scan = new Scanner(System.in);
            char repeat;
            do {
                int size;
                do {
                    System.out.print("Enter desired array size\n> ");
                    size = scan.nextInt();
                    if (size <= 2)
                        System.out.println("Remarks: Size must be more than 2.");
                } while (size <= 2);//no point in looking for which occured most if there's only 2 values

                int[] a = new int[size];

                for (int counter = 0; counter <= a.length - 1; counter++) {
                    do {
                        System.out.print("Enter a number for a[" + counter + "]\n> ");
                        a[counter] = scan.nextInt();
                        if (a[counter] == 0)
                            System.out.print("Remarks: 0 is a reserved value. Try another");
                    } while (a[counter] == 0);//0 will be reserved for detecting if there are occurences or not thus it is not allowed.
                }

                if (occurs(a) == 0)
                    System.out.println("Result: No number occured more than once");
                else
                    System.out.println("Result: " + occurs(a) + " occured most often");

                do {
                    System.out.print("repeat operation? Y/N\n> ");
                    repeat = scan.next().charAt(0);
                    repeat = Character.toUpperCase(repeat);
                    if (repeat != 'N' && repeat != 'Y')
                        System.out.println("Remarks: Invalid choice.");
                } while (repeat != 'N' && repeat != 'Y');
            } while (repeat == 'Y');
            System.out.print("Terminating... ");
        }
        static int occurs ( int[] a){
            int mostOften = 0, frequency = 0;

            for (int counter = 0; counter <= a.length - 1; counter++) {
                int currentTest = 0;
                for (int counter2 = 0; counter2 <= a.length - 1; counter2++) {
                    if (a[counter] == a[counter2])
                        currentTest++;
                }
                if (currentTest > mostOften && currentTest != frequency) {
                    mostOften = a[counter];
                    frequency = currentTest;
                }
            }
            if (frequency > 1) {
                return mostOften;
            } else
                return mostOften = 0;
        }
    }
