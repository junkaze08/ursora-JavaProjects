import java.util.Scanner;
public class FCFS {
    public void fcfs(Scanner scanner) {

        System.out.println("\nFirst Camp First Serve");
        System.out.print("Enter the number of process: ");
        int numProc = scanner.nextInt();

        int[] procID = new int[numProc];
        int[] arrTime = new int[numProc];
        int[] burstTime = new int[numProc];
        int[] compTime = new int[numProc];
        int[] turnAround = new int[numProc];
        int[] waitingTime = new int[numProc];
        int temp;
        float averageWaitingTime,averageTimeArrival;
        averageWaitingTime = 0;
        averageTimeArrival = 0;

        for(int i = 0; i < numProc; i++) {
            System.out.print("Enter process " + (i+1) + " arrival time: ");
            arrTime[i] = scanner.nextInt();
            System.out.print("Enter process " + (i+1) + " burst time: ");
            burstTime[i] = scanner.nextInt();
            procID[i] = i+1;
        }

        for(int i = 0; i < numProc; i++) {
            for(int  j=0;  j < numProc-(i+1) ; j++) {
                if(arrTime[j] > arrTime[j+1] ) {
                    temp = arrTime[j];
                    arrTime[j] = arrTime[j+1];
                    arrTime[j+1] = temp;
                    temp = burstTime[j];
                    burstTime[j] = burstTime[j+1];
                    burstTime[j+1] = temp;
                    temp = procID[j];
                    procID[j] = procID[j+1];
                    procID[j+1] = temp;
                }
            }
        }

        for(int  i = 0 ; i < numProc; i++) {
            if( i == 0) {
                compTime[i] = arrTime[i] + burstTime[i];
            }
            else {
                if( arrTime[i] > compTime[i-1]) {
                    compTime[i] = arrTime[i] + burstTime[i];
                }
                else
                    compTime[i] = compTime[i-1] + burstTime[i];
            }
            turnAround[i] = compTime[i] - arrTime[i];
            waitingTime[i] = turnAround[i] - burstTime[i];
            averageWaitingTime += waitingTime[i];
            averageTimeArrival += turnAround[i];
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%5s%20s%5s%15s%3s%n", "|", "Process ID", "|", "Arrival Time", "|", "Burst Time", "|", "Completion Time", "|", "Turn Around Time", "|", "Waiting Time", "|");
        for(int i = 0; i < numProc; i++) {
            System.out.println("--------------------+-------------------+-------------------+-----------------------+------------------------+-----------------+");
            System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%5s%5s%20s%4s%14s%n", "|", procID[i], "|", arrTime[i], "|", burstTime[i], "|", compTime[i], "|", turnAround[i], "|", waitingTime[i], "|");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        ganttAlgo(numProc,arrTime,procID,burstTime);

        System.out.println("\nGantt Chart: ");
        for(int i = 0; i < numProc; i++) {
            System.out.print("--P" + procID[i] +"--|");
        }
        System.out.print("\n0    ");
        sortAlgo(numProc, compTime);
        System.out.println();
        aveResult(numProc,turnAround,compTime,arrTime,waitingTime,burstTime);
    }

    public static void ganttAlgo(int numberOfProcesses,int[]arrivalTime,int[]processID,int[]burstTime){

        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {

                if(arrivalTime[i] > arrivalTime[j]) {
                    temp = arrivalTime[i];
                    arrivalTime[i] = arrivalTime[j];
                    arrivalTime[j] = temp;

                    temp = processID[i];
                    processID[i] = processID[j];
                    processID[j] = temp;

                    temp = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = temp;
                }
            }
        }
    }

    public static void sortAlgo(int numProc, int[]compTime){

        int i = 0;
        while (i < numProc) {
            for (int j = i + 1; j < numProc; j++) {
                int storage;
                if (compTime[i] > compTime[j]) {
                    storage =  compTime[i];
                    compTime[i] = compTime[j];
                    compTime[j] = storage;
                }
            }
            System.out.print(" "+compTime[i] + "     ");
            i++;
        }

    }

    public static void aveResult(int numProc,int[]turnAround,int[]compTime,int[]arrTime,int[]waitingTime,int[]burstTime){

        float aveWT, aveTT;
        aveWT = 0f;
        aveTT = 0f;

        for(int i = 0; i < numProc ; i++){
            turnAround[i] = compTime[i] - arrTime[i];
            waitingTime[i] = turnAround[i] - burstTime[i];
            aveWT += waitingTime[i];
            aveTT += turnAround[i];
        }

        System.out.println("\nAverage Waiting Time: "+ (aveWT/(float) numProc));
        System.out.println("Average Turnaround Time: "+(aveTT/(float) numProc));
    }

}
