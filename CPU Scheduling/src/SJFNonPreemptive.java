import java.util.Scanner;
public class SJFNonPreemptive {
    public void sjfnp(Scanner scanner){

        System.out.println("\nSJF Non Preemptive Scheduling");
        System.out.print("Enter the number of process: ");
        int numProc = scanner.nextInt();

        int[] procID = new int[numProc];
        int[] arrTime = new int[numProc];
        int[] burstTime = new int[numProc];
        int[] compTime = new int[numProc];
        int[] turnAround = new int[numProc];
        int[] waitingTime = new int[numProc];
        int[] flag = new int[numProc];
        int initial=0, total=0;

        for(int i=0; i<numProc; i++)
        {
            System.out.print ("Enter process of " + (i+1) + " arrival time: ");
            arrTime[i] = scanner.nextInt();
            System.out.print ("Enter process of " + (i+1) + " burst time: ");
            burstTime[i] = scanner.nextInt();
            procID[i] = i+1;
            flag[i] = 0;
        }

        do {
            int c = numProc, min = 99;
            if (total == numProc)
                break;

            for (int i = 0; i < numProc; i++) {

                if ((arrTime[i] <= initial) && (flag[i] == 0) && (burstTime[i] < min)) {
                    min = burstTime[i];
                    c = i;
                }
            }

            if (c == numProc)
                initial++;
            else {
                compTime[c] = initial + burstTime[c];
                initial += burstTime[c];
                turnAround[c] = compTime[c] - arrTime[c];
                waitingTime[c] = turnAround[c] - burstTime[c];
                flag[c] = 1;
                total++;
            }
        } while (true);

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

    public static void ganttAlgo(int numProc,int[]arrTime,int[]procID,int[]burstTime){
        int storage;
        for (int i = 0; i < numProc; i++) {
            for (int j = i+1; j < numProc; j++) {

                if(arrTime[i] > arrTime[j]) {
                    storage = arrTime[i];
                    arrTime[i] = arrTime[j];
                    arrTime[j] = storage;

                    storage = procID[i];
                    procID[i] = procID[j];
                    procID[j] = storage;

                    storage = burstTime[i];
                    burstTime[i] = burstTime[j];
                    burstTime[j] = storage;
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



