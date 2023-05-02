public class PartTimeEmployee extends Person{
    double payRate;
    double hoursWorked;

    public PartTimeEmployee(){
        payRate = 0;
        hoursWorked = 0;
    }

    public PartTimeEmployee(String fName, String lName, double rate, double hrs){
        firstName = fName;
        lastName = lName;
        payRate = rate;
        hoursWorked = hrs;
    }

    public String toString(){
        return firstName + " " + lastName + "\t" + payRate + "\t\t" + hoursWorked;
    }
    public void setNameRateHours(String fName, String lName, double rate, double hrs){
        firstName = fName;
        lastName = lName;
        payRate = rate;
        hoursWorked = hrs;
    }

    public double getPayRate(){
        return payRate;
    }

    public double getHoursWorked(){
        return hoursWorked;
    }

    public double calculatePay(){
        return payRate * hoursWorked;
    }
}
    Person Class
public class Person{
    String personID;
    String firstName;
    String lastName;
    String birthDate;
    String address;
    public Person(){
        personID = "";
        firstName = "";
        lastName = "";
        birthDate = "";
        address = "";
    }
    public Person(String IDNum, String first, String last, String birthD, String address){
        personID = IDNum;
        firstName = first;
        lastName = last;
        birthDate = birthD;
        this.address = address;
    }
    public void setPerson(String IDNum, String first, String last, String birthD, String address){
        personID = IDNum;
        firstName = first;
        lastName = last;
        birthDate = birthD;
        this.address = address;
    }

    public String getPersonID(){
        return personID;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getBirthDate(){
        return birthDate;
    }
    public String getAddress(){
        return address;
    }
    public void print(){
        System.out.println();
        System.out.println("PERSON");
        System.out.println("ID No.\tFirst Name\tLast Name\tBirth Date\tAddress");
        System.out.println(personID + "\t" + firstName + "\t\t" + lastName + "\t\t" + birthDate + "\t" +
                address);
    }
    public String toString(){
        return personID + " " + firstName + " " + lastName + " " + birthDate + " " + address;
    }
}