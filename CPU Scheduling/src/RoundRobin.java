import java.util.Scanner;

public class RoundRobin {
    public void roundR(Scanner scanner){

        int numProc, quantum;
        System.out.print("Enter Number of Processes: ");
        numProc = scanner.nextInt();
        int[] burstTime = new int[numProc];
        int[] process = new int[numProc];
        int[] waitingTime = new int[numProc];
        int[] turnAroundTime = new int[numProc];

        for(int i = 0; i < numProc; i++){
            process[i] = (i+1);
            System.out.print("Enter Burst Time of Process #" + (i+1) + ": ");
            burstTime[i] = scanner.nextInt();
        }

        System.out.print("Enter Quantum: ");
        quantum = scanner.nextInt();

        int[] rem_bt = new int[numProc];

        for (int i = 0 ; i < numProc ; i++) {
            rem_bt[i] =  burstTime[i];
        }

        int t = 0;
        while(true){
            boolean done = true;
            for (int i = 0 ; i < numProc; i++){
                if (rem_bt[i] > 0){
                    done = false;
                    if (rem_bt[i] > quantum){
                        t += quantum;
                        rem_bt[i] -= quantum;
                    }
                    else{
                        t = t + rem_bt[i];
                        waitingTime[i] = t - burstTime[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done)
                break;
        }

        for (int i = 0; i < numProc ; i++)
            turnAroundTime[i] = burstTime[i] + waitingTime[i];

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%4s%n", "|", "Process ID", "|", "Burst Time", "|", "Waiting Time", "|", "Turn Around Time","|");
        for(int i = 0; i < numProc; i++) {
            System.out.println("--------------------+-------------------+-------------------+-----------------------+");
            System.out.printf("%-5s%-15s%-5s%-15s%-5s%-15s%-5s%-15s%5s%n", "|", process[i], "|", burstTime[i], "|", waitingTime[i], "|", turnAroundTime[i],"|");
        }
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.println("\nGantt Chart: ");
        for(int i = 0; i < numProc; i++) {
            System.out.print("--P" + process[i] +"--|");
        }
        System.out.print("\n0    ");

        sortAlgo(numProc, waitingTime);

        System.out.println();
        System.out.println();

        aveWT(numProc, burstTime, waitingTime, quantum);
        aveTAT(numProc, burstTime, waitingTime, turnAroundTime);
        aveResult(numProc, waitingTime, turnAroundTime);
    }

    public void aveWT(int numProc, int[] burstTime, int[] waitingTime, int quantum){

        int[] rem_bt = new int[numProc];

        for (int i = 0 ; i < numProc ; i++) {
            rem_bt[i] =  burstTime[i];
        }

        int t = 0;
        while(true){
            boolean done = true;
            for (int i = 0 ; i < numProc; i++){
                if (rem_bt[i] > 0){
                    done = false;
                    if (rem_bt[i] > quantum){
                        t += quantum;
                        rem_bt[i] -= quantum;
                    }
                    else{
                        t = t + rem_bt[i];
                        waitingTime[i] = t - burstTime[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            if (done)
                break;
        }
    }

    public void aveTAT(int numProc, int[] burstTime, int[] waitingTime, int[] turnAroundTime){
        for (int i = 0; i < numProc ; i++)
            turnAroundTime[i] = burstTime[i] + waitingTime[i];
    }

    public static void sortAlgo(int numProc, int[]waitingTime){

        int i = 0;
        while (i < numProc) {
            for (int j = i + 1; j < numProc; j++) {
                int storage;
                if (waitingTime[i] > waitingTime[j]) {
                    storage =  waitingTime[i];
                    waitingTime[i] = waitingTime[j];
                    waitingTime[j] = storage;
                }
            }
            System.out.print(" "+waitingTime[i] + "     ");
            i++;
        }

    }

    public void aveResult(int numProc, int[] waitingTime, int[] turnAroundTime){
        float total_wt = 0, total_tat = 0;

        for (int i=0; i<numProc; i++){
            total_wt = total_wt + waitingTime[i];
            total_tat = total_tat + turnAroundTime[i];
        }

        System.out.println("Average Waiting Time = " + (total_wt/(float) numProc));
        System.out.println("Average Turn Around Time = " + (total_tat/(float) numProc));
    }
}
