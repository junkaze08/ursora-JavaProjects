public class MainPerson {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        PartTimeEmployee pt = new PartTimeEmployee();
        int choice;
        double rate, hrs;
        String IDNum, first, last, birthD, address;
        do {
            System.out.println("Menu");
            System.out.println("[1] Add Employee");
            System.out.println("[2] Display Employee");
            System.out.println("[3] Exit");
            System.out.print("[!] Your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1://Add employee

                    System.out.println();
                    int input;
                    //Start of input for employee
                    do { //validation for id no.
                        System.out.print("[!]Please input Employee ID Number: ");
                        input = sc.nextInt();
                        if (input <= 0 || input > 9999)//Accepts only 1-4 digits numbers
                            System.out.println("[!]Enter a valid id number.");
                        IDNum = String.valueOf(input);
                    } while (input <= 0 || input > 9999);
                    //add zeros to empty place value
                    if (input < 10)
                        IDNum = "000" + IDNum;
                    else if (input < 100)
                        IDNum = "00" + IDNum;
                    else
                        IDNum = "0" + IDNum;
                    //input for Full name
                    sc.nextLine();
                    System.out.print("[!]Enter First Name: ");
                    first = sc.nextLine();
                    System.out.print("[!]Enter Last Name: ");
                    last = sc.nextLine();
                    //input for birth day
                    int month, day, year;
                    System.out.println("Input Birth Date");
                    do { //validation for month
                        System.out.print("Input Birth month: ");
                        month = sc.nextInt();
                        if (month <= 0 || month > 12)
                            System.out.println("[!]not valid");
                    } while (month <= 0 || month > 12);
                    do { //validation for day
                        System.out.print("[!]Input day: ");
                        day = sc.nextInt();
                        if (day <= 0 || day > 31)
                            System.out.println("[!]not valid");
                    } while (day <= 0 || day > 31);
                    do { //validation for year
                        System.out.print("[!]Input year: ");
                        year = sc.nextInt();
                        if (year <= 0)
                            System.out.println("[!]not valid");
                    } while (year <= 0);
                    birthD = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

                    sc.nextLine();
                    System.out.print("[!]Address: ");
                    address = sc.nextLine();
                    //Part time input
                    System.out.print("\n[!]Please input Pay Rate: ");
                    rate = sc.nextDouble();
                    System.out.print("[!]Please input Input Hours: ");
                    hrs = sc.nextDouble();
                    sc.nextLine();
                    //passing values
                    pt.setPerson(IDNum, first, last, birthD, address);
                    pt.setNameRateHours(first, last, rate, hrs);
                    break;
                case 2://Display employee
                    pt.print();
                    System.out.println("\nPart Time Employee");
                    System.out.println("Name\t\tPay Rate\tHours Worked\tPay");
                    System.out.println(pt + "\t\t" + pt.calculatePay());
                    break;
                case 3:
                    System.out.println("Thank you for using the Program!");
                    break;
                default:
                    System.out.println("[!]Invalid input.");
                    break;
            }
        } while (choice != 3);
    }
}