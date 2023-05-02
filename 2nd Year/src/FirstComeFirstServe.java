
import java.util.Scanner;
public class FirstComeFirstServe {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean flag;
        do {
            System.out.print("Enter Total Number to Process: ");
            int arraysize = scan.nextInt();
            if(arraysize <= 0){
                System.out.println("Invalid Number to Process! Please Try Again!");
                flag = true;
            } else {
                flag = false;
                int[] processID = new int[arraysize];
                int[] arrival = new int[arraysize];
                int[] burst = new int[arraysize];
                int[] completionTime = new int[arraysize];
                int[] turnaroundTime = new int[arraysize];
                int[] waitingTime = new int[arraysize];
                int temp;
                double averageWT = 0, averageTA = 0;

                {
                    int i = 0;
                    while (i < arraysize) {
                        System.out.print("Enter Arrival Time: ");
                        arrival[i] = scan.nextInt();
                        System.out.print("Enter Burst time: ");
                        burst[i] = scan.nextInt();
                        processID[i] = i + 1;
                        i++;
                    }
                }

                {
                    int i = 0;
                    while (i < arraysize) {
                        for (int j = 0; j < arraysize - (i + 1); j++) {
                            if (arrival[j] > arrival[j + 1]) {
                                temp = arrival[j];
                                arrival[j] = arrival[j + 1];
                                arrival[j + 1] = temp;

                                temp = burst[j];
                                burst[j] = burst[j + 1];
                                burst[j + 1] = temp;

                                temp = processID[j];
                                processID[j] = processID[j + 1];
                                processID[j + 1] = temp;
                            }
                        }
                        i++;
                    }
                }

                {
                    int i = 0;
                    while (i < arraysize) {
                        if (i == 0) {
                            completionTime[i] = arrival[i] + burst[i];
                        } else {
                            if (arrival[i] > completionTime[i - 1]) {
                                completionTime[i] = arrival[i] + burst[i];
                            } else
                                completionTime[i] = completionTime[i - 1] + burst[i];
                        }
                        turnaroundTime[i] = completionTime[i] - arrival[i];
                        waitingTime[i] = turnaroundTime[i] - burst[i];
                        averageWT += waitingTime[i];
                        averageTA += turnaroundTime[i];
                        i++;
                    }
                }

                System.out.println();
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%5s%20s%5s%15s%3s%n", "|", "Process ID", "|", "Arrival Time", "|", "Burst Time", "|", "Completion Time", "|", "Turn Around Time", "|", "Waiting Time", "|");
                for (int x = 0; x < arraysize; x++) {
                    System.out.println("--------------------+-------------------+-------------------+-----------------------+------------------------+-----------------+");
                    System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%5s%5s%20s%4s%14s%n", "|", x, "|", arrival[x], "|", burst[x], "|", completionTime[x], "|", turnaroundTime[x], "|", waitingTime[x], "|");
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println();
                System.out.println("Average Waiting Time: " + averageWT + "/" + arraysize + " = " + (averageWT / arraysize));
                System.out.println();
                System.out.println("Average Waiting Time: " + averageTA + "/" + arraysize + " = " + (averageTA / arraysize));
                System.out.println();

                for(int z = 0; z<arraysize; z++){
                    System.out.print("-----+");
                }
                System.out.println();
                for (int i = 0; i < arraysize; i++) {
                    System.out.print(" P" + i + "  |");
                }
                System.out.println();
                for(int z = 0; z<arraysize; z++){
                    System.out.print("-----+");
                }
                System.out.println();
                System.out.print("0   ");
                for (int i = 0; i < arraysize; i++) {
                    System.out.print(completionTime[i] + "    ");
                }
            }
        } while(flag);
    }
}
