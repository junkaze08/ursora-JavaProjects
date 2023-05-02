import java.util.Scanner;
public class EmployeeMain {
    static Scanner sc = new Scanner(System.in);

    int choice;

    public EmployeeMain(){
        //EmployeeOperations emp = new EmployeeOperations();
        do{
            System.out.println("Menu");
            System.out.println("[1] Register Employee");
            System.out.println("[2] Add Payroll");
            System.out.println("[3] Update Employee's Payroll");
            System.out.println("[4] Update Payroll");
            System.out.println("[5] View Employee's Profile");
            System.out.println("[6] View Payroll by Employee");
            System.out.println("[7] View Payroll by Date");
            System.out.println("[8] View Payroll Summary");
            System.out.println("[9] View all Employees");
            System.out.println("[0] Exit");
            System.out.print("[!] Your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:

                    break;
                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:

                    break;

                case 0:
                    System.out.println("Program Terminated, Thank you");
                    break;
            }

        }while(choice <= 0);
    }
}
