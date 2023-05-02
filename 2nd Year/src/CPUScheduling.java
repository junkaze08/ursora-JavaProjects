import java.io.DataInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CPUScheduling {

    static Scanner scanner = new Scanner(System.in);
    static int choice;

    public static void main(String[] args) throws IOException {

        menu(choice);
        repeater(choice);

    }

    public static void menu(int choice) throws IOException {

        boolean error = true;

        System.out.println("------------------MENU-----------------");
        System.out.println("Choose (1)First Come First Serve");
        System.out.println("Choose (2)Shortest Job First NON_PREEMPTIVE");
        System.out.println("Choose (3)Shortest Job First PREEMPTIVE");
        System.out.println("Choose (4)Round Robin");
        System.out.println("Choose (5)Preemptive Priority");
        System.out.println("---------------------------------------");

        while (error) {

            try {
                System.out.print("Choose number: ");
                choice = scanner.nextInt();
                if (choice == 1) {
                    firstComeFirstServe();
                    error = false;
                } else if (choice == 2) {
                    shortestJobFirst_nonPreemptive();
                    error = false;
                } else if (choice == 3) {
                    shortestJobFirst_Preemptive();
                    error = false;
                } else if (choice == 4) {
                    roundRobin();
                    error = false;
                } else if (choice == 5) {
                    preemptivePriority();
                    error = false;
                }
            } catch (InputMismatchException e) {
                scanner.next();
            }

        }

    }

    public static void repeater (int choice) throws IOException {

        String option = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println();
            System.out.println("\nProgram ended refer to choices below: ");

            System.out.println("Choose option (choose) to choose other algorithm");
            System.out.println("Choose option (exit) to end program");
            System.out.print("Pick a choice: ");
            option = scanner.next().toUpperCase().trim();
            try {

                if (option.equals("CHOOSE")) {

                    menu(choice);

                } else if (option.equals("EXIT")) {

                    System.out.println("Thank you have a nice day.");
                    validInput = true;

                }

            } catch (InputMismatchException e) {
                scanner.next();
            }

        }

    }

    public static void sort(int numberOfProcesses, int [] completionTime){

        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i + 1; j < numberOfProcesses; j++) {
                int tmp;
                if (completionTime[i] > completionTime[j]) {
                    tmp =  completionTime[i];
                    completionTime[i] = completionTime[j];
                    completionTime[j] = tmp;
                }
            }
            System.out.print(" "+completionTime[i] + "     ");
        }

    }

    public static void printAverage(int numberOfProcesses,
                                    int [] turnAround,
                                    int [] completionTime,
                                    int [] arrivalTime,
                                    int [] waitingTime,
                                    int [] burstTime){

        float averageWaitingTime = 0f;
        float averageTurnaroundTime = 0f;

        for(int i = 0; i < numberOfProcesses ; i++){

            turnAround[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnAround[i] - burstTime[i];
            averageWaitingTime += waitingTime[i];
            averageTurnaroundTime += turnAround[i];



        }
        System.out.println("\naverage waiting time: "+ (averageWaitingTime/(float) numberOfProcesses));
        System.out.println("average turnaround time: "+(averageTurnaroundTime/(float) numberOfProcesses));
    }

    public static void ganttChartSort(int numberOfProcesses,
                                      int [] arrivalTime,
                                      int [] processID,
                                      int[] burstTime){

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

    public static void firstComeFirstServe() {

        System.out.println("------------------------------------------------");
        System.out.println("You have choose (FCFS) algorithm");
        System.out.println("------------------------------------------------");
        System.out.print("Enter the number of process: ");
        int numberOfProcesses = scanner.nextInt();

        int[] processID = new int[numberOfProcesses];
        int[] burstTime = new int[numberOfProcesses];
        int[] arrivalTime = new int[numberOfProcesses];
        int[] completionTime = new int[numberOfProcesses];
        int[] turnAround = new int[numberOfProcesses];
        int[] waitingTime = new int[numberOfProcesses];

        {
            int i = 0;
            while (i < numberOfProcesses) {
                processID[i] = i;
                System.out.print("Enter process " + (i) + " arrival time: ");
                arrivalTime[i] = scanner.nextInt();
                if (i == 0) {
                    System.out.print("Enter process " + (i) + " burst time: ");
                    burstTime[i] = scanner.nextInt();
                } else {
                    System.out.print("Enter Burst of process #"+processID[i]+": ");
                    int value = scanner.nextInt();
                    if (value < burstTime[i - 1]) {
                        System.out.println("Error! Input again...");
                        i = 0;
                        continue;
                    } else {
                        burstTime[i] = value;
                    }
                }
                i++;
            }
        }




        System.out.println();
        completionTime[0] = burstTime[0] + arrivalTime[0];
        for(int i = 1; i < numberOfProcesses; i++) {
            completionTime[i] = completionTime[i - 1] + burstTime[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            turnAround[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnAround[i] - burstTime[i];
        }
        System.out.println(String.format("%-10s", "Process") + String.format("%-10s", "Arrival Time") + String.format("%16s", "Burst Time") + String.format("%20s", "Completion Time") + String.format("%21s", "Turn Around Time")+ String.format("%22s", "Waiting Time"));
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println(String.format("%-10s", processID[i]) + String.format("%-18s", arrivalTime[i]) + String.format("%-15s", burstTime[i]) + String.format("%-20s", completionTime[i]) + String.format("%-26s", turnAround[i]) + String.format("%-23s", waitingTime[i]));
        }

        ganttChartSort(numberOfProcesses, arrivalTime, processID, burstTime);

        System.out.println("\ngantt chart: ");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.print("--P" + processID[i] +"--|");
        }
        System.out.print("\n0    ");
        sort(numberOfProcesses, completionTime);
        System.out.println();
        printAverage(numberOfProcesses,turnAround,completionTime,arrivalTime,waitingTime,burstTime);

    }

    public static void shortestJobFirst_nonPreemptive(){

        System.out.println("------------------------------------------------");
        System.out.println("You have choose (SJF NON_PREEMPTIVE) algorithm");
        System.out.println("------------------------------------------------");
        System.out.print("Enter the number of process: ");
        int numberOfProcesses = scanner.nextInt();

        int[] processID = new int[numberOfProcesses];
        int[] arrivalTime = new int[numberOfProcesses];
        int[] burstTime = new int[numberOfProcesses];
        int[] completionTime = new int[numberOfProcesses];
        int[] turnAround = new int[numberOfProcesses];
        int[] waitingTime = new int[numberOfProcesses];
        int[] flag = new int[numberOfProcesses];
        int st=0, tot=0;

        for(int i=0;i<numberOfProcesses;i++)
        {
            System.out.print ("enter process " + (i+1) + " arrival time: ");
            arrivalTime[i] = scanner.nextInt();
            System.out.print ("enter process " + (i+1) + " burst time: ");
            burstTime[i] = scanner.nextInt();
            processID[i] = i+1;
            flag[i] = 0;
        }

        while(true) {
            int c=numberOfProcesses, min=99999;
            if (tot == numberOfProcesses)
                break;

            for (int i=0; i<numberOfProcesses; i++) {

                if ((arrivalTime[i] <= st) && (flag[i] == 0) && (burstTime[i]<min))
                {
                    min=burstTime[i];
                    c=i;
                }
            }

            if (c==numberOfProcesses)
                st++;
            else {
                completionTime[c]=st+burstTime[c];
                st+=burstTime[c];
                turnAround[c]=completionTime[c]-arrivalTime[c];
                waitingTime[c]=turnAround[c]-burstTime[c];
                flag[c]=1;
                tot++;
            }
        }
        System.out.println();
        System.out.println(String.format("%-10s", "Process") + String.format("%-10s", "Arrival Time") + String.format("%16s", "Burst Time") + String.format("%20s", "Completion Time") + String.format("%21s", "Turn Around Time")+ String.format("%22s", "Waiting Time"));
        for(int i=0;i<numberOfProcesses;i++)
        {
            System.out.println(String.format("%-10s", processID[i]) + String.format("%-18s", arrivalTime[i]) + String.format("%-15s", burstTime[i]) + String.format("%-20s", completionTime[i]) + String.format("%-26s", turnAround[i]) + String.format("%-23s", waitingTime[i]));
        }

        ganttChartSort(numberOfProcesses,arrivalTime,processID,burstTime);

        System.out.println("\ngantt chart: ");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.print("--P" + processID[i] +"--|");
        }
        System.out.print("\n0    ");
        sort(numberOfProcesses, completionTime);
        System.out.println();
        printAverage(numberOfProcesses,turnAround,completionTime,arrivalTime,waitingTime,burstTime);
    }

    public static void shortestJobFirst_Preemptive(){

        System.out.println("------------------------------------------------");
        System.out.println("You have choose (SJF_PREEMPTIVE) algorithm");
        System.out.println("------------------------------------------------");
        System.out.print("Enter the number of process: ");
        int numberOfProcess= scanner.nextInt();
        int[] processID = new int[numberOfProcess];
        int[] arrivalTime = new int[numberOfProcess];
        int[] burstTime = new int[numberOfProcess];
        int[] completionTime = new int[numberOfProcess];
        int[] turnAround = new int[numberOfProcess];
        int[] waitingTime = new int[numberOfProcess];
        int[] flag = new int[numberOfProcess];
        int[] burstTimeStorage = new int[numberOfProcess];
        int i, startTime=0, total=0;

        for (i=0;i<numberOfProcess;i++) {
            processID[i]= i+1;
            System.out.print("enter process " +(i+1)+ " arrival time: ");
            arrivalTime[i]= scanner.nextInt();
            System.out.print("enter process " +(i+1)+ " burst time: ");
            burstTime[i]= scanner.nextInt();
            burstTimeStorage[i]= burstTime[i];
            flag[i]= 0;
        }

        while(true){
            int min=99,c=numberOfProcess;
            if (total==numberOfProcess)
                break;

            for ( i=0;i<numberOfProcess;i++) {
                if ((arrivalTime[i]<=startTime) && (flag[i]==0) && (burstTime[i]<min))
                {
                    min=burstTime[i];
                    c=i;
                }
            }

            if (c==numberOfProcess)
                startTime++;
            else {
                burstTime[c]--;
                startTime++;
                if (burstTime[c]==0)
                {
                    completionTime[c]= startTime;
                    flag[c]=1;
                    total++;
                }
            }
        }

        for (i = 0; i < numberOfProcess; i++) {
            turnAround[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnAround[i] - burstTimeStorage[i];
        }

        System.out.println();
        System.out.println(String.format("%-10s", "Process") + String.format("%-10s", "Arrival Time") + String.format("%16s", "Burst Time") + String.format("%20s", "Completion Time") + String.format("%21s", "Turn Around Time")+ String.format("%22s", "Waiting Time"));
        for(i=0;i<numberOfProcess;i++)
        {
            System.out.println(String.format("%-10s", processID[i]) + String.format("%-18s", arrivalTime[i]) + String.format("%-15s", burstTimeStorage[i]) + String.format("%-20s", completionTime[i]) + String.format("%-26s", turnAround[i]) + String.format("%-23s", waitingTime[i]));
        }

        ganttChartSort(numberOfProcess,arrivalTime,processID,burstTimeStorage);

        System.out.println("\ngantt chart: ");

        for(int j = 0; j < numberOfProcess; j++) {
            System.out.print("--P" + processID[j] +"--|");
        }

        System.out.print("\n0    ");

        sort(numberOfProcess, completionTime);

        System.out.println();

        printAverage(numberOfProcess,turnAround,completionTime,arrivalTime,waitingTime,burstTimeStorage);

    }

    public static void roundRobin() throws IOException {

        DataInputStream in=new DataInputStream(System.in);
        int i,j,k,q,sum=0;
        System.out.println("------------------------------------------------");
        System.out.println("You have choose (RB) algorithm");
        System.out.println("------------------------------------------------");
        System.out.print("Enter number of process: ");
        int numberOfProcesses=Integer.parseInt(in.readLine());
        int[] burstTime = new int[numberOfProcesses];
        int[] waitingTime = new int[numberOfProcesses];
        int[] turnAround = new int[numberOfProcesses];
        int[] alpha = new int[numberOfProcesses];
        int[] processID = new int[numberOfProcesses];
        System.out.println("Enter burst Time");
        for(i=0;i<numberOfProcesses;i++) {
            System.out.print("Enter burst Time for "+"P"+(i+1)+": ");
            burstTime[i]=Integer.parseInt(in.readLine());
        }
        System.out.print("Enter Time quantum: ");
        q=Integer.parseInt(in.readLine());
        for(i=0;i<numberOfProcesses;i++)
            alpha[i]=burstTime[i];
        for(i=0;i<numberOfProcesses;i++)
            waitingTime[i]=0;
        do {
            for(i=0;i<numberOfProcesses;i++) {
                if(burstTime[i]>q) {
                    burstTime[i]-=q;
                    for(j=0;j<numberOfProcesses;j++) {
                        if((j!=i)&&(burstTime[j]!=0))
                            waitingTime[j]+=q;
                    }
                }
                else {
                    for(j=0;j<numberOfProcesses;j++)
                    {
                        if((j!=i)&&(burstTime[j]!=0))
                            waitingTime[j]+=burstTime[i];
                    }
                    burstTime[i]=0;
                }
            }
            sum=0;
            for(k=0;k<numberOfProcesses;k++)
                sum=sum+burstTime[k];
        }
        while(sum!=0);
        for(i=0;i<numberOfProcesses;i++)
            turnAround[i]=waitingTime[i]+alpha[i];
        System.out.println();
        System.out.println(String.format("%-20s", "Process") + String.format("%-15s", "Burst Time") + String.format("%16s", "Waiting Time") + String.format("%20s", "Turn Around Time"));
        for(i=0;i<numberOfProcesses;i++) {
            System.out.println(String.format("%-20s", "P"+(i+1)) + String.format("%-15s", alpha[i]) + String.format("%5s", waitingTime[i]) + String.format("%16s", turnAround[i]));

        }
        System.out.println();
        for (i=0;i<numberOfProcesses;i++){
            System.out.print("--P" + (i+1) +"--|");
        }
        float averageWaitingTime=0;
        float averageTurnAroundTime=0;
        for(j=0;j<numberOfProcesses;j++) {
            averageWaitingTime+=waitingTime[j];
        }
        for(j=0;j<numberOfProcesses;j++) {
            averageTurnAroundTime+=turnAround[j];
        }

        System.out.print("\n0    ");
        sort(numberOfProcesses, turnAround);
        System.out.println();
        System.out.println();
        System.out.println("Average waiting time: "+(averageWaitingTime/numberOfProcesses)+"\nAverage turn around time: "+(averageTurnAroundTime/numberOfProcesses));
    }


    public static void preemptivePriority() {

        int x;
        int numberOfProcess;
        int averageWaitingTime;
        int averageTurnAroundTime;
        int i;

        int[] process = new int[10];
        int[] processPriority = new int[10];
        int[] burstTime = new int[10];
        int[] waitingTime = new int[10];
        int[] turnAroundTime = new int[10];
        int[] completionTime = new int[10];

        System.out.println("------------------------------------------------");
        System.out.println("You have choose (PP) algorithm");
        System.out.println("------------------------------------------------");
        System.out.print("Enter the number of process : ");
        numberOfProcess = scanner.nextInt();
        System.out.println();
        for(i=0;i<numberOfProcess;i++)
        {
            System.out.print("Enter burst Time for "+"P"+(i+1)+": ");
            burstTime[i] = scanner.nextInt();
            System.out.print("Enter Priority Time for "+"P"+(i+1)+": ");
            processPriority[i] = scanner.nextInt();
            process[i]=i+1;
        }

        for(i=0;i<numberOfProcess-1;i++)
        {
            for(int j=i+1;j<numberOfProcess;j++)
            {
                if(processPriority[i]>processPriority[j])
                {
                    x=processPriority[i];
                    processPriority[i]=processPriority[j];
                    processPriority[j]=x;
                    x=burstTime[i];
                    burstTime[i]=burstTime[j];
                    burstTime[j]=x;
                    x=process[i];
                    process[i]=process[j];
                    process[j]=x;
                }
            }
        }
        waitingTime[0]=0;
        averageWaitingTime=0;
        turnAroundTime[0]=burstTime[0];
        averageTurnAroundTime=turnAroundTime[0];
        for(i=1;i<numberOfProcess;i++)
        {
            waitingTime[i]=turnAroundTime[i-1];
            averageWaitingTime+=waitingTime[i];
            turnAroundTime[i]=waitingTime[i]+burstTime[i];
            averageTurnAroundTime+=turnAroundTime[i];
        }

        completionTime[0] = burstTime[0] + processPriority[0];
        for(i = 1; i < numberOfProcess; i++) {
            completionTime[i] = completionTime[i - 1] + burstTime[i];
        }

        System.out.println();
        System.out.println(String.format("%-15s", "Process") + String.format("%-15s", "Burst Time") + String.format("%-16s", "Waiting Time") + String.format("%-20s", "Turn Around Time") + String.format("%-20s", "Priority"));
        for(i=0;i<numberOfProcess;i++) {
            System.out.println(String.format("%-15s","P"+process[i]) + String.format("%-15s", burstTime[i]) + String.format("%-16s", waitingTime[i]) + String.format("%-20s", turnAroundTime[i]) + String.format("%-20s", processPriority[i]));
        }

        for(i = 1; i < numberOfProcess; i++) {
            completionTime[i] = completionTime[i - 1] + burstTime[i];
        }

        ganttChartSort(numberOfProcess,processPriority,process,burstTime);

        System.out.println("\ngantt chart: ");

        for(int j = 0; j < numberOfProcess; j++) {
            System.out.print("--P" + process[j] +"--|");
        }
        System.out.print("\n0    ");

        sort(numberOfProcess, completionTime);

        System.out.println();
        averageWaitingTime/=numberOfProcess;
        averageTurnAroundTime/=numberOfProcess;
        System.out.print("\n Average Wait Time : "+averageWaitingTime);
        System.out.print("\n Average Turn Around Time : "+averageTurnAroundTime);
    }
}

