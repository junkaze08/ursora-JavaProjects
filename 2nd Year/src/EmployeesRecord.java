public class EmployeesRecord {
    private String empID;
    private String empLName;
    private String empFName;
    private String empMI;
    private String empGender;
    private String Division;
    private double empHrsWorked;
    private double RatePerHr;
    private double BasicPay;
    private double SSSDeduction;
    private double TaxDeduction;
    private double HealthInsurance;
    private double UnionDues;
    private double empDeducOthers;
    private double Netpay;

    public EmployeesRecord(){

    }

    public EmployeesRecord(String empID, String empLName, String empFName, String empMI, String empGender, String Division, double empHrsWorked){

    }

    public void setEmployees(String Id, String Lname, String Fname, String MI, String Gen, String Div, Double hrsworked){
        this.empID = Id;
        empLName = Lname;
        empFName = Fname;
        empMI = MI;
        empGender = Gen;
        Division = Div;
        empHrsWorked = hrsworked;
    }

    public String getID(){
        return getID();
    }

    public String getLastName(){
        return getLastName();
    }

    public String Division(){
        return Division();
    }

    public String Gender(){
        return Gender();
    }

}
