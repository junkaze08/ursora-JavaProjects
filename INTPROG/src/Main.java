import java.util.Scanner;

public class Main {

    private static final Validation validation = new Validation();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        enterValues();
    }
    public static void enterValues(){

        System.out.print("College: ");
        String college = scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Employee #: ");
        int empNum = validation.checkNumber(scanner, "Invalid Employee#...","Employee #: ");
        scanner.nextLine();
        System.out.print("Name: ");
        String name = validation.checkString(scanner,"Name contains Number","Name: ");
        System.out.print("Gender: ");
        String gender = validation.checkGender(scanner,"Gender Must be specified", "Gender: ");
        System.out.print("Age: ");
        int age = validation.checkNumber(scanner,"Invalid Age...","Age: ");
        scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("Barangay: ");
        String barangay = scanner.nextLine();
        System.out.print("City/Municipality: ");
        String cinMon = scanner.nextLine();
        System.out.print("Province : ");
        String province = scanner.nextLine();

        Teacher teacher = new Teacher(college, position,empNum,name,gender,age,street,barangay,cinMon,province);

        System.out.println("---TEACHER---");
        System.out.println("College: " + teacher.getCollege());
        System.out.println("Position: " + teacher.getEmpPosition());
        System.out.println("Employee #: " + teacher.getEmpNum());
        System.out.println("Name: " + teacher.getName());
        System.out.println("Gender: " + teacher.getGender());
        System.out.println("Age: " + teacher.getAge());
        System.out.println("Street: " + teacher.getStreet());
        System.out.println("Barangay: " + teacher.getBarangay());
        System.out.println("City/Municipality: " + teacher.getCinMun());
        System.out.println("Province : " + teacher.getProvince());
    }
}