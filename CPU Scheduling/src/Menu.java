import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    FCFS fcfs = new FCFS();
    SJFNonPreemptive sjfNonPreemptive = new SJFNonPreemptive();
    SJFPreemptive sjfPreemptive = new SJFPreemptive();
    RoundRobin roundRobin = new RoundRobin();
    public void menu(){

        while (true) {
            try {
                System.out.println("\n1. First Come First Serve");
                System.out.println("2. Shortest Job First NON-PREEMPTIVE");
                System.out.println("3. Shortest Job First PREEMPTIVE");
                System.out.println("4. Round Robin");
                System.out.println("5. Exit");
                System.out.print("Choose number: ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    fcfs.fcfs(scanner);
                }   else if (choice == 2) {
                    sjfNonPreemptive.sjfnp(scanner);
                }   else if (choice == 3) {
                    sjfPreemptive.sjfp(scanner);
                }   else if (choice == 4) {
                    roundRobin.roundR(scanner);
                }   else if (choice <= 5){
                    break;
                }   else if (choice <= 6){
                    System.out.println("Input out of bounds, please try again!");
                }
            }
                catch(InputMismatchException e){
                scanner.next();
            }
        }
    }
}
