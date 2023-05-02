public class Employee extends Person{
    String empPosition;
    int empNum;

    public Employee(){
        super();
        empNum = 0;
        empPosition = "";
    }

    public Employee(String empPosition, int empNum, String name, String gender, int age, String street, String barangay, String CinMun, String province){
        super(name, gender, age, street, barangay, CinMun, province);
        this.empPosition = empPosition;
        this.empNum = empNum;
    }

    public void setEmpPosition(String empPosition){
        this.empPosition = empPosition;
    }
    public String getEmpPosition(){
        return empPosition;
    }

    public void setEmpNum(int empNum){
        this.empNum = empNum;
    }
    public int getEmpNum(){
        return empNum;
    }
}
