import java.util.Arrays;
import java.util.Scanner;
public class FCFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Total Number to Process: ");
        int arrsize = scan.nextInt();
        int[] a = new int[arrsize];
        int[] b = new int[arrsize];
        int[] c = new int[arrsize];
        int i, sum = 0;
        int arrival, burst, completion, turn, waiting, semiarrival, semiburst, semicompletion, arrbur, finalcompletion, comptime, finalcomp, potarrival, potburst;
        for (int j = 0; j <= a.length - 1; j++) {
            System.out.print("Enter Arrival Time: ");
            a[j] = scan.nextInt();
            System.out.print("Enter Burst Time: ");
            b[j] = scan.nextInt();

        }

        System.out.println();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Process ID", "Arrival Time", "Burst Time", "Completion Time", "Turn Around Time", "Waiting Time");
        for (i = 0; i < a.length; i++) {
            arrival = a[i];
            burst = b[i];
            semiarrival = a[0];
            semiburst = b[0];
            potarrival = a[0];
            potburst = b[0];
            for (i = 0; i < a.length; i++) {

                if (i == a[0]) {
                    arrbur = semiarrival + semiburst;
                    completion = arrbur;
                    turn = completion - arrival;
                    waiting = turn - burst;
                    sum = sum + waiting;
                    System.out.println(i + "                   " + a[i] + "                     " + b[i] +
                            "                     " + completion + "                     " + turn +
                            "                     " + waiting);
                }
                }
            for (i = 1; i < a.length; i++) {
                comptime = potarrival + potburst;
                finalcompletion = comptime;
                finalcomp = burst + finalcompletion;
                turn = finalcomp - arrival;
                waiting = turn - burst;
                sum = sum + waiting;
                System.out.println(i + "                   " + a[i] + "                     " + b[i] +
                        "                     " + finalcomp + "                     " + turn +
                        "                     " + waiting);
            }
        }

                System.out.println();
                System.out.println("Average Waiting Time: " + sum + "/" + arrsize + " = " + (sum) / arrsize);

                System.out.println();
                for (i = 0; i < a.length; i++) {
                    System.out.print(" P" + i + "     ");
                }
                System.out.println();
                System.out.print("0     ");
                for (i = 0; i < a.length; i++) {
                    System.out.print(c[i] + "      ");
                }

        }
    }
